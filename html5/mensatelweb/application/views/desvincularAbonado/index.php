<?php
defined('BASEPATH') OR exit('No direct script access allowed');

$this->view('elements/header'); ?>



<div class="row" ng-controller="desvincularAbonadoCtrl">
	
	<div class="col-sm-12">
		
		<!-- MIGA DE PAN -->
		<ol class="breadcrumb">
		  <li><a href="#">Home</a></li>
		  <li class="active">Desvincular abonado</li>
		</ol>
		
		<!-- PANEL DE CONTENIDO -->
		<div class="panel panel-success">
		  <div class="panel-heading">DESVINCULAR ABONADO</div>
			<div class="panel-body">

				<div class="col-md-6 col-md-offset-3">
				      <form name="frmDesvincularAbonado" novalidate ng-submit="desvincularAbonado(desvincularAbonadoForm , desvincularAbonadoForm.$valid )">
					      <fieldset>					
							<div class="form-group label-floating">
								<label class="control-label" for="focusedInput2">Número abonado</label>
								<input class="form-control" name="numero" id="numero" type="number" required ng-model="desvincularAbonadoForm.numero" ng-minlength="10" ng-maxlength="10">
								<p ng-show="!frmDesvincularAbonado.$pristine && frmDesvincularAbonado.numero.$error.required" class="help-block">Número abonado es requerido</p>
								<p ng-show="!frmDesvincularAbonado.$pristine && frmDesvincularAbonado.numero.$error.minlength" class="help-block">Número mínimo de 10 digitos</p>
								<p ng-show="!frmDesvincularAbonado.$pristine && frmDesvincularAbonado.numero.$error.maxlength" class="help-block">Número máximo de 10 digitos</p>
							</div>
							
							<div class="form-group">
								<button type="submit" class="btn btn-primary" ng-disabled="frmDesvincularAbonado.$invalid">Desvincular abonado</button>
							</div>				

						  </fieldset>
					</form>
				</div>

			</div>
		</div>

	</div>

</div>

<?php $this->view('elements/footer');?>