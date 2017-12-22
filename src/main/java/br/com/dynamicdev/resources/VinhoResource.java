package br.com.dynamicdev.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.dynamicdev.model.Vinho;
import br.com.dynamicdev.repository.VinhoRepository;

@RestController
@RequestMapping("/vinhos")
public class VinhoResource {
	
	@Autowired
	private VinhoRepository vinhoRepository;
	
	@GetMapping
	private List<Vinho> listar(){
		return vinhoRepository.findAll();
	}
	
	@PostMapping
	private ResponseEntity<Void> salvar(@RequestBody Vinho vinho) {
		
		vinho = vinhoRepository.save(vinho);		
		
		URI uri = ServletUriComponentsBuilder
				.fromCurrentRequest().path("/{id}").buildAndExpand(vinho.getId()).toUri();
		
		return ResponseEntity.created(uri).build();		
	}

}
