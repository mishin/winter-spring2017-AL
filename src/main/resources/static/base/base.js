angular.module('EX.home', [
    'angular-ui.router',
    'angular-stockpile',
    'angular-jwt',
    'ngMaterial'
])
.config(function($stateProvider, $mdThemingProvider) {
    $stateProvider.state('base', {
        url: '/',
        controller: 'BaseCtrl',
    templateUrl: 'base/base.html',
        data: {
            requiresLogin: true
        }
    });

    $mdThemingProvider.theme('default')
        .primaryPalette('blue');
})
.controller('BaseCtrl', function BaseController($scope, $http, store, jwtHelper, $mdSidenav, $log) {
    $scope.jwt = store.get('jwt');
    $scope.decodedJwt = $scope.jwt && jwtHelper.decodeToken($scope.jwt);

    $scope.logout = function() {
        store.set('jwt', '');
        location.reload();
    }
});