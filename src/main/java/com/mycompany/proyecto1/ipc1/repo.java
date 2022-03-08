
package com.mycompany.proyecto1.ipc1;


public class repo {
     private String encabezado = "";
    private String pie = "\n </body>\n" +
                         "</html>";

    
     private void Encabezado (String titulo){
        encabezado =    "<!DOCTYPE html>\n" +
                        "<html lang=\"en\">\n" +
                        "<head>\n" +
                        "    <meta charset=\"UTF-8\">\n" +
                        "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n" +
                        "    <title>"+titulo+"</title>\n" +
                        "</head>\n" +
                        "<body>";
    }
    
    public String reporteUsuarios(){
        String reporte="";

        Encabezado("Reporte de usuarios");
        reporte = reporte + encabezado;

        String [] encabezados = {"ID del usuario", "Nombre", "Apellido", "Nombre de usuario", "Rol", "Bibliografias prestadas"};
        String[][] datosUsuarios = Usuario.datosUsuario();
        String[][] datosnuevos = new String[datosUsuarios.length][6];

        for (int i = 0; i < datosUsuarios.length; i++) {
            datosnuevos[i][0]=datosUsuarios[i][0];
            datosnuevos[i][1]=datosUsuarios[i][1];
            datosnuevos[i][2]=datosUsuarios[i][2];
            datosnuevos[i][3]=datosUsuarios[i][3];
            String numeroRol =datosUsuarios[i][4];

            if (numeroRol.equals("1")) {
                datosnuevos[i][4]="Administrador";
            }else if (numeroRol.equals("2")) {
                datosnuevos[i][4]="Estudiante";
            }else if (numeroRol.equals("3")) {
                datosnuevos[i][4]="Profesor";
            }

            String Prestadas = "0";
            String[][] datosPrestamoPorUsuario = prestamo.PrestamoNoDevueltos(datosUsuarios[i][0]);

            if (datosPrestamoPorUsuario != null) {
                if (datosPrestamoPorUsuario[0][0] != null) {
                    Prestadas = datosPrestamoPorUsuario.length +"";
                }
            }
            datosnuevos[i][5]=Prestadas;
        }

        String tabla = crearTabla(encabezados,datosnuevos);

        reporte =reporte+tabla+pie;

        return reporte;
    }

     public String reporteBibliografias() {

        String repo="";

        Encabezado("Reporte de Bibliografias");
        repo = repo + encabezado;

        String [] encabezados = {"Tema","Bibliografias asociadas"};
        String[][] datosBibliografia = Bibliografia.datosBibiliografia();


        if (datosBibliografia[0][0] == null) {
            return "";
        }

        String temasSeparados = "";
        for (int i = 0; i < datosBibliografia.length; i++) {
            String[] temasBibliografiaIndividual = datosBibliografia[i][5].split(",");

            for (int j = 0; j < temasBibliografiaIndividual.length; j++) {

                String temaIndividual = temasBibliografiaIndividual[j];

                if (i == 0 && j ==0) {
                    temasSeparados+= temaIndividual + " ;";
                }else{
                    int verificaciones = 1;
                    String [] temasVerificados = temasSeparados.split(";");
                    boolean noAparecio =true;
                    for (int k = 0; k < temasVerificados.length; k++) {

                        if (temasVerificados[k].trim().equals(temaIndividual.trim())) {
                            noAparecio = false;
                        }
                        if (verificaciones == temasVerificados.length && noAparecio) {
                            temasSeparados+= " " + temaIndividual + " ;";
                        }

                        verificaciones++;
                    }
                }
            }
        }

        temasSeparados = temasSeparados.substring(0, temasSeparados.length()-1);

        String [] temas = temasSeparados.split(";");
        String[][] datosReporten = new String[temas.length][2];

        for (int i = 0; i < datosReporten.length; i++) {
            datosReporten[i][0] =temas[i].trim();

            int bibliografiasRegistradas = 0;
            for (int j = 0; j < datosBibliografia.length; j++) {
                String[] temasBibliografiaIndividual = datosBibliografia[j][5].split(",");
                for (int k = 0; k < temasBibliografiaIndividual.length; k++) {
                    if (temasBibliografiaIndividual[k].trim().equals(temas[i].trim())) {
                        bibliografiasRegistradas++;

                    }
                }
            }


            datosReporten[i][1] =bibliografiasRegistradas+"";

        }

        String tabla = crearTabla(encabezados,datosReporten);

        repo =repo+tabla+pie;
        return repo;

    }
    
    
        private String crearTabla(String [] encabezados, String[][] datosCuerpo){
        String tabla ="\n<table border='1'>";


        //Encabezado
        String encabezadoTabla = "\n\t\t<tr>";
        for (String encabezado:encabezados) {
            encabezadoTabla = encabezadoTabla + "\n\t\t\t<th>"+encabezado+"</th>";
        }
        encabezadoTabla=encabezadoTabla+"\n\t\t</tr>";

        //cuerpo de tabla
        String cuerpoTabla = "";
        for (int i = 0; i < datosCuerpo.length; i++) {
            String fila = "\n\t\t<tr>";
            for (int j = 0; j < datosCuerpo[i].length; j++) {
                fila=fila+"\n\t\t\t<td>"+datosCuerpo[i][j]+"</td>";
            }
            fila=fila+"\n\t\t</tr>";
            cuerpoTabla=cuerpoTabla+fila;
        }
        

        tabla=tabla+encabezadoTabla+cuerpoTabla+"\n</table>";

        return tabla;
    }

   

}
