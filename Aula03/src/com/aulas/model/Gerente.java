package com.aulas.model;

public class Gerente extends Funcionario{
	/* vamos aplicar herança
	private String nome;
	private String cpf;
	private double salario;
	*/
	
	private int senha;
	private int numeroDeFunctionariosGerenciados;
	
	/*
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public double getSalario() {
		return salario;
	}
	public void setSalario(double salario) {
		this.salario = salario;
	}*/
	public int getSenha() {
		return senha;
	}
	public void setSenha(int senha) {
		this.senha = senha;
	}
	public int getNumeroDeFunctionariosGerenciados() {
		return numeroDeFunctionariosGerenciados;
	}
	public void setNumeroDeFunctionariosGerenciados(int numeroDeFunctionariosGerenciados) {
		this.numeroDeFunctionariosGerenciados = numeroDeFunctionariosGerenciados;
	}
	
	
public boolean autentica(int senha) {
	if (this.senha == senha) {
		System.out.println("Acesso permitido");
		return true;
	}else {
		System.out.println("Acesso negado");
		return false;
	}
}

@Override
public double getBonificacao() {
	return (this.getSalario() * 0.15)+this.getSalario();
}
	
}
