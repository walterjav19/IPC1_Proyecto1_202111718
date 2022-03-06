
package com.mycompany.proyecto1.ipc1;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URISyntaxException;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;



public class formularios {
    
    //objetos swing y awt
    JLabel vision,etiqueta,etiban;
    JFrame principal,login,admi;
    
    JButton btnabout,btnlogin,logout;
    ImageIcon logo,banner;    
    
    //datos usuarios

    
    public void fprincipal(){
        
        principal= new JFrame();
        principal.setLayout(null);
        principal.setResizable(false);
        principal.getContentPane().setBackground(new Color(255,255,255));
        principal.setSize(1200,600);
        principal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        principal.setTitle("BIBLIOTECA FACULTAD DE INGENIERIA USAC");
        
        logo=new ImageIcon("C:\\Users\\walte\\OneDrive\\Documentos\\NetBeansProjects\\proyecto1-IPC1\\src\\main\\java\\imagenes\\usac.jpg");
        etiqueta=new JLabel();
        etiqueta.setIcon(logo);
        etiqueta.setText("VISIÓN");
        etiqueta.setVerticalTextPosition(JLabel.TOP);
        etiqueta.setFont(new Font("MV Boli",Font.PLAIN,20));
        etiqueta.setBounds(50,240,400,400);
        principal.add(etiqueta);
        banner=new ImageIcon("C:\\Users\\walte\\OneDrive\\Documentos\\NetBeansProjects\\proyecto1-IPC1\\src\\main\\java\\imagenes\\banner1.JPG");
        etiban=new JLabel();
        etiban.setIcon(banner);
        etiban.setBounds(250,0,774,296);
        principal.add(etiban);
        
        vision= new JLabel();
        vision.setText("<html>Ser la unidad de informacion especializada y técnica con"
                + " <p> estandares de Biblioteca Universitaria, en beneficio del<p>"
                + "desarrollo de la ciencia y la tecnologia del pais <html>");
        vision.setFont(new Font("Century",Font.ITALIC,15));
        vision.setBounds(290,350,410,80);
        principal.add(vision);
        
        btnlogin=new JButton("Login");
        btnlogin.setVisible(true);
        btnlogin.setBounds(1050,60,100,30);
        principal.add(btnlogin);
        
        ActionListener es=new ActionListener(){
           
            public void actionPerformed(ActionEvent e) {
              principal.dispose();
              login();
            }
            
        };
        btnlogin.addActionListener(es);
        
        btnabout=new JButton("About");
        btnabout.setVisible(true);
        btnabout.setBounds(1050,450,100,30);
        principal.add(btnabout);
        
       ActionListener escuchador= new ActionListener() {
         
          public void actionPerformed(ActionEvent e) {
              
              if(java.awt.Desktop.isDesktopSupported()){
               java.awt.Desktop desktop=java.awt.Desktop.getDesktop();
               
                if(desktop.isSupported(java.awt.Desktop.Action.BROWSE)){
                       try{
                           java.net.URI uri=new java.net.URI("https://portal.ingenieria.usac.edu.gt/");
                           desktop.browse(uri);
                       }catch(URISyntaxException | IOException ex){
                           
                       }
                }
              }
                  
          }
      };
      btnabout.addActionListener(escuchador);
        
        principal.setVisible(true);
        
    }
    
    
    
    
    
