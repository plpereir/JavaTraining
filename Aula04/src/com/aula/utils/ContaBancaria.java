package com.aula.utils;

public class ContaBancaria {
	public double saldo;
	
	
	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}

	boolean saca(double quantidade)
	{
		if (quantidade > this.saldo)
		{
			System.out.println("Nao é possível sacar, fora do limite");
			return false;
		}else
		{
			this.saldo = this.saldo - quantidade;
			System.out.println("Saque feito com sucesso, saldo atualizado: "+this.saldo);
			return true;
		}
	}
	
}
