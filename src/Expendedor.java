import Monedas.*;
import Productos.*;

public class Expendedor {
    public static final int COCA = 1;
    public static final int SPRITE = 2;

    private Deposito<Bebida> cocacola;
    private Deposito<Bebida> sprite;
    private Deposito<Moneda> monVuelto;
    private int precio;

    public Expendedor(int NumBebidas, int PrecioBebidas){
        cocacola = new Deposito<Bebida>();
        sprite = new Deposito<Bebida>();
        monVuelto = new Deposito<Moneda>();
        precio = PrecioBebidas;

        for(int i = 0; i < NumBebidas; i++){
            cocacola.add(new CocaCola(100 + i));
            sprite.add(new Sprite(200 + i));
        }
    }
    public Bebida comprarBebida(Moneda m, int cual){
        if(m == null) return null;
        if(m.getValor()< precio){
            monVuelto.add(m);
            return null;
        }
        Bebida b = null;
        switch(cual){
            case COCA: b = cocacola.get(); break;
            case SPRITE: b = sprite.get(); break;
        }

        if(b == null){
            monVuelto.add(m);
            return null;
        }

        int diferencia = m.getValor() - precio;
        while(diferencia >= 100){
            monVuelto.add(new Moneda100());
            diferencia -= 100;
        }
        return b;
    }
    public Moneda getVuelto(){
        return monVuelto.get();
    }
    public int getPrecio() {
        return precio;
    }
}