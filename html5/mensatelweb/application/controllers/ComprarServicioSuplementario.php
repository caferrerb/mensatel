<?php
defined('BASEPATH') OR exit('No direct script access allowed');

class ComprarServicioSuplementario extends CI_Controller {

	public function __construct()
    {
        parent::__construct();

        $this->records = $this->configuracion_model->getAll();
        $this->records = $this->records[0];

        // Set config options (only 'server' is required to work)
        $config = array('server' => 'http://'.$this->records->host.':'.$this->records->puerto);

        // Run some setup
        $this->rest->initialize($config);
    }

     /**
     * 
     */
    public function index(){
        $this->data['title'] = "Mensatel ADMIN";

        $this->load->view('comprarServicioSuplementario/index', $this->data);
    }

    public function comprarServicioSuplementario(){
        $numeroabonado = $this->input->get('numeroabonado');
        $codigoservicio  = $this->input->get('codigoservicio');
        
        $params = array(
            'Agregarservicio' => array(
                    'numeroabonado'=> $numeroabonado,
                    'codigoservicio'=> $codigoservicio)
        );

        $response = $this->rest->post($this->records->path_comprar_servicio_suplementario, //Uri del servicio
                              json_encode($params), //array de parametros
                              'json' //mimetype a enviar
                             ); 

        echo "<pre>";
        print_r($response);
        echo "</pre>";
        die(__FILE__ . ' - In line - ' . __LINE__);

    }
}