package com.example.service;

import java.util.List;

import com.example.model.Producto;

public interface ProductoService {
	
	List<Producto> catalogo();
	List<Producto> productosCategoria(String categoria);
	Producto productoCodigo(int codigo);
	void altaProducto(Producto producto);
	Producto eliminarProducto(int cod);
	Producto actualizarPrecio(int cod, double precio);

}
