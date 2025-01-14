package atividade2;

import java.util.Scanner;

public class Fibonacci {
	
	private static final int MAX_ELEMENTS = 100;
	private static final int[] fibElements = new int[MAX_ELEMENTS];
	
	public static int findElementDP(int elementNumber) {
		for(int i = 0; i < MAX_ELEMENTS; i++) {
			fibElements[i] = -1;
		}
		
		return findElement(elementNumber);
	}
	
	public static int findElement(int elementNumber) {
		if (fibElements[elementNumber] == -1) {
			if (elementNumber <= 1) {
				fibElements[elementNumber] = elementNumber;
			} else {
				fibElements[elementNumber] = findElement(elementNumber - 1) + findElement(elementNumber - 2);
			}
		}
		
		return fibElements[elementNumber];	
	}

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.print("Informe um número:");
		int numero = sc.nextInt();
		
		boolean pertence = false;
		int a = 0, b = 1;
		
		 while (a <= numero) {
	            if (a == numero) {
	                pertence = true;
	                break;
	            }
	            int temp = a + b;
	            a = b;
	            b = temp;
	        }
		
		if (pertence) {
			System.out.println("Número informado pertence a sequência.");
		} else {
			System.out.println("Número informado não pertence a sequência.");
		}
		

		sc.close();
	}

}
