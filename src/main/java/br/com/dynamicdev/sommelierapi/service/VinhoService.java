package br.com.dynamicdev.sommelierapi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
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
	
	/**
	 * Metodo para verificar a existencia de um vinho.
	 * Chama o metodo buscarPeloId que se nao encontrar
	 * o vinho lanca uma excecao que lanca um NOT FOUND 
	 * @param vinho
	 */
	public void verificarExistencia(Vinho vinho) {
		buscarPeloId(vinho.getId());
	}
	
	public void atualizar(Vinho vinho) {
		
		/* vericando se o vinho realmente existe, poderia ter
		 * chamado o metodo buscarPeloId direto, mas criei o metodo
		 *  verificar existencia para ajudar na legibilidade do codigo */
		verificarExistencia(vinho);
		vinhoRepository.save(vinho);
	}
	
	public void deletar(Long id) {
		
		try {			
			vinhoRepository.delete(id);			
		} catch (EmptyResultDataAccessException e) {
			throw new RecursoNaoEncontradoException("O vinho não foi encontrado");
		}
	}

}
