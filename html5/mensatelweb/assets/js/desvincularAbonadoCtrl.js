app.controller('desvincularAbonadoCtrl', function($scope, $http, sendService ) {

	$scope.respuestaDesvinculo = [];
	var uriCtrl = 'desvincularAbonado/'

    $scope.desvincularAbonado = function(numero){

        var data = {'numero':numero};

        sendService.get(uriCtrl+'desvincularAbonado', data)
            .then(
                function( response ) {
                    $scope.respuestaDesvinculo = response;
                },

                function( errorMessage ) {
                    console.warn( errorMessage );
                }
            );

    }

});