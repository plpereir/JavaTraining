package com.aula02.model;

public class Pessoa {
	private String Nome;
	private String Endereco;
	private int Idade;
	
	
	public Pessoa(String Nome, String Endereco, int Idade)
	{
		this.setNome(Nome);;
		this.setEndereco(Endereco);
		this.setIdade(Idade);
	}
	
	public String getNome() {
		return Nome;
	}
	public void setNome(String nome) {
		Nome = nome;
	}
	public String getEndereco() {
		return Endereco;
	}
	public void setEndereco(String endereco) {
		Endereco = endereco;
	}
	public int getIdade() {
		return Idade;
	}
	public void setIdade(int idade) {
		Idade = idade;
	}
	
	@Override
	public String toString() {
		return "Pessoa [Nome=" + Nome + ", Endereco=" + Endereco + ", Idade=" + Idade + "]";
	}
	
	

}
