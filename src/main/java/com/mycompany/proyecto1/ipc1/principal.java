
package com.mycompany.proyecto1.ipc1;

public class principal {
    
    public static void main(String[] args){
        Usuario administrador = new Usuario("1","administrador", "administrador", "admin", "1", "password");
        System.out.println(administrador);
        formularios c= new formularios();
        c.fprincipal();
    }
        
}
