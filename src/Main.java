import Monedas.*;
import Productos.*;

public class Main{
    public static void main(String[] args) {
        Expendedor exp = new Expendedor(1, 500);



        Comprador c1 = new Comprador(new Moneda500(), Expendedor.COCA, exp);
        System.out.println(c1.queBebiste());
        if (c1.cuantoVuelto() != 0) {
            System.out.println(c1.cuantasMonedas() + " Monedas de $100");
        }
        else {
            System.out.println("No hay vuelto");
        }


        System.out.println(" ");


        Comprador c2 = new Comprador(new Moneda1500(), Expendedor.SPRITE, exp);
        System.out.println(c2.queBebiste());
        if (c2.cuantoVuelto() != 0) {
            System.out.println(c2.cuantasMonedas() + " Monedas de $100");
        }
        else {
            System.out.println("No hay vuelto");
        }


        System.out.println(" ");


        Comprador c3 = new Comprador(new Moneda1000(), Expendedor.COCA, exp);
        System.out.println(c3.queBebiste());
        if (c3.cuantoVuelto() != 0) {
            System.out.println(c3.cuantasMonedas() + " Monedas de $100");
        }
        else {
            System.out.println("No hay vuelto");
        }


        System.out.println(" ");


        Comprador c4 = new Comprador(new Moneda1000(), 5, exp);
        System.out.println(c4.queBebiste());
        if (c4.cuantoVuelto() != 0) {
            System.out.println(c4.cuantasMonedas() + " Monedas de $100");
        }
        else {
            System.out.println("No hay vuelto");
        }


        System.out.println(" ");


        Comprador c5 = new Comprador(new Moneda100(), Expendedor.SPRITE, exp);
        System.out.println(c5.queBebiste());
        if (c5.cuantoVuelto() != 0) {
            System.out.println(c5.cuantasMonedas() + " Monedas de $100");
        }
        else {
            System.out.println("No hay vuelto");
        }


        System.out.println(" ");


        Comprador c6 = new Comprador(null, Expendedor.SPRITE, exp);
        System.out.println(c6.queBebiste());
        if (c6.cuantoVuelto() != 0) {
            System.out.println(c6.cuantasMonedas() + " Monedas de $100");
        }
        else {
            System.out.println("No hay vuelto");
        }


        System.out.println(" ");


        Comprador c7 = new Comprador(new Moneda0(), Expendedor.SPRITE, exp);
        System.out.println(c7.queBebiste());
        if (c7.cuantoVuelto() != 0) {
            System.out.println(c7.cuantasMonedas() + " Monedas de $100");
        }
        else {
            System.out.println("No hay vuelto");
        }


    }
}