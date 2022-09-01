package com.aulas.model;

public class Diretor extends Gerente{

	public Diretor(String nome, String cpf,double salario) {
		super(nome, cpf);
		this.setSalario(salario);
		// TODO Auto-generated constructor stub
	}

	private double PLR;

	public double getPLR() {
		return PLR;
	}

	public void setPLR(double pLR) {
		PLR = pLR;
	}

	@Override
	public double getBonificacao() {
		return (this.getSalario() * 0.30);
	}
}
