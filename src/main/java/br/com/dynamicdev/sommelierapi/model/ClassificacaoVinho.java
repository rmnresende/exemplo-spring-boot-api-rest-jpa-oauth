package br.com.dynamicdev.sommelierapi.model;

public enum ClassificacaoVinho {
	
	SUAVE("Suave"), SECO("Seco"), DEMI_SEC("Demi-sec"), BRUT("Brut");
	
	private String descricao;
	
	private ClassificacaoVinho(String descricao) {
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
}
