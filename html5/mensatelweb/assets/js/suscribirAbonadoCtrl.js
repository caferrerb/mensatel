app.controller('suscribirAbonadoCtrl', function($scope, $http, sendService ) {

	$scope.push = [];
    $scope.respuestaSuscripcion = [];
	var uriCtrl = 'suscribirAbonado/'    

    $scope.suscribirAbonado = function(numero, doc, tipodoc){

        var data = {'numero':numero, 'doc':doc, 'tipodoc':tipodoc};

        sendService.get(uriCtrl+'suscribirAbonado', data)
            .then(
                function( response ) {
                    $scope.respuestaSuscripcion = response;
                },

                function( errorMessage ) {
                    console.warn( errorMessage );
                }
            );

    }

});