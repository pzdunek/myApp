(function() {
    'use strict';

    angular
        .module('myApp')
        .config(stateConfig);

    stateConfig.$inject = ['$stateProvider'];

    function stateConfig($stateProvider) {
        $stateProvider
            .state('cinema', {
                parent: 'main',
                url: '/cinema',
                data: {
                    authorities: ['ROLE_USER']
                },
                views: {
                    'main-view': {
                        templateUrl: 'app/main/cinema/cinema.html',
                        controller: 'CinemaController',
                        controllerAs: 'vm'
                    }
                }
            });
    }
})();