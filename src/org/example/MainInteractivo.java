package org.example;

import java.util.Scanner;

public class MainInteractivo {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Expendedor expendedor = new Expendedor(10); //

        System.out.println("EXPENDEDOR INTERACTIVO");

        while(true) {

            System.out.println("\n Seleccione que producto desea comprar: ");

            System.out.println("1. Coca Cola ($" + Catalogo.COCACOLA.getPrecio() + ")");
            System.out.println("2. Sprite    ($" + Catalogo.SPRITE.getPrecio() + ")");
            System.out.println("3. Fanta     ($" + Catalogo.FANTA.getPrecio() + ")");
            System.out.println("4. Snickers  ($" + Catalogo.SNICKERS.getPrecio() + ")");
            System.out.println("5. Super 8   ($" + Catalogo.SUPER8.getPrecio() + ")");
            System.out.println("0. Salir");

            int queProducto = scanner.nextInt();

            if (queProducto == 0) {
                System.out.println("Adiós, ¡Vuelve pronto! ");
                break;
            }

            Catalogo productoElegido = null;
            switch (queProducto) {
                case 1 -> productoElegido = Catalogo.COCACOLA;
                case 2 -> productoElegido = Catalogo.SPRITE;
                case 3 -> productoElegido = Catalogo.FANTA;
                case 4 -> productoElegido = Catalogo.SNICKERS;
                case 5 -> productoElegido = Catalogo.SUPER8;
                default -> {
                    System.out.println("\nEl número indiciado no corresponde a ningún producto... Intente de nuevo:");
                    continue;
                }
            }

            System.out.println("\nSeleccione su método de pago.");
            System.out.println("1. Moneda de $100");
            System.out.println("2. Moneda de $500");
            System.out.println("3. Moneda de $1000");
            System.out.println("4. No tengo moneda.");
            int opcionMoneda = scanner.nextInt();

            Moneda moneda = null;
            switch (opcionMoneda) {
                case 1 -> moneda = new Moneda100();
                case 2 -> moneda = new Moneda500();
                case 3 -> moneda = new Moneda1000();
                case 4 -> moneda = null;
                default -> {
                    System.out.println("Opción inválida. Intenta de nuevo.");
                    continue;
                }
            }

            try {
                Comprador comprador = new Comprador(moneda, productoElegido, expendedor);
                System.out.println("Se compro lo siguiente: " + comprador.getSabor());
                System.out.println("Vuelto: $" + comprador.getTotalVuelto());
            } catch (PagoIncorrectoException e) {
                System.out.println(e.getMessage());
            } catch (NoHayProductoException e) {
                System.out.println(e.getMessage());
            } catch (PagoInsuficienteException e) {
                System.out.println(e.getMessage());
            }
        }
        scanner.close();

    }
}
