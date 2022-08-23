package TiposPrimitivos;

public class VariaveisTiposPrimitivos {

	static int MeuNumero = 1;
	static int MeuNumero2 = 10;
	
	static String Meutexto = "Minha Soma é: ";
	
	double ComDecimais = 1.1;
	
	long GuardarMaior = 194958585;
	
	static String[] MeuPrimeiroArray = {"a","b","c"};
	
	private static int Soma(int n1, int n2)
	{
		return n1+n2;
	}
	
	public static void main(String[] args) {
		//Este print, faz a soma durante a impressao
		System.out.println(Meutexto+Soma(MeuNumero, MeuNumero2));
		
		/*
		 * o numero 2 esta sendo comparado, se ele é maior que 2
		 * ou ainda menor ou igual a 2
		 */
		
		if (MeuNumero>2)
		{
			System.out.println("Sim ele é maior que 2");
		}else
		{
			System.out.println("Não ele é menor ou igual a 2");
		}
		
		switch(MeuNumero2) {
		case 1: {System.out.println("Meu Numero é 1");}
		case 10: {System.out.println("O triplo do MeuNumero é: "+(MeuNumero2*3));}
		}
		
		int i=1;
		while(i<=10)
		{
			System.out.println("O valor de i é: "+i);
			i++;
		}
		for(String x : MeuPrimeiroArray) {
			System.out.println("A letra impressa é: "+x);
		}
		for(int w=20;w>0;w--) {
			System.out.println("Valor de w dentro do for: "+w);
		}
	}

}
