<?php
defined('BASEPATH') OR exit('No direct script access allowed');

$this->view('elements/header'); ?>



<div class="row" ng-controller="recargarCtrl">
	
	<div class="col-sm-12">
		
		<!-- MIGA DE PAN -->
		<ol class="breadcrumb">
		  <li><a href="#">Home</a></li>
		  <li class="active">Recargar abonado</li>
		</ol>
		
		<!-- PANEL DE CONTENIDO -->
		<div class="panel panel-success">
		  <div class="panel-heading">RECARGAR ABONADO</div>
			<div class="panel-body">

				<div class="col-md-6 col-md-offset-3">
				      <form name="frmRecargar" novalidate ng-submit="recargar( recargarForm, recargarForm.$valid )">
					      <fieldset>					
							<div class="form-group label-floating">
								<label class="control-label" for="focusedInput2">Número abonado</label>
								<input class="form-control" name="numero" id="numero" type="text" required ng-model="recargarForm.numero" ng-minlength="10" ng-maxlength="10">
								<p ng-show="!frmRecargar.$pristine && frmRecargar.numero.$error.required" class="help-block">Número abonado origen es requerido</p>
								<p ng-show="!frmRecargar.$pristine && frmRecargar.numero.$error.minlength" class="help-block">Número mínimo de 10 digitos</p>
								<p ng-show="!frmRecargar.$pristine && frmRecargar.numero.$error.maxlength" class="help-block">Número máximo de 10 digitos</p>
							</div>

							<div class="form-group label-floating">
								<label class="control-label" for="focusedInput2">Plan</label>
								<!-- <input class="form-control" name="plan" id="plan" type="number" required ng-model="recargarForm.plan"> -->
								<select name="plan" id="plan" class="form-control" required ng-model="recargarForm.plan">
						          	<option value="1">Plus</option>
							        <option value="2">Premium</option>
						        </select>
								<p ng-show="!frmRecargar.$pristine && frmRecargar.plan.$error.required" class="help-block">Plan es requerido</p>
							</div>

							<div class="form-group label-floating">
								<label class="control-label" for="focusedInput2">Monto</label>
								<input class="form-control" name="monto" id="monto" type="number" required ng-model="recargarForm.monto">
								<p ng-show="!frmRecargar.$pristine && frmRecargar.monto.$error.required" class="help-block">Monto es requerido</p>
							</div>

							<div class="form-group label-floating">
								<label class="control-label" for="focusedInput2">Número tarjeta</label>
								<input class="form-control" name="numTarjeta" id="numTarjeta" type="text" required ng-model="recargarForm.numTarjeta" ng-minlength="16">
								<p ng-show="!frmRecargar.$pristine && frmRecargar.numTarjeta.$error.required" class="help-block">Número tarjeta es requerido</p>
								<p ng-show="!frmRecargar.$pristine && frmRecargar.numTarjeta.$error.minlength" class="help-block">Número mínimo de 16 digitos</p>
							</div>

							<div class="form-group label-floating">
								<label class="control-label" for="focusedInput2">Código seguridad</label>
								<input class="form-control" name="codigoseguridad" id="codigoseguridad" type="number" required ng-model="recargarForm.codigoseguridad" ng-maxlength="3" ng-minlength="3">
								<p ng-show="!frmRecargar.$pristine && frmRecargar.codigoseguridad.$error.required && !frmRecargar.codigoseguridad.$valid" class="help-block">Código de seguridad requerido</p>
								<p ng-show="!frmRecargar.$pristine && frmRecargar.codigoseguridad.$error.minlength" class="help-block">Número mínimo de 3 digitos</p>
							</div>

							<div class="form-group label-floating">
								<label class="control-label" for="focusedInput2">Fecha expiración</label>
								<input class="form-control" name="fechaex" id="fechaex" type="text" required ng-model="recargarForm.fechaex" ng-maxlength="7" ng-minlength="7">
								<p ng-show="!frmRecargar.$pristine && frmRecargar.fechaex.$error.required && !frmRecargar.fechaex.$valid" class="help-block">Fecha de expiración requerida</p>
								<p ng-show="!frmRecargar.$pristine && frmRecargar.fechaex.$error.minlength" class="help-block">Mínimo 7 caracteres</p>
								<p ng-show="!frmRecargar.$pristine && frmRecargar.fechaex.$error.maxlength" class="help-block">Máximo 7 caracteres</p>
							</div>

							<div class="form-group">
								<button type="submit" class="btn btn-primary" ng-disabled="frmRecargar.$invalid" >Recargar</button>
							</div>					

						  </fieldset>
					</form>

				</div>

			</div>
		</div>

	</div>

</div>

<?php $this->view('elements/footer');?>