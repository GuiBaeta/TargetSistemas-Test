package atividade4;

import java.text.DecimalFormat;

public class PercentualDeRepresentacao {

	public static void main(String[] args) {

		double SP = 67836.43;
		double RJ = 36678.66;
		double MG = 29229.88;
		double RS = 27165.48;
		double outros = 19849.53;

		double total = SP + RJ + MG + RS + outros;
		
		double PorcentagemSP = (SP * 100) / total;
		double PorcentagemRJ = (RJ * 100) / total;
		double PorcentagemMG = (MG * 100) / total;
		double PorcentagemRS = (RS * 100) / total;
		double PorcentagemOutros = (outros* 100) / total;
		
        DecimalFormat df = new DecimalFormat("#.##"); // Formata para 2 casas decimais
        System.out.println("O Estado de SP faturou: R$ " + SP + ". Que equivale " + df.format(PorcentagemSP) + "% do total mensal da distribuidora.");
        System.out.println("O Estado de RJ faturou: R$ " + RJ + ". Que equivale " + df.format(PorcentagemRJ) + "% do total mensal da distribuidora.");
        System.out.println("O Estado de MG faturou: R$ " + MG + ". Que equivale " + df.format(PorcentagemMG) + "% do total mensal da distribuidora.");
        System.out.println("O Estado de RS faturou: R$ " + RS + ". Que equivale " + df.format(PorcentagemRS) + "% do total mensal da distribuidora.");
        System.out.println("Outros estados faturaram: R$ " + outros + ". Que equivale " + df.format(PorcentagemOutros) + "% do total mensal da distribuidora.");
		
	}

}
