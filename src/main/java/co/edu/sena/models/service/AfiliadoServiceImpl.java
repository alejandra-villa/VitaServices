package co.edu.sena.models.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.sena.models.entity.Afiliado;
import co.edu.sena.repository.AfiliadoRepository;

@Service
public class AfiliadoServiceImpl implements AfiliadoService{
	
	@Autowired
	AfiliadoRepository afiliadoRepository;
	
	@Override
	public Optional<Afiliado> findById(Integer id) {
		return afiliadoRepository.findById(id);
	}

	@Override
	public List<Afiliado> findAll() {
		return afiliadoRepository.findAll();
	}

	@Override
	public Afiliado save(Afiliado afiliado) {
		return afiliadoRepository.save(afiliado);
	}

	@Override
	public void deleteById(Integer id) {
		afiliadoRepository.deleteById(id);
	}
	
}
