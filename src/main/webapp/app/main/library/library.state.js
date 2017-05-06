(function() {
    'use strict';

    angular
        .module('myApp')
        .config(stateConfig);

    stateConfig.$inject = ['$stateProvider'];

    function stateConfig($stateProvider) {
        $stateProvider
            .state('library', {
                parent: 'main',
                url: '/library',
                data: {
                    authorities: ['ROLE_USER']
                },
                views: {
                    'main-view': {
                        templateUrl: 'app/main/library/library.html',
                        controller: 'LibraryController',
                        controllerAs: 'vm'
                    }
                }
            });
    }
})();