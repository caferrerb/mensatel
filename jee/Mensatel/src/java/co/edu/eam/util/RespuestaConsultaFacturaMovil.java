package co.edu.eam.util;

public class RespuestaConsultaFacturaMovil {

	
	private String numero;
	private String valor;
	
	
	public RespuestaConsultaFacturaMovil(String numero, String valor) {
		super();
		this.numero = numero;
		this.valor = valor;
	}
	/**
	 * @return the numero
	 */
	public String getNumero() {
		return numero;
	}
	/**
	 * @param numero the numero to set
	 */
	public void setNumero(String numero) {
		this.numero = numero;
	}
	/**
	 * @return the valor
	 */
	public String getValor() {
		return valor;
	}
	/**
	 * @param valor the valor to set
	 */
	public void setValor(String valor) {
		this.valor = valor;
	}
	
	
}
