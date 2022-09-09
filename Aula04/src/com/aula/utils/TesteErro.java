package com.aula.utils;

class TesteErro {
	public static void main(String[] args) {
		System.out.println("inicio	do	main");
		metodo1();
		System.out.println("fim	do	main");
	}

	static void metodo1() {
		System.out.println("inicio	do	metodo1");
		metodo2();
		System.out.println("fim	do	metodo1");
	}

	static void metodo2() {
		ContaBancaria cb = new ContaBancaria();
		try {
		System.out.println("inicio	do	metodo2");
		for (int i = 0; i <= 15; i++) {
			cb.setSaldo(i + 1000);
			System.out.println(cb.getSaldo());
			if (i == 5) {
				cb = null;
			}
		}
		System.out.println("fim	do	metodo2");
		}catch(Exception ex) {
			System.out.println(ex.toString());
		}finally {
			System.out.println("operacao encerrada saldo atual: "+cb.getSaldo());
			
		}
	}
}