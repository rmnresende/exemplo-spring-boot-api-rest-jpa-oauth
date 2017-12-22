package br.com.dynamicdev.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

}
