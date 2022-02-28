
package com.mycompany.proyecto1.ipc1;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.HashMap;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;



public class formularios {
    
    //objetos swing y awt
    JLabel vision,etiqueta,etiban;
    JFrame principal,login,admi;
    
    JButton btnabout,btnlogin,logout;
    ImageIcon logo,banner;    
    
    
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
        admi.getContentPane().setBackground(new Color(82, 74, 109 ));
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
                int opcion=JOptionPane.showConfirmDialog(null, "Esta seguro que quiere Cerrar sesion");
                if(opcion==0){
                    fprincipal();
                    admi.dispose();
                }
            }
            
        };
        
        logout.addActionListener(escuchador);
        
        JPanel  reportes=new JPanel();
        reportes.setLayout(null);
        reportes.setBackground(new Color(72, 103, 117));
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
        
        JButton btnveru = new JButton("Ver");
        btnveru.setBackground(new Color(64,207,255));
        btnveru.setForeground(new Color(255,255,255));
        btnveru.setBorderPainted(false);
        btnveru.setBounds(200, 40, 90, 30);
        uz.add(btnveru);
        
        JButton btnmodificaru = new JButton("Modificar");
        btnmodificaru.setBackground(new Color(64,207,255));
        btnmodificaru.setForeground(new Color(255,255,255));
        btnmodificaru.setBorderPainted(false);
        btnmodificaru.setBounds(60, 130, 90, 30);
        uz.add(btnmodificaru);
        
        JButton btnelimaru = new JButton("Eliminar");
        btnelimaru.setBackground(new Color(64,207,255));
        btnelimaru.setForeground(new Color(255,255,255));
        btnelimaru.setBorderPainted(false);
        btnelimaru.setBounds(200, 130, 90, 30);
        uz.add(btnelimaru);
        
        JPanel bli= new JPanel();
        bli.setBackground(new Color(72, 103, 117));
        bli.setLayout(null);
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
        
        
    }
    
    
    
    

