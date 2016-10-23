<?php
defined('BASEPATH') OR exit('No direct script access allowed');

$this->view('elements/header'); ?>



<div class="row" ng-controller="registrarUsuarioCtrl">
	
	<div class="col-sm-12">
		
		<!-- MIGA DE PAN -->
		<ol class="breadcrumb">
		  <li><a href="#">Home</a></li>
		  <li class="active">Registrar usuario</li>
		</ol>
		
		<!-- PANEL DE CONTENIDO -->
		<div class="panel panel-success">
		  <div class="panel-heading">REGISTRAR USUARIO</div>
			<div class="panel-body">



				<div class="col-md-6 col-md-offset-3">
				      <form>
					      <fieldset>					
							<div class="form-group label-floating">
								<label class="control-label" for="focusedInput2">Nombre</label>
								<input class="form-control" name="nombre" id="nombre" type="text" required ng-model="nombre">
								<p class="help-block">Nombre</p>
							</div>

							<div class="form-group label-floating">
								<label class="control-label" for="focusedInput2">Apellido</label>
								<input class="form-control" name="apellido" id="apellido" type="text" required ng-model="apellido">
								<p class="help-block">Apellido</p>
							</div>

							<div class="form-group label-floating">
								<label class="control-label" for="focusedInput2">Ciudad</label>
								<input class="form-control" name="ciudad" id="ciudad" type="text" required ng-model="ciudad">
								<p class="help-block">Ciudad</p>
							</div>

							<div class="form-group label-floating">
								<label class="control-label" for="focusedInput2">Correo</label>
								<input class="form-control" name="correo" id="correo" type="text" required ng-model="correo">
								<p class="help-block">Correo</p>
							</div>

							<div class="form-group label-floating">
								<label class="control-label" for="focusedInput2">Documento</label>
								<input class="form-control" name="doc" id="doc" type="text" required ng-model="doc">
								<p class="help-block">Documento</p>
							</div>

							<div class="form-group label-floating">
								<label class="control-label" for="focusedInput2">Tipo documento</label>
								<input class="form-control" name="tipodoc" id="tipodoc" type="text" required ng-model="tipodoc">
								<p class="help-block">Tipo documento</p>
							</div>

							<div class="form-group">
								<button type="submit" class="btn btn-primary" ng-click="registrarUsuario(nombre, apellido, ciudad, correo, doc, tipodoc)">Registrar</button>
							</div>					

						  </fieldset>
					</form>
					{{respuestaRegistro}}
				</div>

			</div>
		</div>

	</div>

</div>

<?php $this->view('elements/footer');?>