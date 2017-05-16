(function() {
    'use strict';

    angular
        .module('myApp')
        .controller('CinemaController',CinemaController);

    CinemaController.$inject = ['Theater', 'Show','$uibModal'];

    function CinemaController(Theater, Show, $uibModal) {
        var vm = this;

        // vm.selectedCinema;
        var movies = [];

    	getAllTheaters();

    	function getAllTheaters(){
    		Theater.query(function(response) {
                vm.theaters = response;
                  });
            }


    	function getAllFilmsOfSelectedTheater(cinema){
            Show.getAllFilmsOfSelectedTheater({
    			theaterName: cinema
    		}, function(response){
    			movies = response;
                var myArray = [];
                var numberOfSeats = response[0].theater.numberOfSeats; 
                console.log(numberOfSeats);
                angular.forEach(response, function(data){
                	myArray.push(data.movy.movieName);
                })
                let unique = Array.from(new Set(myArray));
                
                 vm.films = unique;
            });
        	
        }

		vm.changeThater = function(){
    		getAllFilmsOfSelectedTheater(vm.selectedCinema);
    	}


    	vm.changeMovie = function(){
    		var dates = [];
    		angular.forEach(movies, function(data){
                	if(data.movy.movieName == vm.selectedMovie){
                		dates.push(data.movieDate);
                	}
                })
    		vm.dates = dates;
    		
    	}


    	vm.order = function(){
    		if (modalInstance !== null) return;
            modalInstance = $uibModal.open({
                templateUrl: 'app/main/cinema/order.html',
                controller: 'OrderController',
                controllerAs: 'vm',
                animation: true,
                backdrop: 'static',
                size: 'lg'
    	})};


    	function clear () {
            $uibModalInstance.dismiss('cancel');
        }

    	  
        var modalInstance = null;   
        
        var resetModal = function () {
            modalInstance = null;
        };

        

    }
})();