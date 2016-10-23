app.controller('enviarMensajeCtrl', function($scope, $http, sendService ) {

	$scope.push = [];
    $scope.respuestaMensaje = [];
	var uriCtrl = 'enviarMensaje/'

    $scope.enviarMensaje = function(abonadoorigen, abonadodestino, mensaje){

        var data = {'abonadoorigen':abonadoorigen,
        'abonadodestino':abonadodestino, 'mensaje':mensaje};

        sendService.get(uriCtrl+'enviarMensaje', data)
            .then(
                function( response ) {
                    $scope.respuestaMensaje = response;
                },

                function( errorMessage ) {
                    console.warn( errorMessage );
                }
            );

    }

});