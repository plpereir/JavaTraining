package com.aula.utils;

public class Teste {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ContaBancaria cb = new ContaBancaria();
		cb.setSaldo(10000);
		
		System.out.println(cb.saca(400));
	}

}
