package org.example;

public enum Catalogo {
    COCACOLA(1, 100);
    SPRITE(2, 1000);
    FANTA(3, 1000);
    SNICKERS(4, 800);
    SUPER8(5, 500);

    private final int id;
    private final int precio;

    Catalogo(int id, int precio){
        this.id = id;
        this.precio = precio;
    }
    public int getPrecio(){return precio;}
    public int getId(){return id;}
}

