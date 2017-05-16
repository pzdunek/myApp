(function() {
    'use strict';
    angular
        .module('myApp')
        .factory('Show', Show);

    Show.$inject = ['$resource'];

    function Show ($resource) {
        var resourceUrl =  'api/shows';

        return $resource(resourceUrl, {}, {
            'query': {  
                method: 'GET', 
                isArray: true
            },
            'get': {
                method: 'GET', 
                transformResponse: function (data) {
                    if (data) {
                        data = angular.fromJson(data);
                    }
                    return data;
                }
            },
            'update': { 
                method:'PUT',
                transformResponse: function (data) {
                    if (data) {
                        data = angular.fromJson(data);
                    }
                    return data;
                } 
            },
            'getAllFilmsOfSelectedTheater': {  
                method: 'GET', 
                isArray: true,
                params: {theaterName: '@theaterName'}
            }
        });
    }
})();
