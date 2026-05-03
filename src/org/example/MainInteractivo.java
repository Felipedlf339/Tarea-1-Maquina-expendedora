package org.example;
import java.util.Scanner;

/**
 * Main interactivo que permite al usuario comprar desde la consola.
 */
public class MainInteractivo {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in); // Scanner para leer lo ingresado por el usuario.
        Expendedor expendedor = new Expendedor(10); // Se crea el expendedor con un stock de 10 para cada producto.

        System.out.println("EXPENDEDOR INTERACTIVO");

        // Bucle while para controlar el expendedor (Cuando terminar o no el programa).
        while(true) {

            // Menú de productos y sus respectivos precios obtenidos de cátalogo.
            System.out.println("\n Seleccione que producto desea comprar: ");

            System.out.println("1. Coca Cola ($" + Catalogo.COCACOLA.getPrecio() + ")");
            System.out.println("2. Sprite    ($" + Catalogo.SPRITE.getPrecio() + ")");
            System.out.println("3. Fanta     ($" + Catalogo.FANTA.getPrecio() + ")");
            System.out.println("4. Snickers  ($" + Catalogo.SNICKERS.getPrecio() + ")");
            System.out.println("5. Super 8   ($" + Catalogo.SUPER8.getPrecio() + ")");
            System.out.println("0. Salir");

            int queProducto = scanner.nextInt(); // Se lee el entero ingresado por el usuario.

            if (queProducto == 0) {
                System.out.println("Adiós, ¡Vuelve pronto! ");
                break; // Si el usuario selecciona salir se termina el programa.
            }

            // Según el número escogido se selecciona el producto correspondiente del cátalogo.
            Catalogo productoElegido = null; // Inicializa el producto como null.
            switch (queProducto) {
                case 1 -> productoElegido = Catalogo.COCACOLA;
                case 2 -> productoElegido = Catalogo.SPRITE;
                case 3 -> productoElegido = Catalogo.FANTA;
                case 4 -> productoElegido = Catalogo.SNICKERS;
                case 5 -> productoElegido = Catalogo.SUPER8;
                default -> {
                    System.out.println("\nEl número indiciado no corresponde a ningún producto... Intente de nuevo:");
                    continue; // Empieza un nuevo ciclo.
                }
            }

            // Menú de monedas a escoger.
            System.out.println("\nSeleccione su método de pago.");
            System.out.println("1. Moneda de $100");
            System.out.println("2. Moneda de $500");
            System.out.println("3. Moneda de $1000");
            System.out.println("4. No tengo moneda.");
            int opcionMoneda = scanner.nextInt();

            // Se selecciona la moneda según la opción escogida.
            Moneda moneda = null; // Se inicializa moneda.
            switch (opcionMoneda) {
                case 1 -> moneda = new Moneda100();
                case 2 -> moneda = new Moneda500();
                case 3 -> moneda = new Moneda1000();
                case 4 -> moneda = null; // Si no hay moneda es null.
                default -> {
                    System.out.println("\nOpción inválida... Intente de nuevo.");
                    continue;
                }
            }

            // Se intenta realizar la compra y se ven las posibles exepciones, si algo falla entonces dara su mensaje de error..
            try {
                Comprador comprador = new Comprador(moneda, productoElegido, expendedor);
                System.out.println("Se compro lo siguiente: " + comprador.getSabor());
                System.out.println("Vuelto: $" + comprador.getTotalVuelto());
            } catch (PagoIncorrectoException e) {
                System.out.println(e.getMessage()); // Si la moneda es null.
            } catch (NoHayProductoException e) {
                System.out.println(e.getMessage()); // Si el stock se acaba.
            } catch (PagoInsuficienteException e) {
                System.out.println(e.getMessage()); // Si el dinero no alcanza,
            }
        }
        scanner.close();

    }
}
