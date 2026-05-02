package org.example;

public class Comprador {

    private String sabor;
    private int totalVuelto;

    public Comprador(Moneda moneda, Catalogo cual, Expendedor expendedor)
            throws PagoIncorrectoException, NoHayProductoException, PagoInsuficienteException {

        this.sabor = null;
        this.totalVuelto = 0;

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