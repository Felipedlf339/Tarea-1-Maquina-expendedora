package Productos;

import Excepciones.NohayProductoException;

public abstract class Bebida{
    private int serie;
    public Bebida(){}

    public Bebida(int serie){
        this.serie = serie;
    }
    public int getSerie() {return serie; }

    public abstract String beber() throws NohayProductoException;
}