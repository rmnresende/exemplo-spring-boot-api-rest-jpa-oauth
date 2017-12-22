package br.com.dynamicdev.sommelierapi.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.dynamicdev.sommelierapi.model.Vinho;
import br.com.dynamicdev.sommelierapi.respository.VinhoRepository;

@RestController
@RequestMapping("/vinhos")
public class VinhoResource {

	@Autowired
	private VinhoRepository vinhoRepository;

	@GetMapping
	private List<Vinho> listar() {
		return vinhoRepository.findAll();
	}

	@GetMapping("/{id}")
	public ResponseEntity<Vinho> buscarPeloId(@PathVariable Long id) {

		Vinho vinho = vinhoRepository.findOne(id);

		return ResponseEntity.ok().body(vinho);
	}

	@PostMapping
	private ResponseEntity<Void> salvar(@RequestBody Vinho vinho) {

		vinho = vinhoRepository.save(vinho);

		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(vinho.getId()).toUri();

		return ResponseEntity.created(uri).build();
	}

}
