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

        $abonadorigen = $this->input->get('abonadoorigen');
        $abonadodestino = $this->input->get('abonadodestino');
        $mensaje = $this->input->get('mensaje');

        $params = array(
            'Enviarmsj' => array(
                'abonadoorigen' => $abonadorigen,
                'abonadodestino' => $abonadodestino,
                'mensaje' => $mensaje
                )
        );

        $response = $this->rest->post($this->records->path_enviar_mensaje, //Uri del servicio
                                      json_encode($params), //array de parametros
                                      'json' //mimetype a enviar
                                     ); 

        echo "<pre>";
        print_r($response);
        echo "</pre>";
        die(__FILE__ . ' - In line - ' . __LINE__);

    }
}