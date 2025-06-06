package com.ipartek.modelo;

public class Libro {

	private int id_libro;
	private String titulo;
	private String isbn;
	private int stock;
	private double precio;
	private int FK_categoria;
	private int FK_autor;

	public Libro(int id_libro, String titulo, String isbn, int stock, double precio, int fK_categoria, int fK_autor) {
		super();
		this.id_libro = id_libro;
		this.titulo = titulo;
		this.isbn = isbn;
		this.stock = stock;
		this.precio = precio;
		FK_categoria = fK_categoria;
		FK_autor = fK_autor;
	}

	public Libro() {
		super();
		this.id_libro = 0;
		this.titulo = "";
		this.isbn = "";
		this.stock = 0;
		this.precio = 0;
		FK_categoria = 0;
		FK_autor = 0;
	}

	public int getId_libro() {
		return id_libro;
	}

	public void setId_libro(int id_libro) {
		this.id_libro = id_libro;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public int getFK_categoria() {
		return FK_categoria;
	}

	public void setFK_categoria(int fK_categoria) {
		FK_categoria = fK_categoria;
	}

	public int getFK_autor() {
		return FK_autor;
	}

	public void setFK_autor(int fK_autor) {
		FK_autor = fK_autor;
	}

	@Override
	public String toString() {
		return "Libro [id_libro=" + id_libro + ", titulo=" + titulo + ", isbn=" + isbn + ", stock=" + stock
				+ ", precio=" + precio + ", FK_categoria=" + FK_categoria + ", FK_autor=" + FK_autor + "]";
	}

}
