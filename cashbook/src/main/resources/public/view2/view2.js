'use strict';

angular.module('myApp.view2', ['ngRoute'])

  .config(['$routeProvider', function($routeProvider) {
    $routeProvider.when('/view2', {
      templateUrl: 'view2/view2.html',
      controller: 'View2Ctrl'
    });
  }])

  .service ('appService', function($http) {
    this.getBookings = function() {
      return $http({
        "method": "get",
        "url": '/monthsReportCalc'
      });
    };
    this.saveBooking = function($scope, booking) {
      // use $.param jQuery function to serialize data from JSON
      var data = $.param({
        "date": booking.date.toISOString(),
        "name": booking.name,
        "amount": booking.amount
      });

      var config = {
        headers: {
          'Content-Type': 'application/x-www-form-urlencoded;charset=utf-8;'
        }
      };
      $http.post('/book', data, config)
        .then(function (data) {
          $scope.bookings.push({
            'date': booking.date.toISOString(),
            'name': booking.name,
            'amount': booking.amount
          });
        });
    }
  })

  .controller('View2Ctrl', view2Ctrl);

  function view2Ctrl($scope, $http, appService){

    $scope.addNew = function(booking){
      appService.saveBooking($scope, booking);
    };

    appService.getBookings().then(function(bookings){
      $scope.bookings = bookings.data;
    });
  }