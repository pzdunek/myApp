(function() {
    'use strict';

    angular
        .module('myApp')
        .controller('CinemaController',CinemaController);

    CinemaController.$inject = ['Theater'];

    function CinemaController(Theater) {
        var vm = this;

        vm.selectedCinema;
        
    	getAllTheaters();

    	function getAllTheaters(){
    		Theater.query(function(data) {
                vm.theaters = data;
              	console.log(data);
                
                  });
            



    	}  

    }
})();