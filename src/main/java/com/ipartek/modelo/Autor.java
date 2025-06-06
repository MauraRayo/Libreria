package com.ipartek.modelo;

public class Autor {

	private int id_autor;
	private String autor;
	private String fecha_nacimiento;
	private String fecha_defuncion;
	private int FK_nacionalidad;

	public Autor(int id_autor, String autor, String fecha_nacimiento, String fecha_defuncion, int fK_nacionalidad) {
		super();
		this.id_autor = id_autor;
		this.autor = autor;
		this.fecha_nacimiento = fecha_nacimiento;
		this.fecha_defuncion = fecha_defuncion;
		FK_nacionalidad = fK_nacionalidad;
	}

	public Autor() {
		super();
		this.id_autor = 0;
		this.autor = "";
		this.fecha_nacimiento = "";
		this.fecha_defuncion = "";
		FK_nacionalidad = 0;
	}

	public int getId_autor() {
		return id_autor;
	}

	public void setId_autor(int id_autor) {
		this.id_autor = id_autor;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public String getFecha_nacimiento() {
		return fecha_nacimiento;
	}

	public void setFecha_nacimiento(String fecha_nacimiento) {
		this.fecha_nacimiento = fecha_nacimiento;
	}

	public String getFecha_defuncion() {
		return fecha_defuncion;
	}

	public void setFecha_defuncion(String fecha_defuncion) {
		this.fecha_defuncion = fecha_defuncion;
	}

	public int getFK_nacionalidad() {
		return FK_nacionalidad;
	}

	public void setFK_nacionalidad(int fK_nacionalidad) {
		FK_nacionalidad = fK_nacionalidad;
	}

	@Override
	public String toString() {
		return "Autor [id_autor=" + id_autor + ", autor=" + autor + ", fecha_nacimiento=" + fecha_nacimiento
				+ ", fecha_defuncion=" + fecha_defuncion + ", FK_nacionalidad=" + FK_nacionalidad + "]";
	}

}
