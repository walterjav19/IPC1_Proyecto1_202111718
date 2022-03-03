
package com.mycompany.proyecto1.ipc1;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.HashMap;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
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
    
    
    
    HashMap<String,String> logininfo = new HashMap<String,String>();
	
	formularios(){
		
		logininfo.put("admin","password");
                
		
	}
	
	public HashMap getLoginInfo(){
		return logininfo;
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
               
               if(logininfo.containsKey(usu)) {
				if(logininfo.get(usu).equals(password)) {
					
					JOptionPane.showMessageDialog(null, "Credenciales Validas");
                                        admin();
                                        login.dispose();
				}
				else {
					
	                       JOptionPane.showMessageDialog(null,"Credenciales Invalidas, por favor intente nuevamente");

				}

			}
			else {
		        JOptionPane.showMessageDialog(null,"El usuario no existe por favor pongase en contacto con el"
                                + "administrador del sistema para efectuar su registro");
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
        
        JButton biblio= new JButton("Bibliografias");
        biblio.setBackground(new Color(64,207,255));
        biblio.setForeground(new Color(255,255,255));
        biblio.setBorderPainted(false);
        biblio.setBounds(140,40,110,30);
        reportes.add(biblio);
        
        
        JButton pre= new JButton("Prestamos");
        pre.setBackground(new Color(64,207,255));
        pre.setForeground(new Color(255,255,255));
        pre.setBorderPainted(false);
        pre.setBounds(260,40,110,30);
        reportes.add(pre);
        
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
        
        JButton btnverb = new JButton("Ver");
        btnverb.setBackground(new Color(64,207,255));
        btnverb.setForeground(new Color(255,255,255));
        btnverb.setBorderPainted(false);
        btnverb.setBounds(200, 40, 90, 30);
        bli.add(btnverb);
        
        JButton btnmodificarb = new JButton("Modificar");
        btnmodificarb.setBackground(new Color(64,207,255));
        btnmodificarb.setForeground(new Color(255,255,255));
        btnmodificarb.setBorderPainted(false);
        btnmodificarb.setBounds(60, 130, 90, 30);
        bli.add(btnmodificarb);
        
        JButton btnelimarb = new JButton("Eliminar");
        btnelimarb.setBackground(new Color(64,207,255));
        btnelimarb.setForeground(new Color(255,255,255));
        btnelimarb.setBorderPainted(false);
        btnelimarb.setBounds(200, 130, 90, 30);
        bli.add(btnelimarb);
        
       
        
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
       JOptionPane.showMessageDialog(null, "contraseñas no coinciden");
       txtcontraseña.setText(null);
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



public void cargarDatos(String id){
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
            }
            
            
            if (contraseña.equals(confirmar)) {

                    if (Usuario.actualizarUsuario(id,nombre,apellido,usuario,rol,contraseña)) {
                        JOptionPane.showMessageDialog(null, "Usuario actualizado");
                        txtbuscar.setEnabled(true);
                        
                    }
                }else{
                    JOptionPane.showMessageDialog(null, "Las contraseñas no coinciden", "Error", JOptionPane.WARNING_MESSAGE);
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
                cargarDatos(txtbuscar.getText());
            }
          }
      };
      btnbuscar.addActionListener(b);
      
    }
 

 public void mostrar(){
     JFrame frame4=new JFrame(); 
     frame4.setLayout(null);
     frame4.setResizable(false);
     frame4.setSize(1200,600);
     
     
     
     
     frame4.setVisible(true);
     
     
 }
 
 
 
 
        
    }
    
    
    
    

