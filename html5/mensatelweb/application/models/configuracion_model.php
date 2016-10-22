<?php 

class Configuracion_model extends CI_Model {



    public function __construct()
    {
        // Call the CI_Model constructor
        parent::__construct();
        $this->load->database();
    }

    public function getAll(){
        $query = $this->db->get('configuracion');
        return $query->result();
    }

    public function update($data){
        return $this->db->update('configuracion', $data, array('id' => $data['id']));
    }

}

 ?>