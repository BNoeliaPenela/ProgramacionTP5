/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import model.Categoria;
import model.Producto;
import view.Console;
import java.util.ArrayList;

public class Controller {
    
    ArrayList<Producto> listProd = new ArrayList<Producto>();
    ArrayList<Categoria> listCat = new ArrayList<Categoria>();
     
    protected Producto prod;
    protected Categoria cat;
    protected Console view;

    public Controller() {
        this.cat = new Categoria();
        this.prod = new Producto();
        this.view = new Console();
    }

    public Producto getProd() {
        return prod;
    }

    public void setProd(Producto prod) {
        this.prod = prod;
    }

    public Categoria getCat() {
        return cat;
    }

    public void setCat(Categoria cat) {
        this.cat = cat;
    }
    
    

    
    public void Menu(){
        
       
        int opcion;
        boolean salir = false;
        
        while (salir == false){
            
            opcion = this.view.LeerInt("""
                                       Ingrese la operacion que quiere realizar.
                                       1-Cargar Categoria
                                       2-Cargar Producto
                                       3-Mostrar Productos
                                       4-Actualizar Productos
                                       5-Eliminar Productos
                                       6-Listar productos por categoria
                                       7-Actualizar categoria
                                       8-Eliminar productos por Categoria
                                       9-Salir del menu""");
            
            switch(opcion){
            
                
                case 1:
                    CargarCat(listCat);
                    break;
                case 2:                     
                    CargarProd();
                    break;
                case 3:
                    MostrarLista(listProd);
                    break;
                case 4:
                    ActualizarProd(listProd);
                    break;
                case 5:
                    EliminarProd(listProd);
                    break;
                case 6:
                    ListarProdCat(listProd);
                    break;
                case 7:
                    ActualizarCat(listProd);
                    break;
                case 8:
                    EliminarPorCat(listProd);
                    break;
                case 9:
                    salir = true;
                    break;
                
            
            }
           
        }
        this.view.MostrarMensaje("Ha salido del menu");
    }
    
    
    public void CargarCat(ArrayList listCat){
        
        int id = this.view.LeerInt("Ingrese el ID de la categoria");
        String nombre = this.view.LeerString("Ingrese el nombre de la categoria");
        
        Categoria cat = new Categoria(id, nombre);
        
        listCat.add(cat);
        this.view.MostrarMensaje("Categoria agregada exitosamente");
    }
       
    public void CargarProd(){
        
        
        
        int id = this.view.LeerInt("Ingrese el ID del producto.");
                      
        String nombre = this.view.LeerString("Ingrese el nombre del producto.");
                        
        double precio = this.view.LeerInt("Ingrese el precio del producto.");
        
        Producto prod = new Producto(id, nombre, precio);
        
        MostrarCat(listCat);
        int catId = this.view.LeerInt("A cual de estas categorias pertenece el producto?");
        boolean found = false;
        for (int i = 0; i < listCat.size(); i++){
            Categoria cat = listCat.get(i);
            if (cat.getId() == catId){
                                                
                prod.setCat(cat);
                found = true;
            }
                
        }
        if (found == false){
            this.view.MostrarMensaje("Esa categoria no existe");
        }
        else{
            listProd.add(prod);        
            this.view.MostrarMensaje("Producto agregado exitosamente");
        }
        
                                                      
        
    }
        
    private void MostrarCat(ArrayList listCat){
        
        if (listCat.isEmpty()){
            this.view.MostrarMensaje("La lista esta vacia");
            
        }
        else{
            for(int i = 0; i < listCat.size(); i++){
                Categoria cat = (Categoria)listCat.get(i);
                this.view.MostrarCat(cat);
            }
        }
    }
     
    public void MostrarLista(ArrayList listProd){
        
        if (listProd.isEmpty()){
            
            
            this.view.MostrarMensaje("No hay ningun producto en la lista.");
        }
        else{
            /*for(Producto producto: listProd ){
                System.out.println(producto);
            }*/
            
            for (int i = 0; i < listProd.size(); i++){ //se sobreescribio el metodo ToString.
                
                Producto prod = (Producto)listProd.get(i); //sin sobreescribir el metodo, devuelve la referencia de memoria del objeto. 
                
                this.view.MostrarProducto(prod);
            }
            
        }
    }
    
