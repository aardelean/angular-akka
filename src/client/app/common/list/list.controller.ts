/// <reference path="./../../../interfaces.d.ts"/>

var $inject = [
  '$location', '$scope', '$http'
];

class ListController {

  static $inject: any[];
  constructor(private $location, $scope, $http) {

//      $scope.friends=[
//          {name:'John', age:25, gender:'boy'},
//          {name:'Jessie', age:30, gender:'girl'},
//          {name:'Johanna', age:28, gender:'girl'},
//          {name:'Joy', age:15, gender:'girl'},
//          {name:'Mary', age:28, gender:'girl'},
//          {name:'Peter', age:95, gender:'boy'},
//          {name:'Sebastian', age:50, gender:'boy'},
//          {name:'Erika', age:27, gender:'girl'},
//          {name:'Patrick', age:40, gender:'boy'},
//          {name:'Samantha', age:60, gender:'girl'}
//      ]
      var req = {
          method: 'GET',
          url: '/spray/friends'
      }

      $http(req).success(function(response ){
          $scope.friends=response
      }).error(function(){$scope.friends=[ {name:'Error', age:0, gender:'none'}]});
  }

}

ListController.$inject = $inject;
angular.register('app')
  .controller('ListController', ListController);


