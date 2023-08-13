package co.edu.sena.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.edu.sena.models.entity.Producto;
import co.edu.sena.models.service.ProductoService;

@RestController
@RequestMapping("/api/productos")
public class ProductoController {
	
	@Autowired
	ProductoService productoService;
	
	@GetMapping("/{id}")
	public Optional<Producto> consultarPorId(@PathVariable Integer id) {
		
		return productoService.findById(id);
	}
	
	@GetMapping("/listar")
	public List<Producto> consultarTodos(){
		
		return productoService.findAll();
	}
	
	@PostMapping
	public Producto registar(@RequestBody Producto producto) {
		
		return productoService.save(producto);
	}
	
	@DeleteMapping("/{id}")
	public void eliminar(@PathVariable Integer id) {
		
		productoService.deleteById(id);
	}
	
	@PutMapping("/actualizar/{id}")
	public Producto actualizar(@RequestBody Producto producto, @PathVariable Integer id) {
		
		Producto productoDB = productoService.findById(id).get();
		
		productoDB.setNombre(producto.getNombre());
		productoDB.setDescripcion(producto.getDescripcion());
		productoDB.setPrecio(producto.getPrecio());
		
		return productoService.save(productoDB);
	}
		

}
