import Excepciones.*;
import Monedas.*;
import Productos.*;

public class Comprador {
    private String sonido;
    private int vuelto;
    private int numeroMonedas;

    public Comprador(Moneda m, int cualBebida, Expendedor exp) {

        try {
            if (m == null) {
                throw new PagoIncorrectoException("No hay dinero");
            } else if (m.getValor() < exp.getPrecio()) {
                throw new PagoInsuficienteException("Saldo Insuficiente");
            } else {
                Bebida b = exp.comprarBebida(m, cualBebida);

                try {
                    if (b == null) {
                        throw new NohayProductoException("No hay Bebidas Disponibles");
                    }
                    sonido = b.beber();
                } catch (Exception e) {
                    sonido = e.getMessage();
                }

                vuelto = 0;
                Moneda mv = exp.getVuelto();

                while (mv != null) {
                    vuelto += mv.getValor();
                    mv = exp.getVuelto();
                }

                numeroMonedas = vuelto / 100;
            }

        } catch (Exception e) {
            vuelto = 0;
            sonido = e.getMessage();


        }
    }


    public int cuantoVuelto(){
        return vuelto;
    }
    public int cuantasMonedas(){
        return numeroMonedas;
    }
    public String queBebiste(){
        return sonido;
    }
}