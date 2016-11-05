
</div> <!-- fin container -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.1/jquery.min.js"></script>
<?php 

	$js = array(
		'bootstrap.min.js',
		'material.min.js',
		'ripples.min.js',
		'angular.min.js',
		'angular-route.min.js',
		'ng-notify.js',
		'app.js',
		'recargarCtrl.js',
		'enviarMensajeCtrl.js',
		'suscribirAbonadoCtrl.js',
		'comprarServicioSuplementarioCtrl.js',
		'desvincularAbonadoCtrl.js',
		'quitarServicioSuplementarioCtrl.js'
		);

	echo add_js($js);
 ?>

 <script type="text/javascript">
 	$.material.init();
 	$.material.ripples();
 	$.material.input();
 	$.material.checkbox();
 	$.material.radio();
 </script>

 </body>
</html>