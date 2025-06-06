package com.ipartek.modelo;

public class Nacionalidad {

	private int id_nacionalidad;
	private String nombre;

	public Nacionalidad(int id_nacionalidad, String nombre) {
		super();
		this.id_nacionalidad = id_nacionalidad;
		this.nombre = nombre;
	}

	public Nacionalidad() {
		super();
		this.id_nacionalidad = 0;
		this.nombre = "";
	}

	public int getId_nacionalidad() {
		return id_nacionalidad;
	}

	public void setId_nacionalidad(int id_nacionalidad) {
		this.id_nacionalidad = id_nacionalidad;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Override
	public String toString() {
		return "Nacionalidad [id_nacionalidad=" + id_nacionalidad + ", nombre=" + nombre + "]";
	}

}