    public void login(){
        
        login=new JFrame();
        login.setLayout(null);
        login.getContentPane().setBackground(new Color(72, 103, 117));
        login.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        login.setResizable(false);
        login.setSize(500,500);
        login.setTitle("LOGIN");
        login.setLocationRelativeTo(null); 
        
        JLabel usuario=new JLabel("Usuario");
        usuario.setForeground(new Color(255, 255, 255));
        usuario.setBounds(135, 200, 100, 30);
        login.add(usuario);
        
        JTextField txtusu= new JTextField();
        txtusu.setBackground(new Color(106, 128, 138));
        txtusu.setForeground(new Color(255, 255, 255));
        txtusu.setBounds(220,200,100,30);
        login.add(txtusu);
       
        
        JLabel contraseña=new JLabel("Contraseña");
        contraseña.setForeground(new Color(255, 255, 255));
        contraseña.setBounds(135,245,100,30);
        login.add(contraseña);
        
        JPasswordField txtcon=new JPasswordField();
        txtcon.setBackground(new Color(106, 128, 138));
        txtcon.setForeground(new Color(255, 255, 255));
        txtcon.setBounds(220,245,100,30);
        login.add(txtcon);
        
        JButton btnlogin=new JButton("Ingresar");
        btnlogin.setBounds(130,300,100,30);
        btnlogin.setBackground(new Color(64,207,255));
        btnlogin.setForeground(new Color(255,255,255));
        btnlogin.setBorderPainted(false);
        login.add(btnlogin);
        
        ActionListener c= new ActionListener(){
       
            public void actionPerformed(ActionEvent e) {
               String usu = txtusu.getText();
	       String password = String.valueOf(txtcon.getPassword());
               
               if (usu.equals("") || password.equals("")) {
                JOptionPane.showMessageDialog(null, "Ingrese su usuario y contraseña", "Error", JOptionPane.ERROR_MESSAGE);

            } else {
                String[] respuesta = Usuario.login(usu, password);//arreglo guarda parametros
                if (respuesta[0].equals("0")) {
                    JOptionPane.showMessageDialog(null, respuesta[1], "", JOptionPane.ERROR_MESSAGE);
                } else {
                    if (respuesta[3].equals("1")) {// frame para el admin
                        admin();
                        login.dispose();
                        JOptionPane.showMessageDialog(null, respuesta[1], "Bienvenido", JOptionPane.INFORMATION_MESSAGE);
                    }
                    if (respuesta[3].equals("3") || respuesta[3].equals("2")) {
                        login.dispose();
                        JOptionPane.showMessageDialog(null, respuesta[1], "Bienvenido", JOptionPane.INFORMATION_MESSAGE);

                    }

                }
            }
         
             
            }
        };
        btnlogin.addActionListener(c);
        
        JButton btnclear=new JButton("Cancelar");
        btnclear.setBounds(280,300,100,30);
        btnclear.setBackground(Color.red);
        btnclear.setForeground(new Color(255,255,255));
        btnclear.setBorderPainted(false);
        login.add(btnclear);
        
        ActionListener escuchador= new ActionListener(){
            
            public void actionPerformed(ActionEvent e) {
                txtusu.setText("");
                txtcon.setText("");
                fprincipal();
                login.dispose();
            }
            
        };
        
        btnclear.addActionListener(escuchador);
        
        ImageIcon usu=new ImageIcon(new ImageIcon("C:\\Users\\walte\\OneDrive\\Documentos\\NetBeansProjects\\proyecto1-IPC1\\src\\main\\java\\imagenes\\usuario_1.png").getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT));
        JLabel etiusu=new JLabel();
        etiusu.setIcon(usu);
        etiusu.setBounds(210,90,100,100);
        login.add(etiusu);
        
        
        login.setVisible(true);
    }
    
    public void admin(){
        
        admi=new JFrame();
        admi.setSize(1200,540);
        admi.setTitle("ADMIN");
        admi.getContentPane().setBackground(new Color(96, 96, 96 ));
        admi.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        admi.setResizable(false);
        admi.setLocationRelativeTo(null);
        admi.setLayout(null);
        
        ImageIcon escudo=new ImageIcon(new ImageIcon("C:\\Users\\walte\\OneDrive\\Documentos\\NetBeansProjects\\proyecto1-IPC1\\src\\main\\java\\imagenes\\escudo.png").getImage().getScaledInstance(175, 175, Image.SCALE_DEFAULT));
        JLabel es=new JLabel(escudo);
        es.setBounds(20,20,175,175);
        admi.add(es);
        
        logout=new JButton("Logout");
        logout.setBackground(Color.red);
        logout.setForeground(new Color(255,255,255));
        logout.setBorderPainted(false);
        logout.setBounds(1000,40,100,30);
        admi.add(logout);
        
         ActionListener escuchador= new ActionListener(){
            
            public void actionPerformed(ActionEvent e) {
                int opcion=JOptionPane.showConfirmDialog(null, "Esta seguro que quiere cerrar sesion");
                if(opcion==0){
                    login();
                    admi.dispose();
                }
            }
            
        };
        
        logout.addActionListener(escuchador);
        
        JPanel  reportes=new JPanel();
        reportes.setLayout(null);
        reportes.setBackground(new Color(72, 103, 117));
        reportes.setBorder(BorderFactory.createTitledBorder("                    "));
        reportes.setBounds(700, 100, 400, 90);
        admi.add(reportes);
        
       
        JLabel r=new JLabel("Reportes");
        r.setFont(new Font("Century Gothic",Font.PLAIN,14));
        r.setForeground(new Color(255,255,255));
        r.setBounds(10, 0, 100, 30);
        r.setHorizontalAlignment(SwingConstants.LEFT);
        reportes.add(r);
        
        
        JButton usuarios= new JButton("Usuarios");
        usuarios.setBounds(20,40,100,30);
        usuarios.setBackground(new Color(64,207,255));
        usuarios.setForeground(new Color(255,255,255));
        usuarios.setBorderPainted(false);
        reportes.add(usuarios);
        
        ActionListener re= new ActionListener() {
         
          public void actionPerformed(ActionEvent e) {
             reporteusu();
             admi.dispose();
          }
      };
      usuarios.addActionListener(re);
        
        JButton biblio= new JButton("Bibliografias");
        biblio.setBackground(new Color(64,207,255));
        biblio.setForeground(new Color(255,255,255));
        biblio.setBorderPainted(false);
        biblio.setBounds(140,40,110,30);
        reportes.add(biblio);
        
         ActionListener ru= new ActionListener() {
         
          public void actionPerformed(ActionEvent e) {
             reportebiblio();
             admi.dispose();
          }
      };
      biblio.addActionListener(ru);
        
        JButton pre= new JButton("Prestamos");
        pre.setBackground(new Color(64,207,255));
        pre.setForeground(new Color(255,255,255));
        pre.setBorderPainted(false);
        pre.setBounds(260,40,110,30);
        reportes.add(pre);
        
          ActionListener rpre= new ActionListener() {
         
          public void actionPerformed(ActionEvent e) {
             reporteprest();
             admi.dispose();
          }
      };
      pre.addActionListener(rpre);
        
        JPanel uz= new JPanel();
        uz.setLayout(null);
        uz.setBorder(BorderFactory.createTitledBorder("                 "));
        uz.setBackground(new Color(72, 103, 117));
        uz.setBounds(250,250,400,200);
        admi.add(uz);
        
        JLabel u=new JLabel("Usuarios");
        u.setBounds(10, 0, 100, 30);
        u.setFont(new Font("Century Gothic",Font.PLAIN,14));
        u.setForeground(new Color(255,255,255));
        u.setHorizontalAlignment(SwingConstants.LEFT);
        uz.add(u);
        
        
        
        JButton btncrearu = new JButton("Crear");
        btncrearu.setBackground(new Color(64,207,255));
        btncrearu.setForeground(new Color(255,255,255));
        btncrearu.setBorderPainted(false);
        btncrearu.setBounds(60, 40, 90, 30);
        uz.add(btncrearu);
        
        ActionListener cu= new ActionListener() {
         
          public void actionPerformed(ActionEvent e) {
             cusuarios();
             admi.dispose();
          }
      };
      btncrearu.addActionListener(cu);
        
        
        
        JButton btnveru = new JButton("Ver");
        btnveru.setBackground(new Color(64,207,255));
        btnveru.setForeground(new Color(255,255,255));
        btnveru.setBorderPainted(false);
        btnveru.setBounds(200, 40, 90, 30);
        uz.add(btnveru);
        
        ActionListener cs= new ActionListener() {
         
          public void actionPerformed(ActionEvent e) {
             mostrar();
             admi.dispose();
          }
      };
      btnveru.addActionListener(cs);
        
        
        JButton btnmodificaru = new JButton("Modificar");
        btnmodificaru.setBackground(new Color(64,207,255));
        btnmodificaru.setForeground(new Color(255,255,255));
        btnmodificaru.setBorderPainted(false);
        btnmodificaru.setBounds(60, 130, 90, 30);
        uz.add(btnmodificaru);
        
        ActionListener cri= new ActionListener() {
         
          public void actionPerformed(ActionEvent e) {
             actualizar();
             admi.dispose();
          }
      };
      btnmodificaru.addActionListener(cri);
        
        
        JButton btnelimaru = new JButton("Eliminar");
        btnelimaru.setBackground(new Color(64,207,255));
        btnelimaru.setForeground(new Color(255,255,255));
        btnelimaru.setBorderPainted(false);
        btnelimaru.setBounds(200, 130, 90, 30);
        uz.add(btnelimaru);
        
        ActionListener cr= new ActionListener() {
         
          public void actionPerformed(ActionEvent e) {
             eliminar();
             admi.dispose();
          }
      };
      btnelimaru.addActionListener(cr);
        
        
        JPanel bli= new JPanel();
        bli.setBackground(new Color(72, 103, 117));
        bli.setLayout(null);
        bli.setBorder(BorderFactory.createTitledBorder("                         "));
        bli.setBounds(700,250,400,200);
        admi.add(bli);
        
        JLabel b=new JLabel("Bibliografias");
        b.setFont(new Font("Century Gothic",Font.PLAIN,14));
        b.setForeground(new Color(255,255,255));
        b.setBounds(10, 0, 100, 30);
        b.setHorizontalAlignment(SwingConstants.LEFT);
        bli.add(b);
        
        JButton btncrearb = new JButton("Crear");
        btncrearb.setBackground(new Color(64,207,255));
        btncrearb.setForeground(new Color(255,255,255));
        btncrearb.setBorderPainted(false);
        btncrearb.setBounds(60, 40, 90, 30);
        bli.add(btncrearb);
        
        
           ActionListener cb= new ActionListener() {
         
          public void actionPerformed(ActionEvent e) {
             
             String[] opciones = {"Crear Masiva", "Crear individual"};
             int x = JOptionPane.showOptionDialog(null, "Forma de carga","Elige una opcion",JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, opciones, opciones[0]);
             
             if (x ==0) {
                cargamasiva();
                admi.dispose();
            }else if (x == 1) {
                cargaindividual();
                admi.dispose();
            }
          }
      };
      btncrearb.addActionListener(cb);
        
        JButton btnverb = new JButton("Ver");
        btnverb.setBackground(new Color(64,207,255));
        btnverb.setForeground(new Color(255,255,255));
        btnverb.setBorderPainted(false);
        btnverb.setBounds(200, 40, 90, 30);
        bli.add(btnverb);
        
        ActionListener btnver= new ActionListener() {
         
          public void actionPerformed(ActionEvent e) {
             mostrarbibliografias();
             admi.dispose();
          }
      };
      btnverb.addActionListener(btnver);
        
        JButton btnmodificarb = new JButton("Modificar");
        btnmodificarb.setBackground(new Color(64,207,255));
        btnmodificarb.setForeground(new Color(255,255,255));
        btnmodificarb.setBorderPainted(false);
        btnmodificarb.setBounds(60, 130, 90, 30);
        bli.add(btnmodificarb);
        
        ActionListener btnm= new ActionListener() {
         
          public void actionPerformed(ActionEvent e) {
             actualizarbibliografia();
             admi.dispose();
          }
      };
      btnmodificarb.addActionListener(btnm);
        
        
        JButton btnelimarb = new JButton("Eliminar");
        btnelimarb.setBackground(new Color(64,207,255));
        btnelimarb.setForeground(new Color(255,255,255));
        btnelimarb.setBorderPainted(false);
        btnelimarb.setBounds(200, 130, 90, 30);
        bli.add(btnelimarb);
        
        ActionListener btnel= new ActionListener() {
         
          public void actionPerformed(ActionEvent e) {
             eliminarbiblio();
             admi.dispose();
          }
      };
      btnelimarb.addActionListener(btnel);
        
       
        
         admi.setVisible(true);

                 
        
    }
        
    
    public void cusuarios(){
      JFrame frame = new JFrame();
      frame.setSize(400,400);
      frame.setLayout(null);
      frame.setResizable(false);
      frame.setLocationRelativeTo(null);
      frame.setTitle("CREAR USUARIO");
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      
      JLabel Id= new JLabel();
      Id.setText("ID");
      Id.setBounds(30,30,100,30);
      frame.add(Id);
      
      JTextField txtId= new JTextField();
      txtId.setBounds(135,30,200,30);
      frame.add(txtId);
      
      JLabel nombre = new JLabel("Nombre");
      nombre.setBounds(30,60,100,30);
      frame.add(nombre);
      
      JTextField txtnombre = new JTextField();
      txtnombre.setBounds(135,60,200,30);
      frame.add(txtnombre);
      
      JLabel apellido = new JLabel("Apellido");
      apellido.setBounds(30,90,100,30);
      frame.add(apellido);
      
      JTextField txtapellido = new JTextField();
      txtapellido.setBounds(135,90,200,30);
      frame.add(txtapellido);
      
      JLabel usuario = new JLabel("Usuario");
      usuario.setBounds(30,120,100,30);
      frame.add(usuario);
      
      JTextField txtusuario = new JTextField();
      txtusuario.setBounds(135,120,200,30);
      frame.add(txtusuario);
      
      JLabel rol = new JLabel("Rol");
      rol.setBounds(30,150,100,30);
      frame.add(rol);
      
      JComboBox box = new JComboBox();
      box.setBounds(135,150,100,30);
      box.addItem("Estudiante");
      box.addItem("Profesor");
      frame.add(box);
      
      JLabel contraseña = new JLabel("Contraseña");
      contraseña.setBounds(30,180,100,30);
      frame.add(contraseña);
      
      JPasswordField txtcontraseña = new JPasswordField();
      txtcontraseña.setBounds(135,180,200,30);
      frame.add(txtcontraseña);
      
      JLabel confirmar = new JLabel("Confirmar");
      confirmar.setBounds(30,210,100,30);
      frame.add(confirmar);
      
      JPasswordField txtconfirmar = new JPasswordField();
      txtconfirmar.setBounds(135,210,200,30);
      frame.add(txtconfirmar);
      
      JButton btncrear = new JButton("Crear");
      btncrear.setBounds(30,280,100,30);
      frame.add(btncrear);
      
       
      ActionListener escuchador= new ActionListener() {
         
          public void actionPerformed(ActionEvent e) {
              
              
            String id = txtId.getText();
            String nombre = txtnombre.getText();
            String apellido = txtapellido.getText();
            String usuario = txtusuario.getText();
            String rol = (String) box.getSelectedItem();
            String contraseña = txtcontraseña.getText();
            String confirmar = txtconfirmar.getText();
if (id.equals("") || nombre.equals("") || apellido.equals("") || usuario.equals("") || rol.equals("") || contraseña.equals("") || confirmar.equals("")) {
                JOptionPane.showMessageDialog(null, "Campos vacios", "Error", JOptionPane.WARNING_MESSAGE);
            }else{
                String Rol = "2";
                 if (rol.equals("Profesor")) {
                    Rol="3";
                }

    
    if(contraseña.equals(confirmar)){
        JOptionPane.showMessageDialog(null, "Usuario creado Correctamente");
        Usuario usuarioNuevo = new Usuario(id,nombre,apellido,usuario,Rol,contraseña);
        txtId.setText(null);
        txtapellido.setText(null);
        txtnombre.setText(null);
        txtusuario.setText(null);
        txtcontraseña.setText(null);
        txtconfirmar.setText(null);
        System.out.println(usuarioNuevo);
         
        
    }else{
       JOptionPane.showMessageDialog(null, "contraseña de confirmacion no coincide intente de nuevo");
       txtconfirmar.setText(null);
    }
 
          }
          }

      };
      btncrear.addActionListener(escuchador);
      
      
      JButton btncancelar = new JButton("Cancelar");
      btncancelar.setBounds(200,280,100,30);
      frame.add(btncancelar);
      
      ActionListener cs= new ActionListener() {
         
          public void actionPerformed(ActionEvent e) {
              txtId.setText("");
              txtnombre.setText("");
              txtapellido.setText("");
              txtusuario.setText("");
              txtcontraseña.setText("");
              txtconfirmar.setText("");
              admin();
              frame.dispose();
              
          }
      };
      btncancelar.addActionListener(cs);
      frame.setVisible(true);

  }

