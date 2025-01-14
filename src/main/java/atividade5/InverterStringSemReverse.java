package atividade5;

import java.util.Scanner;

public class InverterStringSemReverse {

	 public static String inverterString(String str) {
	        String resultado = "";
	        
	        for (int i = str.length() - 1; i >= 0; i--) {
	            resultado += str.charAt(i);  
	        }
	        
	        return resultado;
	    }
	    
	    public static void main(String[] args) {
	        Scanner sc = new Scanner(System.in);
	        
	        System.out.print("Digite uma string: ");
	        String entrada = sc.nextLine();
	        
	        String resultado = inverterString(entrada);
	        
	        System.out.println("String invertida: " + resultado);
	        
	        sc.close();
	    }

}
