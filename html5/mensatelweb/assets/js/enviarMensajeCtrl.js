app.controller('enviarMensajeCtrl', function($scope, $http, sendService ) {

	$scope.push = [];
	var uriCtrl = 'enviarMensaje/'

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

	$scope.sendMessagePost = function(){

		sendService.post()
            .then(
                function( friends ) {
                    $scope.push = friends;
                },

                function( errorMessage ) {
                    console.warn( errorMessage );
                }
            );

	}

    $scope.sendMessagePost = function(){

        sendService.post()
            .then(
                function( friends ) {
                    $scope.push = friends;
                },

                function( errorMessage ) {
                    console.warn( errorMessage );
                }
            );

    }

});