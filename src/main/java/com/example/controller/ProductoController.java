package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.Producto;
import com.example.service.ProductoServiceImpl;

@RestController
@RequestMapping("productos")
public class ProductoController {
	@Autowired
	ProductoServiceImpl productoService;
	
	@GetMapping
	public List<Producto> catalogo(){
		return productoService.catalogo();
	}

	@GetMapping("/welcome")
	public String welcome(){
		return "Welcome people!!!";
	}
	
	@GetMapping("/{categoria}")
	public List<Producto> productosCategoria(@PathVariable("categoria") String categoria){
		return productoService.productosCategoria(categoria);
	}
	
	//en este método, el codigo se espera a traves de un parametro y no de la url
	@GetMapping(value="producto/{codigo}")
	public Producto productoCodigo(@PathVariable("codigo") int codigo) {
		return productoService.productoCodigo(codigo);
	}
	
	@PostMapping
	public void altaProducto(@RequestBody Producto producto) {
		productoService.altaProducto(producto);
	}
	
	@DeleteMapping(value = "/{codigo}")
	public Producto eliminarProducto(@PathVariable("codigo") int codigo) {
		return productoService.eliminarProducto(codigo);
	}
	
	@PutMapping
	public Producto actualizarPrecio(@RequestParam("codigo") int codigo, @RequestParam("precio") double precio) {
		return productoService.actualizarPrecio(codigo, precio);
	}

}
