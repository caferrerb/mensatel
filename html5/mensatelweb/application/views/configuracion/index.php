<?php
defined('BASEPATH') OR exit('No direct script access allowed');

$this->view('elements/header'); ?>



<div class="row">

	<div class="col-sm-12">
		
		<!-- MIGA DE PAN -->
		<ol class="breadcrumb">
		  <li><a href="#">Home</a></li>
		  <li class="active">Configuración</li>
		</ol>
		
		<!-- PANEL DE CONTENIDO -->
		<div class="panel panel-success">
		  <div class="panel-heading">CONFIGURACIÓN</div>
		  <div class="panel-body">
		    


			<div class="col-md-6 col-md-offset-3">
			    <?php echo form_open('configuracion/guardar'); ?>
				  <fieldset>


				    <div class="form-group label-floating">
					  <label class="control-label" for="focusedInput2">Host Principal</label>
					  <input class="form-control" name="host" id="focusedInput2" type="text" required value="<?php echo $data->host ?>">
					  <p class="help-block">Dominio o IP del host</p>
					</div>

					<div class="form-group label-floating">
					  <label class="control-label" for="focusedInput2">Puerto</label>
					  <input class="form-control" name="puerto" id="focusedInput2" type="text" value="<?php echo $data->puerto ?>" required>
					  <p class="help-block">Puerto de conexión</p>
					</div>

					<div class="form-group label-floating">
					  <label class="control-label" for="focusedInput2">Uri Recargas</label>
					  <input class="form-control" name="path_recargas" id="focusedInput2" type="text" required value="<?php echo $data->path_recargas ?>">
					  <p class="help-block">Endpoint para las recargas</p>
					</div>

					<div class="form-group label-floating">
					  <label class="control-label" for="focusedInput2">Uri Envio mensaje</label>
					  <input class="form-control" name="path_enviar_mensaje" id="focusedInput2" type="text" required value="<?php echo $data->path_enviar_mensaje ?>">
					  <p class="help-block">Endpoint para el envío de mensaje</p>
					</div>

					<div class="form-group label-floating">
					  <label class="control-label" for="focusedInput2">Uri Suscribir abonado</label>
					  <input class="form-control" name="path_suscribir_abonado" id="focusedInput2" type="text" required value="<?php echo $data->path_suscribir_abonado ?>">
					  <p class="help-block">Endpoint para suscribir abonado</p>
					</div>


					<div class="form-group label-floating">
					  <label class="control-label" for="focusedInput2">Uri Comprar servicio suplementario</label>
					  <input class="form-control" name="path_comprar_servicio_suplementario" id="focusedInput2" type="text" required value="<?php echo $data->path_comprar_servicio_suplementario ?>">
					  <p class="help-block">Endpoint para comprar servicio suplementario</p>
					</div>


					<div class="form-group label-floating">
					  <label class="control-label" for="focusedInput2">Uri Cancelar servicio suplementario</label>
					  <input class="form-control" name="path_cancelar_servicio_suplementario" id="focusedInput2" type="text" required value="<?php echo $data->path_cancelar_servicio_suplementario ?>">
					  <p class="help-block">Endpoint para cancelar servicio suplementario</p>
					</div>

					<div class="form-group label-floating">
					  <label class="control-label" for="focusedInput2">Uri Cancelar suscripción</label>
					  <input class="form-control" name="path_cancelar_suscripcion" id="focusedInput2" type="text" required value="<?php echo $data->path_cancelar_suscripcion ?>">
					  <p class="help-block">Endpoint para cancelar suscripción</p>
					</div>

					<div class="form-group label-floating">
					  <label class="control-label" for="focusedInput2">Uri Registrar usuario</label>
					  <input class="form-control" name="path_registrar_usuario" id="focusedInput2" type="text" required value="<?php echo $data->path_registrar_usuario ?>">
					  <p class="help-block">Endpoint para registrar usuario</p>
					</div>

					<div class="form-group label-floating">
					  <label class="control-label" for="focusedInput2">Uri Listar planes</label>
					  <input class="form-control" name="path_listar_planes" id="focusedInput2" type="text" required value="<?php echo $data->path_listar_planes ?>">
					  <p class="help-block">Endpoint para listar planes</p>
					</div>

					<input type="hidden" name="id" value="<?php echo $data->id ?>">
				    
				    <div class="form-group">
				        <button type="submit" class="btn btn-primary">Actualizar</button>
				    </div>


				  </fieldset>
				</form>
			</div>

		  </div>
		</div>

	</div>

</div>







<?php $this->view('elements/footer');?>