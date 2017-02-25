'use strict';

angular
  .module('myApp.view1', ['ngRoute', 'datatables', 'ngResource'])


  .config(['$routeProvider', function($routeProvider) {
    $routeProvider.when('/view1', {
      templateUrl: 'view1/view1.html',
      controller: 'View1Ctrl'
    });
  }])

  .service ('appService', function($http) {
    this.getPersons = function() {
      return $http({
        "method": "get",
        "url": './view1/data.json'
        });
    };
  })

  .controller('View1Ctrl',['$scope', '$resource', '$location', '$http', 'appService', View1Ctrl]);

  function View1Ctrl($scope, $resource, $location, $http, appService) {

    appService.getPersons().then(function(persons){
      $scope.persons = persons.data;
    });



  }