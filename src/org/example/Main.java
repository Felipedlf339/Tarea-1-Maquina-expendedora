package org.example;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Main de pruebas que demuestra el correcto funcionamiento del expendedor
 */

public class Main {
    public static void main(String[] args){

        Expendedor exp = new Expendedor(2);

        //Caso 1: Compra de CocaCola con Moneda1000, sin vuelto
        System.out.println("-- Caso 1: Compra exitosa de CocaCola sin vuelto --");
        try{
            Comprador c1 = new Comprador(new Moneda1000(), Catalogo.COCACOLA, exp);
            System.out.println("Consumió: " + c1.getSabor());
            System.out.println("Vuelto : $" + c1.getTotalVuelto());
        } catch (Exception e){
            System.out.println("Excepción: " + e.getMessage());
        }

        //Caso 2: Compra de Snickers con Moneda1000, vuelto $200
        System.out.println("-- Caso 2: Compra exitosa de Snkickers con vuelto --");
        try{
            Comprador c2 = new Comprador(new Moneda1000(), Catalogo.SNICKERS, exp);
            System.out.println("Consumió: "+ c2.getSabor());
            System.out.println("Vuelto : $" + c2.getTotalVuelto());
        } catch (Exception e){
            System.out.println("Excepcion: " + e.getMessage());
        }

        //Caso 3: Compra de Super8 con Moneda500, sin vuelto
        System.out.println("-- Caso 3: Compra de dulce exacto --");
        try{
            Comprador c3 = new Comprador(new Moneda500(), Catalogo.SUPER8, exp);
            System.out.println("Consumió: " + c3.getSabor());
            System.out.println("Vuelto: $" + c3.getTotalVuelto());
        } catch (Exception e){
            System.out.println("Excepcion : " + e.getMessage());
        }

        //Caso 4: PagoInsuficienteException (Moneda100 para Sprite que cuesta $1000)
        System.out.println("-- Caso 4: PagoInsuficienteException --");
        try{
            Comprador c4 = new Comprador(new Moneda100(), Catalogo.SPRITE, exp);
            System.out.println("Consumió: " + c4.getSabor());
            System.out.println("Vuelto: $" + c4.getTotalVuelto());
        } catch (PagoInsuficienteException e){
            System.out.println("PagoInsuficienteException: " + e.getMessage());
        } catch (Exception e){
            System.out.println("Excepcion: " + e.getMessage());
        }

        //Caso 5: PagoIncorrectoException (moneda null)
        System.out.println("-- Caso 5: PagoIncorrectoException --");
        try{
            Comprador c5 = new Comprador(null, Catalogo.FANTA, exp);
            System.out.println("Consumió: "+ c5.getSabor());
        } catch (PagoIncorrectoException e){
            System.out.println("PagoIncorrectoException: "+ e.getMessage());
        } catch (Exception e){
            System.out.println("Exception: " + e.getMessage());
        }
        //Caso 6: NoHayProductoException (agotar CocaCola y pedir una más)
        System.out.println("\n=== Caso 6: NoHayProductoException ===");
        try {
            //Agotamos la segunda CocaCola
            Comprador c6 = new Comprador(new Moneda1000(), Catalogo.COCACOLA, exp);
            System.out.println("Consumió: " + c6.getSabor());
            //Ahora no hay más CocaCola
            Comprador c7 = new Comprador(new Moneda1000(), Catalogo.COCACOLA, exp);
            System.out.println("Consumió: " + c7.getSabor());
        } catch (NoHayProductoException e) {
            System.out.println("NoHayProductoException: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Excepción: " + e.getMessage());
        }

        //Caso 7: Ordenamiento de monedas Comparable
        System.out.println("\n-- Caso 7: Ordenamiento de monedas --");
        ArrayList<Moneda> monedas = new ArrayList<>();
        monedas.add(new Moneda1000());
        monedas.add(new Moneda100());
        monedas.add(new Moneda500());
        monedas.add(new Moneda100());
        monedas.add(new Moneda1000());
        monedas.add(new Moneda500());
        Collections.sort(monedas);
        for(Moneda m : monedas){
            System.out.println(m);
        }

    }
}