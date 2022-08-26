package com.aula02.model;

public class Aluno {
	private Pessoa dadosPessoais;
	private String serie;
	
	public Aluno(Pessoa dadosPessoais, String serie)
	{
		this.setDadosPessoais(dadosPessoais);
		this.setSerie(serie);
	}
	
	
	public Pessoa getDadosPessoais() {
		return dadosPessoais;
	}
	public void setDadosPessoais(Pessoa dadosPessoais) {
		this.dadosPessoais = dadosPessoais;
	}
	public String getSerie() {
		return serie;
	}
	public void setSerie(String serie) {
		this.serie = serie;
	}
	@Override
	public String toString() {
		return "Aluno [dadosPessoais=" + dadosPessoais + ", serie=" + serie + "]";
	}

	
}
