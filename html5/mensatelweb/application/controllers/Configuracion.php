<?php
defined('BASEPATH') OR exit('No direct script access allowed');

class Configuracion extends CI_Controller {


	
	public function __construct()
    {
        parent::__construct();

    }

    /**
     * 
     */
    public function index(){
        $this->data['title'] = "Mensatel - Configuración";

        $datos = $this->configuracion_model->getAll();
        $this->data['data'] = $datos[0];

        $this->load->view('configuracion/index', $this->data);
    }

    public function guardar(){

        $data = $this->input->post();

        $response = $this->configuracion_model->update($data);

        redirect('Configuracion/index');
    }

}