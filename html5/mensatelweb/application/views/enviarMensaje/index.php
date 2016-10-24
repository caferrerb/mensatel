<?php
defined('BASEPATH') OR exit('No direct script access allowed');

$this->view('elements/header'); ?>



<div class="row" ng-controller="enviarMensajeCtrl">
	
	<div class="col-sm-12">
		
		<!-- MIGA DE PAN -->
		<ol class="breadcrumb">
		  <li><a href="#">Home</a></li>
		  <li class="active">Enviar mensaje</li>
		</ol>
		
		<!-- PANEL DE CONTENIDO -->
		<div class="panel panel-success">
		  <div class="panel-heading">ENVIAR MENSAJE</div>
			<div class="panel-body">



				<div class="col-md-6 col-md-offset-3">
				      <form name="frmEnviarMensaje" ng-submit="enviarMensaje( formData, formData.$valid )">
					      <fieldset>					
							<div class="form-group label-floating">
								<label class="control-label" for="focusedInput2">Número abonado origen</label>
								<input class="form-control" name="abonadoorigen" id="abonadoorigen" type="number" required ng-model="formData.abonadoorigen">
								<p ng-show="!frmEnviarMensaje.$pristine && frmEnviarMensaje.abonadoorigen.$error.required" class="help-block">Número abonado origen es requerido</p>
							</div>

							<div class="form-group label-floating">
								<label class="control-label" for="focusedInput2">Número abonado destino</label>
								<input class="form-control" name="abonadodestino" id="abonadodestino" type="number" required ng-model="formData.abonadodestino">
								<p ng-show="!frmEnviarMensaje.$pristine && frmEnviarMensaje.abonadodestino.$error.required" class="help-block">Número abonado destino es requerido</p>
							</div>

							<div class="form-group label-floating">
								<label class="control-label" for="focusedInput2">Mensaje</label>
								<input class="form-control" name="mensaje" id="mensaje" type="text" required ng-model="formData.mensaje">
								<p ng-show="!frmEnviarMensaje.$pristine && frmEnviarMensaje.mensaje.$error.required" class="help-block">El mensaje es requerido</p>
							</div>

							<div class="form-group">
								<button type="submit" class="btn btn-primary" ng-disabled="!frmEnviarMensaje.$valid">
									Enviar mensaje 
								</button>
							</div>					

						  </fieldset>
					</form>
				</div>

			</div>
		</div>

	</div>

</div>

<?php $this->view('elements/footer');?>