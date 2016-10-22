<?php
defined('BASEPATH') OR exit('No direct script access allowed');

class Login extends CI_Controller {


	
	public function __construct()
    {
        parent::__construct();

       
    }


    public function index(){
        $this->data['title'] = "Mensatel ADMIN";

        // $this->load->view('elements/header', $this->data);
        // $this->load->view('elements/footer');
    }


}