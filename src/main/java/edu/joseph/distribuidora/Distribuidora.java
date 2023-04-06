package edu.joseph.distribuidora;

import java.text.DecimalFormat;
import java.util.Scanner;

public class Distribuidora {
	//metodo que arredonda os numero após obter o percentual
	static double percentualFaturamento(double faturamentoTotal, double faturamento) {
		DecimalFormat df = new DecimalFormat("#,###,00");
		String numero = df.format(faturamento * 100 / faturamentoTotal);
		return Double.parseDouble(numero);
	}
	
	public static void main(String[] args) {
		var sc = new Scanner(System.in);

		double faturamentoSP = 67836.43;
		double faturamentoRJ = 36678.66;
		double faturamentoMG = 29229.88;
		double faturamentoES = 27165.48;
		double faturamentoOutros = 19849.53;

		double faturamentoTotal = 180759.98;

		while (true) {

			System.out.println("1 - Mostrar valor do faturamento e percentual no estado de SP");
			System.out.println("2 - Mostrar valor do faturamento e percentual no estado de RJ");
			System.out.println("3 - Mostrar valor do faturamento e percentual no estado de MG");
			System.out.println("4 - Mostrar valor do faturamento e percentual no estado de ES");
			System.out.println("5 - Mostrar valor do faturamento e percentual nas demais localidades");
			System.out.println("6 - Mostrar valor do faturamento e percentual total");
			System.out.println("7 - Sair");
			System.out.print("Escolha a opção que desja visualizar: ");
			int escolha = sc.nextInt();

			switch (escolha) {

			case 1:
				System.out.println("O faturamento Mensal em SP foi " + faturamentoSP 
						+ " e representa " + percentualFaturamento(faturamentoTotal, faturamentoSP));
				System.out.println();
				break;

			case 2:
				System.out.println("O faturamento Mensal em RJ foi " + faturamentoRJ 
						+ " e representa " + percentualFaturamento(faturamentoTotal, faturamentoRJ));
				System.out.println();
				break;
			
			case 3:	
				System.out.println("O faturamento Mensal em MG foi " + faturamentoMG 
						+ " e representa " + percentualFaturamento(faturamentoTotal, faturamentoMG));
				System.out.println();
				break;
			
			case 4:	
				System.out.println("O faturamento Mensal em ES foi " + faturamentoES 
						+ " e representa " + percentualFaturamento(faturamentoTotal, faturamentoES));
				System.out.println();
				break;
			
			case 5:	
				System.out.println("O faturamento Mensal nas demais localidades foi " + faturamentoOutros 
						+ " e representa " + percentualFaturamento(faturamentoTotal, faturamentoOutros));
				System.out.println();
				break;
				
			case 6:	
				System.out.println("O faturamento total foi de :" + faturamentoTotal);
				System.out.println();
				break;
				
			case 7:
				System.out.println("Aplicação encerrada!");
				sc.close();
				System.exit(0);
			default:
				throw new IllegalArgumentException("Unexpected value ");
			}
		}

	}
	
}
