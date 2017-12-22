package br.com.dynamicdev.sommelierapi.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@Entity
@Table(name = "vinho")
public class Vinho implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Long id;
	
	private String nome;
	
	@JsonInclude(Include.NON_NULL)
	private String descricao;
	
	private TipoVinho tipoVinho;
	
	private ClassificacaoVinho classificacaoVinho;
	
	private int volume; //volume em ML da garrafa de vinho
	
	private double teorAlcoolico;
	
	@JsonInclude(Include.NON_NULL)
	private Integer safra;//ano da safra do vinho, usando Integer em vez de int pois este campo pode ter valores nulos
	
	@JsonInclude(Include.NON_NULL)
	private String origem; //nome do pais de origem do vinho

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	@Enumerated(EnumType.STRING)
	@Column(name = "tipo_vinho")
	public TipoVinho getTipoVinho() {
		return tipoVinho;
	}

	public void setTipoVinho(TipoVinho tipoVinho) {
		this.tipoVinho = tipoVinho;
	}

	@Enumerated(EnumType.STRING)
	@Column(name = "classificacao_vinho")
	public ClassificacaoVinho getClassificacaoVinho() {
		return classificacaoVinho;
	}

	public void setClassificacaoVinho(ClassificacaoVinho classificacaoVinho) {
		this.classificacaoVinho = classificacaoVinho;
	}

	public int getVolume() {
		return volume;
	}

	public void setVolume(int volume) {
		this.volume = volume;
	}

	@Column(name = "teor_alcoolico")
	public double getTeorAlcoolico() {
		return teorAlcoolico;
	}

	public void setTeorAlcoolico(double teorAlcoolico) {
		this.teorAlcoolico = teorAlcoolico;
	}

	public Integer getSafra() {
		return safra;
	}

	public void setSafra(Integer safra) {
		this.safra = safra;
	}

	public String getOrigem() {
		return origem;
	}

	public void setOrigem(String origem) {
		this.origem = origem;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Vinho other = (Vinho) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}
