(function() {
  'use strict';

  angular
    .module('myApp')
    .controller('CinemaController', CinemaController);

  CinemaController.$inject = ['Theater', 'Show', '$uibModal', 'InitHall'];

  function CinemaController(Theater, Show, $uibModal, InitHall) {
    var vm = this;

    // vm.selectedCinema;
    var movies = [];
    vm.cantChangeHour = true;
    vm.cantGoNext = true;

    getAllTheaters();

    function getAllTheaters() {
      Theater.query(function(response) {
        vm.theaters = response;
      });
    }


    function getAllFilmsOfSelectedTheater(cinema) {
      Show.getAllFilmsOfSelectedTheater({
        theaterName: cinema
      }, function(response) {
        movies = response;
        var myArray = [];
        angular.forEach(response, function(data) {
          myArray.push(data.movy.movieName);
        })
        let unique = Array.from(new Set(myArray));

        vm.films = unique;
      });

    }

    vm.changeThater = function() {
      getAllFilmsOfSelectedTheater(vm.selectedCinema);
    }


    vm.changeMovie = function() {
      var dates = [];
      angular.forEach(movies, function(data) {
        if (data.movy.movieName == vm.selectedMovie) {
          dates.push(data.movieDate);
        }
      })
      vm.dates = dates;

    }

    vm.changeDate = function(){
        vm.cantChangeHour = false;
        vm.hours = ["18:00", "20:00"]
    }

    vm.changeHour = function(){
        vm.cantGoNext = false;
    }


    vm.order = function() {
      if (modalInstance !== null) return;
      modalInstance = $uibModal.open({
        templateUrl: 'app/main/cinema/order.html',
        controller: 'OrderController',
        controllerAs: 'vm',
        animation: true,
        backdrop: 'static',
        size: 'lg',
        resolve: {
          cinema: function() {
            return vm.selectedCinema;
          }
        }
      });
      modalInstance.result.then(function() {

        resetModal();
      }, function() {

        resetModal();
      });


    }


    function clear() {
      $uibModalInstance.dismiss('cancel');
    }


    var modalInstance = null;

    var resetModal = function() {
      modalInstance = null;
    };

    


  }
})();
