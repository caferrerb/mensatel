app.controller('comprarServicioSuplementarioCtrl', function($scope, $http, sendService ) {

	$scope.respuestaCompra= [];
	var uriCtrl = 'comprarServicioSuplementario/'

    $scope.comprarServicioSuplementario = function(numeroabonado, codigoservicio){

        var data = {'numeroabonado':numeroabonado,
        'codigoservicio':codigoservicio};

        sendService.get(uriCtrl+'comprarServicioSuplementario', data)
            .then(
                function( response ) {
                    $scope.respuestaCompra = response;
                },

                function( errorMessage ) {
                    console.warn( errorMessage );
                }
            );

    }

});