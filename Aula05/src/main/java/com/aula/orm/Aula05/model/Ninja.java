package com.aula.orm.Aula05.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ninjas")
public class Ninja {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	@Column(name = "name")
	private String nome;
	private String habilidade;
	private String aldeia;
	private int idade;
	private Boolean aposentado;
	@Column(name = "xxxx")
	private String novoCampo;
	
	public Ninja() {
		
	}
	
	public Ninja(String nome, String habilidade, String aldeia, int idade, Boolean aposentado, String novoCampo) {
		this.nome = nome;
		this.habilidade = habilidade;
		this.aldeia = aldeia;
		this.idade = idade;
		this.aposentado = aposentado;
		this.novoCampo = novoCampo;
	}
	
	
	public Ninja(int id, String nome, String habilidade, String aldeia, int idade, Boolean aposentado,
			String novoCampo) {
		super();
		this.id = id;
		this.nome = nome;
		this.habilidade = habilidade;
		this.aldeia = aldeia;
		this.idade = idade;
		this.aposentado = aposentado;
		this.novoCampo = novoCampo;
	}

	public String getNovoCampo() {
		return novoCampo;
	}

	public void setNovoCampo(String novoCampo) {
		this.novoCampo = novoCampo;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getHabilidade() {
		return habilidade;
	}
	public void setHabilidade(String habilidade) {
		this.habilidade = habilidade;
	}
	public String getAldeia() {
		return aldeia;
	}
	public void setAldeia(String aldeia) {
		this.aldeia = aldeia;
	}
	public int getIdade() {
		return idade;
	}
	public void setIdade(int idade) {
		this.idade = idade;
	}
	public Boolean getAposentado() {
		return aposentado;
	}
	public void setAposentado(Boolean aposentado) {
		this.aposentado = aposentado;
	}
	@Override
	public String toString() {
		return "Ninja [id=" + id + ", nome=" + nome + ", habilidade=" + habilidade + ", aldeia=" + aldeia + ", idade="
				+ idade + ", aposentado=" + aposentado + "]";
	}
	
	

}
