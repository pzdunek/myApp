(function() {
    'use strict';
    angular
        .module('myApp')
        .factory('Movie', Movie);

    Movie.$inject = ['$resource'];

    function Movie ($resource) {
        var resourceUrl =  'api/movie/:id';

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
