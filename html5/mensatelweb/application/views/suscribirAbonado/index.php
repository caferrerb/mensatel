<?php
defined('BASEPATH') OR exit('No direct script access allowed');

$this->view('elements/header'); ?>



<div class="row" ng-controller="suscribirAbonadoCtrl">
	
	<div class="col-sm-12">
		
		<!-- MIGA DE PAN -->
		<ol class="breadcrumb">
		  <li><a href="#">Home</a></li>
		  <li class="active">Suscribir abonado</li>
		</ol>
		
		<!-- PANEL DE CONTENIDO -->
		<div class="panel panel-success">
		  <div class="panel-heading">SUSCRIBIR ABONADO</div>
			<div class="panel-body">

				<div class="col-md-6 col-md-offset-3">
				      <form name="frmSuscribirAbonado" novalidate ng-submit="suscribirAbonado(suscribirAbonadoForm , suscribirAbonadoForm.$valid )">
					      <fieldset>					
							<div class="form-group label-floating">
								<label class="control-label" for="focusedInput2">Número abonado</label>
								<input class="form-control" name="numero" id="numero" type="number" required ng-model="suscribirAbonadoForm.numero" ng-minlength="10" ng-maxlength="10">
								<p ng-show="!frmSuscribirAbonado.$pristine && frmSuscribirAbonado.numero.$error.required" class="help-block">Número abonado es requerido</p>
								<p ng-show="!frmSuscribirAbonado.$pristine && frmSuscribirAbonado.numero.$error.minlength" class="help-block">Número mínimo de 10 digitos</p>
								<p ng-show="!frmSuscribirAbonado.$pristine && frmSuscribirAbonado.numero.$error.maxlength" class="help-block">Número máximo de 10 digitos</p>
							</div>

							<div class="form-group label-floating">
								<label class="control-label" for="focusedInput2">Documento</label>
								<input class="form-control" name="doc" id="doc" type="text" required ng-model="suscribirAbonadoForm.doc" ng-minlength="6" ng-maxlength="12">
								<p ng-show="!frmSuscribirAbonado.$pristine && frmSuscribirAbonado.doc.$error.required" class="help-block">Número abonado es requerido</p>
								<p ng-show="!frmSuscribirAbonado.$pristine && frmSuscribirAbonado.doc.$error.minlength" class="help-block">Número mínimo de 10 digitos</p>
								<p ng-show="!frmSuscribirAbonado.$pristine && frmSuscribirAbonado.doc.$error.maxlength" class="help-block">Número máximo de 10 digitos</p>
							</div>

							<div class="form-group label-floating">
								<label class="control-label" for="focusedInput2">Tipo documento</label>
								<select name="tipodoc" id="tipodoc" class="form-control" required ng-model="suscribirAbonadoForm.tipodoc">
						          	<option value="CEDULA">Cedula</option>
							        <option value="TI">Tarjeta identidad</option>
							        <option value="PAS">Pasaporte</option>
						        </select>

								<p ng-show="!frmSuscribirAbonado.$pristine && frmSuscribirAbonado.tipodoc.$error.required" class="help-block">Tipo documento es requerido</p>
							</div>
							<div class="form-group">
								<button type="submit" class="btn btn-primary" ng-disabled="frmSuscribirAbonado.$invalid" >Registrar</button>
							</div>				

						  </fieldset>
					</form>
				</div>

			</div>
		</div>

	</div>

</div>

<?php $this->view('elements/footer');?>