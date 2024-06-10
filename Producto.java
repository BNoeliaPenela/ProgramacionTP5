/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tp5prog.model;

import tp5prog.model.Categoria;

public class Producto {
    
    int id;
    String nombre;
    double precio;
    Categoria cat;
    
    public Producto(){
        
        this.cat = new Categoria();
    }
    public Producto(int id, String nombre, double precio){
        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public Categoria getCat() {
        return cat;
    }

    public void setCat(Categoria cat) {
        this.cat = cat;
    }
    
    
    
    
    @Override
    public String toString() {
        return "Producto{" +
        "id =" + id +
        ", nombre ='" + nombre + '\'' +
        ", precio =" + precio + ", categoria =" + cat.getNombre() +
        '}';
  }
}


