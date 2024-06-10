/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tp5prog.view;

import tp5prog.model.Producto;
import tp5prog.model.Categoria;
import java.util.Scanner;

public class Console {
    
    protected Scanner scanner;

    public Console() {
        this.scanner = new Scanner(System.in);
    }
    
    public void MostrarProducto (Producto prod){
        System.out.println(prod);
    }
    public void MostrarCat(Categoria cat){
        System.out.println(cat);
    }
    
    public void MostrarMensaje(String mensaje){
        System.out.println(mensaje);
    }
    
    
   
    public String LeerString (String mensaje){
        
        String salida;
        System.out.println(mensaje);
        salida = this.scanner.next();
        return salida;
    }
    
    public int LeerInt(String mensaje){
        
        int salida;
        System.out.println(mensaje);
        salida = this.scanner.nextInt();
        return salida;
    }

   
    
    
}
