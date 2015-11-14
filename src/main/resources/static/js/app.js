angular.module('cryptoApp', [ "ngRoute" ])
		.config(
		[ '$routeProvider', function($routeProvider) {
			$routeProvider.when('/', {
				templateUrl : 'views/default.html'
			}).when('/caesar', {
				templateUrl : 'views/caesar.html',
				controller: 'CaesarController as caesarCrtl'
			}).when('/substitution', {
				templateUrl : 'views/substitution.html',
				controller: 'SubstitutionController as substitutionCrtl'
			}).otherwise({
				redirectTo : '/'
			});
		} ])
		