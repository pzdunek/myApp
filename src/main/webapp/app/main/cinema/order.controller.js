(function() {
    'use strict';

    angular
        .module('myApp')
        .controller('OrderController', OrderController);

    OrderController.$inject = ['$uibModalInstance'];

    function OrderController ($uibModalInstance) {
        var vm = this;

        
        var reserved = ['A2', 'A3', 'C5', 'C6', 'C7', 'C8', 'J1', 'J2', 'J3', 'J4'];
        var selected = [];

        vm.clear = clear;
        

        function clear () {
            $uibModalInstance.dismiss('cancel');
        }

        vm.submitSeats = function(){
            console.log("wyslano")
        }

    }
})();
