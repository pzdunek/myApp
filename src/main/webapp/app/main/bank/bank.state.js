(function() {
    'use strict';

    angular
        .module('myApp')
        .config(stateConfig);

    stateConfig.$inject = ['$stateProvider'];

    function stateConfig($stateProvider) {
        $stateProvider
            .state('bank', {
                parent: 'main',
                url: '/bank',
                data: {
                    authorities: ['ROLE_USER']
                },
                views: {
                    'main-view': {
                        templateUrl: 'app/main/bank/bank.html',
                        controller: 'BankController',
                        controllerAs: 'vm'
                    }
                }
            });
    }
})();