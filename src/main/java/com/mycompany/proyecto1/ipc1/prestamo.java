
package com.mycompany.proyecto1.ipc1;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


public class prestamo {
     
    public static String datos = "";
    public static int numeroPrestamo =0;

    private final static int CAMPOS=5;


    private String id;
    private String titulo;
    private String fecha;
    private String devuelto; 
    private String idUsuario;

    public prestamo(String titulo, String idUsuario){
        DateTimeFormatter formatoDeFecha = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");

        numeroPrestamo=numeroPrestamo+1;
        this.id = (numeroPrestamo) +"";
        this.titulo = titulo;
        this.fecha = formatoDeFecha.format(LocalDateTime.now());
        this.devuelto = "0";
        this.idUsuario = idUsuario;
    }

    public static String[][] datosPrestamo(){
        String[] arregloDatos = datos.split("\n");

        String [][] datosFormateados = new String[arregloDatos.length][CAMPOS];

        if (datos.length()>0) {
            for (int i = 0; i < arregloDatos.length; i++) {
                for (int j = 0; j < CAMPOS; j++) {
                    datosFormateados[i][j]=arregloDatos[i].split(";")[j];
                }
            }
        }


        return datosFormateados;
    }
    
    

    public static String[][] PrestamoNoDevueltos(String idUsuario){
        int datosDisponibles = 0;

        if (datosPrestamo()[0][0] != null) {
            for (int i = 0; i < datosPrestamo().length; i++) {
                if ((datosPrestamo()[i][4].equals(idUsuario)) && (datosPrestamo()[i][3].equals("0"))) {
                    datosDisponibles++;
                }
            }
        }


        if (datosDisponibles>0) {
            String [][] busqueda = new String [datosDisponibles][4];
            int contador = 0;
            for (int i = 0; i < datosPrestamo().length; i++) {
                if ((datosPrestamo()[i][4].equals(idUsuario)) && (datosPrestamo()[i][3].equals("0"))) {
                    busqueda[contador]=datosPrestamo()[i];
                }
            }

     
            return busqueda;
        }else{
            return null;
        }
    }


    
}