    public void ActualizarProd(ArrayList listProd){
                                      
        int idM = this.view.LeerInt("Ingrese el ID del producto a modificar");
        
        
        
        if (listProd.isEmpty()){
            
            this.view.MostrarMensaje("La lista esta vacia");
        }
        else{
            boolean found = false;
            for (int i = 0; i < listProd.size(); i++){
                
                Producto prod = (Producto)listProd.get(i);
                
                if (prod.getId() == idM){
                
                           
                int opcion = this.view.LeerInt("Que desea modificar?\n1-ID\n2-nombre\n3-precio\n4-TODO");
                
                
                while(found == false){
                    
                    switch(opcion){
                        case 1:                                                  
                            int id = this.view.LeerInt("Ingresar el nuevo ID");
                            prod.setId(id);
                            found = true;
                            break;
                        case 2:                           
                            String nombre = this.view.LeerString("Ingresar nuevo Nombre");
                            prod.setNombre(nombre);
                            found = true;
                            break;
                        case 3:                            
                            double precio = this.view.LeerInt("Ingresar nuevo Precio");                            
                            prod.setPrecio(precio);
                            found = true;
                            break;
                        case 4:
                           
                            prod.setId(this.view.LeerInt("Ingresar el nuevo ID"));                                                       
                            prod.setNombre(this.view.LeerString("Ingresar nuevo Nombre"));                                                    
                            prod.setPrecio(this.view.LeerInt("Ingresar nuevo Precio"));
                            found = true;
                            break;
                    }
                }
                
            }
            
                                   
            }
            if (found == true){
            
                this.view.MostrarMensaje("Actualizacion exitosa.");
            }
            else{
                this.view.MostrarMensaje("No se ha encontrado ese producto.");
            }
        }
        
                               
    } 
     
    public void EliminarProd(ArrayList listProd){
        
        if (listProd.isEmpty()){
            
            this.view.MostrarMensaje("La lista esta vacia");
        }
        else{
            
            boolean found = false;
            int idE = this.view.LeerInt("Ingrese el ID del producto a eliminar");
            
            for (int i = 0; i < listProd.size(); i++){
                
                Producto prod = (Producto)listProd.get(i);
                
                if (prod.getId() == idE){
                    
                    found = true;
                    listProd.remove(prod);
                }
            }
            
            if (found == true){
                
                this.view.MostrarMensaje("Prodcuto eliminado con exito");
            }
                                                  
        }
        
    }
    
    public void ListarProdCat(ArrayList listProd){
        
        int catId = this.view.LeerInt("Ingresar el ID de la categoria que desea ver");
        
        
        boolean found = false;
        for (int i = 0; i < listProd.size(); i++){ 
               
            Producto prod = (Producto)listProd.get(i); 
            
            if (prod.getCat().getId() == catId){
                
                this.view.MostrarProducto(prod);
                found = true;
            }
                                                       
        }
        
        if (found == false){
            this.view.MostrarMensaje("Ningun producto pertenece a esta categoria.");
        }
        
    }
    
    public void ActualizarCat(ArrayList listProd){
        
        int catIdM = this.view.LeerInt("Ingresar el ID de la categoria que desea modificar");
        
        MostrarCat(listCat);
        int catId = this.view.LeerInt("Que otra categoria le quiere asignar a los productos?");
        boolean found = false;
        for (int i = 0; i < listCat.size(); i++){
            Categoria cat = listCat.get(i);
            if (cat.getId() == catId){
                
                for (int j = 0; j < listProd.size(); j++){ 
               
                    Producto prod = (Producto)listProd.get(j); 
            
                    if (prod.getCat().getId() == catIdM){
                                
                        
                        prod.setCat(cat);
                
                        
                    }
                                                       
                }
                                                
                
                found = true;
            }
                
        }
        if (found == false){
            this.view.MostrarMensaje("Esa categoria no existe");
        }
        else{
                  
            this.view.MostrarMensaje("Categoria modificada exitosamente");
        }        
        
        
    }
    
    public void EliminarPorCat(ArrayList listProd){
        
        int catIdM = this.view.LeerInt("Ingresar el ID de la categoria que desea eliminar");
        
        boolean found = false;
        boolean found1 = false;
        
        for (int i = 0; i < listProd.size(); i++){ 
               
            Producto prod = (Producto)listProd.get(i); 
            
            if (prod.getCat().getId() == catIdM){
                                
                        
                listProd.remove(prod);
                
                found = true;        
            }
                                                       
        }
        if (found == true){
           this.view.MostrarMensaje("Se han eliminado todos los productos pertenecientes a esta categoria.");
            
        }
        else{
            this.view.MostrarMensaje("No hay productos pertenecientes a esta categoria.");
        }
        
        for(int i = 0; i < listCat.size(); i++){
            Categoria cat = listCat.get(i);
            if (cat.getId() == catIdM){
                listCat.remove(cat);
                found1 = true;
            }
            
        }
        if (found1 == true){
            this.view.MostrarMensaje("La categoria se ha eliminado de la lista correctamente");
        }
        else{
            this.view.MostrarMensaje("La categoria no existe");
        }
        
                
        
        
        
    }
}
