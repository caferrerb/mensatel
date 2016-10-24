app.controller('enviarMensajeCtrl', function($scope, $http, sendService, ngNotify) {

	$scope.push = [];
    $scope.respuestaMensaje = [];
	var uriCtrl = 'enviarMensaje/'

    $scope.enviarMensaje = function(formData, isValid){


        ngNotify.set('Enviando solicitud...', {
            sticky: true
        });

        sendService.get(uriCtrl+'enviarMensaje', formData)
            .then(

                function( response ) {
                    ngNotify.dismiss();

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