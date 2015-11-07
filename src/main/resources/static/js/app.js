angular.module('cryptoApp', []).controller(
		'CaesarController',
		[
				'$http',
				function($http) {
					var self = this;

					self.encode = function() {
						console.log('before call encode');
						var url = '/caesar/encode?' + 'alphabet='
								+ self.alphabet + '&text=' + self.text
								+ '&swift=' + self.swift;
						$http.get(url).then(function(response) {
							self.result = response.data;
						}, function(errResponse) {
							console.error('Error while trying encode');
						});
					};

					self.decode = function() {
						console.log('before call decode');
						var url = '/caesar/decode?' + 'alphabet='
								+ self.alphabet + '&text=' + self.text
								+ '&swift=' + self.swift;
						$http.get(url).then(function(response) {
							self.result = response.data;
						}, function(errResponse) {
							console.error('Error while trying decode');
						});
					};

				} ]);