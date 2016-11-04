<?php
defined('BASEPATH') OR exit('No direct script access allowed');

$this->view('elements/header'); ?>

<div class="row" ng-controller="quitarServicioSuplementarioCtrl">
	
	<div class="col-sm-12">
		
		<!-- MIGA DE PAN -->
		<ol class="breadcrumb">
		  <li><a href="#">Home</a></li>
		  <li class="active">Quitar servicio suplementario</li>
		</ol>
		
		<!-- PANEL DE CONTENIDO -->
		<div class="panel panel-success">
		  <div class="panel-heading">QUITAR SERVICIO SUPLEMENTARIO</div>
			<div class="panel-body">

				<div class="col-md-6 col-md-offset-3">
				      <form name="frmquitarServicioSuplementario" novalidate ng-submit="quitarServicioSuplementario(quitarServicioSuplementarioForm , quitarServicioSuplementarioForm.$valid )">
					      <fieldset>

					      	<div class="form-group label-floating">
								<label class="control-label" for="focusedInput2">Número abonado</label>
								<input class="form-control" name="numeroabonado" id="numeroabonado" type="number" required ng-model="quitarServicioSuplementarioForm.numeroabonado" ng-minlength="10" ng-maxlength="10">
								<p ng-show="!frmquitarServicioSuplementario.$pristine && frmquitarServicioSuplementario.numeroabonado.$error.required" class="help-block">Número abonado es requerido</p>
								<p ng-show="!frmquitarServicioSuplementario.$pristine && frmquitarServicioSuplementario.numeroabonado.$error.minlength" class="help-block">Número mínimo de 10 digitos</p>
								<p ng-show="!frmquitarServicioSuplementario.$pristine && frmquitarServicioSuplementario.numeroabonado.$error.maxlength" class="help-block">Número máximo de 10 digitos</p>
							</div>

							<div class="form-group label-floating">
								<label class="control-label" for="focusedInput2">Servicio</label>
								<select name="codigoservicio" id="codigoservicio" class="form-control" required ng-model="quitarServicioSuplementarioForm.codigoservicio">
						          	<option value="1">SMS</option>
							        <option value="2">Push</option>
							        <option value="3">Correo electronico</option>
						        </select>
								<p ng-show="!frmquitarServicioSuplementario.$pristine && frmquitarServicioSuplementario.codigoservicio.$error.required" class="help-block">Plan es requerida</p>
							</div>

							<div class="form-group">
								<button type="submit" class="btn btn-primary" ng-disabled="frmquitarServicioSuplementario.$invalid">Quitar</button>
							</div>					

						  </fieldset>
					</form>
				</div>
			</div>
		</div>

	</div>

</div>

<?php $this->view('elements/footer');?>