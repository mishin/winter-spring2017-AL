// script.js

    // create the module and name it scotchApp
        // also include ngRoute for all our routing needs
    var scotchApp = angular.module('scotchApp', ['ngRoute']);

    // configure our routes
    scotchApp.config(function($routeProvider) {
        $routeProvider

            // route for the home page
            .when('/', {
                templateUrl : 'pages/home.html',
                controller  : 'mainController'
            })

            // route for the login page
            .when('/about', {
                templateUrl : 'pages/about.html',
                controller  : 'aboutController'
            })

            // route for the contact page
            .when('/contact', {
                templateUrl : 'pages/contact.html',
                controller  : 'contactController'
            });
    });

    // create the controller and inject Angular's $scope
    scotchApp.controller('mainController', function($scope) {
        // create a message to display in our view
        $scope.message = 'This page is a work in progress';
    });

    scotchApp.controller('aboutController', function($scope, $http) {


        $scope.sendSignIn = function(email, password) {
           var postRequest = {
          			method: 'POST',
          			url:(window.location.hostname === 'localhost' ?
        				"http://localhost:8080/user" :
        				"https://slocharts.herokuapp.com/user"),
        			data: {
        				email: $scope.email,
        				password: $scope.password,
        			}
           }
          		$http(postRequest).then(function success(response) {
          		window.sessionStorage.token = data;
          	    window.location.href = "https://slocharts.herokuapp.com/student";
        		}, function error(response) {
        			console.error('error:');
        			console.error(response.data.message);
        		});
        }
    });

    scotchApp.controller('contactController', function($scope, $http) {
        $scope.save = function(user) {
          		var postRequest = {
          			method: 'POST',
          			url:(window.location.hostname === 'localhost' ?
        				"http://localhost:8080/user" :
        				"https://slocharts.herokuapp.com/user"),
        			data: {
        				firstName: $scope.user.firstName,
        				lastName: $scope.user.lastName,
        				email: $scope.user.email,
        				password: $scope.user.password,
        			}
          		}
          		$http(postRequest).then(function success(response) {
          	    window.location.href = "https://slocharts.herokuapp.com/student";
        		}, function error(response) {
        			console.error('error:');
        			console.error(response.data.message);
        		});
        };

    });