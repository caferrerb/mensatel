app.controller('comprarServicioSuplementarioCtrl', function($scope, $http, sendService, ngNotify) {

	var uriCtrl = 'comprarServicioSuplementario/'

    $scope.comprarServicioSuplementario = function(formData, isValid){

        ngNotify.set('Enviando solicitud...', {
            sticky: true
        });

        sendService.get(uriCtrl+'comprarServicioSuplementario', formData)
            .then(
                function( response ) {
                    ngNotify.dismiss();
                    if(response.codigo != undefined){

                        if(response.codigo == 'COD-0000'){
                            ngNotify.set(response.respuesta, 'success');
                        }else{
                            ngNotify.set(response.respuesta, 'error');   
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