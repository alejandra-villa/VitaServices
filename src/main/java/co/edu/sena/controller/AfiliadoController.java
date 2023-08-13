package co.edu.sena.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import co.edu.sena.models.entity.Afiliado;
import co.edu.sena.models.service.AfiliadoService;

@RestController
@RequestMapping("/api/afiliado")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.DELETE, RequestMethod.PUT})
public class AfiliadoController {
	
	@Autowired
	AfiliadoService afiliadoService;
	
	@GetMapping("/{id}")
	public Optional<Afiliado> consultarPorId(@PathVariable Integer id) {
		
		return afiliadoService.findById(id);
	}
	
	@GetMapping("/listar")
	public List<Afiliado> consultarTodos() {
		
		return afiliadoService.findAll();
	}
	
	@PostMapping
	public Afiliado registrar(@RequestBody Afiliado afiliado) {
		
		return afiliadoService.save(afiliado);
	}
	
	@DeleteMapping("/{id}")
	public void eliminar(@PathVariable Integer id) {
		
		afiliadoService.deleteById(id);
	}
	
	@PutMapping("/actualizar/{id}")
	public Afiliado actualizar(@RequestBody Afiliado afiliado, @PathVariable Integer id) {
		
		Afiliado afiliadoBD = afiliadoService.findById(id).get();
		
		afiliadoBD.setDocumento(afiliado.getDocumento());
		afiliadoBD.setNombres(afiliado.getNombres());
		afiliadoBD.setApellidos(afiliado.getApellidos());
		afiliadoBD.setEdad(afiliado.getEdad());
		afiliadoBD.setTelefono(afiliado.getTelefono());
		afiliadoBD.setCorreo(afiliado.getCorreo());
		afiliadoBD.setDireccion(afiliado.getDireccion());
		afiliadoBD.setBeneficiarios(afiliado.getBeneficiarios());
		
		return afiliadoService.save(afiliadoBD);
		
	}

}
