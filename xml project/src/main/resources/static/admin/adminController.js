var app = angular.module('admin.controllers', []);

app.controller('adminController', ['$scope','adminService', '$location','$state',
  	function ($scope, adminService, $location,$state) {
		function checkRights() {
			adminService.checkRights().then(
				function (response) {
					if(response.data != "") {
						$scope.admin = response.data;
					}
				}, 
				function (response){
				    $location.path('login');
					alert("Greska");
				}
			);
		}
		checkRights();
	}
]);
