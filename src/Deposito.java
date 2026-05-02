import java.util.ArrayList;

public class Deposito<T>{
    private ArrayList<T> almacen;

    public Deposito(){
        almacen = new ArrayList<T>();
    }
    public void add(T item){
        almacen.add(item);
    }

    public T get(){
        if(almacen.size() == 0) return null;
        return almacen.remove(0);
    }
}