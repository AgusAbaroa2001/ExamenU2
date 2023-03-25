import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Venatana extends JFrame{
	
	private String anterior = "login";
	private String actual = "login";
	public JPanel panel = null;
	
	public Venatana() {
			
		this.setVisible(true);
		this.setSize(500, 600);
		this.setLocationRelativeTo(null);
		this.setTitle("Hola mundo");
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(null);
		this.getContentPane().setBackground(Color.black);
		
		limpiarVentana();
		
		this.repaint();
		this.revalidate();
		
	}
	
	public void limpiarVentana() {
		
		if(panel!= null) {
			this.remove(panel);
		}
		
		if(actual.equals("login")){
			panel = login(); 
			
			this.add(panel);
			
			this.repaint();
			this.revalidate();
		}
		
		if(actual.equals("registro")){
			panel = registro();
			
			this.add(panel);
			
			this.repaint();
			this.revalidate();
		}
		
	}
	
	public JPanel login()//________________________________________________________________
	{
		
		anterior = actual;
		actual = "login";
		
		//PANEL PRINCIPAL----------------------------------
		JPanel jpL = new JPanel();
		jpL.setSize(500, 600);
		jpL.setLocation(0, 0);
		jpL.setLayout(null);
		jpL.setBackground(Color.decode("#76D09A"));
		
		//TITULO----------------------------------------------------------
		JLabel tituloL = new JLabel("Accede a tu Cuenta",JLabel.CENTER);
		tituloL.setFont(new Font("Arial", Font.BOLD,20));
		tituloL.setSize(280, 40);
		tituloL.setLocation(100, 20);
		tituloL.setOpaque(true);
		tituloL.setBackground(Color.decode("#76D09A"));
		tituloL.setForeground(Color.white);
		jpL.add(tituloL);
		
		//TITULO DE NOMBRE DE USUARIO----------------------------------------------
		JLabel nombreTag = new JLabel("Nombre de usuario: ",JLabel.LEFT);
		nombreTag.setFont(new Font("Arial", Font.BOLD,15));
		nombreTag.setSize(250, 20);
		nombreTag.setLocation(120, 280);
		nombreTag.setOpaque(true);
		nombreTag.setBackground(Color.decode("#76D09A"));
		nombreTag.setForeground(Color.white);
		jpL.add(nombreTag);
		//CAJA DE NOMBRE DE USUARIO
		JTextField nombreC = new JTextField("");
		nombreC.setSize(250, 30);
		nombreC.setLocation(120, 310);
		jpL.add(nombreC);
		
		//TITULO DE LA CONTRASEÑA--------------------------------------------------
		JLabel contraseñaTag = new JLabel("Contraseña de acceso: ",JLabel.LEFT);
		contraseñaTag.setFont(new Font("Arial", Font.BOLD,15));
		contraseñaTag.setSize(250, 20);
		contraseñaTag.setLocation(120, 350);
		contraseñaTag.setOpaque(true);
		contraseñaTag.setBackground(Color.decode("#76D09A"));
		contraseñaTag.setForeground(Color.white);
		jpL.add(contraseñaTag);
		//CAJA DE CONTRASEÑA
		JPasswordField contraseñaC = new JPasswordField();
		contraseñaC.setSize(250, 30);
		contraseñaC.setLocation(120, 370);
		jpL.add(contraseñaC);
		
		//BOTON DE CANCELAR-------------------------------------------------------------
		JButton cancelar = new JButton("Cancelar");
		cancelar.setSize(120,40);
		cancelar.setLocation(120,410);
		cancelar.setBackground(Color.decode("#E48080"));
		cancelar.setForeground(Color.white);
		jpL.add(cancelar);
		
		JButton iniciarS = new JButton("Iniciar Sesión");
		iniciarS.setSize(120,40);
		iniciarS.setLocation(250,410);
		iniciarS.setBackground(Color.decode("#3DADFF"));
		iniciarS.setForeground(Color.white);
		jpL.add(iniciarS);
		
		iniciarS.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				String temp = new String(contraseñaC.getPassword());
				
				if (nombreC.getText().length()==0 || temp.length()==0) {
					JOptionPane.showMessageDialog(null,"Faltan campos por llenar","Error al iniciar sesion",JOptionPane.WARNING_MESSAGE);
				}else{
					try {
						if (leector(nombreC.getText(),temp)) {
							JOptionPane.showMessageDialog(null,"Bienvenido "+nombreC.getText());
							anterior = actual;
							actual = "registro";
							
							limpiarVentana();
							repaint();
							revalidate();
						}else {
							JOptionPane.showMessageDialog(null,"Usuario y/o contraseña son incorrectos","Error al iniciar sesion",JOptionPane.ERROR_MESSAGE);
						}
					} catch (IOException e1) {
						e1.printStackTrace();
					}
				}
				
				
				
			}
			
		});
		
		this.add(jpL);
		return jpL;
		
	}

	
	public JPanel registro() {
		
		anterior = actual;
		actual = "registro";
		
		JPanel jp2 = new JPanel();
		jp2.setSize(500, 700);
		jp2.setLocation(0, 0);
		jp2.setLayout(null);
		jp2.setBackground(Color.decode("#C45EDF"));
		
		//titulo
		JLabel titleR = new JLabel("Registro nuevo usuario",JLabel.CENTER);
		titleR.setFont(new Font("Comic Sans", Font.BOLD,20));
		titleR.setSize(280, 40);
		titleR.setLocation(100, 20);
		titleR.setOpaque(true);
		titleR.setBackground(Color.green);
		jp2.add(titleR);
		
		JLabel tag1R = new JLabel("Ingrese el nombre de usuario: ",JLabel.CENTER);
		tag1R.setSize(250, 20);
		tag1R.setLocation(120, 80);
		tag1R.setOpaque(true);
		tag1R.setBackground(Color.black);
		tag1R.setForeground(Color.white);
		jp2.add(tag1R);
		
		JTextField usernameR = new JTextField("");
		usernameR.setSize(250, 40);
		usernameR.setLocation(120, 100);
		jp2.add(usernameR);
		
		JLabel tag2R = new JLabel("Ingrese el correo electrónico: ",JLabel.CENTER);
		tag2R.setSize(250, 20);
		tag2R.setLocation(120, 140);
		tag2R.setOpaque(true);
		tag2R.setBackground(Color.black);
		tag2R.setForeground(Color.white);
		jp2.add(tag2R);
		
		JPasswordField passwordR = new JPasswordField();
		passwordR.setSize(250, 40);
		passwordR.setLocation(120, 160);
		jp2.add(passwordR);
		
		JLabel tag3 = new JLabel("Ingrese el nombre: ",JLabel.CENTER);
		tag3.setSize(250, 20);
		tag3.setLocation(120, 210);
		tag3.setOpaque(true);
		tag3.setBackground(Color.black);
		tag3.setForeground(Color.white);
		jp2.add(tag3);
		
		JTextField name = new JTextField("");
		name.setSize(250, 40);
		name.setLocation(120, 250);
		jp2.add(name);
		
		JLabel tag4 = new JLabel("Ingrese el nombre: ",JLabel.CENTER);
		tag4.setSize(250, 20);
		tag4.setLocation(120, 300);
		tag4.setOpaque(true);
		tag4.setBackground(Color.black);
		tag4.setForeground(Color.white);
		jp2.add(tag4);
		
		JTextField lastname = new JTextField("");
		lastname.setSize(250, 40);
		lastname.setLocation(120, 340);
		jp2.add(lastname);
		
		JButton btnAdd = new JButton("R E G I S T R O");
		btnAdd.setSize(250,40);
		btnAdd.setLocation(120, 390);
		jp2.add(btnAdd);
		
		btnAdd.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				anterior = actual;
				actual = "login";
				
				limpiarVentana();
				
			}
			
		});
		
		return jp2;
	}
	
	
	
	public boolean leector(String nombre,String contraseña) throws IOException {
		File archivo;
		archivo = new File("users.txt");
		BufferedReader bf = new BufferedReader(new FileReader(archivo));
		
		String temp = bf.readLine();
		
		String[] buscador = temp.split(" ");
		
		while(temp!=null) {
			
			if (buscador[0].equals(nombre)) {
				if(buscador[3].equals(contraseña)) {
					return true;
				}
			}
			
			temp = bf.readLine();
			if(temp!=null)
				buscador = temp.split(" ");
		}
		
		return false;
}
	
	public void registrarDatos(String nombre,String apellido,String correo,String contraseña) throws IOException {
		
		File archivo;
		FileWriter escritor;
		PrintWriter linea;
		archivo = new File("users.txt");
		
		if (!archivo.exists()) {
			try {
				archivo.createNewFile();
				
				escritor = new FileWriter(archivo,true);
				linea = new PrintWriter(escritor);
				linea.println(nombre+" "+apellido+" "+correo+" "+contraseña);
				linea.close();
				escritor.close();
				
			}catch(Exception e){
				System.out.println("Error: "+e.getMessage());
			}
		}else {
			try {
				escritor = new FileWriter(archivo,true);
				linea = new PrintWriter(escritor);
				linea.println(nombre+" "+apellido+" "+correo+" "+contraseña);
				linea.close();
				escritor.close();
				
			}catch(Exception e){
				System.out.println("Error: "+e.getMessage());
			}
		}
	}
	
	
}

