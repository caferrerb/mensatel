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
				      <form>
					      <fieldset>					
							<div class="form-group label-floating">
								<label class="control-label" for="focusedInput2">Número abonado</label>
								<input class="form-control" name="numero" id="numero" type="number" required ng-model="numero">
								<p class="help-block">Número abonado</p>
							</div>

							<div class="form-group label-floating">
								<label class="control-label" for="focusedInput2">Documento</label>
								<input class="form-control" name="documento" id="documento" type="text" required ng-model="documento">
								<p class="help-block">Documento</p>
							</div>

							<div class="form-group label-floating">
								<label class="control-label" for="focusedInput2">Tipo documento</label>
								<input class="form-control" name="tipodoc" id="tipodoc" type="text" required ng-model="tipodoc">
								<p class="help-block">Tipo documento</p>
							</div>

							<div class="form-group">
								<button type="submit" class="btn btn-primary" ng-click="suscribirAbonado(numero, documento, tipodoc)">Registrar</button>
							</div>					

						  </fieldset>
					</form>
					{{respuestaSuscripcion}}
				</div>

			</div>
		</div>

	</div>

</div>

<?php $this->view('elements/footer');?>