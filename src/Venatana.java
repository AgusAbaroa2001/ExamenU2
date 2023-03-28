import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;

public class Venatana extends JFrame{
	
	private String anterior = "login";
	private String actual = "login";
	public JPanel panel = null;
	
	public Venatana() {
			
		this.setVisible(true);
		this.setSize(500, 600);
		this.setLocationRelativeTo(null);
		this.setTitle("AgustinoScary");
		
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
		if(actual.equals("menu")){
			panel = menu();
			
			this.add(panel);
			
			this.repaint();
			this.revalidate();
		}
		
		if(actual.equals("miCuenta")){
			panel = miCuenta();
			
			this.add(panel);
			
			this.repaint();
			this.revalidate();
		}
		
		if(actual.equals("AyudaU")){
			panel = AyudaU();
			
			this.add(panel);
			
			this.repaint();
			this.revalidate();
		}
		
		if(actual.equals("listaU")){
			panel = listaU();
			
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
							actual = "menu";//+++++++++
							
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
	
	public JPanel menu()//_________________________________________________________________________
	{
		anterior = actual;
		actual = "menu";
		
		//PANEL PRINCIPAL-------------------------------------------------
		JPanel jpM = new JPanel();
		jpM.setSize(500, 600);
		jpM.setLocation(0, 0);
		jpM.setLayout(null);
		jpM.setBackground(Color.decode("#76D09A"));
		
		
		//TITULO----------------------------------------------------------
		JLabel tituloM = new JLabel("Bievenido Usuario",JLabel.CENTER);
		tituloM.setFont(new Font("Arial", Font.BOLD,20));
		tituloM.setSize(280, 40);
		tituloM.setLocation(100, 40);
		tituloM.setOpaque(true);
		tituloM.setBackground(Color.decode("#76D09A"));
		tituloM.setForeground(Color.white);
		jpM.add(tituloM);
		
		//BARRA-----------------------------------------------------------
		JMenuBar barra = new JMenuBar();
		barra.setLocation(0,0);
		barra.setSize(500,30);
		this.add(barra);
		
		JMenu cuenta = new JMenu("Cuenta");
		JMenu usuarios = new JMenu("Usuarios");
		JMenu ayuda = new JMenu("Ayuda");
		
		barra.add(cuenta);
		barra.add(usuarios);
		barra.add(ayuda);
		
		JMenuItem miCuenta = new JMenuItem("Mi Cuenta");
		miCuenta.addActionListener(new ActionListener() {//VAS AL PANEL DE MI CUENTA--------------

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				anterior = actual;
				actual = "miCuenta";
				
				limpiarVentana();
				
			}
			
		});
		JMenuItem cerrarSesion = new JMenuItem("Cerrar Sesión");
		cerrarSesion.addActionListener(new ActionListener() {//CIERRA LA SESION--------------

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				anterior = actual;
				actual = "login";
				
				limpiarVentana();
				
			}
			
		});
		cuenta.add(miCuenta);
		cuenta.add(cerrarSesion);
		
		
		JMenuItem listaUsuarios = new JMenuItem("Lista de Usuarios");//LISTA DE USUARIOS----------------
		listaUsuarios.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				anterior = actual;
				actual = "listaU";
				
				limpiarVentana();
				
			}
			
		});
		JMenuItem crearUsuarios = new JMenuItem("Crear Usuarios");//CREAR USUARIOS--------------------------
		crearUsuarios.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				anterior = actual;
				actual = "registro";
				
				limpiarVentana();
				
			}
			
		});
		usuarios.add(listaUsuarios);
		usuarios.add(crearUsuarios);
		
		JMenuItem comoCrear = new JMenuItem("¿Cómo Crear Usuarios?");
		comoCrear.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				anterior = actual;
				actual = "AyudaU";
				
				limpiarVentana();
				
			}
			
		});
		ayuda.add(comoCrear);
		
		setJMenuBar(barra);
		
		return jpM;	
	}
	
	public JPanel miCuenta()//_______________________________________________________________
	{
		anterior = actual;
		actual = "miCuenta";
		
		//PANEL PRINCIPAL-------------------------------------------------
		JPanel jpMC = new JPanel();
		jpMC.setSize(500, 600);
		jpMC.setLocation(0, 0);
		jpMC.setLayout(null);
		jpMC.setBackground(Color.decode("#76D09A"));
		
		//TITULO----------------------------------------------------------
		JLabel titulo = new JLabel("Mi Cuenta Personal",JLabel.CENTER);
		titulo.setFont(new Font("Arial", Font.BOLD,20));
		titulo.setSize(280, 40);
		titulo.setLocation(100, 20);
		titulo.setOpaque(true);
		titulo.setBackground(Color.decode("#76D09A"));
		titulo.setForeground(Color.white);
		jpMC.add(titulo);
		
		//PANEL SECUNDARIO-------------------------------------------------
		JPanel jpMC2 = new JPanel();
		jpMC2.setSize(400, 350);
		jpMC2.setLocation(50, 150);
		jpMC2.setLayout(null);
		jpMC2.setBackground(Color.decode("#60AF93"));
		jpMC.add(jpMC2);
		
		//NOMBRE-----------------------------------------------------------
		JLabel nombreTag = new JLabel("Nombre: ",JLabel.LEFT);
		nombreTag.setFont(new Font("Arial", Font.BOLD,15));
		nombreTag.setSize(200, 20);
		nombreTag.setLocation(50, 30);
		nombreTag.setOpaque(true);
		nombreTag.setBackground(Color.decode("#60AF93"));
		nombreTag.setForeground(Color.white);
		jpMC2.add(nombreTag);
		JTextField nombreC = new JTextField("");
		nombreC.setSize(300, 30);
		nombreC.setLocation(50, 50);
		jpMC2.add(nombreC);
		
		//APELLIDOS-----------------------------------------------------------
		JLabel apellidosTag = new JLabel("Apellidos: ",JLabel.LEFT);
		apellidosTag.setFont(new Font("Arial", Font.BOLD,15));
		apellidosTag.setSize(200, 20);
		apellidosTag.setLocation(50, 90);
		apellidosTag.setOpaque(true);
		apellidosTag.setBackground(Color.decode("#60AF93"));
		apellidosTag.setForeground(Color.white);
		jpMC2.add(apellidosTag);
		JTextField apellidosC = new JTextField("");
		apellidosC.setSize(300, 30);
		apellidosC.setLocation(50, 110);
		jpMC2.add(apellidosC);
		
		//CORREO-----------------------------------------------------------
		JLabel correoTag = new JLabel("Correo: ",JLabel.LEFT);
		correoTag.setFont(new Font("Arial", Font.BOLD,15));
		correoTag.setSize(200, 20);
		correoTag.setLocation(50, 150);
		correoTag.setOpaque(true);
		correoTag.setBackground(Color.decode("#60AF93"));
		correoTag.setForeground(Color.white);
		jpMC2.add(correoTag);
		JTextField correoC = new JTextField("");
		correoC.setSize(300, 30);
		correoC.setLocation(50, 170);
		jpMC2.add(correoC);
		
		//CONTRASEÑA-----------------------------------------------------------
		JLabel contraTag = new JLabel("Contraseña: ",JLabel.LEFT);
		contraTag.setFont(new Font("Arial", Font.BOLD,15));
		contraTag.setSize(200, 20);
		contraTag.setLocation(50, 210);
		contraTag.setOpaque(true);
		contraTag.setBackground(Color.decode("#60AF93"));
		contraTag.setForeground(Color.white);
		jpMC2.add(contraTag);
		JPasswordField contraC = new JPasswordField("");
		contraC.setSize(300, 30);
		contraC.setLocation(50, 230);
		jpMC2.add(contraC);
		
		//BOTONES--------------------------------------------------------------
		JButton cancelar = new JButton("Cancelar");
		cancelar.setSize(140,40);
		cancelar.setLocation(50,280);
		cancelar.setBackground(Color.decode("#E48080"));
		cancelar.setForeground(Color.white);
		jpMC2.add(cancelar);
		cancelar.addActionListener(new ActionListener() {//VAS AL PANEL DE MI CUENTA--------------

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				anterior = actual;
				actual = "menu";
				
				limpiarVentana();
				
			}
			
		});
		JButton iniciarS = new JButton("Actualizar Datos");
		iniciarS.setSize(150,40);
		iniciarS.setLocation(200,280);
		iniciarS.setBackground(Color.decode("#3DADFF"));
		iniciarS.setForeground(Color.white);
		iniciarS.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				int contTemp = 0;
				String aux = new String(contraC.getPassword());

				
				if (nombreC.getText().length()!=0 && 
					apellidosC.getText().length()!=0 &&  
					correoC.getText().length()!=0 &&  
					aux.length()!=0) {
					contTemp+=1;
				}else {
					JOptionPane.showMessageDialog(null,"La informacion no se ha podido actualizar","Error al llenar datos",JOptionPane.ERROR_MESSAGE);
					contTemp=0;
				}
			
				if(contTemp>=1) {
					JOptionPane.showMessageDialog(null,"Cuenta actulizada con exito");
					
					limpiarVentana();
					repaint();
					revalidate();
					
				}
			}
			
		});
		jpMC2.add(iniciarS);
		
		return(jpMC);
	}
	
    JButton deleteButton = new JButton("Eliminar");
	public JPanel listaU()//________________________________________________________________________________________
	{
		
		anterior = actual;
		actual = "listaU";
		
		//PANEL PRINCIPAL--------------------------------------------------------------------
		JPanel jpLU = new JPanel();
		jpLU.setSize(500, 600);
		jpLU.setLocation(0, 0);
		jpLU.setLayout(null);
		jpLU.setBackground(Color.decode("#76D09A"));
		
		//TITULO-------------------------------------------------------------------------------
		JLabel titulo = new JLabel("Lista de Usuarios",JLabel.CENTER);
		titulo.setFont(new Font("Arial", Font.BOLD,20));
		titulo.setSize(280, 40);
		titulo.setLocation(100, 20);
		titulo.setOpaque(true);
		titulo.setBackground(Color.decode("#76D09A"));
		titulo.setForeground(Color.white);
		jpLU.add(titulo);
		
		//SUBTITULO----------------------------------------------------------------------------
		JLabel subTitulo = new JLabel("Editar",JLabel.LEFT);
		subTitulo.setFont(new Font("Arial", Font.BOLD,15));
		subTitulo.setSize(280, 40);
		subTitulo.setLocation(50, 60);
		subTitulo.setOpaque(true);
		subTitulo.setBackground(Color.decode("#76D09A"));
		subTitulo.setForeground(Color.white);
		jpLU.add(subTitulo);
		
		//CAJA DE USUARIOS-----------------------------------------------------------------------
		File archivo = new File("users.txt");
		ArrayList<String> opciones = new ArrayList<>();
		try {
		Scanner lector = new Scanner(archivo);
		while (lector.hasNextLine()) {
			String linea = lector.nextLine();
			String[] partes = linea.split(" ");
			opciones.add(partes[0]);
		}
		}catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		JComboBox<String> cajaU = new JComboBox<String>(opciones.toArray(new String[0]));
		
		//BOTON-----------------------------------------------------------------------------------
		JButton botonEditar = new JButton("Editar a " + cajaU.getSelectedItem().toString());
		botonEditar.setSize(375,40);
		botonEditar.setLocation(50,140);
		botonEditar.setBackground(Color.decode("#31C148"));
		botonEditar.setForeground(Color.white);
		jpLU.add(botonEditar);
		
		cajaU.setSize(375,30);
		cajaU.setLocation(50,100);
		cajaU.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String nombreS = cajaU.getSelectedItem().toString();
				botonEditar.setText("Editar a " + nombreS);
				
			}
			
		});
		jpLU.add(cajaU);
		
		//TABLA----------------------------------------------------------------------------------		
		DefaultTableModel modelo = new DefaultTableModel(new String[]{"Nombre", "Apellido", "Correo", "Contraseña", "Acción"}, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                if (column == 2) {
                	return true;
                }else {
                	return false;
                }
            }
        };
        
        try (BufferedReader br = new BufferedReader(new FileReader("users.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(" ");
                modelo.addRow(new Object[]{data[0], data[1], data[2], data[3], ""});
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        JTable tabla = new JTable(modelo);
        
        TableCellRenderer renderer = new TableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
                return deleteButton;
            }
        };
        
        JButton deleteButton = new JButton("Eliminar");
        deleteButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if (e.getSource() == deleteButton) {
		            int selectedRow = tabla.getSelectedRow();
		            if (selectedRow != -1) {
		                int opcion = JOptionPane.showConfirmDialog(null, "¿Está seguro de borrar esta cuenta?", "CONFIRMACION", JOptionPane.YES_NO_CANCEL_OPTION);
		                if (opcion == JOptionPane.YES_OPTION) {
		                    DefaultTableModel model = (DefaultTableModel) tabla.getModel();
		                    model.removeRow(selectedRow);
		                }
		            }
		        }
			}
        	
        });
       
        TableColumn column = tabla.getColumnModel().getColumn(4);
        column.setCellRenderer(renderer);
        column.setCellEditor(null);
        
        JScrollPane scrollPane = new JScrollPane(tabla);
        scrollPane.setLocation(25, 190);
        scrollPane.setSize(425,100);
        // Agregamos el JScrollPane al JFrame
        jpLU.add(scrollPane);
		
       
        
		return jpLU;
	}
	
	public JPanel registro() {
		
		anterior = actual;
		actual = "registro";
		
		JPanel jp2 = new JPanel();
		jp2.setSize(500, 700);
		jp2.setLocation(0, 0);
		jp2.setLayout(null);
		jp2.setBackground(Color.decode("#76D09A"));
		
		JPanel jpMC2 = new JPanel();
		jpMC2.setSize(400, 380);
		jpMC2.setLocation(43, 150);
		jpMC2.setLayout(null);
		jpMC2.setBackground(Color.decode("#60AF93"));
		jp2.add(jpMC2);
		
		//titulo
		JLabel titleR = new JLabel("Crear usuario",JLabel.CENTER);
		titleR.setFont(new Font("Comic Sans", Font.BOLD,20));
		titleR.setSize(200, 40);
		titleR.setLocation(130, 20);
		titleR.setOpaque(true);
		titleR.setBackground(Color.decode("#76D09A"));
		titleR.setForeground(Color.white);
		jp2.add(titleR);
		
		//espacios a rellenar
		JLabel tag1R = new JLabel("Nombre: ",JLabel.CENTER);
		tag1R.setSize(60, 20);
		tag1R.setLocation(10, 5);
		tag1R.setOpaque(true);
		tag1R.setBackground(Color.decode("#60AF93"));
		tag1R.setForeground(Color.white);
		jpMC2.add(tag1R);
		
		JTextField usernameR = new JTextField("");
		usernameR.setSize(380, 20);
		usernameR.setLocation(10, 30);
		jpMC2.add(usernameR);
		
		JLabel tag2R = new JLabel("Apellido: ",JLabel.CENTER);
		tag2R.setSize(62, 20);
		tag2R.setLocation(10, 60);
		tag2R.setOpaque(true);
		tag2R.setBackground(Color.decode("#60AF93"));
		tag2R.setForeground(Color.white);
		jpMC2.add(tag2R);
		
		JTextField userR = new JTextField();
		userR.setSize(380, 20);
		userR.setLocation(10, 80);
		jpMC2.add(userR);
		
		JLabel tag3 = new JLabel("Email: ",JLabel.CENTER);
		tag3.setSize(55, 20);
		tag3.setLocation(10, 110);
		tag3.setOpaque(true);
		tag3.setBackground(Color.decode("#60AF93"));
		tag3.setForeground(Color.white);
		jpMC2.add(tag3);
		
		JTextField name = new JTextField("");
		name.setSize(380, 20);
		name.setLocation(10, 130);
		jpMC2.add(name);
		
		JLabel tag4 = new JLabel("Contraseña: ",JLabel.CENTER);
		tag4.setSize(80, 20);
		tag4.setLocation(10, 160);
		tag4.setOpaque(true);
		tag4.setBackground(Color.decode("#60AF93"));
		tag4.setForeground(Color.white);
		jpMC2.add(tag4);
		
		JPasswordField passwordR = new JPasswordField("");
		passwordR.setSize(380, 20);
		passwordR.setLocation(10, 180);
		jpMC2.add(passwordR);
		
		JLabel tag5 = new JLabel("Confirmar Contraseña: ",JLabel.CENTER);
		tag5.setSize(135, 20);
		tag5.setLocation(10, 220);
		tag5.setOpaque(true);
		tag5.setBackground(Color.decode("#60AF93"));
		tag5.setForeground(Color.white);
		jpMC2.add(tag5);
		
		JPasswordField passwordCR = new JPasswordField("");
		passwordCR.setSize(380, 20);
		passwordCR.setLocation(10, 240);
		jpMC2.add(passwordCR);
		
		
		JButton btnAdd = new JButton("Crear Usuario");
		btnAdd.setSize(150,40);
		btnAdd.setLocation(230, 290);
		btnAdd.setOpaque(true);
		btnAdd.setBackground(Color.decode("#3DADFF"));
		btnAdd.setForeground(Color.white);
		jpMC2.add(btnAdd);
		
		btnAdd.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				int contTemp = 0;
				
				if (usernameR.getText().length()!=0 && 
					userR.getText().length()!=0 &&  
					name.getText().length()!=0) {
					contTemp+=1;
				}else {
					JOptionPane.showMessageDialog(null,"Faltan campos por llenar","Error al llenar datos",JOptionPane.ERROR_MESSAGE);
					contTemp=0;
				}
				
				String aux = new String(passwordR.getPassword());
				String auxDos = new String(passwordCR.getPassword());
				if (aux.equals(auxDos) && aux.length()!=0) {
					contTemp+=1;
				}else 
					JOptionPane.showMessageDialog(null,"Las contraseñas no coinciden","Contraseña erronea",JOptionPane.ERROR_MESSAGE);
				
				if(contTemp>=2) {
					JOptionPane.showMessageDialog(null,"Cuenta creada con exitoso");
					
					limpiarVentana();
					repaint();
					revalidate();
					try {
						registrarDatos(usernameR.getText(),userR.getText(),name.getText(),aux);
					} catch (IOException e1) {
						e1.printStackTrace();
					}
				}
				
			}
			
		});
		
		JButton btnAdd2 = new JButton("Cancelar");
		btnAdd2.setSize(150,40);
		btnAdd2.setLocation(20, 290);
		btnAdd2.setOpaque(true);
		btnAdd2.setBackground(Color.decode("#E48080"));
		btnAdd2.setForeground(Color.white);
		jpMC2.add(btnAdd2);
		
		btnAdd2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				anterior = actual;
				actual = "menu";
				
				limpiarVentana();
				
			}
			
		});
		
		return jp2;
	}
	
	public JPanel AyudaU() {
		
		JPanel fondo = new JPanel();
		fondo.setSize(500,600);
		fondo.setLocation(0,0);
		fondo.setBackground(Color.decode("#76D09A"));
		fondo.setLayout(null);
		
		JPanel jpMC2 = new JPanel();
		jpMC2.setSize(400, 350);
		jpMC2.setLocation(50, 150);
		jpMC2.setLayout(null);
		jpMC2.setBackground(Color.decode("#60AF93"));
		fondo.add(jpMC2);
		
		JLabel tituloU = new JLabel("¿Como crear un usuario?");
		tituloU.setFont(new Font("Arial", Font.BOLD,20));
		tituloU.setSize(300,50);
		tituloU.setLocation(120, 20);
		tituloU.setOpaque(true);
		tituloU.setBackground(Color.decode("#76D09A"));
		tituloU.setForeground(Color.white);
		fondo.add(tituloU);
		
		JLabel txt1 = new JLabel("1. Hacer click en la opcion 'Usuarios' en ");
		txt1.setFont(new Font("Arial", Font.BOLD,17));
		txt1.setSize(350,20);
		txt1.setLocation(10, 20);
		txt1.setOpaque(true);
		txt1.setBackground(Color.decode("#60AF93"));
		txt1.setForeground(Color.white);
		jpMC2.add(txt1);
		JLabel txt1_2 = new JLabel("el menú superior");
		txt1_2.setFont(new Font("Arial", Font.BOLD,17));
		txt1_2.setSize(350,20);
		txt1_2.setLocation(20, 40);
		txt1_2.setOpaque(true);
		txt1_2.setBackground(Color.decode("#60AF93"));
		txt1_2.setForeground(Color.white);
		jpMC2.add(txt1_2);
		
		JLabel txt2 = new JLabel("2. Hacer click en la opcion 'Crear");
		txt2.setFont(new Font("Arial", Font.BOLD,17));
		txt2.setSize(400,20);
		txt2.setLocation(10, 65);
		txt2.setOpaque(true);
		txt2.setBackground(Color.decode("#60AF93"));
		txt2.setForeground(Color.white);
		jpMC2.add(txt2);
		JLabel txt2_2 = new JLabel("'usuario' en el menú desplegado");
		txt2_2.setFont(new Font("Arial", Font.BOLD,17));
		txt2_2.setSize(350,20);
		txt2_2.setLocation(20, 85);
		txt2_2.setOpaque(true);
		txt2_2.setBackground(Color.decode("#60AF93"));
		txt2_2.setForeground(Color.white);
		jpMC2.add(txt2_2);
		
		JLabel txt3 = new JLabel("3. Llenar los campos solicitados ");
		txt3.setFont(new Font("Arial", Font.BOLD,17));
		txt3.setSize(400,20);
		txt3.setLocation(10, 110);
		txt3.setOpaque(true);
		txt3.setBackground(Color.decode("#60AF93"));
		txt3.setForeground(Color.white);
		jpMC2.add(txt3);
		
		JLabel txt4 = new JLabel("4. Escribir una pequeña descripcion de ti");
		txt4.setFont(new Font("Arial", Font.BOLD,17));
		txt4.setSize(400,20);
		txt4.setLocation(10, 135);
		txt4.setOpaque(true);
		txt4.setBackground(Color.decode("#60AF93"));
		txt4.setForeground(Color.white);
		jpMC2.add(txt4);
		
		JLabel txt5 = new JLabel("5. Seleccionar tu comida favorita");
		txt5.setFont(new Font("Arial", Font.BOLD,17));
		txt5.setSize(400,20);
		txt5.setLocation(10, 160);
		txt5.setOpaque(true);
		txt5.setBackground(Color.decode("#60AF93"));
		txt5.setForeground(Color.white);
		jpMC2.add(txt5);
		
		JLabel txt6 = new JLabel("6. Seleccionar color favorito");
		txt6.setFont(new Font("Arial", Font.BOLD,17));
		txt6.setSize(400,20);
		txt6.setLocation(10, 185);
		txt6.setOpaque(true);
		txt6.setBackground(Color.decode("#60AF93"));
		txt6.setForeground(Color.white);
		jpMC2.add(txt6);
		
		JLabel txt7 = new JLabel("7. Hacer click en el boton 'Crear");
		txt7.setFont(new Font("Arial", Font.BOLD,17));
		txt7.setSize(400,20);
		txt7.setLocation(10, 210);
		txt7.setOpaque(true);
		txt7.setBackground(Color.decode("#60AF93"));
		txt7.setForeground(Color.white);
		jpMC2.add(txt7);
		JLabel txt7_2 = new JLabel("Usuario'");
		txt7_2.setFont(new Font("Arial", Font.BOLD,17));
		txt7_2.setSize(400,20);
		txt7_2.setLocation(20, 230);
		txt7_2.setOpaque(true);
		txt7_2.setBackground(Color.decode("#60AF93"));
		txt7_2.setForeground(Color.white);
		jpMC2.add(txt7_2);
		
		JLabel txt8 = new JLabel("8. Listo, el usuario se ha creado");
		txt8.setFont(new Font("Arial", Font.BOLD,17));
		txt8.setSize(400,20);
		txt8.setLocation(10, 255);
		txt8.setOpaque(true);
		txt8.setBackground(Color.decode("#60AF93"));
		txt8.setForeground(Color.white);
		jpMC2.add(txt8);
		
		JButton btnAdd = new JButton("Crear un usuario ahora");
		btnAdd.setFont(new Font("Arial", Font.BOLD,15));
		btnAdd.setSize(250,40);
		btnAdd.setLocation(70, 290);
		btnAdd.setOpaque(true);
		btnAdd.setBackground(Color.decode("#3DADFF"));
		btnAdd.setForeground(Color.white);
		jpMC2.add(btnAdd);
		
		btnAdd.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				anterior = actual;
				actual = "registro";
				
				limpiarVentana();
				
			}
			
		});
		
		repaint();
		revalidate();
		return fondo;
		
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

