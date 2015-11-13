angular.module('cryptoApp', [ "ngRoute" ])
		.config(
		[ '$routeProvider', function($routeProvider) {
			$routeProvider.when('/', {
				template : '<h5>This is the default route</h5>'
			}).when('/caesar', {
				templateUrl : 'views/caesar.html',
				controller: 'CaesarController as caesarCrtl'
			}).otherwise({
				redirectTo : '/'
			});
		} ])
		