import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Cartao {
    protected double limite;
    protected double saldo;
    protected List<Compra> compras;

    public double getLimite() {
        return limite;
    }

    public double getSaldo() {
        return saldo;
    }

    public List<Compra> getCompras() {
        return compras;
    }

    public Cartao(double limite) {
        this.limite = limite;
        this.saldo = limite;
        this.compras = new ArrayList<>();
    }

    Scanner leitura = new Scanner(System.in);

    public boolean lancaCompra(Compra compra){
        if (compra.getValor() <= limite){
            this.limite = limite - compra.getValor();
            this.compras.add(compra);
            return true;
        } else {
            return false;
        }

    }
}
