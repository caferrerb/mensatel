<?php 

class Estudiante_model extends CI_Model {

     public $id;
     public $codigo;
     public $nombre;
     public $apellido;
     public $cedula;
     public $semestre;
     public $edad;


    public function __construct()
    {
        // Call the CI_Model constructor
        parent::__construct();
        $this->load->database();
    }

    public function getAll(){
    	$query = $this->db->get('estudiante');
        return $query->result();
    }

    public function searchBy($campo, $criterio)
    {
    	$this->db->where($campo, $criterio);
        $query = $this->db->get('estudiante');
        return $query->result();
    }

    public function insert($data)
    {
        unset($data['type']);
        unset($data['id']);
        return $this->db->insert('estudiante', $data);
    }

    public function update($data)
    {
        unset($data['type']);
        return $this->db->update('estudiante', $data, array('id' => $data['id']));
    }

    public function delete($id){

    	return $this->db->delete('estudiante', array('id' => $id)); 
    }

    public function validateInsertUpdate($data){

        $this->db->where('codigo', $data['codigo']);
        $this->db->or_where('cedula', $data['cedula']);
        $query = $this->db->get('estudiante')->result();

        if($query){
            return false;
        }else{
            return true;
        }
    }

    public function validateCode($data){

        $this->db->where('codigo', $data['codigo']);
        $this->db->or_where('cedula', $data['cedula']);
        $query = $this->db->get('estudiante')->result();

        if($query){
            return false;
        }else{
            return true;
        }
    }

}

 ?>