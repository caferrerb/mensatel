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
				      <form>
					      <fieldset>					
							<div class="form-group label-floating">
								<label class="control-label" for="focusedInput2">Número abonado</label>
								<input class="form-control" name="numero" id="numero" type="text" required ng-model="numero">
								<p class="help-block">Número</p>
							</div>

							<div class="form-group label-floating">
								<label class="control-label" for="focusedInput2">Plan</label>
								<input class="form-control" name="plan" id="plan" type="number" required ng-model="plan">
								<p class="help-block">Plan</p>
							</div>

							<div class="form-group label-floating">
								<label class="control-label" for="focusedInput2">Monto</label>
								<input class="form-control" name="monto" id="monto" type="number" required ng-model="monto">
								<p class="help-block">Monto</p>
							</div>

							<div class="form-group label-floating">
								<label class="control-label" for="focusedInput2">Número tarjeta</label>
								<input class="form-control" name="numTarjeta" id="numTarjeta" type="text" required ng-model="numTarjeta">
								<p class="help-block">Número tarjeta</p>
							</div>

							<div class="form-group label-floating">
								<label class="control-label" for="focusedInput2">Código seguridad</label>
								<input class="form-control" name="codigoseguridad" id="codigoseguridad" type="number" required ng-model="codigoseguridad">
								<p class="help-block">Código seguridad</p>
							</div>

							<div class="form-group label-floating">
								<label class="control-label" for="focusedInput2">Fecha expiración</label>
								<input class="form-control" name="fechaex" id="fechaex" type="text" required ng-model="fechaex">
								<p class="help-block">Fecha expiración</p>
							</div>

							<div class="form-group">
								<button type="submit" class="btn btn-primary" ng-click="recargar(numero, plan, monto, numTarjeta, codigoseguridad, fechaex)">Recargar</button>
							</div>					

						  </fieldset>
					</form>

					{{respuestaRecarga}}

				</div>

			</div>
		</div>

	</div>

</div>

<?php $this->view('elements/footer');?>