var app = angular.module('hello', ['ngRoute']);

app.controller('home', ['$scope', '$http', function($scope, $http) {
	$http.get('/resource/').success(function(data) {
	    $scope.data = data;
	  });
    $scope.showCreateLeague = false;
    $scope.addLeague = function() {$scope.data.leagues.push($scope.data.lll);};
    $scope.leagues = [];
}]);

//app.controller('leagueCreationController', function ($scope){
//	  $http.get('/resource/').success(function(data) {
//		    $scope.greeting = data;
//		  })
//});
//
//
//app.config(['$routeProvider', function($routeProvider) {
//	$routeProvider.
//	when('/leagueCreation', {
//	templateUrl: 'leagueCreation.html',
//	controller: 'leagueCreationController'
//	}).
//	when('/detalle', {
//	templateUrl: 'views/detalle.html',
//	controller: 'DetalleController'
//	}).
//	otherwise({
//	redirectTo: '/leagueCreation'
//	});
//	}]);
