package com.aulas.utils;

import com.aulas.model.Funcionario;
import com.aulas.model.Gerente;

public class Testes {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Gerente gerente = new Gerente();
		
		//podemos chamar metodos do funcionario
		gerente.setNome("João da Silva");
		
		//metodo especifico da classe gerente
		gerente.setSenha(4321);
		
		gerente.setSalario(100);
		
		System.out.println("Gerente: "+gerente.getBonificacao());
		
		
		Funcionario funcionario = new Funcionario();
		
		funcionario.setSalario(100);
		System.out.println("Funcionario: "+funcionario.getBonificacao());
		
	}

}
