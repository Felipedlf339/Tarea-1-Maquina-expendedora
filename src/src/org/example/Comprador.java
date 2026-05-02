package org.example;

public class Comprador {

    private String sabor;
    private int totalVuelto;

    public Comprador(Moneda moneda, int numProducto, Expendedor expendedor)
            throws PagoIncorrectoException, NoHayProductoException, PagoInsuficienteException {

        this.sabor = null;
        this.totalVuelto = 0;

        Catalogo cual = null;
        Catalogo[] productos = Catalogo.values();
        for (int i = 0; i < productos.length; i++) {
            if (productos[i].getId() == numProducto) {
                cual = productos[i];
                break;
            }
        }

        if (cual == null) {
            throw new NoHayProductoException("No existe producto que tenga el ID: " + numProducto);
        }

        Producto producto = expendedor.comprarProducto(moneda, cual);
        this.sabor = producto.consumir();

        Moneda vuelto = expendedor.getVuelto();
        while (vuelto != null) {
            this.totalVuelto += vuelto.getValor();
            vuelto = expendedor.getVuelto();
        }
    }

    public String getSabor() {
        return sabor;
    }

    public int getTotalVuelto() {
        return totalVuelto;
    }
}