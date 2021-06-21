package GUIDUAL_TomasMota;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import javax.swing.JButton;
import java.awt.Dimension;
import java.awt.Color;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.SwingConstants;
import javax.swing.JPasswordField;
import java.awt.Font;

@SuppressWarnings("serial")
public class Login extends JFrame {

	// Variables
	private JPanel contentPane;
	private JTextField textUsuario;
	private JPasswordField passwordLogin;
	public ArrayList<Usuarios> usuarios = new ArrayList<>();
	public static Login frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new Login();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Creacion del frame.
	 */
	public Login() {
		// Añadimos un usuario por defecto para que se pueda acceder al sistema.
		usuarios.add(new Usuarios("root", "root", "", "", ""));
		// Configuración de la ventana de Login.
		setResizable(false);
		setTitle("Login");
		setName("Login");
		// Icono que se pone para la esquina de la ventana.
		setIconImage(Toolkit.getDefaultToolkit().getImage("images/iconosBotones/Login.png"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 464, 450);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(138, 43, 226));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(2, 0, 0, 0));

		// Panel principal para meter los datos necesarios.
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		panel.setMaximumSize(new Dimension(8, 8));
		contentPane.add(panel);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[] { 136, 136, 90 };
		gbl_panel.rowHeights = new int[] { 0, 57, 62, 0 };
		gbl_panel.columnWeights = new double[] { 0.0, 1.0, 1.0 };
		gbl_panel.rowWeights = new double[] { 1.0, 0.0, 0.0, Double.MIN_VALUE };
		panel.setLayout(gbl_panel);

