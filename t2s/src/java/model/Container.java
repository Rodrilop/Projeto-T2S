/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author RodrigoLopes
 */
public class Container {
   
	/** The id cont. */
	private int id_cont;
	
	/** The num container. */
	private String num_container;
	
	/** The cliente. */
	private String cliente;
	
	/** The tipo. */
	private String tipo;
	
	/** The status. */
	private String status;
	
	/** The categoria. */
	private String categoria;

	/**
	 * Instantiates a new java beans cont.
	 */
	public Container() {
		super();
	}

	/**
	 * Instantiates a new java beans cont.
	 *
	 * @param id_cont the id cont
	 * @param num_container the num container
	 * @param cliente the cliente
	 * @param tipo the tipo
	 * @param status the status
	 * @param categoria the categoria
	 */
	public Container(int id_cont, String num_container, String cliente, String tipo, String status, String categoria) {
		super();
		this.id_cont = id_cont;
		this.cliente = cliente;
		this.num_container = num_container;
		this.tipo = tipo;
		this.status = status;
		this.categoria = categoria;
	}

	/**
	 * Gets the id cont.
	 *
	 * @return the id cont
	 */
	public int getId_cont() {
		return id_cont;
	}

	/**
	 * Sets the id cont.
	 *
	 * @param id_cont the new id cont
	 */
	public void setId_cont(int id_cont) {
		this.id_cont = id_cont;
	}
	
	/**
	 * Gets the num container.
	 *
	 * @return the num container
	 */
	public String getNum_container() {
		return num_container;
	}

	/**
	 * Sets the num container.
	 *
	 * @param num_container the new num container
	 */
	public void setNum_container(String num_container) {
		this.num_container = num_container;
	}
	
	/**
	 * Gets the cliente.
	 *
	 * @return the cliente
	 */
	public String getCliente() {
		return cliente;
	}

	/**
	 * Sets the cliente.
	 *
	 * @param cliente the new cliente
	 */
	public void setCliente(String cliente) {
		this.cliente = cliente;
	}


	/**
	 * Gets the tipo.
	 *
	 * @return the tipo
	 */
	public String getTipo() {
		return tipo;
	}

	/**
	 * Sets the tipo.
	 *
	 * @param tipo the new tipo
	 */
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	/**
	 * Gets the status.
	 *
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * Sets the status.
	 *
	 * @param status the new status
	 */
	public void setStatus(String status) {
		this.status = status;
	}

	/**
	 * Gets the categoria.
	 *
	 * @return the categoria
	 */
	public String getCategoria() {
		return categoria;
	}

	/**
	 * Sets the categoria.
	 *
	 * @param categoria the new categoria
	 */
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
}