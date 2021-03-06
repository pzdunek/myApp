(function() {
    'use strict';

    angular
        .module('myApp')
        .controller('OrderController', OrderController);

    OrderController.$inject = ['$uibModalInstance', '$scope', 'InitHall', 'cinema'];

    function OrderController ($uibModalInstance, $scope, InitHall, cinema) {
        var vm = this;

        vm.cinema = cinema;
        

        getRowsAndCols();
        function getRowsAndCols(){
            InitHall.getRowsAndCols({
                 theaterName: vm.cinema
            }, function(response){
                var colsDownloaded = response.cols;
                var rowsDownloaded = response.rows;
                $scope.rows = rowsDownloaded;
                $scope.cols = colsDownloaded;
           });

        }
        

        vm.clear = clear;
        

        function clear () {
            $uibModalInstance.dismiss('cancel');
        }

        vm.submitSeats = function(){
            console.log("wyslano")

            if(selected.length > 0) {
                alert("Selected Seats: \n" + selected);
            } else {
                alert("No seats selected!");
            }
        }


         // Init layout
        // $scope.rows = rowsDownloaded;
        // $scope.cols = colsDownloaded;

        // Set reserved and selected
        var reserved = ['A2', 'A3', 'C5', 'C6', 'C7', 'C8', 'J1', 'J2', 'J3', 'J4','A1', 'F7'];
        var selected = [];

        // seat onClick
        $scope.seatClicked = function(seatPos) {
            console.log("Selected Seat: " + seatPos);
            var indexOfSelected = selected.indexOf(seatPos);
            var indexOfReserved = reserved.indexOf(seatPos);
            if(indexOfSelected != -1  ) {
                // seat already selected, remove
                selected.splice(indexOfSelected, 1);
               
            } else if(indexOfReserved != -1){
                
                selected.splice(indexOfReserved, 1);
            } else {
                // new seat, push
                selected.push(seatPos);
            }
        }

        // get seat status
        $scope.getStatus = function(seatPos) {
            if(reserved.indexOf(seatPos) > -1) {
                return 'reserved';
            } else if(selected.indexOf(seatPos) > -1) {
                return 'selected';
            }
        }

        // clear selected
        $scope.clearSelected = function() {
            selected = [];
        }

        // show selected
        $scope.showSelected = function() {
            if(selected.length > 0) {
                alert("Selected Seats: \n" + selected);
            } else {
                alert("No seats selected!");
            }
        }

    }
})();
