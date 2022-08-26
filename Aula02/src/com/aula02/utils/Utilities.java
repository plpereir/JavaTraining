package com.aula02.utils;

import java.util.ArrayList;
import java.util.List;

import com.aula02.model.*;

public class Utilities {

	public static void ImprimeAlunos()
	{
		List<Aluno> Alunos = new ArrayList<Aluno>();
		
		Pessoa pessoa = new Pessoa("Joao", "Rua 1",10);	
		String serie = "09 Ano";
		Aluno aluno = new Aluno(pessoa,serie);
		Alunos.add(aluno);
		Pessoa pessoa2 = new Pessoa("Maria", "Rua 2",15);	
		String serie2 = "08 Ano";
		Aluno aluno2 = new Aluno(pessoa2,serie2);
		Alunos.add(aluno2);
		Pessoa pessoa3 = new Pessoa("Jose", "Rua 3",20);
		String serie3 = "07 Ano";
		Aluno aluno3 = new Aluno(pessoa3,serie3);
		Alunos.add(aluno3);
		
		for(Aluno x:Alunos)
		{
			System.out.println(x.toString());
		}
		
	}
	public static void ImprimePessoas()
	{
		List<Pessoa> Pessoas = new ArrayList<Pessoa>();
		
		Pessoa pessoa = new Pessoa("Joao", "Rua 1",10);		
		Pessoas.add(pessoa);
		Pessoa pessoa2 = new Pessoa("Maria", "Rua 2",15);		
		Pessoas.add(pessoa2);
		Pessoa pessoa3 = new Pessoa("Jose", "Rua 3",20);		
		Pessoas.add(pessoa3);
		
		for(Pessoa x:Pessoas)
		{
			System.out.println(x.toString());
		}
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println("Imprime Pessoas");
		ImprimePessoas();
		
		System.out.println("Imprime Alunos");
		
		ImprimeAlunos();
	}

}
