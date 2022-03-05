
package com.mycompany.proyecto1.ipc1;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


public class prestamo {
     //datos de los usuarios
    public static String datos = "";
    public static int numeroPrestamo =-1;

    private final static int NUMERO_CAMPOS=5;


    private String id;
    private String titulo;
    private String fecha;
    private String devuelto; 
    private String idUsuario;

    public prestamo(String titulo, String idUsuario){
        DateTimeFormatter formatoDeFecha = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");

        numeroPrestamo+=1;
        this.id = (numeroPrestamo) +"";
        this.titulo = titulo;
        this.fecha = formatoDeFecha.format(LocalDateTime.now());
        this.devuelto = "0";
        this.idUsuario = idUsuario;
    }

    private static boolean modificarDisponiblidad(String tituloBuscar, boolean aumentar) {

        System.out.println(tituloBuscar);
        String[] datosBibliografia = Bibliografia.buscarBibliografia(tituloBuscar);

            String tipo = datosBibliografia[0];
            String autor = datosBibliografia[1];
            String titulo = datosBibliografia[2];
            String descripcion = datosBibliografia[3];
            String edicion = datosBibliografia[4];
            String[] temas = datosBibliografia[5].split(",");
            String frecuenciaActual = datosBibliografia[6];
            String ejemplares = datosBibliografia[7];
            String areas = datosBibliografia[8];
            String copias = datosBibliografia[9];
            int disponibles = Integer.parseInt(datosBibliografia[10].trim());

            int nuevaDisponibilidad;
            if (aumentar) {
                nuevaDisponibilidad = disponibles + 1;
            } else {
                nuevaDisponibilidad = disponibles - 1;

            }
            return Bibliografia.actualizarBibliografia(tipo, autor, titulo, descripcion, edicion, temas, frecuenciaActual, ejemplares, areas, copias, nuevaDisponibilidad+"");
    }

    public String crearPrestamo(){

        String respuesta;


        if (existeDisponibilidad(this.titulo)) {


                if(modificarDisponiblidad(this.titulo, false)){
                    datos = datos + this.id +";"+this.titulo+";"+this.fecha+";"+this.devuelto+";"+this.idUsuario+"\n";
                    respuesta ="Prestamo creado correctamente";
                }else{
                    respuesta ="Hubo algun error";
                }

        }else{
            respuesta ="No existe disponibilidad de esta bibliografía";
        }
        return respuesta;
    }

    public static String[][] listarPrestamoNoDevueltos(String idUsuario){
        int datosDisponibles = 0;

        if (datosPrestamo()[0][0] != null) {
            for (int i = 0; i < datosPrestamo().length; i++) {
                if ((datosPrestamo()[i][4].equals(idUsuario)) && (datosPrestamo()[i][3].equals("0"))) {
                    datosDisponibles++;
                }
            }
        }


        if (datosDisponibles>0) {
            String [][] datosPrestamoBusqueda = new String [datosDisponibles][4];
            int contadorAux = 0;
            for (int i = 0; i < datosPrestamo().length; i++) {
                if ((datosPrestamo()[i][4].equals(idUsuario)) && (datosPrestamo()[i][3].equals("0"))) {
                    datosPrestamoBusqueda[contadorAux]=datosPrestamo()[i];
                }
            }

            //regresar tipo ?
            return datosPrestamoBusqueda;
        }else{
            return null;
        }
    }

    public static String[][] listarPrestamos(String idUsuario) {

        if (datosPrestamo()[0][0] == null) {
            return null;
        }

   
        int coincidencias = 0;
        for (int i = 0; i < datosPrestamo().length; i++) {
            //verificar si contiene el tema
            if (datosPrestamo()[i][4].equalsIgnoreCase(idUsuario)) {
                coincidencias++;
            }
        }

        if (coincidencias>0) {
            String [][] datosPrestamoBusqueda = new String[coincidencias][NUMERO_CAMPOS];
            int contadorAux =0;

            for (int i = 0; i < datosPrestamo().length; i++) {
                if (datosPrestamo()[i][4].equalsIgnoreCase(idUsuario)) {
                    datosPrestamoBusqueda[contadorAux] =datosPrestamo()[i];
                    contadorAux++;
                }
            }

            return datosPrestamoBusqueda;
        }else{
            return null;
        }

    }


    public static String devolverPrestamo(String idPrestamo){
        String [] datosUsuarioBusqueda = null;

        for (int i = 0; i < datosPrestamo().length; i++) {
            if ((datosPrestamo()[i][0].equals(idPrestamo)) && (datosPrestamo()[i][3].equals("0"))) {
                datosUsuarioBusqueda = datosPrestamo()[i];
            }
        }


        if (datosUsuarioBusqueda != null){
            String nuevosDatos="";
            for (int i = 0; i < datosPrestamo().length; i++) {
                if (!(datosPrestamo()[i][0].equals(idPrestamo))) {
                    for (int j = 0; j < NUMERO_CAMPOS; j++) {
                        nuevosDatos=nuevosDatos+ datosPrestamo()[i][j] +";";
                    }
                    nuevosDatos=nuevosDatos+"\n";
                }else{
                    nuevosDatos=nuevosDatos+datosUsuarioBusqueda[0] +";"+datosUsuarioBusqueda[1]+";"+datosUsuarioBusqueda[2]+";"+"1"+";"+datosUsuarioBusqueda[4]+"\n";
                    modificarDisponiblidad(datosUsuarioBusqueda[1],true);
                }
            }
            datos=nuevosDatos;
            return "Biliografia devuelta correctamente";
        }else{
            return "Biliografia devuelta previamente";
        }
    }

    private boolean existeDisponibilidad(String titulo){

        int disposibles = Integer.parseInt(Bibliografia.disponibilidadBibliografia(titulo));
        if (disposibles>=1) {
            return true;
        }else{
            return false;
        }
    }

    public static String[][] datosPrestamo(){
        String[] arregloDatos = datos.split("\n");

        String [][] datosFormateados = new String[arregloDatos.length][NUMERO_CAMPOS];

        if (datos.length()>0) {
            for (int i = 0; i < arregloDatos.length; i++) {
                for (int j = 0; j < NUMERO_CAMPOS; j++) {
                    datosFormateados[i][j]=arregloDatos[i].split(";")[j];
                }
            }
        }


        return datosFormateados;
    }
}
