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
				      <form name="frmRegistrarUsuario" novalidate ng-submit="registrarUsuario( registrarUsuarioForm, registrarUsuarioForm.$valid )">
					      <fieldset>

							<div class="form-group label-floating">
								<label class="control-label" for="focusedInput2">Nombre</label>
								<input class="form-control" name="nombre" id="nombre" type="text" required ng-model="registrarUsuarioForm.nombre" ng-minlength="3" ng-maxlength="45">
								<p ng-show="!frmRegistrarUsuario.$pristine && frmRegistrarUsuario.nombre.$error.required" class="help-block">Nombre es requerido</p>
								<p ng-show="!frmRegistrarUsuario.$pristine && frmRegistrarUsuario.nombre.$error.minlength" class="help-block">Nombre mínimo de 3 digitos</p>
								<p ng-show="!frmRegistrarUsuario.$pristine && frmRegistrarUsuario.nombre.$error.maxlength" class="help-block">Nombre máximo de 45 digitos</p>
							</div>

							<div class="form-group label-floating">
								<label class="control-label" for="focusedInput2">Apellido</label>
								<input class="form-control" name="apellido" id="apellido" type="text" required ng-model="registrarUsuarioForm.apellido" ng-minlength="3" ng-maxlength="45">
								<p ng-show="!frmRegistrarUsuario.$pristine && frmRegistrarUsuario.apellido.$error.required" class="help-block">Apellido es requerido</p>
								<p ng-show="!frmRegistrarUsuario.$pristine && frmRegistrarUsuario.apellido.$error.minlength" class="help-block">Apellido mínimo de 3 digitos</p>
								<p ng-show="!frmRegistrarUsuario.$pristine && frmRegistrarUsuario.apellido.$error.maxlength" class="help-block">Apellido máximo de 45 digitos</p>
							</div>

							<div class="form-group label-floating">
								<label class="control-label" for="focusedInput2">Ciudad</label>
								<select name="ciudad" id="ciudad" class="form-control" required ng-model="registrarUsuarioForm.ciudad">
						          	<option value="1">Armenia</option>
							        <option value="2">Bogotá</option>
							        <option value="3">Cali</option>
							        <option value="4">Medellin</option>
						        </select>
								<p ng-show="!frmRegistrarUsuario.$pristine && frmRegistrarUsuario.ciudad.$error.required" class="help-block">Ciudad es requerida</p>
							</div>

							<div class="form-group label-floating">
								<label class="control-label" for="focusedInput2">Correo</label>
								<input class="form-control" name="correo" id="correo" type="text" required ng-model="registrarUsuarioForm.correo" ng-minlength="10" ng-maxlength="50">
								<p ng-show="!frmRegistrarUsuario.$pristine && frmRegistrarUsuario.correo.$error.required" class="help-block">Correo es requerido</p>
								<p ng-show="!frmRegistrarUsuario.$pristine && frmRegistrarUsuario.correo.$error.minlength" class="help-block">Correo mínimo de 10 digitos</p>
								<p ng-show="!frmRegistrarUsuario.$pristine && frmRegistrarUsuario.correo.$error.maxlength" class="help-block">Correo máximo de 50 digitos</p>
							</div>

							<div class="form-group label-floating">
								<label class="control-label" for="focusedInput2">Documento</label>
								<input class="form-control" name="doc" id="doc" type="text" required ng-model="registrarUsuarioForm.doc" ng-minlength="3" ng-maxlength="45">
								<p ng-show="!frmRegistrarUsuario.$pristine && frmRegistrarUsuario.doc.$error.required" class="help-block">Documento es requerido</p>
								<p ng-show="!frmRegistrarUsuario.$pristine && frmRegistrarUsuario.doc.$error.minlength" class="help-block">Documento mínimo de 10 digitos</p>
								<p ng-show="!frmRegistrarUsuario.$pristine && frmRegistrarUsuario.doc.$error.maxlength" class="help-block">Documento máximo de 10 digitos</p>
							</div>
							
							<div class="form-group label-floating">
								<label class="control-label" for="focusedInput2">Tipo documento</label>
								<select name="tipodoc" id="tipodoc" class="form-control" required ng-model="registrarUsuarioForm.tipodoc">
						          	<option value="CEDULA">Cedula</option>
							        <option value="TI">Tarjeta identidad</option>
							        <option value="PAS">Pasaporte</option>
						        </select>
								<p ng-show="!frmRegistrarUsuario.$pristine && frmRegistrarUsuario.tipodoc.$error.required" class="help-block">Tipo documento es requerido</p>
							</div>

							<div class="form-group">
								<button type="submit" class="btn btn-primary" ng-disabled="frmRegistrarUsuario.$invalid">Registrar</button>
							</div>					

						  </fieldset>
					</form>
				</div>

			</div>
		</div>

	</div>

</div>

<?php $this->view('elements/footer');?>
