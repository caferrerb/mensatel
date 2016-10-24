<?php
defined('BASEPATH') OR exit('No direct script access allowed');

class EnviarMensaje extends CI_Controller {

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

        $this->load->view('enviarmensaje/index', $this->data);
    }

    public function enviarMensaje(){

        $params = array(
            'Enviarmsj' => $this->input->get()
        );

        $response = $this->rest->post($this->records->path_enviar_mensaje, //Uri del servicio
                                      json_encode($params), //array de parametros
                                      'json' //mimetype a enviar
                                     ); 

        echo json_encode($response);

    }
}