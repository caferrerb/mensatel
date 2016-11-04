<?php
defined('BASEPATH') OR exit('No direct script access allowed');

$this->view('elements/header'); ?>

<div class="row" ng-controller="comprarServicioSuplementarioCtrl">
	
	<div class="col-sm-12">
		
		<!-- MIGA DE PAN -->
		<ol class="breadcrumb">
		  <li><a href="#">Home</a></li>
		  <li class="active">Comprar servicio suplementario</li>
		</ol>
		
		<!-- PANEL DE CONTENIDO -->
		<div class="panel panel-success">
		  <div class="panel-heading">COMPRAR SERVICIO SUPLEMENTARIO</div>
			<div class="panel-body">

				<div class="col-md-6 col-md-offset-3">
				      <form name="frmComprarServicioSuplementario" novalidate ng-submit="comprarServicioSuplementario(comprarServicioSuplementarioForm , comprarServicioSuplementarioForm.$valid )">
					      <fieldset>

					      	<div class="form-group label-floating">
								<label class="control-label" for="focusedInput2">Número abonado</label>
								<input class="form-control" name="numeroabonado" id="numeroabonado" type="number" required ng-model="comprarServicioSuplementarioForm.numeroabonado" ng-minlength="10" ng-maxlength="10">
								<p ng-show="!frmComprarServicioSuplementario.$pristine && frmComprarServicioSuplementario.numeroabonado.$error.required" class="help-block">Número abonado es requerido</p>
								<p ng-show="!frmComprarServicioSuplementario.$pristine && frmComprarServicioSuplementario.numeroabonado.$error.minlength" class="help-block">Número mínimo de 10 digitos</p>
								<p ng-show="!frmComprarServicioSuplementario.$pristine && frmComprarServicioSuplementario.numeroabonado.$error.maxlength" class="help-block">Número máximo de 10 digitos</p>
							</div>

							<div class="form-group label-floating">
								<label class="control-label" for="focusedInput2">Servicio</label>
								<select name="codigoservicio" id="codigoservicio" class="form-control" required ng-model="comprarServicioSuplementarioForm.codigoservicio">
						          	<option value="1">SMS</option>
							        <option value="2">Push</option>
							        <option value="3">Correo electronico</option>
						        </select>
								<p ng-show="!frmComprarServicioSuplementario.$pristine && frmComprarServicioSuplementario.codigoservicio.$error.required" class="help-block">Plan es requerida</p>
							</div>

							<div class="form-group">
								<button type="submit" class="btn btn-primary" ng-disabled="frmComprarServicioSuplementario.$invalid">Comprar</button>
							</div>					

						  </fieldset>
					</form>
				</div>
			</div>
		</div>

	</div>

</div>

<?php $this->view('elements/footer');?>