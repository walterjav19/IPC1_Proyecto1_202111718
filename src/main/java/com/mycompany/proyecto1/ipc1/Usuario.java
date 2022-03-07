
package com.mycompany.proyecto1.ipc1;

public class Usuario {

    public static String datos = "";

    private final static int CAMPOS=6;

    //parametros para el constructor
    private String id;
    private String nombre;
    private String apellido;
    private String nombreUsuario;
    private String rol;
    private String contrasena;

    public Usuario(String id, String nombre, String apellido, String nombreUsuario, String rol, String contrasena){
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.nombreUsuario = nombreUsuario;
        this.rol = rol;
        this.contrasena = contrasena;

        crearUsuario();
    }

    public boolean crearUsuario(){

        //verificacion en consola
        if (!existeUsuario(id)) {
            datos = datos + this.id +";"+this.nombre+";"+this.apellido+";"+this.nombreUsuario+";"+this.rol+";"+this.contrasena+"\n";
            return true;
        }else{
            return false;
        }
    }

    public static String[][] datosUsuario(){
        String[] arregloDatos = datos.split("\n");

        String [][] datosnuevos = new String[arregloDatos.length][6];

        if (datos.length()>0) {
            for (int i = 0; i < arregloDatos.length; i++) {
                for (int j = 0; j < CAMPOS; j++) {
                    datosnuevos[i][j]=arregloDatos[i].split(";")[j];
                }
            }
        }
        return datosnuevos;
    }

    public static boolean actualizarUsuario(String id, String nombre, String apellido, String nombreUsuario, String rol, String contrasena){
            if (existeUsuario(id)) {
                String nuevosDatos="";
                for (int i = 0; i < datosUsuario().length; i++) {
                    if (!(datosUsuario()[i][0].equals(id))) {
                        for (int j = 0; j < CAMPOS; j++) {
                            nuevosDatos=nuevosDatos+ datosUsuario()[i][j] +";";
                        }
                        nuevosDatos=nuevosDatos+"\n";
                    }else{
                        nuevosDatos=nuevosDatos+id +";"+nombre+";"+apellido+";"+nombreUsuario+";"+rol+";"+contrasena+"\n";
                    }
                }

                datos=nuevosDatos;

                return true;
            }else{
                return false;
            }
        }

    public static void eliminarUsuario(String id){

        
        String nuevosDatos="";
        for (int i = 0; i < datosUsuario().length; i++) {
            if (!(datosUsuario()[i][0].equals(id))) {

                for (int j = 0; j < CAMPOS; j++) {
                    nuevosDatos=nuevosDatos+ datosUsuario()[i][j] +";";
                }
                nuevosDatos=nuevosDatos+"\n";
            }
        }
        datos=nuevosDatos;
    }

    public static String[] buscarUsuario(String id) {

        String [] Busqueda = null;

        for (int i = 0; i < datosUsuario().length; i++) {
            if ((datosUsuario()[i][0].equals(id))) {
                Busqueda = datosUsuario()[i];
            }
        }

        return Busqueda;

    }

    private static boolean existeUsuario(String id){//verificamos si hay 

    
        if (datos.length()>0) {
            boolean hay =false;
            for (int i = 0; i < datosUsuario().length; i++) {
                if ((datosUsuario()[i][0].equals(id))) {
                    hay=true;
                }
            }
            return hay;
        }else{
            return false;
        }
    }

    public static String[] login(String nombre, String contraseña){
        String [] mensaje = new String[4];

        for (int i = 0; i < datosUsuario().length; i++) {
            if (datosUsuario()[i][3].equals(nombre)) {
                if (datosUsuario()[i][5].equals(contraseña)) {
                    mensaje[0]="1";
                    mensaje[1]="Bienvenido: " + datosUsuario()[i][3];
                    mensaje[2]=datosUsuario()[i][0];
                    mensaje[3]=datosUsuario()[i][4];

                }else{
                    mensaje[0]="0";
                    mensaje[1]="Credenciales inválidas para el usuario, por favor intente nuevamente";
                    mensaje[2]=null;
                    mensaje[3]=null;

                }
                break;
            }else{
                if (i == datosUsuario().length-1) {
                    mensaje[0]="0";
                    mensaje[1]="Usuario inexistente, contacte al administrador";
                    mensaje[2]=null;
                    mensaje[3]=null;

                }
            }

        }

        return mensaje;
    } 

}
