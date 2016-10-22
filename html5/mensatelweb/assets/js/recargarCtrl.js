app.controller('recargarCtrl', function($scope, $http, sendService ) {

	$scope.push = [];
    $scope.respuestaRecarga = [];
	var uriCtrl = 'recargar/'

	$scope.sendMessage = function(){

		var data = {'mensaje':'Envio desde Angular.JS'};

		sendService.get(uriCtrl+'web', data)
            .then(
                function( friends ) {
                    $scope.push = friends;
                },

                function( errorMessage ) {
                    console.warn( errorMessage );
                }
            );

	}

    $scope.recargar = function(numero, plan, monto, numTarjeta, codigoseguridad, fechaex){

        var data = {'numero':numero,
        'plan':plan, 'monto':monto, 'numTarjeta':numTarjeta, 
        'codigoseguridad': codigoseguridad, 'fechaex':fechaex};

        sendService.get(uriCtrl+'recargar', data)
            .then(
                function( response ) {
                    $scope.respuestaRecarga = response;
                },

                function( errorMessage ) {
                    console.warn( errorMessage );
                }
            );

    }

});