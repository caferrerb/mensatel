<?php
defined('BASEPATH') OR exit('No direct script access allowed');

class Recargar extends CI_Controller {


	
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

        $this->load->view('recargar/index', $this->data);
    }

    /**
     * 
     */
    public function web(){
       

        $mensaje = $this->input->get('mensaje');



        //Parametros o body de la solicitud de acuerdo al mimetype enviado
        $params = array(
            'to'=>'eajqbebaq2o:APA91bGUJtX1AAYi9rRD-un3-tca0jvNDOH0KPp2jrdGA-GYS0_Oa3sWYfxwkbsCEjwcChTaKB8pbqcmEQeQD5gGe0YAeEfXYdJ7C29CQRFDYlkG38cfNouT4RPceJ6SRbQfoVH0tiCU',
            'data'=>array('origen'=>'CESAR','mensaje'=>$mensaje));

        //Se agregan cabeceras adicionales
        $this->rest->http_header('Authorization','key=AIzaSyDR3TxgyVVJeVKwBXVDcHZbswB1LIRfJow');


        //Envio de la solicitud
        $response = $this->rest->post($this->records->path_recargas, //Uri del servicio
                                      json_encode($params), //array de parametros
                                      'json' //mimetype a enviar
                                     ); 

        echo json_encode($response);
    }


    public function consultarOperador(){

        $abonado = $this->input->get('abonado');

        $params = array(
            'ConsultarOperador' => array(
                'numeroabonado' => $abonado
                )
        );

        $response = $this->rest->post($this->records->path_recargas, //Uri del servicio
                                      json_encode($params), //array de parametros
                                      'json' //mimetype a enviar
                                     ); 

        echo "<pre>";
        print_r($response->ConsultarOperadorResponse->return);
        echo "</pre>";
        die(__FILE__ . ' - In line - ' . __LINE__);

    }

    public function recargar(){
        $numero = $this->input->get('numero');
        $plan  = $this->input->get('plan');
        $monto = $this->input->get('monto');
        $numTarjeta  = $this->input->get('numTarjeta');
        $codigoseguridad = $this->input->get('codigoseguridad');
        $fechaex  = $this->input->get('fechaex');

        $params = array(
            'Recargarabonado' => array(
                    'numero'=> $numero,
                    'plan'=> $plan,
                    'monto' => $monto,
                    'numTarjeta' => $numTarjeta,
                    'codigoseguridad' => $codigoseguridad,
                    'fechaex' => $fechaex
                )
        );

        $response = $this->rest->post($this->records->path_recargas, //Uri del servicio
                              json_encode($params), //array de parametros
                              'json' //mimetype a enviar
                             ); 

        echo "<pre>";
        print_r($response);
        echo "</pre>";
        die(__FILE__ . ' - In line - ' . __LINE__);

    }

    public function realizarRecarga(){
        $records = $this->configuracion_model->getAll();
    }


}