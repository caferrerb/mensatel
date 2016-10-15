package co.edu.eam.soa.vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.GraphicsEnvironment;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Properties;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javafx.scene.image.Image;

public class FrmBeeper extends JFrame implements Runnable{

	private JPanel contentPane;
	private JLabel lblFondoBeeper;
	private JLabel lblTextoMensaje;
	
	private Properties propiedades;
	private String ip_host;
	private int puerto_host;
	private String num_abonado;
	
	private Socket con;
	private PrintStream salidaTxt;
	private BufferedReader entradaTxt;
	
	Toolkit tk = Toolkit.getDefaultToolkit();


	/**
	 * Create the frame.
	 */
	public FrmBeeper() {
		
		propiedades = new Properties();
		
		/**Cargamos el archivo desde la ruta especificada*/
		try {
			propiedades
			     .load(new FileInputStream("beeperConfig.properties"));
		} catch (FileNotFoundException e) {
			//e.printStackTrace();
			System.out.println("Archivo de propiedades con encontrado");
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		ip_host = propiedades.getProperty("ip_host");
		puerto_host = Integer.parseInt(propiedades.getProperty("port"));
		num_abonado = propiedades.getProperty("num_abonado");
		
		try {
			con = new Socket(ip_host, puerto_host);
			salidaTxt = new PrintStream(con.getOutputStream());
			entradaTxt = new BufferedReader(new 
						InputStreamReader(con.getInputStream()));
			
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		componenteInit();
		
	}
	
	/**
	 * Elementos de la interfaz
	 */
	public void componenteInit(){
		
		setResizable(false);
		getContentPane().setLayout(null);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 419, 310);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		//Fuente Digital
		ClassLoader classLoader = this.getClass().getClassLoader();
		String filename="/font/digital-7.ttf";
		Font Digitalfont = null;
		try {
			Digitalfont = Font.createFont(Font.TRUETYPE_FONT, this.getClass().getResourceAsStream(filename));
			//Digitalfont = Font.createFont(Font.TRUETYPE_FONT, new File(filename));
			Digitalfont = Digitalfont.deriveFont(Font.BOLD,28);
			GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
			ge.registerFont(Digitalfont);
		} catch (FontFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		contentPane.setLayout(null);
		
		lblTextoMensaje = new JLabel("Sin mensajes");
		lblTextoMensaje.setBounds(97, 75, 207, 45);
		lblTextoMensaje.setFont(Digitalfont);
		contentPane.add(lblTextoMensaje);
		
		
		//----------------------------------
		lblFondoBeeper = new JLabel("");
		BufferedImage im;
		try {
			im = ImageIO.read(this.getClass().getResourceAsStream("/images/beeper.png"));
			lblFondoBeeper.setIcon(new ImageIcon(im));
			lblFondoBeeper.setBounds(10, 0, 397, 270);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		getContentPane().add(lblFondoBeeper);
		
		new Thread(this).start();
		this.setVisible(true);
		
	}

	public void run() {
		
		salidaTxt.println("abonado@"+num_abonado);
		String respuesta;
		try {
			respuesta = entradaTxt.readLine();
			System.out.println("Respuesta Servidor: "+respuesta);
			
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
		
		boolean conectado = true;
		while(conectado){
			
			try {
				String mensaje = entradaTxt.readLine();
				
				String cadenaContiene = "You are using SafeProtocol";
				//boolean contieneCadena = mensaje.contains(cadenaContiene);
				
				if(mensaje.contains(cadenaContiene)){
					String[] partesMensaje = mensaje.split("&");
					mensaje = partesMensaje[1];
				}
				
				//Beep del sistema
				tk.beep();
				
				boolean rotarTexto = true;
				char c;
				
				int i = 0;
				while(i < 60){
					
					try{
						Thread.sleep(500);	// Hacemos una pausa para darle velocidad al movimiento
						c = mensaje.charAt(0);	// Tomamos la primera letra de la cadena
						mensaje = mensaje.substring(1, mensaje.length()); // Quitamos la primera letra de la cadena
						mensaje += c; // Pegamos la primera letra al final de la cadena
						
						lblTextoMensaje.setText(mensaje);
						
						//System.out.println(c);
						
						i++;
						
					}
					catch(InterruptedException ie){}
				}
				
				
				
				//System.out.println("Mensaje recibido: "+mensaje);
			} catch (IOException e) {
				System.out.println("Sin conexi�n del servidor");
				conectado = false;
				
				//e.printStackTrace();
			}
			
		}
		
		try {
			con.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
