package com.aula.orm.Aula05;

import com.aula.orm.Aula05.dao.DAO;
import com.aula.orm.Aula05.model.Ninja;

public class Testes {

	public static void main(String[] args) {
		
		DAO<Ninja> daoNinja = new DAO<>(Ninja.class);
		
		//Ninja naruto = new Ninja("Naruto", "Ninjutsu", "Konoha", 30, false, "x");
		//Ninja shikamaru = new Ninja("Shikamaru", "Ninjutsu", "Konoha", 29, true, "y");
		
		Ninja itachi = new Ninja("Shikamaru", "Ninjutsu", "Nao tem", 29, true, "z");


		daoNinja.abrir();
		
		//daoNinja.create(naruto);
		
		//daoNinja.create(shikamaru);
		//daoNinja.create(itachi);
		

		
		daoNinja.atualizar(6, "Itachi", "Genjutsu", "Nao tem", true, 25);
		
		
		Ninja itachi2 = new Ninja(6,"Shikamaru", "Ninjutsu", "Nao tem", 29, false, "z");
		daoNinja.atualizar(itachi2);
		
		System.out.println(daoNinja.encontrarPeloId(5));
		
		daoNinja.fechar();
	}

}