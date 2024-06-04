/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package tp5prog;

import java.util.ArrayList;
import java.util.Scanner;

public class TP5Prog {

   
    
    public static void main(String[] args) {
      
         ArrayList<Producto> listProd = new ArrayList<Producto>();
        
        
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Ingrese la operacion que quiere realizar"); //escribir menu
        int opcion = scanner.nextInt();
        boolean salir = false;
        
        while (salir == false){
            
            switch(opcion){
            
                case 1:                     
                    CargarProd(listProd);
                    break;
                case 2:
                    MostrarLista(listProd);
                    break;
                case 3:
                    ActualizarProd(listProd);
                    break;
                
            
            }
            System.out.println("Ingrese la operacion que quiere realizar"); //escribir menu
            opcion = scanner.nextInt();
        }
        System.out.println("Ha salido del menu");
                
    }
    
    public static void CargarProd(ArrayList listProd){
        
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese el ID del producto.");
        int id = scanner.nextInt();
        
        System.out.println("Ingrese el nombre del producto.");
        String nombre = scanner.next();
        
        System.out.println("Ingrese el precio del producto.");       
        double precio = scanner.nextDouble();
        
        Producto prod = new Producto(id, nombre, precio);
        
        listProd.add(prod);
        
        System.out.println("Producto agregado exitosamente");
    }
    
    public static void MostrarLista(ArrayList listProd){
        
        if (listProd.isEmpty()){
            
            System.out.println("No hay ningun producto en la lista.");
        }
        else{
            /*for(Producto producto: listProd ){
                System.out.println(producto);
            }*/
            
            for (int i = 0; i < listProd.size(); i++){ //se sobreescribio el metodo ToString.
                
                Producto prod = (Producto)listProd.get(i); //sin sobreescribir el metodo, devuelve la referencia de memoria del objeto. 
                System.out.println(prod);
            }
            
        }
    }
    
    public static void ActualizarProd(ArrayList listProd){
        
        Scanner scanner = new Scanner(System.in);
        
        
        System.out.println("Ingrese el ID del producto a modificar");
        int idM = scanner.nextInt();
        boolean found = false;
        
        for (int i = 0; i < listProd.size(); i++){
            
            Producto prod = (Producto)listProd.get(i);
            
            if (prod.getId() == idM){
                
                System.out.println("Que desea modificar?\n1-ID\n2-nombre\n3-precio\n4-TODO");
                int opcion = scanner.nextInt();
                
                
                while(found == false){
                    
                    switch(opcion){
                        case 1:
                            System.out.println("Ingresar el nuevo ID");
                            int id = scanner.nextInt();
                            prod.setId(id);
                            found = true;
                            break;
                        case 2:
                            System.out.println("Ingresar nuevo Nombre");
                            String nombre = scanner.next();
                            prod.setNombre(nombre);
                            found = true;
                            break;
                        case 3:
                            System.out.println("Ingresar nuevo Precio");
                            double precio = scanner.nextDouble();
                            prod.setPrecio(precio);
                            found = true;
                            break;
                        case 4:
                            System.out.println("Ingresar el nuevo ID");
                            prod.setId(scanner.nextInt());
                            System.out.println("Ingresar nuevo Nombre");                            
                            prod.setNombre(scanner.next());
                            System.out.println("Ingresar nuevo Precio");                             
                            prod.setPrecio(scanner.nextDouble());
                            found = true;
                            break;
                    }
                }
                
            }
        }
        if (found == true){
            System.out.println("Actualizacion exitosa.");
        }
        else{
            System.out.println("No se ha encontrado ese producto.");
        }
        
        
    } 
    
    
}