		// Label para el titulo (Login)
		JLabel lblLogin = new JLabel("Login");
		lblLogin.setForeground(new Color(138, 43, 226));
		lblLogin.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 23));
		GridBagConstraints gbc_lblLogin = new GridBagConstraints();
		gbc_lblLogin.fill = GridBagConstraints.VERTICAL;
		gbc_lblLogin.insets = new Insets(0, 0, 5, 5);
		gbc_lblLogin.gridx = 1;
		gbc_lblLogin.gridy = 0;
		panel.add(lblLogin, gbc_lblLogin);

		// Label para Usuario.
		JLabel lblUsuario = new JLabel("Usuario");
		lblUsuario.setHorizontalAlignment(SwingConstants.RIGHT);
		lblUsuario.setHorizontalTextPosition(SwingConstants.RIGHT);
		GridBagConstraints gbc_lblUsuario = new GridBagConstraints();
		gbc_lblUsuario.fill = GridBagConstraints.BOTH;
		gbc_lblUsuario.insets = new Insets(0, 0, 5, 5);
		gbc_lblUsuario.gridx = 0;
		gbc_lblUsuario.gridy = 1;
		panel.add(lblUsuario, gbc_lblUsuario);

		// Casilla de texto para poner el Usuario.
		textUsuario = new JTextField();
		textUsuario.setSize(new Dimension(10, 10));
		textUsuario.setMinimumSize(new Dimension(10, 10));
		textUsuario.setMaximumSize(new Dimension(10, 10));
		GridBagConstraints gbc_textUsuario = new GridBagConstraints();
		gbc_textUsuario.fill = GridBagConstraints.HORIZONTAL;
		gbc_textUsuario.insets = new Insets(0, 0, 5, 5);
		gbc_textUsuario.gridx = 1;
		gbc_textUsuario.gridy = 1;
		panel.add(textUsuario, gbc_textUsuario);
		textUsuario.setColumns(10);

		// Label para la contraseña.
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setHorizontalTextPosition(SwingConstants.RIGHT);
		lblPassword.setHorizontalAlignment(SwingConstants.RIGHT);
		GridBagConstraints gbc_lblPassword = new GridBagConstraints();
		gbc_lblPassword.fill = GridBagConstraints.BOTH;
		gbc_lblPassword.insets = new Insets(0, 0, 0, 5);
		gbc_lblPassword.gridx = 0;
		gbc_lblPassword.gridy = 2;
		panel.add(lblPassword, gbc_lblPassword);

		// Casilla de tipo Password para poner la contraseña.
		passwordLogin = new JPasswordField();
		GridBagConstraints gbc_passwordLogin = new GridBagConstraints();
		gbc_passwordLogin.insets = new Insets(0, 0, 0, 5);
		gbc_passwordLogin.fill = GridBagConstraints.HORIZONTAL;
		gbc_passwordLogin.gridx = 1;
		gbc_passwordLogin.gridy = 2;
		panel.add(passwordLogin, gbc_passwordLogin);

		// Panel secundario para añadir los botones necesarios.
		JPanel panelbotones = new JPanel();
		panelbotones.setBackground(new Color(255, 255, 255));
		panelbotones.setBorder(new EmptyBorder(30, 0, 0, 0));
		contentPane.add(panelbotones);
		panelbotones.setLayout(null);

		// Botón para entrar dentro del sistema (Login).
		JButton buttonLogin = new JButton("Login");
		buttonLogin.setMargin(new Insets(2, 4, 2, 4));
		buttonLogin.setBorderPainted(false);
		buttonLogin.setForeground(Color.WHITE);
		buttonLogin.setBackground(new Color(138, 43, 226));
		buttonLogin.setBounds(107, 35, 63, 23);
		panelbotones.add(buttonLogin);
		buttonLogin.addActionListener(new ActionListener() {
			// Llamamos al metodo para Iniciar la sesión.
			@Override
			public void actionPerformed(ActionEvent e) {
				InicioSesion();
			}
		});

		// Botón para registrarse en el sistema (Sign Up).
		JButton buttonSignUp = new JButton("Sign up");
		buttonSignUp.setMargin(new Insets(2, 4, 2, 4));
		buttonSignUp.setForeground(new Color(255, 255, 255));
		buttonSignUp.setBackground(new Color(138, 43, 226));
		buttonSignUp.setBorderPainted(false);
		buttonSignUp.setBounds(250, 35, 67, 23);
		panelbotones.add(buttonSignUp);
		buttonSignUp.addActionListener(new ActionListener() {
			// Creamos la ventana de Registro y se oculta la anterior.
			@Override
			public void actionPerformed(ActionEvent e) {
				Registro registro = new Registro(usuarios, frame);
				registro.setVisible(true);
				setVisible(false);
			}
		});
	}

	/*
	 * Metodo de Inicio de Sesión; Se compara los usuarios registrados y sus
	 * contraseñas.
	 */
	private void InicioSesion() {
		boolean loginCorrecto = false;
		for (Usuarios usuariosinicio : usuarios) {
			if (textUsuario.getText().equals(usuariosinicio.getUsername())
					&& (String.valueOf(passwordLogin.getPassword()).equals(usuariosinicio.getPassword()))) {
				// Si la contraseña del usuario es correcta y corresponde al usuario indicado,
				// se aprueba el Login.
				loginCorrecto = true;
			}
		}

		// Una vez aprobado el login, se muestra un mensaje de bienvenida al usuario y
		// se avanza a la ventana de GestionProductos
		if (loginCorrecto) {
			JOptionPane.showMessageDialog(contentPane,
					"Bienvenido ".concat(textUsuario.getText()) + ", has entrado al sistema de gestión de productos",
					"Inicio de sesion correcto", JOptionPane.INFORMATION_MESSAGE);
			GestionProductos productos = new GestionProductos();
			productos.setVisible(true);
			setVisible(false);
			dispose();

			// Si al iniciar sesión la contraseña o el usuario es incorrecto, le envia el
			// siguiente mensaje.
		} else {
			JOptionPane.showMessageDialog(contentPane, "Usuario o Contraseña Erronea...", "Inicio de sesion erroneo",
					JOptionPane.ERROR_MESSAGE);
		}
		
	}
}
