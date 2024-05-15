/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package productos;

import java.util.ArrayList;
import java.util.Scanner;
/**
 *
 * @author Alumno15
 */
public class Productos {

    
    ArrayList<Productos1> listProd = new ArrayList<>();
    
    
    public static void main(String[] args) {
        
        
        CargarLista();
        
        
                
    }
    
    public static void CargarLista(){
        
        Scanner teclado = new Scanner(System.in);
        
        System.out.println("Ingresar id del producto");
        int id = teclado.nextInt();
        System.out.println("Ingresar nombre del producto");
        String nombre = teclado.nextLine();
        System.out.println("Ingresar el precio del producto");
        double precio = teclado.nextDouble();
        
        Productos1 prod1 = new Productos1(id, nombre, precio);       
        listProd.add(prod1);
        
        System.out.println("Producto agregado: " + prod1.getNombre());
    }
    
    
}
