import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner leitura = new Scanner(System.in);

        try {
            System.out.println("Qual valor será convertido?");
            double moedaInicial = Double.parseDouble(leitura.nextLine());

            Conversor converter = new Conversor();

            System.out.println("Coloque sua chave API do site ExchangeRate-API: ");
            var api = leitura.nextLine();

            System.out.printf("""
                    **********************************************************************************************
                    Digite qual seu tipo de moeda: 
                    
                    USD = Dólar Americano
                    BRL = Real
                    EUR = Euro
                    JPY = Iene
                    CAD = Dólar canadense
                    INR = Rúpia Indiana
                    
                    Caso a moeda solicitado não esteja nessa lista basta procurar a sigla de 3 digitos e inserir.
                    **********************************************************************************************
                    """);

            String moeda = leitura.nextLine().toUpperCase();
            Moeda resultado = converter.conversor(api, moeda);

            System.out.println("Você selecionou " + moedaInicial + " " + moeda);

            System.out.printf("""
                    **********************************************************************************************
                    Digite para qual moeda você quer realizar a conversão: 
                    
                    USD = Dólar Americano
                    BRL = Real
                    EUR = Euro
                    JPY = Iene
                    CAD = Dólar canadense
                    INR = Rúpia Indiana
                    
                    Caso a moeda solicitado não esteja nessa lista basta procurar a sigla de 3 digitos e inserir.
                    **********************************************************************************************
                    """);

            String moedaConvertida = leitura.nextLine().toUpperCase();
            Double valorMoedaConvertida = (resultado.conversion_rates().get(moedaConvertida)) * moedaInicial;
            System.out.println("Sua conversão de " + moedaInicial + " " + moeda + " É IGUAL A " + valorMoedaConvertida + " " + moedaConvertida);
        } catch (Exception e) {
            System.out.println("Você realizou digitou algo errado, reformule os dados inseridos.");;
        }

    }
}