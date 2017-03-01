'use strict';

angular.module('myApp.view2', ['ngRoute'])

  .config(['$routeProvider', function($routeProvider) {
    $routeProvider.when('/view2', {
      templateUrl: 'view2/view2.html',
      controller: 'View2Ctrl'
    });
  }])

  .service ('appService', bookingRepositoryProvider)

  .controller('View2Ctrl', view2Ctrl);




  function view2Ctrl($scope, appService){

    $scope.addNew = function(booking){
      appService.saveBooking(booking, function () {
        $scope.bookings.push({
          'date': booking.date.toISOString(),
          'name': booking.name,
          'amount': booking.amount
        });
      });
    };

    appService.getBookings()
      .then(function(bookings){
        $scope.bookings = bookings.data;
      });
  }


  function bookingRepositoryProvider ($http) {
    this.getBookings = function() {
      return $http({
        "method": "get",
        "url": '/monthsReportCalc'
      });
    };


    this.saveBooking = function(booking, onPosted) {
      // use $.param jQuery function to serialize data from JSON
      var queryString = $.param({
        "date": booking.date.toISOString(),
        "name": booking.name,
        "amount": booking.amount
      });

      var config = {
        headers: {
          'Content-Type': 'application/x-www-form-urlencoded;charset=utf-8;'
        }
      };
      $http.post('/book', queryString, config)
        .then(onPosted);
    }
  }