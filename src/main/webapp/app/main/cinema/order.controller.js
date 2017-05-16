(function() {
    'use strict';

    angular
        .module('myApp')
        .controller('OrderController', OrderController);

    OrderController.$inject = ['$uibModalInstance'];

    function OrderController ($uibModalInstance) {
        var vm = this;

      
        vm.clear = clear;
        vm.confirmDelete = confirmDelete;

        function clear () {
            $uibModalInstance.dismiss('cancel');
        }

        function confirmDelete () {
            Powform.delete({
                kodPowiazanego: entity.id.kodPowiazanego.toUpperCase(),
                wariantPowiazanego: entity.id.wariantPowiazanego,
                kodPierwotnego: entity.id.kodPierwotnego.toUpperCase(),
                wariantPierwotnego: entity.id.wariantPierwotnego
            },
            function () {
                $uibModalInstance.close(true);
            },
            function(){
                CommunicationService.openError('E-POWFORM-CANT-DELETE');
                $uibModalInstance.close(true);
            });
        }
    }
})();
