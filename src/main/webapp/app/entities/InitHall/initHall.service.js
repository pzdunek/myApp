(function() {
    'use strict';
    angular
        .module('myApp')
        .factory('InitHall', InitHall);

    InitHall.$inject = ['$resource'];

    function InitHall ($resource) {
        var resourceUrl =  'api/initHall';

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
            'getRowsAndCols': {  
                method: 'GET', 
                isArray: false,
                params: {theaterName: '@theaterName'}
            }
        });
    }
})();
