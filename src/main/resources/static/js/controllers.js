angular.module('cryptoApp')
	.controller(
		'CaesarController',
		[
				'$http',
				function($http) {
					var self = this;

					self.encode = function() {
						var url = '/caesar/encode?' + 'alphabet='
								+ self.alphabet + '&text=' + self.text
								+ '&swift=' + self.swift;
						$http.get(url).then(function(response) {
							self.result = response.data;
						}, function(errResponse) {
							console.error('Error while trying caesar encode');
						});
					};

					self.decode = function() {
						var url = '/caesar/decode?' + 'alphabet='
								+ self.alphabet + '&text=' + self.text
								+ '&swift=' + self.swift;
						$http.get(url).then(function(response) {
							self.result = response.data;
						}, function(errResponse) {
							console.error('Error while trying caesar decode');
						});
					};

				} ])
.controller(
		'SubstitutionController',
		[
				'$http',
				function($http) {
					var self = this;

					self.encode = function() {
						console.log('before call encode');
						var url = '/substitution/encode?' + 'alphabet='
								+ self.alphabet + '&cipher='
								+ self.cipher + '&text=' + self.text;
						$http.get(url).then(function(response) {
							self.result = response.data;
						}, function(errResponse) {
							console.error('Error while trying substitution encode');
						});
					};

					self.decode = function() {
						console.log('before call decode');
						var url = '/substitution/decode?' + 'alphabet='
								+ self.alphabet + '&cipher='
								+ self.cipher + '&text=' + self.text;
						$http.get(url).then(function(response) {
							self.result = response.data;
						}, function(errResponse) {
							console.error('Error while trying substitution decode');
						});
					};
					
					self.generateRandomAlphabet = function() {
						var url = '/substitution/generateRandomAlphabet?alphabet=' 
						 + self.alphabet;
						$http.get(url).then(function(response) {
							self.keyword = response.data;
						}, function(errResponse) {
							console.error('Error generating random alphabet');
						});
					};

				} ]);