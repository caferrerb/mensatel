<?php
defined('BASEPATH') OR exit('No direct script access allowed');

class DesvincularAbonado extends CI_Controller {

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

        $this->load->view('desvincularabonado/index', $this->data);
    }

    public function desvincularAbonado(){
        $numero = $this->input->get('numero');
        
        $params = array(
            'Desvincularabonado' => array(
                    'numero'=> $numero)
        );

        $response = $this->rest->post($this->records->path_cancelar_suscripcion, //Uri del servicio
                              json_encode($params), //array de parametros
                              'json' //mimetype a enviar
                             ); 

        echo "<pre>";
        print_r($response);
        echo "</pre>";
        die(__FILE__ . ' - In line - ' . __LINE__);

    }
}