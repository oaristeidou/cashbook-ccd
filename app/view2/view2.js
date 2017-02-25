'use strict';

angular.module('myApp.view2', ['ngRoute'])

.config(['$routeProvider', function($routeProvider) {
  $routeProvider.when('/view2', {
    templateUrl: 'view2/view2.html',
    controller: 'View2Ctrl'
  });
}])

.controller('View2Ctrl', view2Ctrl);

  function view2Ctrl(){
    var vm= this;
    vm.submitData = function (transaction) {
      var config = {
        params: {
          transaction: transaction
        }
      };

    $http.post("/book", null, config)
      .success(function (data, status, headers, config)
      {
        vm[ajaxSubmitResult] = data;
      })
      .error(function (data, status, headers, config)
      {
        vm[ajaxSubmitResult] = "SUBMIT ERROR";
      });
    };
  }