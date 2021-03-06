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
	
	this.findAllUlazneFakture = function(){
		return $http.get("/faktura/findAllUlazneFakture");
	}
	
	this.findAllPoslovniSaradnici = function(firma){
		return $http.post("/firma/findAllPoslovniSaradnici",firma);
	}
	
	this.createHTML = function(faktura){
		return $http.post("/faktura/createHTML",faktura);
	}
	
	this.createPDF = function(faktura){
		return $http.post("/faktura/createPDF",faktura);
	}
	
	this.sendNalog = function(faktura){
		return $http.post("/nalog/sendNalog",faktura);
	}
	
	this.sendFaktura = function(faktura){
		return $http.post("/faktura/sendFaktura",faktura);
	}
}]);