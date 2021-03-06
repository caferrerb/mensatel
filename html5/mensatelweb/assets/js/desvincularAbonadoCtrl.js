app.controller('desvincularAbonadoCtrl', function($scope, $http, sendService, ngNotify) {

	var uriCtrl = 'desvincularAbonado/'

    $scope.desvincularAbonado = function(formData, isValid){

        ngNotify.set('Enviando solicitud...', {
            sticky: true
        });

        sendService.get(uriCtrl+'desvincularAbonado', formData)
            .then(
                function( response ) {
                    ngNotify.dismiss();
                    if(response.codigo != undefined){

                        if(response.codigo == 'COD-0000'){
                            ngNotify.set(response.mensaje, 'success');
                        }else{
                            ngNotify.set(response.mensaje, 'error');   
                        }
                    }
                    
                    if(response.respuesta.codigo == 0){
                        ngNotify.set(response.respuesta.respuesta, 'success');
                    }else{
                        ngNotify.set(response.respuesta.respuesta, 'error');
                    }
                },
                function( errorMessage ) {
                    ngNotify.dismiss();
                    ngNotify.set(errorMessage, 'error');
                }
            );
    }
});