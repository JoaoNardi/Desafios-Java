import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Scanner leitura2 = new Scanner(System.in);
        System.out.println("Qual o limite do seu cartão?");
        var cartao1 = new Cartao(leitura2.nextDouble());

        int sair = 1;
        while (sair !=0) {
            Scanner leitura3 = new Scanner(System.in);
            System.out.println("O que voce vai comprar?");
            String descricao = leitura3.nextLine();

            System.out.println("Quanto vai custar?");
            double valor = leitura3.nextDouble();


            Compra compra = new Compra(descricao, valor);
            if(cartao1.lancaCompra(compra)){
                System.out.println("Compra realizada");
            }else {
                System.out.println("Compra negada por falta de limite");
            };

            System.out.println("limite disponivel no cartao : " + cartao1.getLimite());

            System.out.println("Digite 1 para continuar");
            System.out.println("ou 0 para encerrar!");
            sair = leitura3.nextInt();

        }
        System.out.println("************************");
        System.out.println("TABELA DE GASTOS");

        Collections.sort(cartao1.getCompras());
        for (Compra c : cartao1.getCompras()) {
            System.out.println(c.getDescricao() + "----" + "R$" + c.getValor()) ;

        }
        System.out.println("************************");

    }
}