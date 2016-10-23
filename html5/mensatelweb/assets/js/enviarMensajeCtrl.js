app.controller('enviarMensajeCtrl', function($scope, $http, sendService, ngNotify) {

	$scope.push = [];
    $scope.respuestaMensaje = [];
	var uriCtrl = 'enviarMensaje/'

    $scope.enviarMensaje = function(abonadoorigen, abonadodestino, mensaje){

        ngNotify.set('Enviando solicitud...', {
            sticky: true
        });

        var data = {'abonadoorigen':abonadoorigen,
        'abonadodestino':abonadodestino, 'mensaje':mensaje};

        sendService.get(uriCtrl+'enviarMensaje', data)
            .then(

                function( response ) {
                    ngNotify.dismiss();
                    //$scope.respuestaMensaje = response;

                    if(response.respuesta.codigo == -1){
                        ngNotify.set(response.respuesta.respuesta, 'error');
                    }else{
                        ngNotify.set(response.respuesta.respuesta, 'success');
                    }
                },

                function( errorMessage ) {
                    ngNotify.dismiss();
                    //console.warn( errorMessage );
                    ngNotify.set(errorMessage, 'error');
                }
            );

    }

});