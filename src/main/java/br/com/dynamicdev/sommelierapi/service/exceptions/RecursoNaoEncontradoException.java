package br.com.dynamicdev.sommelierapi.service.exceptions;

public class RecursoNaoEncontradoException extends RuntimeException{

	private static final long serialVersionUID = 8712699959450716707L;
	
	public RecursoNaoEncontradoException(String mensagem) {
		super(mensagem);
	}
	
	public RecursoNaoEncontradoException(String mensagem, Throwable causa) {
		super(mensagem, causa);
	}

}
