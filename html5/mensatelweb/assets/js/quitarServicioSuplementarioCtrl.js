app.controller('quitarServicioSuplementarioCtrl', function($scope, $http, sendService, ngNotify) {

	var uriCtrl = 'quitarServicioSuplementario/'

    $scope.quitarServicioSuplementario = function(formData, isValid){

        ngNotify.set('Enviando solicitud...', {
            sticky: true
        });

        sendService.get(uriCtrl+'quitarServicioSuplementario', formData)
            .then(
                function( response ) {
                    ngNotify.dismiss();
                    if(response.P_COD != undefined){

                        if(response.P_COD == 'COD-0000'){
                            ngNotify.set(response.P_MSJ, 'success');
                        }else{
                            ngNotify.set(response.P_MSJ, 'error');   
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