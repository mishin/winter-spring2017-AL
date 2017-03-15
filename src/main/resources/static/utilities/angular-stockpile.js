(function() {


// Create all modules and define dependencies to make sure they exist.
// stores cookies, session tokens, and user information


angular.module('angular-stockpile',
    [
      'angular-stockpile.store'
    ]);

angular.module('angular-stockpile.cookieStorage', [])
  .service('cookieStockpile', ["$cookies", function ($cookies) {

    this.set = function (what, value) {
      return $cookies.put(what, value);
    };

    this.get = function (what) {
      return $cookies.get(what);
    };

    this.remove = function (what) {
      return $cookies.remove(what);
    };
  }]);

angular.module('angular-stockpile.internalStore', ['angular-stockpile.localStorage', 'angular-stockpile.sessionStorage'])
  .factory('InternalStore', ["$log", "$injector", function($log, $injector) {

    function InternalStore(namespace, storage, delimiter, useCache) {
      this.namespace = namespace || null;
      if (angular.isUndefined(useCache) || useCache == null) {
        useCache = true;
      }
      this.useCache = useCache;
      this.delimiter = delimiter || '.';
      this.inMemoryCache = {};
      this.storage = $injector.get(storage || 'localStorage');
    }

    InternalStore.prototype.getNamespacedKey = function(key) {
      if (!this.namespace) {
        return key;
      } else {
        return [this.namespace, key].join(this.delimiter);
      }
    };

    InternalStore.prototype.set = function(name, elem) {
      if (this.useCache) {
        this.inMemoryCache[name] = elem;
      }
      this.storage.set(this.getNamespacedKey(name), JSON.stringify(elem));
    };

    InternalStore.prototype.get = function(name) {
      var obj = null;
      if (this.useCache && name in this.inMemoryCache) {
        return this.inMemoryCache[name];
      }
      var saved = this.storage.get(this.getNamespacedKey(name));
      try {

        if (typeof saved === 'undefined' || saved === 'undefined') {
          obj = undefined;
        } else {
          obj = JSON.parse(saved);
        }

        if (this.useCache) {
          this.inMemoryCache[name] = obj;
        }
      } catch(e) {
        $log.error('Error parsing saved value', e);
        this.remove(name);
      }
      return obj;
    };

    InternalStore.prototype.remove = function(name) {
      if (this.useCache) {
        this.inMemoryCache[name] = null;
      }
      this.storage.remove(this.getNamespacedKey(name));
    };

    return InternalStore;
  }]);


angular.module('angular-stockpile.localStorage', ['angular-stockpile.cookieStorage'])
  .service('localStockpile', ["$window", "$injector", function ($window, $injector) {
    var localStorageAvailable;

    try {
      $window.localStorage.setItem('testKey', 'test');
      $window.localStorage.removeItem('testKey');
      localStorageAvailable = true;
    } catch(e) {
      localStorageAvailable = false;
    }

    if (localStorageAvailable) {
      this.set = function (what, value) {
        return $window.localStorage.setItem(what, value);
      };

      this.get = function (what) {
        return $window.localStorage.getItem(what);
      };

      this.remove = function (what) {
        return $window.localStorage.removeItem(what);
      };

      this.clear = function () {
        $window.localStorage.clear();
      };
    } else {
      var cookieStorage = $injector.get('cookieStockpile');

      this.set = cookieStorage.set;
      this.get = cookieStorage.get;
      this.remove = cookieStorage.remove;
    }
  }]);

angular.module('angular-stockpile.sessionStorage', ['angular-stockpile.cookieStorage'])
  .service('sessionStorage', ["$window", "$injector", function ($window, $injector) {
    var sessionStorageAvailable;

    try {
      $window.sessionStorage.setItem('testKey', 'test');
      $window.sessionStorage.removeItem('testKey');
      sessionStorageAvailable = true;
    } catch(e) {
      sessionStorageAvailable = false;
    }

    if (sessionStorageAvailable) {
      this.set = function (what, value) {
        return $window.sessionStorage.setItem(what, value);
      };

      this.get = function (what) {
        return $window.sessionStorage.getItem(what);
      };

      this.remove = function (what) {
        return $window.sessionStorage.removeItem(what);
      };
    } else {
      var cookieStorage = $injector.get('cookieStorage');

      this.set = cookieStorage.set;
      this.get = cookieStorage.get;
      this.remove = cookieStorage.remove;
    }
  }]);

angular.module('angular-stockpile.store', ['angular-stockpile.internalStore'])
  .provider('store', function() {

    // the default storage
    var _storage = 'localStorage';

    //caching is on by default
    var _caching = true;

    /**
     * Sets the storage.
     *
     * @param {String} storage The storage name
     */
    this.setStore = function(storage) {
      if (storage && angular.isString(storage)) {
        _storage = storage;
      }
    };

    /**
     * Sets the internal cache usage
     *
     * @param {boolean} useCache Whether to use internal cache
     */
    this.setCaching = function(useCache) {
      _caching = !!useCache;
    };

    this.$get = ["InternalStore", function(InternalStore) {
      var store = new InternalStore(null, _storage, null, _caching);

      /**
       * Returns a namespaced store
       *
       * @param {String} namespace The namespace
       * @param {String} storage The name of the storage service
       * @param {String} delimiter The key delimiter
       * @param {boolean} useCache whether to use the internal caching
       * @returns {InternalStore}
       */
      store.getNamespacedStore = function(namespace, storage, delimiter, useCache) {
        return new InternalStore(namespace, storage, delimiter, useCache);
      };

      return store;
    }];
  });


}());