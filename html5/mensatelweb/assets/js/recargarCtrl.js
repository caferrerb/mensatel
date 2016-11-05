app.controller('recargarCtrl', function($scope, $http, sendService, ngNotify ) {

    var uriCtrl = 'recargar/';
    $scope.listaPlanes = [];

    $scope.recargar = function(formData, isValid){

        ngNotify.set('Enviando solicitud...', {
            sticky: true
        });

        sendService.get(uriCtrl+'recargar', formData)
            .then(
                function( response ) {
                    ngNotify.dismiss();

                    if(response.codigo != undefined){

                        if(response.codigo == 'COD-0000'){
                            ngNotify.set(response.mensaje, 'success');
                        }else if(response.mensaje != undefined){
                            ngNotify.set(response.mensaje, 'error');   
                        } else{
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

    $scope.listarPlanes = function(){

        sendService.get(uriCtrl+'listarPlanes')
            .then(
                function( response ) {
                   $scope.listaPlanes = response;
                   console.log($scope.listaPlanes);
                },

                function( errorMessage ) {
                    ngNotify.dismiss();
                    ngNotify.set(errorMessage, 'error');
                }
            );
    }



});