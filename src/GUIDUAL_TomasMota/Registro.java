package GUIDUAL_TomasMota;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

@SuppressWarnings("serial")
public class Registro extends JFrame {

	// Variables
	private JPanel contentPane;
	private JTextField textEmail;
	private JTextField textNombre;
	private JTextField textUsername;
	private JPasswordField password;
	private JPasswordField passwordRepite;
	private static DefaultComboBoxModel<Integer> listaEdad = new DefaultComboBoxModel<Integer>();

	/**
	 * Creacion del frame.
	 */
	public Registro(ArrayList<Usuarios> usuarios, JFrame loginFrame) {
		// Cargamos el componente SELECT con las edades antes de visualizar la ventana.
		rellenarEdad();
		// Configuración de la ventana de Login.
		setResizable(false);
		setTitle("Registro");
		setName("Registro");
		// Icono que se pone para la esquina de la ventana.
		setIconImage(Toolkit.getDefaultToolkit().getImage("images/iconosBotones/signup.png"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 464, 450);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(138, 43, 226));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setAlignmentY(Component.BOTTOM_ALIGNMENT);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[] { 438, 0 };
		gbl_contentPane.rowHeights = new int[] { 0, 250, 70, 0 };
		gbl_contentPane.columnWeights = new double[] { 0.0, Double.MIN_VALUE };
		gbl_contentPane.rowWeights = new double[] { 0.0, 0.0, 0.0, Double.MIN_VALUE };
		contentPane.setLayout(gbl_contentPane);

		// Label para el titulo (Registro)
		JLabel lblRegistro = new JLabel("Registro");
		lblRegistro.setForeground(new Color(255, 255, 255));
		lblRegistro.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 23));
		GridBagConstraints gbc_lblRegistro = new GridBagConstraints();
		gbc_lblRegistro.insets = new Insets(0, 0, 5, 0);
		gbc_lblRegistro.gridx = 0;
		gbc_lblRegistro.gridy = 0;
		contentPane.add(lblRegistro, gbc_lblRegistro);

		// Panel principal para meter los datos necesarios.
		JPanel panel = new JPanel();
		panel.setBorder(new EmptyBorder(0, 15, 0, 0));
		panel.setBackground(new Color(255, 255, 255));
		panel.setMinimumSize(new Dimension(30, 30));
		panel.setSize(new Dimension(50, 50));
		panel.setMaximumSize(new Dimension(8, 8));
		panel.setAlignmentY(7.0f);
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.insets = new Insets(0, 0, 5, 0);
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 1;
		contentPane.add(panel, gbc_panel);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[] { 136, 136, 90 };
		gbl_panel.rowHeights = new int[] { 30, 30, 30, 30, 30, 30, 30 };
		gbl_panel.columnWeights = new double[] { 0.0, 1.0, 1.0 };
		gbl_panel.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0 };
		panel.setLayout(gbl_panel);

		// Label para el Nick del Usuario.
		JLabel lblUserName = new JLabel("Username");
		lblUserName.setHorizontalAlignment(SwingConstants.RIGHT);
		lblUserName.setHorizontalTextPosition(SwingConstants.RIGHT);
		GridBagConstraints gbc_lblUserName = new GridBagConstraints();
		gbc_lblUserName.anchor = GridBagConstraints.WEST;
		gbc_lblUserName.insets = new Insets(0, 0, 5, 5);
		gbc_lblUserName.gridx = 0;
		gbc_lblUserName.gridy = 0;
		panel.add(lblUserName, gbc_lblUserName);

		// Casilla de texto para poner el Nick del Usuario.
		textUsername = new JTextField();
		GridBagConstraints gbc_textUsername = new GridBagConstraints();
		gbc_textUsername.insets = new Insets(0, 0, 5, 5);
		gbc_textUsername.fill = GridBagConstraints.HORIZONTAL;
		gbc_textUsername.gridx = 1;
		gbc_textUsername.gridy = 0;
		panel.add(textUsername, gbc_textUsername);
		textUsername.setColumns(10);

		// Label para la contraseña.
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setHorizontalTextPosition(SwingConstants.RIGHT);
		lblPassword.setHorizontalAlignment(SwingConstants.RIGHT);
		GridBagConstraints gbc_lblPassword = new GridBagConstraints();
		gbc_lblPassword.anchor = GridBagConstraints.WEST;
		gbc_lblPassword.insets = new Insets(0, 0, 5, 5);
		gbc_lblPassword.gridx = 0;
		gbc_lblPassword.gridy = 1;
		panel.add(lblPassword, gbc_lblPassword);

		// Casilla de tipo Password para poner la contraseña
		password = new JPasswordField();
		GridBagConstraints gbc_password = new GridBagConstraints();
		gbc_password.insets = new Insets(0, 0, 5, 5);
		gbc_password.fill = GridBagConstraints.HORIZONTAL;
		gbc_password.gridx = 1;
		gbc_password.gridy = 1;
		panel.add(password, gbc_password);

		// Label para la repetición de la contraseña.
		JLabel lblRepitePassword = new JLabel("Repite Password");
		lblRepitePassword.setHorizontalTextPosition(SwingConstants.RIGHT);
		lblRepitePassword.setHorizontalAlignment(SwingConstants.RIGHT);
		GridBagConstraints gbc_lblRepitePassword = new GridBagConstraints();
		gbc_lblRepitePassword.anchor = GridBagConstraints.WEST;
		gbc_lblRepitePassword.insets = new Insets(0, 0, 5, 5);
		gbc_lblRepitePassword.gridx = 0;
		gbc_lblRepitePassword.gridy = 2;
		panel.add(lblRepitePassword, gbc_lblRepitePassword);

		// Casilla de tipo Password para poner repetición de la contraseña.
		passwordRepite = new JPasswordField();
		GridBagConstraints gbc_passwordRepite = new GridBagConstraints();
		gbc_passwordRepite.insets = new Insets(0, 0, 5, 5);
		gbc_passwordRepite.fill = GridBagConstraints.HORIZONTAL;
		gbc_passwordRepite.gridx = 1;
		gbc_passwordRepite.gridy = 2;
		panel.add(passwordRepite, gbc_passwordRepite);

		// Label para el Nombre de la persona a registrar.
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNombre.setHorizontalTextPosition(SwingConstants.RIGHT);
		GridBagConstraints gbc_lblNombre = new GridBagConstraints();
		gbc_lblNombre.anchor = GridBagConstraints.WEST;
		gbc_lblNombre.insets = new Insets(0, 0, 5, 5);
		gbc_lblNombre.gridx = 0;
		gbc_lblNombre.gridy = 3;
		panel.add(lblNombre, gbc_lblNombre);

		// Casilla de texto para poner el nombre de la persona a registrar.
		textNombre = new JTextField();
		GridBagConstraints gbc_textNombre = new GridBagConstraints();
		gbc_textNombre.insets = new Insets(0, 0, 5, 5);
		gbc_textNombre.fill = GridBagConstraints.HORIZONTAL;
		gbc_textNombre.gridx = 1;
		gbc_textNombre.gridy = 3;
		panel.add(textNombre, gbc_textNombre);
		textNombre.setColumns(10);

		// Label para el Email de la persona a registrar.
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setHorizontalAlignment(SwingConstants.RIGHT);
		lblEmail.setHorizontalTextPosition(SwingConstants.RIGHT);
		GridBagConstraints gbc_lblEmail = new GridBagConstraints();
		gbc_lblEmail.anchor = GridBagConstraints.WEST;
		gbc_lblEmail.insets = new Insets(0, 0, 5, 5);
		gbc_lblEmail.gridx = 0;
		gbc_lblEmail.gridy = 4;
		panel.add(lblEmail, gbc_lblEmail);

		// Casilla de texto para poner el email de la persona a registrar.
		textEmail = new JTextField();
		GridBagConstraints gbc_textEmail = new GridBagConstraints();
		gbc_textEmail.insets = new Insets(0, 0, 5, 5);
		gbc_textEmail.fill = GridBagConstraints.HORIZONTAL;
		gbc_textEmail.gridx = 1;
		gbc_textEmail.gridy = 4;
		panel.add(textEmail, gbc_textEmail);
		textEmail.setColumns(10);

		// Label para la Edad de la persona a registrar.
		JLabel lblEdad = new JLabel("Edad");
		lblEdad.setHorizontalAlignment(SwingConstants.RIGHT);
		lblEdad.setHorizontalTextPosition(SwingConstants.RIGHT);
		GridBagConstraints gbc_lblEdad = new GridBagConstraints();
		gbc_lblEdad.anchor = GridBagConstraints.WEST;
		gbc_lblEdad.insets = new Insets(0, 0, 5, 5);
		gbc_lblEdad.gridx = 0;
		gbc_lblEdad.gridy = 5;
		panel.add(lblEdad, gbc_lblEdad);

		// Lista para seleccionar la edad de la persona a registrar.
		JComboBox<Integer> comboBox = new JComboBox<Integer>(listaEdad);
		// Dentro de la lista se visualiza los diez en la lista en el mismo momento.
		comboBox.setMaximumRowCount(10);
		GridBagConstraints gbc_comboBox = new GridBagConstraints();
		gbc_comboBox.insets = new Insets(0, 0, 5, 5);
		gbc_comboBox.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox.gridx = 1;
		gbc_comboBox.gridy = 5;
		panel.add(comboBox, gbc_comboBox);

		// Panel secundario para añadir los botones necesarios.
		JPanel panelbotones = new JPanel();
		panelbotones.setBorder(new EmptyBorder(30, 0, 0, 0));
		GridBagConstraints gbc_panelbotones = new GridBagConstraints();
		gbc_panelbotones.fill = GridBagConstraints.BOTH;
		gbc_panelbotones.gridx = 0;
		gbc_panelbotones.gridy = 2;
		contentPane.add(panelbotones, gbc_panelbotones);
		panelbotones.setLayout(null);

		// Botón para darse de Alta dentro del Registro (Aceptar).
		JButton buttonAceptar = new JButton("Aceptar");
		buttonAceptar.setMargin(new Insets(2, 4, 2, 4));
		buttonAceptar.setBorderPainted(false);
		buttonAceptar.setForeground(Color.WHITE);
		buttonAceptar.setBackground(new Color(138, 43, 226));
		buttonAceptar.setBounds(118, 23, 63, 23);
		panelbotones.add(buttonAceptar);
		buttonAceptar.addActionListener(new ActionListener() {

			// Si el usuario a registrar finaliza todos los datos necesario.
			@Override
			public void actionPerformed(ActionEvent e) {
				// Llamamos al metodo para comprobar si la respuesta es valida
				// (respuestavalida).
				boolean respuestavalida = comprobarRespuesta();
				if (respuestavalida) {
					// En el caso de estar todo correcto, se registra el usuario.
					Usuarios usuario = new Usuarios(textUsername.getText(), String.valueOf(password.getPassword()),
							textNombre.getText(), textEmail.getText(), comboBox.getSelectedItem().toString());
					usuarios.add(usuario);
					// Se vuelve a la pantalla anterior (Login) y se cierra esta (Registro).
					loginFrame.setVisible(true);
					JOptionPane.showMessageDialog(contentPane, "Usuario registrado con exito",
							"Exito al registrar usuario", JOptionPane.INFORMATION_MESSAGE);
					setVisible(false);
					dispose();
				}
			}

			/*
			 * Metodo de Comprobar Respuesta; Se compara que las contraseñas sean iguales y
			 * no sean nulas, ademas del formato del email.
			 */
			private boolean comprobarRespuesta() {
				if (textUsername.getText().equals("")) {
					JOptionPane.showMessageDialog(contentPane, "El campo Username no puede estar vacio",
							"Registro erroneo", JOptionPane.ERROR_MESSAGE);
					return false;
				}
				if (!String.valueOf(password.getPassword()).equals("")
						&& !String.valueOf(passwordRepite.getPassword()).equals("")
						&& (String.valueOf(password.getPassword())
								.equals(String.valueOf(passwordRepite.getPassword())))) {
					Pattern pattern = Pattern.compile("([a-z0-9]+(\\.?[a-z0-9])*)+@(([a-z]+)\\.([a-z]+))+");
					Matcher mather = pattern.matcher(textEmail.getText());
					if (mather.find() == false) {
						JOptionPane.showMessageDialog(contentPane, "El formato del email no es valido",
								"Registro erroneo", JOptionPane.ERROR_MESSAGE);
						return false;
					}
					return true;

				} else {
					JOptionPane.showMessageDialog(contentPane, "Las contraseñas no coinciden...", "Registro erroneo",
							JOptionPane.ERROR_MESSAGE);
				}
				return false;
			}
		});

		// Botón para salir del Registro y del sistema (Salir).
		JButton buttonSalir = new JButton("Salir");
		buttonSalir.setMargin(new Insets(2, 4, 2, 4));
		buttonSalir.setForeground(new Color(255, 255, 255));
		buttonSalir.setBackground(new Color(138, 43, 226));
		buttonSalir.setBorderPainted(false);
		buttonSalir.setBounds(255, 23, 67, 23);
		panelbotones.add(buttonSalir);
		buttonSalir.addActionListener(new ActionListener() {
			// Al dar al boton salir, se pide una confirmación de si quiere el usuario salir
			// del registro y se cierra el sistema.
			@Override
			public void actionPerformed(ActionEvent e) {
				int respuesta = JOptionPane.showConfirmDialog(contentPane, "Vas a salir del sistema...",
						"Cancelar registro", JOptionPane.OK_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE);
				if (respuesta == 0) {
					System.exit(0);
				}
			}
		});
	}

	/*
	 * Metodo de Rellenar Edad; Realiza un bucle rellenando las edades para la lista
	 * (entre 18 a 90 años).
	 */
	private void rellenarEdad() {
		for (int i = 18; i <= 90; i++) {
			listaEdad.addElement(i);
		}

	}

}
