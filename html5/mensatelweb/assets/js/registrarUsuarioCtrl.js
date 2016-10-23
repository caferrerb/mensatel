app.controller('registrarUsuarioCtrl', function($scope, $http, sendService ) {

	$scope.push = [];
    $scope.respuestaRegistro = [];
	var uriCtrl = 'registrarUsuario/'    

    $scope.registrarUsuario = function(nombre, apellido, ciudad, correo, doc, tipodoc){

        var data = {'nombre':nombre, 'apellido':apellido, 'ciudad':ciudad, 
        'correo':correo, 'doc':doc, 'tipodoc':tipodoc};

        sendService.get(uriCtrl+'registrarUsuario', data)
            .then(
                function( response ) {
                    $scope.respuestaRegistro = response;
                },

                function( errorMessage ) {
                    console.warn( errorMessage );
                }
            );

    }

});