JTextField txtbuscare,txtapellidoe,txtnombree,txtrole,txtusuarioe;
    

 public void BuscarEli(String id){
        String[] datosBusqueda =Usuario.buscarUsuario(id);
        if (datosBusqueda!= null) {
            txtbuscare.setText(datosBusqueda[0]);
            txtnombree.setText(datosBusqueda[1]);
            txtapellidoe.setText(datosBusqueda[2]);
            txtusuarioe.setText(datosBusqueda[3]);
            if (datosBusqueda[4].equals("3")) {
                txtrole.setText("Profesor");
            }else if(datosBusqueda[4].equals("2")){
                txtrole.setText("Estudiante");
            }else{
                txtrole.setText("Administrador");
            }
          
            
            
        }else{
            JOptionPane.showMessageDialog(null, "Registro inexistente", "Error", JOptionPane.WARNING_MESSAGE);
        }
    }

 public void eliminar(){
      JFrame frame2 = new JFrame();
      frame2.setSize(400,400);
      frame2.setLayout(null);
      frame2.setResizable(false);
      frame2.setLocationRelativeTo(null);
      frame2.setTitle("ELIMINAR USUARIO");
      frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame2.setVisible(true);
      
      JButton btnbuscar = new JButton("BUSCAR");
      btnbuscar.setBounds(30,30,100,30);
      frame2.add(btnbuscar);
      
      ActionListener bu= new ActionListener() {
         
          public void actionPerformed(ActionEvent e) {
               if (txtbuscare.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "Debe ingresar un ID", "Error", JOptionPane.WARNING_MESSAGE);
            } else {
                BuscarEli(txtbuscare.getText());
            }
              
          }
      };
      btnbuscar.addActionListener(bu);
      
      txtbuscare = new JTextField();
      txtbuscare.setBounds(135,30,200,30);
      frame2.add(txtbuscare);
      
        JLabel nombre = new JLabel("Nombre");
      nombre.setBounds(30,60,100,30);
      frame2.add(nombre);
      
      txtnombree = new JTextField();
      txtnombree.setBounds(135,60,200,30);
      txtnombree.setEnabled(false);
      frame2.add(txtnombree);
      
        JLabel apellido = new JLabel("Apellido");
      apellido.setBounds(30,90,100,30);
      frame2.add(apellido);
      
      txtapellidoe = new JTextField();
      txtapellidoe.setBounds(135,90,200,30);
      txtapellidoe.setEnabled(false);
      frame2.add(txtapellidoe);
      
      JLabel usuario = new JLabel("Usuario");
      usuario.setBounds(30,120,100,30);
      frame2.add(usuario);
      
      txtusuarioe = new JTextField();
      txtusuarioe.setBounds(135,120,200,30);
      txtusuarioe.setEnabled(false);
      frame2.add(txtusuarioe);
      
      JLabel rol = new JLabel("Rol");
      rol.setBounds(30,150,100,30);
      frame2.add(rol);
      
      txtrole = new JTextField();
      txtrole.setBounds(135,150,200,30);
      txtrole.setEnabled(false);
      frame2.add(txtrole);
      
      
      JButton btneliminar = new JButton("Eliminar");
      btneliminar.setBounds(30,200,100,30);
      frame2.add(btneliminar);
      
      ActionListener be= new ActionListener() {
         
          public void actionPerformed(ActionEvent e) {
             
               String id = txtbuscare.getText();
            if (id.equals("")){
                JOptionPane.showMessageDialog(null, "Debe buscar la información antes", "Error", JOptionPane.WARNING_MESSAGE);
            }else{
                Usuario.eliminarUsuario(id);
                JOptionPane.showMessageDialog(null, "Usuario Eliminado");
                txtbuscare.setText(null);
                txtnombree.setText(null);
                txtapellidoe.setText(null);
                txtusuarioe.setText(null);
                txtrole.setText(null);
            }
              
          }
      };
      btneliminar.addActionListener(be);
      
      
      
      
      JButton btncancelar = new JButton("Cancelar");
      btncancelar.setBounds(200,200,100,30);
      frame2.add(btncancelar);
      
      ActionListener cu= new ActionListener() {
         
          public void actionPerformed(ActionEvent e) {
             admin();
             frame2.dispose();
          }
      };
      btncancelar.addActionListener(cu);
      
    }
 
 
 
