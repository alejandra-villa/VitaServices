package co.edu.sena.models.service;

import java.util.List;
import java.util.Optional;

import co.edu.sena.models.entity.Producto;

public interface ProductoService {
	
	public Optional<Producto>findById(Integer id);
	public List<Producto> findAll();
	public Producto save(Producto producto);
	public void deleteById(Integer id);
}
