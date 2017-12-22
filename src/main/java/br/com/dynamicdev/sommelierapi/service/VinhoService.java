package br.com.dynamicdev.sommelierapi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.dynamicdev.sommelierapi.model.Vinho;
import br.com.dynamicdev.sommelierapi.respository.VinhoRepository;
import br.com.dynamicdev.sommelierapi.service.exceptions.RecursoNaoEncontradoException;

@Service
public class VinhoService {
	
	@Autowired
	private VinhoRepository vinhoRepository;
	
	public List<Vinho> listar() {
		return vinhoRepository.findAll();
	}
	
	public Vinho buscarPeloId(Long id) {
		
		Vinho vinho = vinhoRepository.findOne(id);
		
		if(vinho == null) {
			
			/* neste caso ira lancar uma RecursoNaoEncontradoException,  que ira chamar o ExceptionHandler 
			 * correspondente da classe RecursosExceptionHandler do pacote handler, quer ira 
			 *retornar um 404 para o cliente com detalhes da possivel causa do erro */
			throw new RecursoNaoEncontradoException("Nenhum vinho foi encontrado");
		}
		
		return vinho;
	}
	
	public Vinho salvar(Vinho vinho) {
		
		/* este metodo nao faz atualizacao por isso e preciso garantir que o id sera sempre nulo,
		 * caso contrario o vinho sera atualizado em vez de criado um novo vinho 
		 * */
		
		vinho.setId(null);
		return vinhoRepository.save(vinho);
	}

}
