package GUIDUAL_TomasMota;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextArea;
import java.awt.Font;

@SuppressWarnings("serial")
public class FormularioProductos extends JFrame {

	private JPanel contentPane;
	private JTextField textCodigo;
	private JTextField textNombre;
	private JTextField textPrecio;

	/**
	 * Creacion del frame.
	 */
	public FormularioProductos(ArrayList<Productos> productos, GestionProductos gestionproductos) {
		// Se recibe la lista de productos y la ventana de Gestion de Productos.
		// Configuración de la ventana de Formulario de Registro de Productos.
		setResizable(false);
		setTitle("Registro de Productos");
		setName("Registro de Productos");
		// Icono que se pone para la esquina de la ventana.
		setIconImage(Toolkit.getDefaultToolkit().getImage("images/iconosBotones/shopping_register.png"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 464, 450);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(138, 43, 226));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setAlignmentY(Component.BOTTOM_ALIGNMENT);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[] { 438, 0 };
		gbl_contentPane.rowHeights = new int[] { 250, 70, 0, 0 };
		gbl_contentPane.columnWeights = new double[] { 1.0, Double.MIN_VALUE };
		gbl_contentPane.rowWeights = new double[] { 1.0, 1.0, 1.0, Double.MIN_VALUE };
		contentPane.setLayout(gbl_contentPane);

		// Panel principal para meter los datos necesarios.
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		panel.setMinimumSize(new Dimension(30, 30));
		panel.setSize(new Dimension(50, 50));
		panel.setMaximumSize(new Dimension(8, 8));
		panel.setAlignmentY(7.0f);
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.fill = GridBagConstraints.HORIZONTAL;
		gbc_panel.insets = new Insets(0, 0, 5, 0);
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 0;
		contentPane.add(panel, gbc_panel);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[] { 136, 136, 90 };
		gbl_panel.rowHeights = new int[] { 30, 30, 30, 30, 30, 30, 30 };
		gbl_panel.columnWeights = new double[] { 0.0, 1.0, 1.0 };
		gbl_panel.rowWeights = new double[] { 1.0, 0.0, 0.0, 1.0 };
		panel.setLayout(gbl_panel);

		// Label para el Codigo del Producto.
		JLabel lblCodigo = new JLabel("Código");
		lblCodigo.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCodigo.setHorizontalTextPosition(SwingConstants.RIGHT);
		GridBagConstraints gbc_lblCodigo = new GridBagConstraints();
		gbc_lblCodigo.anchor = GridBagConstraints.EAST;
		gbc_lblCodigo.insets = new Insets(0, 0, 5, 5);
		gbc_lblCodigo.gridx = 0;
		gbc_lblCodigo.gridy = 0;
		panel.add(lblCodigo, gbc_lblCodigo);

		// Casilla de texto para poner el Codigo del Producto.
		textCodigo = new JTextField();
		GridBagConstraints gbc_textCodigo = new GridBagConstraints();
		gbc_textCodigo.insets = new Insets(0, 0, 5, 5);
		gbc_textCodigo.fill = GridBagConstraints.HORIZONTAL;
		gbc_textCodigo.gridx = 1;
		gbc_textCodigo.gridy = 0;
		panel.add(textCodigo, gbc_textCodigo);
		textCodigo.setColumns(10);

		// Label para el Nombre del producto a registrar.
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNombre.setHorizontalTextPosition(SwingConstants.RIGHT);
		GridBagConstraints gbc_lblNombre = new GridBagConstraints();
		gbc_lblNombre.anchor = GridBagConstraints.EAST;
		gbc_lblNombre.insets = new Insets(0, 0, 5, 5);
		gbc_lblNombre.gridx = 0;
		gbc_lblNombre.gridy = 1;
		panel.add(lblNombre, gbc_lblNombre);

		// Casilla de texto para poner el nombre del producto a registrar.
		textNombre = new JTextField();
		GridBagConstraints gbc_textNombre = new GridBagConstraints();
		gbc_textNombre.insets = new Insets(0, 0, 5, 5);
		gbc_textNombre.fill = GridBagConstraints.HORIZONTAL;
		gbc_textNombre.gridx = 1;
		gbc_textNombre.gridy = 1;
		panel.add(textNombre, gbc_textNombre);
		textNombre.setColumns(10);

		// Label para el precio del producto a registrar.
		JLabel lblPrecio = new JLabel("Precio");
		lblPrecio.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPrecio.setHorizontalTextPosition(SwingConstants.RIGHT);
		GridBagConstraints gbc_lblPrecio = new GridBagConstraints();
		gbc_lblPrecio.anchor = GridBagConstraints.EAST;
		gbc_lblPrecio.insets = new Insets(0, 0, 5, 5);
		gbc_lblPrecio.gridx = 0;
		gbc_lblPrecio.gridy = 2;
		panel.add(lblPrecio, gbc_lblPrecio);

		// Casilla de texto para poner el precio del producto a registrar.
		textPrecio = new JTextField();
		GridBagConstraints gbc_textPrecio = new GridBagConstraints();
		gbc_textPrecio.insets = new Insets(0, 0, 5, 5);
		gbc_textPrecio.fill = GridBagConstraints.HORIZONTAL;
		gbc_textPrecio.gridx = 1;
		gbc_textPrecio.gridy = 2;
		panel.add(textPrecio, gbc_textPrecio);
		textPrecio.setColumns(10);

		// Label para poner la descripcion del producto a registrar.
		JLabel lblDescripcion = new JLabel("Descripción");
		GridBagConstraints gbc_lblDescripcion = new GridBagConstraints();
		gbc_lblDescripcion.insets = new Insets(0, 0, 5, 5);
		gbc_lblDescripcion.anchor = GridBagConstraints.EAST;
		gbc_lblDescripcion.gridx = 0;
		gbc_lblDescripcion.gridy = 3;
		panel.add(lblDescripcion, gbc_lblDescripcion);

		// Casilla de texto con un tamaño especifico de filas y columnas para poner la descripcion del producto a registrar.
		JTextArea textDescripcion = new JTextArea();
		textDescripcion.setColumns(5);
		textDescripcion.setRows(4);
		GridBagConstraints gbc_textDescripcion = new GridBagConstraints();
		gbc_textDescripcion.gridheight = 3;
		gbc_textDescripcion.insets = new Insets(0, 0, 5, 5);
		gbc_textDescripcion.fill = GridBagConstraints.BOTH;
		gbc_textDescripcion.gridx = 1;
		gbc_textDescripcion.gridy = 3;
		textDescripcion.setBorder(BorderFactory.createLineBorder(Color.lightGray));
		panel.add(textDescripcion, gbc_textDescripcion);

		// Panel secundario para añadir los botones necesarios.
		JPanel panelbotones = new JPanel();
		panelbotones.setBackground(new Color(255, 255, 255));
		panelbotones.setBorder(new EmptyBorder(30, 0, 0, 0));
		GridBagConstraints gbc_panelbotones = new GridBagConstraints();
		gbc_panelbotones.insets = new Insets(0, 0, 5, 0);
		gbc_panelbotones.fill = GridBagConstraints.BOTH;
		gbc_panelbotones.gridx = 0;
		gbc_panelbotones.gridy = 1;
		contentPane.add(panelbotones, gbc_panelbotones);
		panelbotones.setLayout(null);

		// Botón para darse de Alta dentro del Registro de Productos (Aceptar).
		JButton buttonAceptar = new JButton("Aceptar");
		buttonAceptar.setMargin(new Insets(2, 4, 2, 4));
		buttonAceptar.setBorderPainted(false);
		buttonAceptar.setForeground(Color.WHITE);
		buttonAceptar.setBackground(new Color(138, 43, 226));
		buttonAceptar.setBounds(128, 23, 63, 23);
		panelbotones.add(buttonAceptar);
		buttonAceptar.addActionListener(new ActionListener() {
			// Si el usuario registra el producto y finaliza todos los datos necesario, se comprueba si la respuesta es valida
			@Override
			public void actionPerformed(ActionEvent e) {
				if (textCodigo.getText().equals("")) {
					JOptionPane.showMessageDialog(contentPane,"El codigo del registro no puede estar vacio",
							"Error al añadir producto", JOptionPane.ERROR_MESSAGE);
				} else {
					// En el caso de estar todo correcto, se registra el producto.
					if (gestionproductos.comprobarCodigo(textCodigo.getText(),contentPane)) {
						JOptionPane.showMessageDialog(contentPane, "Producto registrado con exito",
								"Exito al registrar productos", JOptionPane.INFORMATION_MESSAGE);
						// Se crea un nuevo producto.
						Productos p = new Productos();
						p.setCodigo(textCodigo.getText());
						p.setNombre(textNombre.getText());
						p.setPrecio(textPrecio.getText());
						p.setDescripcion(textDescripcion.getText());
						// Se añade el nuevo producto.
						productos.add(p);
						// Se vuelve a la pantalla anterior (Gestion de Productos) y se cierra esta (Registro de Productos).
						gestionproductos.setVisible(true);
						gestionproductos.actualizarDatos(true);
						setVisible(false);
						dispose();
					}
				}
			}
		});

		// Botón para salir del Registro y volver al Gestor (Salir).
		JButton buttonSalir = new JButton("Salir");
		buttonSalir.setMargin(new Insets(2, 4, 2, 4));
		buttonSalir.setForeground(new Color(255, 255, 255));
		buttonSalir.setBackground(new Color(138, 43, 226));
		buttonSalir.setBorderPainted(false);
		buttonSalir.setBounds(247, 23, 67, 23);
		panelbotones.add(buttonSalir);
		buttonSalir.addActionListener(new ActionListener() {
			// Al dar al boton salir, se pide una confirmación de si quiere el usuario salir
			// del registro de productos y se vuelve a la ventana anterior.
			@Override
			public void actionPerformed(ActionEvent e) {
				int respuesta = JOptionPane.showConfirmDialog(contentPane, "Vas a salir del registro de productos...",
						"Cancelar registro de productos", JOptionPane.OK_CANCEL_OPTION,
						JOptionPane.INFORMATION_MESSAGE);
				if (respuesta == 0) {
					gestionproductos.setVisible(true);
					setVisible(false);
					dispose();
				}
			}
		});

		// Label de texto para saber quien ha hecho el sistema.
		JLabel lblHechoporTomas = new JLabel("Sistema hecho por Tomás Mota");
		lblHechoporTomas.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 16));
		lblHechoporTomas.setForeground(new Color(255, 255, 255));
		GridBagConstraints gbc_lblHechoporTomas = new GridBagConstraints();
		gbc_lblHechoporTomas.anchor = GridBagConstraints.SOUTH;
		gbc_lblHechoporTomas.gridx = 0;
		gbc_lblHechoporTomas.gridy = 2;
		contentPane.add(lblHechoporTomas, gbc_lblHechoporTomas);
	}

}
