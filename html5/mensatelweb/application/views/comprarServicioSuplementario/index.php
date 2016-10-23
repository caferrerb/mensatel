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
				      <form>
					      <fieldset>					
							<div class="form-group label-floating">
								<label class="control-label" for="focusedInput2">Número abonado</label>
								<input class="form-control" name="numeroabonado" id="numeroabonado" type="text" required ng-model="numeroabonado">
								<p class="help-block">Número abonado</p>
							</div>

							<div class="form-group label-floating">
								<label class="control-label" for="focusedInput2">Código servicio</label>
								<input class="form-control" name="codigoservicio" id="codigoservicio" type="text" required ng-model="codigoservicio">
								<p class="help-block">Código servicio</p>
							</div>	

							<div class="form-group">
								<button type="submit" class="btn btn-primary" ng-click="comprarServicioSuplementario(numeroabonado, codigoservicio)">Comprar</button>
							</div>					

						  </fieldset>
					</form>

					{{respuestaCompra}}

				</div>

			</div>
		</div>

	</div>

</div>

<?php $this->view('elements/footer');?>