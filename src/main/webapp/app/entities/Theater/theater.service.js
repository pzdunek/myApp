(function() {
    'use strict';
    angular
        .module('myApp')
        .factory('Theater', Theater);

    Theater.$inject = ['$resource'];

    function Theater ($resource) {
        var resourceUrl =  'api/theaters/:id';

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
