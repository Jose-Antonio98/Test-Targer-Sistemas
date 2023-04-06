package edu.joseph.fibonacci;

import java.util.Scanner;

/*Dado a sequência de Fibonacci, onde se inicia por 0 e 1 e o próximo valor sempre será a soma dos 2 valores anteriores 
(exemplo: 0, 1, 1, 2, 3, 5, 8, 13, 21, 34...), escreva um programa na linguagem que desejar onde, informado um número, 
ele calcule a sequência de Fibonacci e retorne uma mensagem avisando se o número informado pertence ou não a sequência.*/

public class Fibonacci {

	static int fibo(int n) {
		if (n < 2) {
			return n;
		} else {
			return fibo(n - 1) + fibo(n - 2);
		}
	}
	
	static boolean confirmaNumero(int fibo, int num) {
		if (fibo == num) {
			return true;
		}else {
			return false;
		}
	}

	public static void main(String[] args) {
		var sc = new Scanner(System.in);
		
		System.out.print("Informe o range da sequencia que desaja verificar:");
		int n = sc.nextInt();
		System.out.print("informe um numero inteiro que deseja saber: ");
		Integer num = sc.nextInt();
		
		for (int i = 0; i <= n; i++) {
			if(confirmaNumero(Fibonacci.fibo(i), num)) {
				System.out.println("O numero pertence a sequencia");
				break;
			}else if (i == 5 && confirmaNumero(Fibonacci.fibo(i), num) == false) {
				System.out.println("O numero não pertence a sequencia");
			}
		}
		sc.close();
	}
}
