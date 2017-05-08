(function() {
    'use strict';
    angular
        .module('myApp')
        .factory('CinemaUser', CinemaUser);

    CinemaUser.$inject = ['$resource'];

    function CinemaUser ($resource) {
        var resourceUrl =  'api/cinemaUser/:id';

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
            }
        });
    }
})();
