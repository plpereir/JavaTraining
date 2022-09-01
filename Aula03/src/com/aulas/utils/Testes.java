package com.aulas.utils;

import com.aulas.model.Diretor;
//import com.aulas.model.Funcionario;
import com.aulas.model.Gerente;

public class Testes {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Gerente gerente = new Gerente("Carlos","123.456.789.00");
		
		System.out.println("antes: "+gerente.getNome());
		
		//podemos chamar metodos do funcionario
		gerente.setNome("João da Silva");
		
		
		System.out.println("depois: "+gerente.getNome());
		
		//metodo especifico da classe gerente
		gerente.setSenha(4321);
		
		gerente.setSalario(100);
		
		
		System.out.println("Gerente: "+gerente.getBonificacao());
		
		/*
		Funcionario funcionario = new Funcionario("Jose da Silva","000.000.000.33");
		
		funcionario.setSalario(100);
		System.out.println("Funcionario: "+funcionario.getBonificacao());
		*/
		
		Diretor diretor = new Diretor("nome padrao","111.222.333.444.55",50000);
		System.out.println("nome do Diretor: "+diretor.getNome());
		System.out.println("Diretor: "+diretor.getBonificacao());
		
	}

}