JTextField txtbuscar,txtnombre,txtapellido,txtusuario;
JComboBox box;
JPasswordField txtcontraseña,txtconfirmar;



public void BuscarDatos(String id){
        String[] datosBusqueda =Usuario.buscarUsuario(id);
        if (datosBusqueda!= null) {
            txtbuscar.setText(datosBusqueda[0]);
            txtbuscar.setEnabled(false);

            txtnombre.setText(datosBusqueda[1]);
            txtapellido.setText(datosBusqueda[2]);
            txtusuario.setText(datosBusqueda[3]);
            box.setEnabled(true);
            if (datosBusqueda[4].equals("3")) {
                box.setSelectedIndex(1);
            }else if(datosBusqueda[4].equals("2")) {
                box.setSelectedIndex(0);
            }else{
                box.setEnabled(false);
            }
            txtcontraseña.setText(datosBusqueda[5]);
            txtconfirmar.setText(datosBusqueda[5]);
        }else{
            JOptionPane.showMessageDialog(null, "No existe dato", "Error", JOptionPane.WARNING_MESSAGE);
        }
    }

 public void actualizar(){
      JFrame frame3 = new JFrame();
      frame3.setSize(400,400);
      frame3.setLayout(null);
      frame3.setTitle("MODIFICAR USUARIO");
      frame3.setResizable(false);
      frame3.setLocationRelativeTo(null);
      frame3.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      
      
      txtbuscar = new JTextField();
      txtbuscar.setBounds(135,30,200,30);
      frame3.add(txtbuscar);
      
      JLabel nombre = new JLabel("Nombre");
      nombre.setBounds(30,60,100,30);
      frame3.add(nombre);
      
      txtnombre = new JTextField();
      txtnombre.setBounds(135,60,200,30);
      frame3.add(txtnombre);
      
      JLabel apellido = new JLabel("Apellido");
      apellido.setBounds(30,90,100,30);
      frame3.add(apellido);
      
      txtapellido = new JTextField();
      txtapellido.setBounds(135,90,200,30);
      frame3.add(txtapellido);
      
      JLabel usuario = new JLabel("Usuario");
      usuario.setBounds(30,120,100,30);
      frame3.add(usuario);
      
      txtusuario = new JTextField();
      txtusuario.setBounds(135,120,200,30);
      frame3.add(txtusuario);
      
      JLabel rol = new JLabel("Rol");
      rol.setBounds(30,150,100,30);
      frame3.add(rol);
      
      box = new JComboBox();
      box.setBounds(135,150,100,30);
      box.addItem("Estudiante");
      box.addItem("Profesor");
      frame3.add(box);
      
      JLabel contraseña = new JLabel("Contraseña");
      contraseña.setBounds(30,180,100,30);
      frame3.add(contraseña);
      
      txtcontraseña = new JPasswordField();
      txtcontraseña.setBounds(135,180,200,30);
      frame3.add(txtcontraseña);
      
      JLabel confirmar = new JLabel("Confirmar");
      confirmar.setBounds(30,210,100,30);  
      frame3.add(confirmar);
      
      txtconfirmar = new JPasswordField();
      txtconfirmar.setBounds(135,210,200,30);
      frame3.add(txtconfirmar);
      
      
      JButton btnactualizar = new JButton("Guardar");
      btnactualizar.setBounds(30,280,100,30);
      frame3.add(btnactualizar);
      
       ActionListener g= new ActionListener() {
         
          public void actionPerformed(ActionEvent e) {
              
            String id = txtbuscar.getText();
            String nombre = txtnombre.getText();
            String apellido = txtapellido.getText();
            String usuario = txtusuario.getText();
            String rol = (String) box.getSelectedItem();
            String contraseña = txtcontraseña.getText();
            String confirmar = txtconfirmar.getText();
            
            if (id.equals("") || nombre.equals("") || apellido.equals("") || usuario.equals("") || rol.equals("") || contraseña.equals("") || confirmar.equals("")) {
                JOptionPane.showMessageDialog(null, "Campos vacios", "Error", JOptionPane.WARNING_MESSAGE);
            }else{
                String Rol = "2";
                 if (rol.equals("Profesor")) {
                    Rol="3";
                }
            
            
            
            if (contraseña.equals(confirmar)) {

                    if (Usuario.actualizarUsuario(id,nombre,apellido,usuario,Rol,contraseña)) {
                        JOptionPane.showMessageDialog(null, "Usuario actualizado");
                        txtbuscar.setEnabled(true);
                        txtnombre.setText(null);
                        txtapellido.setText(null);
                        txtusuario.setText(null);
                        txtcontraseña.setText(null);
                        txtconfirmar.setText(null);
                        txtbuscar.setText(null);
                    }
                }else{
                    JOptionPane.showMessageDialog(null, "Contraseñas distintas", "Error", JOptionPane.WARNING_MESSAGE);
                }
            
          }
          }
      };
      btnactualizar.addActionListener(g);
      
      
      JButton btncancelar = new JButton("Cancelar");
      btncancelar.setBounds(200,280,100,30);
      frame3.add(btncancelar);
      frame3.setVisible(true);
      
       ActionListener cu= new ActionListener() {
         
          public void actionPerformed(ActionEvent e) {
             admin();
             frame3.dispose();
          }
      };
      btncancelar.addActionListener(cu);
      
      
      
      
       JButton btnbuscar = new JButton("BUSCAR");
      btnbuscar.setBounds(30,30,100,30);
      frame3.add(btnbuscar);
      
      ActionListener b= new ActionListener() { 
          
          public void actionPerformed(ActionEvent e) {
             if (txtbuscar.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "no hay Id para buscar", "Error", JOptionPane.WARNING_MESSAGE);
            } else {
                BuscarDatos(txtbuscar.getText());
            }
          }
      };
      btnbuscar.addActionListener(b);
      
    }
 

 public void mostrar(){
     JFrame frame4=new JFrame("Mostrar Usuarios"); 
     frame4.setLayout(null);
     frame4.setResizable(false);
     frame4.setSize(1200,600);
     frame4.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
     frame4.setLocationRelativeTo(null);
     
     JButton btnRegresar = new JButton("Regresar");
     btnRegresar.setBounds(500,350,100,30);
     frame4.add(btnRegresar);
     
      ActionListener REG= new ActionListener() { 
          
          public void actionPerformed(ActionEvent e) {
             frame4.dispose();
             admin();
          }
      };
      btnRegresar.addActionListener(REG);
     
     DefaultTableModel mtabla = new DefaultTableModel(); 
     
     mtabla.addColumn("Id");
     mtabla.addColumn("Nombre");
     mtabla.addColumn("Apellido");
     mtabla.addColumn("Usuario");
     mtabla.addColumn("Rol");
     mtabla.addColumn("Contraseña");
    
     
     JTable tabla1 = new JTable();
     tabla1.setEnabled(false);
     tabla1.setBorder(new LineBorder(Color.blue));
     for (String[] dato: Usuario.datosUsuario()) {
            String tipoRol = "Administrador";
            if (dato[4].equals("2")) {
                tipoRol = "Estudiante";
            }else if (dato[4].equals("3")) {
                tipoRol = "Profesor";
            }
            mtabla.addRow(new Object[]{dato[0],dato[1], dato[2], dato[3],tipoRol,dato[5]});
        }
     JScrollPane scroll= new JScrollPane(tabla1);
     scroll.setBounds(0,0,1200,300);
     tabla1.setModel(mtabla);
     frame4.add(scroll);
     
     
     frame4.setVisible(true);
     
     
 }


 
   void cargaindividual(){
        JFrame ci = new JFrame("carga Individual");
        ci.setSize(800,500);
        ci.setLocationRelativeTo(null);
        ci.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ci.setLayout(null);
      
      JLabel tipo= new JLabel();
      tipo.setText("Tipo");
      tipo.setBounds(30,30,100,30);
      ci.add(tipo);
      
      JComboBox boxt = new JComboBox();
      boxt.setBounds(135,30,100,30);
      boxt.addItem("Libro");
      boxt.addItem("Revista");
      boxt.addItem("Tesis");
      ci.add(boxt);
      
     
      
      JLabel autor = new JLabel("Autor");
      autor.setBounds(30,60,100,30);
      ci.add(autor);
      
      JTextField txtautor = new JTextField();
      txtautor.setBounds(135,60,200,30);
      ci.add(txtautor);
      
      JLabel ti = new JLabel("Titulo");
      ti.setBounds(30,90,100,30);
      ci.add(ti);
      
      JTextField txttitulo = new JTextField();
      txttitulo.setBounds(135,90,200,30);
      ci.add(txttitulo);
      
      JLabel edi = new JLabel("Edicion");
      edi.setBounds(30,120,100,30);
      ci.add(edi);
      
      JTextField txtedicion = new JTextField();
      txtedicion.setBounds(135,120,200,30);
      ci.add(txtedicion);
      
      JLabel des = new JLabel("Descripcion");
      des.setBounds(30,150,100,30);
      ci.add(des);
      
      JTextField txtdescripcion = new JTextField();
      txtdescripcion.setBounds(135,150,200,30);
      ci.add(txtdescripcion);
      
      JLabel tem = new JLabel("Temas");
      tem.setBounds(30,180,100,30);
      ci.add(tem);
      
      JTextField txttemas = new JTextField();
      txttemas.setBounds(135,180,200,30);
      ci.add(txttemas);
      
      JLabel fr = new JLabel("Frecuencia");
      fr.setBounds(425,60,100,30);
      ci.add(fr);
      
      JTextField txtfrecuencia = new JTextField();
      txtfrecuencia.setBounds(500,60,200,30);
      ci.add(txtfrecuencia);
      
      JLabel ej = new JLabel("Ejemplares");
      ej.setBounds(425,90,100,30);
      ci.add(ej);
      
      JTextField txtejemplares = new JTextField();
      txtejemplares.setBounds(500,90,200,30);
      ci.add(txtejemplares);
      
      JLabel cop = new JLabel("Copias");
      cop.setBounds(425,150,100,30);
      ci.add(cop);
      
      JTextField txtcopias = new JTextField();
      txtcopias.setBounds(500,150,200,30);
      ci.add(txtcopias);
      
      JLabel ar = new JLabel("Area");
      ar.setBounds(425,120,100,30);
      ci.add(ar);
      
      JTextField txtarea = new JTextField();
      txtarea.setBounds(500,120,200,30);
      ci.add(txtarea);
      
      JLabel dis = new JLabel("Disponibles");
      dis.setBounds(425,180,100,30);
      ci.add(dis);
      
      JTextField txtdisponibles = new JTextField();
      txtdisponibles.setBounds(500,180,200,30);
      ci.add(txtdisponibles);
      
      JButton btncr= new JButton("Crear");
      btncr.setBounds(225,270,100,30);
      ci.add(btncr);
      
               txtarea.setEnabled(false);
               txtfrecuencia.setEnabled(false);
               txtejemplares.setEnabled(false);
      
       ActionListener ev= new ActionListener() { 
          
          public void actionPerformed(ActionEvent e) {
           int a = boxt.getSelectedIndex();
           System.out.println(a);
           
           if(a==0){
               txtautor.setEnabled(true);
               txttitulo.setEnabled(true);
               txtedicion.setEnabled(true);
               txtdescripcion.setEnabled(true);
               txttemas.setEnabled(true);
               txtfrecuencia.setEnabled(true);
               txtcopias.setEnabled(true);
               txtarea.setEnabled(false);
               txtfrecuencia.setEnabled(false);
               txtejemplares.setEnabled(false);
               
               
               txtautor.setText(null);
               txttitulo.setText(null);
               txtedicion.setText(null);
               txtdescripcion.setText(null);
               txttemas.setText(null);
               txtfrecuencia.setText(null);
               txtcopias.setText(null);
               txtarea.setText(null);
               txtfrecuencia.setText(null);
               txtejemplares.setText(null);
           }
           if(a==1){
               txtautor.setEnabled(true);
               txttitulo.setEnabled(true);
               txtedicion.setEnabled(true);
               txtdescripcion.setEnabled(true);
               txttemas.setEnabled(true);
               txtfrecuencia.setEnabled(true);
               txtcopias.setEnabled(true);
               txtarea.setEnabled(false);
               txtfrecuencia.setEnabled(true);
               txtejemplares.setEnabled(true);
               
               txtautor.setText(null);
               txttitulo.setText(null);
               txtedicion.setText(null);
               txtdescripcion.setText(null);
               txttemas.setText(null);
               txtfrecuencia.setText(null);
               txtcopias.setText(null);
               txtarea.setText(null);
               txtfrecuencia.setText(null);
               txtejemplares.setText(null);
           }if(a==2){
               txtautor.setEnabled(true);
               txttitulo.setEnabled(true);
               txtedicion.setEnabled(true);
               txtdescripcion.setEnabled(true);
               txttemas.setEnabled(true);
               txtfrecuencia.setEnabled(true);
               txtcopias.setEnabled(true);
               txtarea.setEnabled(true);
               txtfrecuencia.setEnabled(false);
               txtejemplares.setEnabled(false);
               
               txtautor.setText(null);
               txttitulo.setText(null);
               txtedicion.setText(null);
               txtdescripcion.setText(null);
               txttemas.setText(null);
               txtfrecuencia.setText(null);
               txtcopias.setText(null);
               txtarea.setText(null);
               txtfrecuencia.setText(null);
               txtejemplares.setText(null);
           }
          }
      };
      boxt.addActionListener(ev);
      
   
      ActionListener btncre= new ActionListener() { 
          
          public void actionPerformed(ActionEvent e) {
           
            String tipo = String.valueOf(boxt.getSelectedIndex());
            String autor = txtautor.getText();
            String titulo = txttitulo.getText();
            String edicion = txtedicion.getText();
            String descripcion = txtdescripcion.getText();
            String temas = txttemas.getText();
            String frecuencia = txtfrecuencia.getText();
            String ejemplares = txtejemplares.getText();
            String area = txtarea.getText();
            String copias = txtcopias.getText();
            String disponibles = txtdisponibles.getText();
              
            if (titulo.equals("") || disponibles.equals("") ) {
                JOptionPane.showMessageDialog(null, "rellene los datos requeridos", "Error", JOptionPane.ERROR_MESSAGE);
            }else{

                String[] temas1 = temas.split(",");
                Bibliografia bibliografia = new Bibliografia(tipo, autor, titulo, descripcion,edicion,temas1,frecuencia,ejemplares,area,copias,disponibles);

                if(bibliografia.crearBibliografiaIndividual()){
                    JOptionPane.showMessageDialog(null, "Bibliografia creada correctamente", "Aviso", JOptionPane.INFORMATION_MESSAGE);
                txtautor.setText(null);
               txttitulo.setText(null);
               txtedicion.setText(null);
               txtdescripcion.setText(null);
               txttemas.setText(null);
               txtfrecuencia.setText(null);
               txtcopias.setText(null);
               txtarea.setText(null);
               txtdisponibles.setText(null);
               txtejemplares.setText(null);
                System.out.println(bibliografia);//comprobaciones en consola
                }
            }
            
           
            
          }
      };
      btncr.addActionListener(btncre);
      
      JButton btncan= new JButton("Cancelar");
      btncan.setBounds(400,270,100,30);
      ci.add(btncan);
      
     
      
       ActionListener btnc= new ActionListener() { 
          
          public void actionPerformed(ActionEvent e) {
             ci.dispose();
             admin();
          }
      };
      btncan.addActionListener(btnc);
      
      ci.setVisible(true);
    }
   
   
   void actualizarbibliografia(){
        JFrame ab = new JFrame("Actualizar Bibliografia");
        ab.setSize(800,500);
        ab.setLocationRelativeTo(null);
        ab.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ab.setLayout(null);
      
      JLabel tipo= new JLabel();
      tipo.setText("Tipo");
      tipo.setBounds(30,30,100,30);
      ab.add(tipo);
      
      JComboBox boxt = new JComboBox();
      boxt.setBounds(135,30,100,30);
      boxt.addItem("Libro");
      boxt.addItem("Revista");
      boxt.addItem("Tesis");
      ab.add(boxt);
      
     
      
      JLabel autor = new JLabel("Autor");
      autor.setBounds(30,60,100,30);
      ab.add(autor);
      
      JTextField txtautor = new JTextField();
      txtautor.setBounds(135,60,200,30);
      ab.add(txtautor);
      
      JLabel ti = new JLabel("Titulo");
      ti.setBounds(30,90,100,30);
      ab.add(ti);
      
      JTextField txttitulo = new JTextField();
      txttitulo.setBounds(135,90,200,30);
      ab.add(txttitulo);
      
      JLabel edi = new JLabel("Edicion");
      edi.setBounds(30,120,100,30);
      ab.add(edi);
      
      JTextField txtedicion = new JTextField();
      txtedicion.setBounds(135,120,200,30);
      ab.add(txtedicion);
      
      JLabel des = new JLabel("Descripcion");
      des.setBounds(30,150,100,30);
      ab.add(des);
      
      JTextField txtdescripcion = new JTextField();
      txtdescripcion.setBounds(135,150,200,30);
      ab.add(txtdescripcion);
      
      JLabel tem = new JLabel("Temas");
      tem.setBounds(30,180,100,30);
      ab.add(tem);
      
      JTextField txttemas = new JTextField();
      txttemas.setBounds(135,180,200,30);
      ab.add(txttemas);
      
      JLabel fr = new JLabel("Frecuencia");
      fr.setBounds(425,60,100,30);
      ab.add(fr);
      
      JTextField txtfrecuencia = new JTextField();
      txtfrecuencia.setBounds(500,60,200,30);
      ab.add(txtfrecuencia);
      
      JLabel ej = new JLabel("Ejemplares");
      ej.setBounds(425,90,100,30);
      ab.add(ej);
      
      JTextField txtejemplares = new JTextField();
      txtejemplares.setBounds(500,90,200,30);
      ab.add(txtejemplares);
      
      JLabel cop = new JLabel("Copias");
      cop.setBounds(425,150,100,30);
      ab.add(cop);
      
      JTextField txtcopias = new JTextField();
      txtcopias.setBounds(500,150,200,30);
      ab.add(txtcopias);
      
      JLabel ar = new JLabel("Area");
      ar.setBounds(425,120,100,30);
      ab.add(ar);
      
      JTextField txtarea = new JTextField();
      txtarea.setBounds(500,120,200,30);
      ab.add(txtarea);
      
      JLabel dis = new JLabel("Disponibles");
      dis.setBounds(425,180,100,30);
      ab.add(dis);
      
      JTextField txtdisponibles = new JTextField();
      txtdisponibles.setBounds(500,180,200,30);
      ab.add(txtdisponibles);
      
      JButton btncr= new JButton("Actualizar");
      btncr.setBounds(225,270,100,30);
      ab.add(btncr);
       
      JButton btncan= new JButton("Cancelar");
      btncan.setBounds(400,270,100,30);
      ab.add(btncan);
      
      JButton btbuscar= new JButton("Buscar");
      btbuscar.setBounds(400,30,100,30);
      ab.add(btbuscar);
      
      JTextField txtbu = new JTextField();
      txtbu.setBounds(500,30,100,30);
      ab.add(txtbu);
      
      
      ActionListener btncre= new ActionListener() { 
          
          public void actionPerformed(ActionEvent e) {
            //campos
            String tipo = String.valueOf(boxt.getSelectedIndex());
            String autor = txtautor.getText();
            String titulo = txttitulo.getText();
            String edicion = txtedicion.getText();
            String descripcion = txtdescripcion.getText();
            String temas = txttemas.getText();
            String frecuencia = txtfrecuencia.getText();
            String ejemplares = txtejemplares.getText();
            String area = txtarea.getText();
            String copias = txtcopias.getText();
            String disponibles = txtdisponibles.getText();

            if (titulo.equals("") || disponibles.equals("") ) {
                JOptionPane.showMessageDialog(null, "No deje el titulo ni los disponibles vacio", "Error", JOptionPane.WARNING_MESSAGE);
            }else{

                String[] temasFormateados = temas.split(",");
                Bibliografia.actualizarBibliografia(tipo, autor, titulo, edicion, descripcion,temasFormateados,frecuencia,ejemplares,area,copias,disponibles);
                if(Bibliografia.actualizarBibliografia(tipo, autor, titulo, edicion, descripcion,temasFormateados,frecuencia,ejemplares,area,copias,disponibles)){
                    JOptionPane.showMessageDialog(null, "Bibliografia Actualizada", "Aviso", JOptionPane.INFORMATION_MESSAGE);
               txtbu.setText(null);
               txtautor.setText(null);
               txttitulo.setText(null);
               txtedicion.setText(null);
               txtdescripcion.setText(null);
               txttemas.setText(null);
               txtfrecuencia.setText(null);
               txtcopias.setText(null);
               txtarea.setText(null);
               txtdisponibles.setText(null);
               txtejemplares.setText(null);
                }else{
                    JOptionPane.showMessageDialog(null, "no se pudo modificar", "Error", JOptionPane.WARNING_MESSAGE);
                }
            }
          }
      };
      btncr.addActionListener(btncre);
      
          ActionListener vu= new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                 String[] datosBusqueda = Bibliografia.buscarBibliografia(txtbu.getText());

            if (datosBusqueda != null) {

                boxt.setSelectedIndex(Integer.parseInt(datosBusqueda[0].replace(" ","")));
                txtautor.setText(datosBusqueda[1]);
                txttitulo.setText(datosBusqueda[2]);
                txtedicion.setText(datosBusqueda[3]);
                txtdescripcion.setText(datosBusqueda[4]);
                txttemas.setText(datosBusqueda[5]);
                txtfrecuencia.setText(datosBusqueda[6]);
                txtejemplares.setText(datosBusqueda[7]);
                txtarea.setText(datosBusqueda[8]);
                txtcopias.setText(datosBusqueda[9]);
                txtdisponibles.setText(datosBusqueda[10]);

            }else{
                JOptionPane.showMessageDialog(null, "No existe registro", "Error", JOptionPane.ERROR_MESSAGE);
            }

            }
          
      };
      btbuscar.addActionListener(vu);
      
      
      
               txttitulo.setEnabled(false);
               txtarea.setEnabled(false);
               txtfrecuencia.setEnabled(false);
               txtejemplares.setEnabled(false);
      
       ActionListener ev= new ActionListener() { 
          
          public void actionPerformed(ActionEvent e) {
           int a = boxt.getSelectedIndex();
           System.out.println(a);
           
           if(a==0){
               txtautor.setEnabled(true);
               txttitulo.setEnabled(false);
               txtedicion.setEnabled(true);
               txtdescripcion.setEnabled(true);
               txttemas.setEnabled(true);
               txtfrecuencia.setEnabled(true);
               txtcopias.setEnabled(true);
               txtarea.setEnabled(false);
               txtfrecuencia.setEnabled(false);
               txtejemplares.setEnabled(false);
               
               
               txtautor.setText(null);
               txttitulo.setText(null);
               txtedicion.setText(null);
               txtdescripcion.setText(null);
               txttemas.setText(null);
               txtfrecuencia.setText(null);
               txtcopias.setText(null);
               txtarea.setText(null);
               txtfrecuencia.setText(null);
               txtejemplares.setText(null);
           }
           if(a==1){
               txtautor.setEnabled(true);
               txttitulo.setEnabled(false);
               txtedicion.setEnabled(true);
               txtdescripcion.setEnabled(true);
               txttemas.setEnabled(true);
               txtfrecuencia.setEnabled(true);
               txtcopias.setEnabled(true);
               txtarea.setEnabled(false);
               txtfrecuencia.setEnabled(true);
               txtejemplares.setEnabled(true);
               
               txtautor.setText(null);
               txttitulo.setText(null);
               txtedicion.setText(null);
               txtdescripcion.setText(null);
               txttemas.setText(null);
               txtfrecuencia.setText(null);
               txtcopias.setText(null);
               txtarea.setText(null);
               txtfrecuencia.setText(null);
               txtejemplares.setText(null);
           }if(a==2){
               txtautor.setEnabled(true);
               txttitulo.setEnabled(false);
               txtedicion.setEnabled(true);
               txtdescripcion.setEnabled(true);
               txttemas.setEnabled(true);
               txtfrecuencia.setEnabled(true);
               txtcopias.setEnabled(true);
               txtarea.setEnabled(true);
               txtfrecuencia.setEnabled(false);
               txtejemplares.setEnabled(false);
               
               txtautor.setText(null);
               txttitulo.setText(null);
               txtedicion.setText(null);
               txtdescripcion.setText(null);
               txttemas.setText(null);
               txtfrecuencia.setText(null);
               txtcopias.setText(null);
               txtarea.setText(null);
               txtfrecuencia.setText(null);
               txtejemplares.setText(null);
           }
          }
      };
      boxt.addActionListener(ev);
      
      
       ActionListener btnc= new ActionListener() { 
          
          public void actionPerformed(ActionEvent e) {
             ab.dispose();
             admin();
          }
      };
      btncan.addActionListener(btnc);
      ab.setVisible(true);
   }
   
   
    void cargamasiva(){
     JFrame framer=new JFrame("Carga Masiva"); 
     framer.setLayout(null);
     framer.setResizable(false);
     framer.setSize(1225,600);
     framer.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
     framer.setLocationRelativeTo(null);
     
     
     JButton btnRegresar = new JButton("Regresar");
     btnRegresar.setBounds(450,500,100,30);
     framer.add(btnRegresar);
     
     JButton btnc = new JButton("Subir");
     btnc.setBounds(600,500,100,30);
     framer.add(btnc);
     
     TextArea repu =new TextArea();
  
     
     JScrollPane scroll= new JScrollPane(repu);
     scroll.setBounds(0,0,1200,500);
     framer.add(scroll);
    
      ActionListener s= new ActionListener() { 
          
          public void actionPerformed(ActionEvent e) {
               if (Bibliografia.crearBibliografiaMasiva(repu.getText())){
                JOptionPane.showMessageDialog(null, "Bibliografia creada", "Aviso",JOptionPane.INFORMATION_MESSAGE);
                repu.setText(null);

            }else{
                JOptionPane.showMessageDialog(null, "Formato de ingreso incorrecto", "Error",JOptionPane.ERROR_MESSAGE);
            }
          }
      };
      btnc.addActionListener(s);
    
     
      ActionListener REG= new ActionListener() { 
          
          public void actionPerformed(ActionEvent e) {
             framer.dispose();
             admin();
          }
      };
      btnRegresar.addActionListener(REG);
      
      
      framer.setVisible(true);   
    }
 
 
    
    void eliminarbiblio(){
        JFrame ab = new JFrame("Eliminar Bibliografia");
        ab.setSize(800,500);
        ab.setLocationRelativeTo(null);
        ab.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ab.setLayout(null);
      
      JLabel tipo= new JLabel();
      tipo.setText("Tipo");
      tipo.setBounds(30,30,100,30);
      ab.add(tipo);
      
      JComboBox boxt = new JComboBox();
      boxt.setBounds(135,30,100,30);
      boxt.addItem("Libro");
      boxt.addItem("Revista");
      boxt.addItem("Tesis");
      ab.add(boxt);
      
     
      
      JLabel autor = new JLabel("Autor");
      autor.setBounds(30,60,100,30);
      ab.add(autor);
      
      JTextField txtautor = new JTextField();
      txtautor.setBounds(135,60,200,30);
      ab.add(txtautor);
      
      JLabel ti = new JLabel("Titulo");
      ti.setBounds(30,90,100,30);
      ab.add(ti);
      
      JTextField txttitulo = new JTextField();
      txttitulo.setBounds(135,90,200,30);
      ab.add(txttitulo);
      
      JLabel edi = new JLabel("Edicion");
      edi.setBounds(30,120,100,30);
      ab.add(edi);
      
      JTextField txtedicion = new JTextField();
      txtedicion.setBounds(135,120,200,30);
      ab.add(txtedicion);
      
      JLabel des = new JLabel("Descripcion");
      des.setBounds(30,150,100,30);
      ab.add(des);
      
      JTextField txtdescripcion = new JTextField();
      txtdescripcion.setBounds(135,150,200,30);
      ab.add(txtdescripcion);
      
      JLabel tem = new JLabel("Temas");
      tem.setBounds(30,180,100,30);
      ab.add(tem);
      
      JTextField txttemas = new JTextField();
      txttemas.setBounds(135,180,200,30);
      ab.add(txttemas);
      
      JLabel fr = new JLabel("Frecuencia");
      fr.setBounds(425,60,100,30);
      ab.add(fr);
      
      JTextField txtfrecuencia = new JTextField();
      txtfrecuencia.setBounds(500,60,200,30);
      ab.add(txtfrecuencia);
      
      JLabel ej = new JLabel("Ejemplares");
      ej.setBounds(425,90,100,30);
      ab.add(ej);
      
      JTextField txtejemplares = new JTextField();
      txtejemplares.setBounds(500,90,200,30);
      ab.add(txtejemplares);
      
      JLabel cop = new JLabel("Copias");
      cop.setBounds(425,150,100,30);
      ab.add(cop);
      
      JTextField txtcopias = new JTextField();
      txtcopias.setBounds(500,150,200,30);
      ab.add(txtcopias);
      
      JLabel ar = new JLabel("Area");
      ar.setBounds(425,120,100,30);
      ab.add(ar);
      
      JTextField txtarea = new JTextField();
      txtarea.setBounds(500,120,200,30);
      ab.add(txtarea);
      
      JLabel dis = new JLabel("Disponibles");
      dis.setBounds(425,180,100,30);
      ab.add(dis);
      
      JTextField txtdisponibles = new JTextField();
      txtdisponibles.setBounds(500,180,200,30);
      ab.add(txtdisponibles);
      
      JButton btncr= new JButton("Eliminar");
      btncr.setBounds(225,270,100,30);
      ab.add(btncr);
       
      JButton btncan= new JButton("Cancelar");
      btncan.setBounds(400,270,100,30);
      ab.add(btncan);
      
      JButton btbuscar= new JButton("Buscar");
      btbuscar.setBounds(400,30,100,30);
      ab.add(btbuscar);
      
      JTextField txtbu = new JTextField();
      txtbu.setBounds(500,30,100,30);
      ab.add(txtbu);
               
               boxt.setEnabled(false);
               txtautor.setEnabled(false);
               txttitulo.setEnabled(false);
               txtedicion.setEnabled(false);
               txtdescripcion.setEnabled(false);
               txttemas.setEnabled(false);
               txtfrecuencia.setEnabled(false);
               txtcopias.setEnabled(false);
               txtarea.setEnabled(false);
               txtdisponibles.setEnabled(false);
               txtejemplares.setEnabled(false);
      
          ActionListener btnel= new ActionListener() { 
          
          public void actionPerformed(ActionEvent e) {
            String titulo = txttitulo.getText();
            Bibliografia.eliminarBibliografia(titulo);
            JOptionPane.showMessageDialog(null, "Bibliografia eliminada", "Aviso", JOptionPane.INFORMATION_MESSAGE);
               txtbu.setText(null);
               txtautor.setText(null);
               txttitulo.setText(null);
               txtedicion.setText(null);
               txtdescripcion.setText(null);
               txttemas.setText(null);
               txtfrecuencia.setText(null);
               txtcopias.setText(null);
               txtarea.setText(null);
               txtdisponibles.setText(null);
               txtejemplares.setText(null);
          }
      };
      btncr.addActionListener(btnel);
               
               
         ActionListener btnb= new ActionListener() { 
          
          public void actionPerformed(ActionEvent e) {
           
                 String[] datosBusqueda = Bibliografia.buscarBibliografia(txtbu.getText());

            if (datosBusqueda != null) {
                boxt.setSelectedIndex(Integer.parseInt(datosBusqueda[0].replace(" ","")));
                txtautor.setText(datosBusqueda[1]);
                txttitulo.setText(datosBusqueda[2]);
                txtedicion.setText(datosBusqueda[3]);
                txtdescripcion.setText(datosBusqueda[4]);
                txttemas.setText(datosBusqueda[5]);
                txtfrecuencia.setText(datosBusqueda[6]);
                txtejemplares.setText(datosBusqueda[7]);
                txtarea.setText(datosBusqueda[8]);
                txtcopias.setText(datosBusqueda[9]);
                txtdisponibles.setText(datosBusqueda[10]);

            }else{
                JOptionPane.showMessageDialog(null, "No existe registro", "Aviso", JOptionPane.WARNING_MESSAGE);
               
            }

              
          }
      };
      btbuscar.addActionListener(btnb);       
               
               
          ActionListener btnc= new ActionListener() { 
          
          public void actionPerformed(ActionEvent e) {
             ab.dispose();
             admin();
          }
      };
      btncan.addActionListener(btnc);
               
               
               
               
      ab.setVisible(true);
    }
 
     void mostrarbibliografias(){
     JFrame framem=new JFrame("Mostrar Bibliografias"); 
     framem.setLayout(null);
     framem.setResizable(false);
     framem.setSize(1225,600);
     framem.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
     framem.setLocationRelativeTo(null);
     
     JButton btnRegresar = new JButton("Regresar");
     btnRegresar.setBounds(500,350,100,30);
     framem.add(btnRegresar);
     
      ActionListener REG= new ActionListener() { 
          
          public void actionPerformed(ActionEvent e) {
             framem.dispose();
             admin();
            
          }
      };
      btnRegresar.addActionListener(REG);
     
     DefaultTableModel mtabla = new DefaultTableModel(); 
     
     mtabla.addColumn("Tipo");
     mtabla.addColumn("Autor");
     mtabla.addColumn("Titulo");
     mtabla.addColumn("Edicion");
     mtabla.addColumn("Descripcion");
     mtabla.addColumn("Temas");
     mtabla.addColumn("Frecuencia");
     mtabla.addColumn("Ejemplares");
     mtabla.addColumn("Area");
     mtabla.addColumn("Copias");
     mtabla.addColumn("Disponibles");
    
     
     JTable tabla1 = new JTable();
     tabla1.setEnabled(false);
     tabla1.setBorder(new LineBorder(Color.red));
     if (Bibliografia.datosBibiliografia()[0][0]!=null) {
            for (String[] dato : Bibliografia.datosBibiliografia()) {
                String tipo = "";
                if (dato[0].equals("0")) {
                    tipo = "Libro";
                } else if (dato[0].equals("1")) {
                    tipo = "Revista";
                } else if (dato[0].equals("2")) {
                    tipo = "Tesis";
                }
                mtabla.addRow(new Object[]{tipo, dato[1], dato[2], dato[3], dato[4], dato[5], dato[6], dato[7], dato[8], dato[9], dato[10]});
            }
        }
     JScrollPane scroll= new JScrollPane(tabla1);
     scroll.setBounds(0,0,1200,300);
     tabla1.setModel(mtabla);
     framem.add(scroll);
     
     
     framem.setVisible(true);
        }
        
        
     void reporteusu(){
     JFrame framer=new JFrame("Reporte usuarios"); 
     framer.setLayout(null);
     framer.setResizable(false);
     framer.setSize(1225,600);
     framer.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
     framer.setLocationRelativeTo(null);
     
     
     JButton btnRegresar = new JButton("Regresar");
     btnRegresar.setBounds(525,500,100,30);
     framer.add(btnRegresar);
     
     TextArea repu =new TextArea();
     repo reporte = new repo();
     
     repu.setText(reporte.reporteUsuarios());
     
     JScrollPane scroll= new JScrollPane(repu);
     scroll.setBounds(0,0,1200,500);
     framer.add(scroll);
   
     
      ActionListener REG= new ActionListener() { 
          
          public void actionPerformed(ActionEvent e) {
             framer.dispose();
             admin();
          }
      };
      btnRegresar.addActionListener(REG);
      
      
      framer.setVisible(true);   
        }
      
     void reportebiblio(){
     JFrame framer=new JFrame("Reporte Bibliografias"); 
     framer.setLayout(null);
     framer.setResizable(false);
     framer.setSize(1225,600);
     framer.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
     framer.setLocationRelativeTo(null);
     
     JButton btnRegresar = new JButton("Regresar");
     btnRegresar.setBounds(525,500,100,30);
     framer.add(btnRegresar);
     
     TextArea repu =new TextArea();
     repo reporte = new repo();
     
     repu.setText(reporte.reporteBibliografias());
     
     JScrollPane scroll= new JScrollPane(repu);
     scroll.setBounds(0,0,1200,500);
     framer.add(scroll);
             
      ActionListener REG= new ActionListener() { 
          
          public void actionPerformed(ActionEvent e) {
             framer.dispose();
             admin();
          }
      };
      btnRegresar.addActionListener(REG);
      
      
      framer.setVisible(true);   
        }
     
     
     void reporteprest(){
     JFrame framer=new JFrame("Reporte Prestamos"); 
     framer.setLayout(null);
     framer.setResizable(false);
     framer.setSize(1225,600);
     framer.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
     framer.setLocationRelativeTo(null);
     
     JButton btnRegresar = new JButton("Regresar");
     btnRegresar.setBounds(525,500,100,30);
     framer.add(btnRegresar);
     
     TextArea repu =new TextArea();
     repo reporte = new repo();
     
     repu.setText(reporte.reportePrestamos());
     
     JScrollPane scroll= new JScrollPane(repu);
     scroll.setBounds(0,0,1200,500);
     framer.add(scroll);
             
      ActionListener REG= new ActionListener() { 
          
          public void actionPerformed(ActionEvent e) {
             framer.dispose();
             admin();
          }
      };
      btnRegresar.addActionListener(REG);
      
      
      framer.setVisible(true);   
     }
        
     void prestamos(){
         
     }
     
     
    }
    
    
    
    

