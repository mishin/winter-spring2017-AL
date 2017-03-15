angular.module( 'EX.signup', [
  'ui.router',
  'angular-stockpile',
  'ngMaterial'
])
.config(function($stateProvider) {
  $stateProvider.state('newUser', {
    url: '/newUser',
    controller: 'newUserCtrl',
    templateUrl: 'newUser/newUser.html'
  });
})
.controller( 'newUserCtrl', function newUserController($scope, $http, store, $state, $rootScope) {

  $scope.user = {};

  $scope.createUser = function() {
    $http({
      url: $rootScope.server_root + 'user',
      method: 'POST',
      data: $scope.user
    }).then(function(response) {
      store.set('jwt', response.data.id_token);
      $state.go('base');
    }, function(error) {
      alert(error.data);
    });
  }

});