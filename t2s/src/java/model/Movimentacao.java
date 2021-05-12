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
public class Movimentacao {
   
	/** The id mov. */
	private int id_mov;
	
	/** The container. */
	private String container;
	
	/** The movimentacao. */
	private String movimentacao;
	
	/** The data inicio. */
	private String data_inicio;
	
	/** The data final. */
	private String data_final;
	
	/**
	 * Instantiates a new java beans mov.
	 */
	public Movimentacao() {
		super();
	}

	/**
	 * Instantiates a new java beans mov.
	 *
	 * @param id_mov the id mov
	 * @param container the container
	 * @param movimentacao the movimentacao
	 * @param data_inicio the data inicio
	 * @param data_final the data final
	 */
	public Movimentacao(int id_mov, String container, String movimentacao, String data_inicio, String data_final) {
		super();
		this.id_mov = id_mov;
		this.container = container;
		this.movimentacao = movimentacao;
		this.data_inicio = data_inicio;
		this.data_final = data_final;
	}
	
	/**
	 * Gets the id mov.
	 *
	 * @return the id mov
	 */
	public int getId_mov() {
		return id_mov;
	}	
	
	/**
	 * Sets the id mov.
	 *
	 * @param id_mov the new id mov
	 */
	public void setId_mov(int id_mov) {
		this.id_mov = id_mov;
	}

	/**
	 * Gets the container.
	 *
	 * @return the container
	 */
	public String getContainer() {
		return container;
	}	
	
	/**
	 * Sets the container.
	 *
	 * @param container the new container
	 */
	public void setContainer(String container) {
		this.container = container;
	}
	
	/**
	 * Gets the movimentacao.
	 *
	 * @return the movimentacao
	 */
	public String getMovimentacao() {
		return movimentacao;
	}

	/**
	 * Sets the movimentacao.
	 *
	 * @param movimentacao the new movimentacao
	 */
	public void setMovimentacao(String movimentacao) {
		this.movimentacao = movimentacao;
	}
	
	/**
	 * Gets the data inicio.
	 *
	 * @return the data inicio
	 */
	public String getData_inicio() {
		return data_inicio;
	}

	/**
	 * Sets the data inicio.
	 *
	 * @param data_inicio the new data inicio
	 */
	public void setData_inicio(String data_inicio) {
		this.data_inicio = data_inicio;
	}
	
	/**
	 * Gets the data final.
	 *
	 * @return the data final
	 */
	public String getData_final() {
		return data_final;
	}

	/**
	 * Sets the data final.
	 *
	 * @param data_final the new data final
	 */
	public void setData_final(String data_final) {
		this.data_final = data_final;
	}
}