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
		
		$scope.saveZaglavljeFakture= function () {
			adminService.saveZaglavljeFakture($scope.zaglavljeFakture).then(
				function(response){
					alert("Sacuvano")
					$state.go("admin.unosStavkeFakture", {});
					$scope.sacuvanoZaglavlje=response.data;
				}, function (response){
					alert("Greska");
				}
			);
		}
		
		$scope.saveStavkaFakture= function () {
			alert($scope.sacuvanoZaglavlje.id)
			adminService.saveStavkaFakture($scope.stavkaFakture,$scope.sacuvanoZaglavlje.id).then(
				function(response){
					var r = confirm("Dodaj jos jednu stavku?");
					if (r == true) {
						$state.go("admin.unosStavkeFakture", {});
						$scope.stavkaFakture=null;
					} else {
						$state.go("admin.home", {});
						$scope.sacuvanoZaglavlje=null;
						$scope.stavkaFakture=null;
					}

				}, function (response){
					alert("Greska");
				}
			);
		}
	}
	
]);
