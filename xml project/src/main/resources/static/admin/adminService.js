var services = angular.module('admin.services', ['ngResource']);

services.service('adminService', ['$http', function($http){
var url = "/admin/";	
	
	this.checkRights = function(){
		return $http.get(url+"checkRights");
	}	
	
	this.saveZaglavljeFakture = function(zaglavljeFakture){
		return $http.post("/zaglavljeFakture",zaglavljeFakture);
	}
	
	this.saveStavkaFakture = function(stavkaFakture,idZaglavlja){
		return $http.post("/faktura/"+idZaglavlja,stavkaFakture);
	}
	
	this.findAllFaktura = function(){
		return $http.get("/faktura/findAllFaktura");
	}
	
	this.findAllPoslovniSaradnici = function(firma){
		return $http.post("/firma/findAllPoslovniSaradnici",firma);
	}
}]);