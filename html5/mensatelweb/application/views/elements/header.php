<!DOCTYPE html>
<html lang="es">
<head>
	<meta charset="UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">

	<title><?php echo $title ?></title>


	<!-- Material Design fonts -->
  	<link rel="stylesheet" type="text/css" href="//fonts.googleapis.com/css?family=Roboto:300,400,500,700">
  	<link rel="stylesheet" type="text/css" href="//fonts.googleapis.com/icon?family=Material+Icons">

	<?php 
		$css = array(
			'bootstrap.min.css',
			'bootstrap-material-design.min.css',
			'ripples.min.css',
			'ng-notify.css'
			);
	 ?>
  	

  	<?php echo add_css($css) ?>

  	
</head>
<body ng-app="app">

	<div class="container">
		
		<!-- BARRA DE MENU -->
		<div class="navbar navbar-inverse">
		  <div class="container-fluid">
		    <div class="navbar-header">
		      <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-inverse-collapse">
		        <span class="icon-bar"></span>
		        <span class="icon-bar"></span>
		        <span class="icon-bar"></span>
		      </button>
		      <a class="navbar-brand" href="">Mensatel</a>
		    </div>
		    <div class="navbar-collapse collapse navbar-inverse-collapse">
		      <ul class="nav navbar-nav">
		        <li><a href="<?= site_url('recargar') ?>">Recargas</a></li>
		        <li><a href="<?= site_url('enviarMensaje') ?>">Enviar Mensaje</a></li>
		        <li><a href="<?= site_url('suscribirAbonado') ?>">Suscribir abonado</a></li>
		        <li><a href="<?= site_url('registrarUsuario') ?>">Registrar usuario</a></li>
		        <li><a href="<?= site_url('comprarServicioSuplementario') ?>">Comprar servicio suplementario</a></li>
		        <li><a href="<?= site_url('desvincularAbonado') ?>">Desvincular abonado</a></li> 
		        
		      </ul>
		      
		      <ul class="nav navbar-nav navbar-right">
		        <li class="dropdown">
		          <a href="" data-target="#" class="dropdown-toggle" data-toggle="dropdown"><i class="material-icons">more_vert</i>
		            </a>
		          <ul class="dropdown-menu">
		            <li><a href="<?= site_url('configuracion') ?>">Configuración</a></li>
		            <li class="divider"></li>
		            <li><a href="javascript:void(0)"><i class="material-icons">cancel</i> Cerrar Sesión</a></li>
		          </ul>
		        </li>
		      </ul>
		    </div>
		  </div>
		</div>

  	
	
