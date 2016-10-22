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
				      <form>
					      <fieldset>					
							<div class="form-group label-floating">
								<label class="control-label" for="focusedInput2">Número abonado origen</label>
								<input class="form-control" name="abonadoorigen" id="abonadoorigen" type="number" required>
								<p class="help-block">Número abonado origen</p>
							</div>

							<div class="form-group label-floating">
								<label class="control-label" for="focusedInput2">Número abonado destino</label>
								<input class="form-control" name="abonadodestino" id="abonadodestino" type="number" required>
								<p class="help-block">Número abonado destino</p>
							</div>

							<div class="form-group label-floating">
								<label class="control-label" for="focusedInput2">Mensaje</label>
								<input class="form-control" name="mensaje" id="mensaje" type="number" required>
								<p class="help-block">Mensaje</p>
							</div>

							<div class="form-group">
								<button type="submit" class="btn btn-primary">Enviar mensaje	</button>
							</div>					

						  </fieldset>
					</form>
				</div>

			</div>
		</div>

	</div>

</div>

<?php $this->view('elements/footer');?>