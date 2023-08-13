package co.edu.sena.models.service;

import java.util.List;
import java.util.Optional;

import co.edu.sena.models.entity.Afiliado;

public interface AfiliadoService {
	
	public Optional<Afiliado>findById(Integer id);
	public List<Afiliado> findAll();
	public Afiliado save(Afiliado afiliado);
	public void deleteById(Integer id);
}
