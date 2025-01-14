package atividade3;

import java.io.File;
import java.io.FileInputStream;
import java.io.ByteArrayInputStream;
import java.nio.charset.StandardCharsets;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.*;

public class FaturamentoDiario {

    public static void main(String[] args) {
        try {
            File file = new File("src/main/resources/dados.xml");
            FileInputStream fileInputStream = new FileInputStream(file);
            byte[] fileContent = new byte[(int) file.length()];
            fileInputStream.read(fileContent);
            fileInputStream.close();

            String xmlString = new String(fileContent, StandardCharsets.UTF_8);
            if (!xmlString.trim().startsWith("<root>")) {
                xmlString = "<root>" + xmlString + "</root>";
            }

            byte[] xmlBytes = xmlString.getBytes(StandardCharsets.UTF_8);
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(xmlBytes);

            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(byteArrayInputStream);
            document.getDocumentElement().normalize();

            NodeList rowList = document.getElementsByTagName("row");

            double menorFaturamento = Double.MAX_VALUE;
            double maiorFaturamento = Double.MIN_VALUE;
            double somaFaturamento = 0.0;
            int diasComFaturamento = 0;

            double[] valores = new double[rowList.getLength()];

            for (int i = 0; i < rowList.getLength(); i++) {
                Node row = rowList.item(i);

                if (row.getNodeType() == Node.ELEMENT_NODE) {
                    Element element = (Element) row;
                    double valor = Double.parseDouble(element.getElementsByTagName("valor").item(0).getTextContent());

                    if (valor > 0) {
                        valores[diasComFaturamento] = valor;
                        diasComFaturamento++;

                        if (valor < menorFaturamento) {
                            menorFaturamento = valor;
                        }
                        if (valor > maiorFaturamento) {
                            maiorFaturamento = valor;
                        }

                        somaFaturamento += valor;
                    }
                }
            }

            double media = somaFaturamento / diasComFaturamento;

            int diasAcimaDaMedia = 0;
            for (int i = 0; i < diasComFaturamento; i++) {
                if (valores[i] > media) {
                    diasAcimaDaMedia++;
                }
            }

            System.out.println("Menor faturamento: " + menorFaturamento);
            System.out.println("Maior faturamento: " + maiorFaturamento);
            System.out.println("Dias com faturamento acima da média: " + diasAcimaDaMedia);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
