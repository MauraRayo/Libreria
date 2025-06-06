package com.ipartek.modelo;

public class Categoria {
	private int id_categoria;
	private String categoria;

	public Categoria(int id_categoria, String categoria) {
		super();
		this.id_categoria = id_categoria;
		this.categoria = categoria;
	}

	public Categoria() {
		super();
		this.id_categoria = 0;
		this.categoria = "";
	}

	public int getId_categoria() {
		return id_categoria;
	}

	public void setId_categoria(int id_categoria) {
		this.id_categoria = id_categoria;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	@Override
	public String toString() {
		return "Categoria [id_categoria=" + id_categoria + ", categoria=" + categoria + "]";
	}

}
