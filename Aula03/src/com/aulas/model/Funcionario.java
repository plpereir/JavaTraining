package com.aulas.model;

public class Funcionario {
	private String nome;
	private String cpf;
	private double salario;
	
	public Funcionario(String nome) {
		this.setNome(nome);
	}
	
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	protected String getCpf() {
		return cpf;
	}
	protected void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public double getSalario() {
		return salario;
	}
	public void setSalario(double salario) {
		this.salario = salario;
	}
	
	public double getBonificacao() {
		return this.getSalario() * 0.10;
	}
	

}
