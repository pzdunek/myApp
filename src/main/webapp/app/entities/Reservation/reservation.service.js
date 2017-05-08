(function() {
    'use strict';
    angular
        .module('myApp')
        .factory('Reservation', Reservation);

    Reservation.$inject = ['$resource'];

    function Reservation ($resource) {
        var resourceUrl =  'api/reservation/:id';

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
