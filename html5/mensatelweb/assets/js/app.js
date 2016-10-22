var app = angular.module('app', ['ngRoute']);

// app.config(function($routeProvider){
//     $routeProvider
//         .when("/", {
//             controller: "modulo1Controller",
//             controllerAs: "m1",
//             templateUrl: "vistas/form.html"
//         })
//         .when("/pagina1", {
//             controller: "modulo1Controller",
//             controllerAs: "m1",
//             templateUrl: "vistas/page1.html"
//         })
//         .when("/pagina2", {
//             controller: "modulo1Controller",
//             controllerAs: "m1",
//             templateUrl: "vistas/page2.html"
//         })
//         .when("/pagina3", {
//             controller: "modulo1Controller",
//             controllerAs: "m1",
//             templateUrl: "vistas/page3.html"
//         });
// });


 // I act a repository for the remote friend collection.
app.service(
    "sendService",
    function( $http, $q ) {
        // Return public API.
        return({
            get: getUrl,
            post: postUrl,
        });
        // ---
        // PUBLIC METHODS.
        // ---
        // I add a friend with the given name to the remote collection.
        function postUrl( uri, data ) {
            var request = $http({
                method: "post",
                url: uri,
                data: data
            });
            return( request.then( handleSuccess, handleError ) );
        }
        
        // I get all of the friends in the remote collection.
        function getUrl(uri, params) {
            var request = $http({
                method: "get",
                url: uri,
                params: params
            });
            return( request.then( handleSuccess, handleError ) );
        }
        
        // ---
        // PRIVATE METHODS.
        // ---
        // I transform the error response, unwrapping the application dta from
        // the API response payload.
        function handleError( response ) {
            // The API response from the server should be returned in a
            // nomralized format. However, if the request was not handled by the
            // server (or what not handles properly - ex. server error), then we
            // may have to normalize it on our end, as best we can.
            if (
                ! angular.isObject( response.data ) ||
                ! response.data.message
                ) {
                return( $q.reject( "An unknown error occurred." ) );
            }
            // Otherwise, use expected error message.
            return( $q.reject( response.data.message ) );
        }

        // I transform the successful response, unwrapping the application data
        // from the API response payload.
        function handleSuccess( response ) {
            return( response.data );
        }
    }
);
