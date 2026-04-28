package org.example;
import java.util.ArrayList;

/**
 * Deposito genérico para almacenar cualquier tipo de objeto T.
 * @param <T> Tipo de objeto(Producto, Moneda, etc).
 */

public class Deposito<T> {
    private ArrayList<T> almacen;

    public Deposito(){
        this.almacen = new ArrayList<T>();
    }
    public void add(T item){
        this.almacen.add(item);
    }
    public T get(){
        if(almacen.isEmpty()) return null;
        return almacen.remove(0);
    }

}
