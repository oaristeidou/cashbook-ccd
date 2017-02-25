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
    this.getBookings = function() {
      return $http({
        "method": "get",
        "url": './data.json'
        });
    };
  })

  .controller('View1Ctrl', view1Ctrl);

  function view1Ctrl(appService) {
    var vm= this;
    appService.getBookings().then(function(bookings){
      vm.bookings = bookings.data;
    });
  }