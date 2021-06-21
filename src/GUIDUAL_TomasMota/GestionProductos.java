package GUIDUAL_TomasMota;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import javax.swing.SpringLayout;
import javax.swing.JButton;
import java.awt.GridBagLayout;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

import java.awt.Dimension;
import javax.swing.JTable;

@SuppressWarnings("serial")
public class GestionProductos extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private ArrayList<Productos> listaproductos = new ArrayList<Productos>();
	private String[] insertarproductos;
	private DefaultTableModel tableModel;
	private TableRowSorter<TableModel> sorter;
	public static GestionProductos frame;

	private String cabecera[] = { "Código", "Nombre", "Precio", "Descripción" };

	/**
	 * Creacion del frame.
	 */
	@SuppressWarnings("unchecked")
	public GestionProductos() {
		// Añadimos dos productos de ejemplos para que se visualicen en la tabla.
		listaproductos.add(new Productos("3", "Iphone 11", "856,00$", "Movil de Apple"));
		listaproductos.add(new Productos("2", "Xioami Mi9T", "426,00$", "Movil de Xiaomi"));
		// Capturamos el frame de la ventana.
		frame = (GestionProductos) SwingUtilities.getRoot(this);
		setResizable(false);
		setTitle("Gestion Productos");
		setName("Gestion Productos");
		// Icono que se pone para la esquina de la ventana
		setIconImage(Toolkit.getDefaultToolkit().getImage("images/iconosBotones/shoppingicon.png"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 464, 450);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(138, 43, 226));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[] { 432, 0 };
		gbl_contentPane.rowHeights = new int[] { 120, 120, 0 };
		gbl_contentPane.columnWeights = new double[] { 0.0, 1.0 };
		gbl_contentPane.rowWeights = new double[] { 1.0, 0.0, Double.MIN_VALUE };
		contentPane.setLayout(gbl_contentPane);

		// Panel principal para meter los datos necesarios.
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.gridwidth = 2;
		gbc_panel.insets = new Insets(0, 0, 5, 0);
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 0;
		contentPane.add(panel, gbc_panel);
		panel.setLayout(new BorderLayout(0, 0));

		// Creación de la tabla y asignación del modelo de este.
		table = new JTable(tableModel);
		table.setAutoCreateRowSorter(true);
		sorter = ((TableRowSorter<TableModel>) table.getRowSorter());
		table.setRowSorter(sorter);
		actualizarDatos(false);
		table.setCellSelectionEnabled(true);
		table.setBounds(30, 40, 200, 300);
		// Se asigna un scroll a la tabla.
		JScrollPane sp = new JScrollPane(table);
		sp.setOpaque(false);
		panel.add(sp);

		// Panel secundario para añadir los botones necesarios.
		JPanel panelbotones = new JPanel();
		panelbotones.setBackground(new Color(255, 255, 255));
		panelbotones.setBorder(new EmptyBorder(30, 0, 0, 0));
		GridBagConstraints gbc_panelbotones = new GridBagConstraints();
		gbc_panelbotones.gridwidth = 2;
		gbc_panelbotones.insets = new Insets(-5, 0, 5, 0);
		gbc_panelbotones.fill = GridBagConstraints.BOTH;
		gbc_panelbotones.gridx = 0;
		gbc_panelbotones.gridy = 1;
		contentPane.add(panelbotones, gbc_panelbotones);
		panelbotones.setLayout(null);

		// Botón para Insertar datos dentro de la tabla del Gestor de Productos
		// (Insertar).
		JButton buttonInsertar = new JButton("Insertar");
		buttonInsertar.setHorizontalTextPosition(SwingConstants.CENTER);
		buttonInsertar.setMargin(new Insets(2, 4, 2, 4));
		buttonInsertar.setBorderPainted(false);
		buttonInsertar.setForeground(Color.WHITE);
		buttonInsertar.setBackground(new Color(138, 43, 226));
		buttonInsertar.setBounds(69, 35, 63, 23);
		panelbotones.add(SpringLayout.WEST, buttonInsertar);
		buttonInsertar.addActionListener(new ActionListener() {

			// Creamos la ventana de Formulario de Productos y se cierra la anterior
			@Override
			public void actionPerformed(ActionEvent e) {
				FormularioProductos formularioProductos = new FormularioProductos(listaproductos, frame);
				formularioProductos.setVisible(true);
				setVisible(false);
				dispose();
			}
		});

		// Botón para Actualizar datos dentro de la tabla del Gestor de Productos
		// (Actualizar)
		JButton buttonActualizar = new JButton("Actualizar");
		buttonActualizar.setMaximumSize(new Dimension(100, 100));
		buttonActualizar.setMinimumSize(new Dimension(100, 100));
		buttonActualizar.setMargin(new Insets(2, 4, 2, 4));
		buttonActualizar.setBorderPainted(false);
		buttonActualizar.setForeground(Color.WHITE);
		buttonActualizar.setBackground(new Color(138, 43, 226));
		buttonActualizar.setBounds(182, 35, 75, 23);
		panelbotones.add(SpringLayout.HORIZONTAL_CENTER, buttonActualizar);
		buttonActualizar.addActionListener(new ActionListener() {

			// Si el usuario esta editando, se para la edición para que el cambio se
			// registre en el modelo de la tabla (tableModel).
			@Override
			public void actionPerformed(ActionEvent e) {
				if (table.getCellEditor() != null) {
					table.getCellEditor().stopCellEditing();
				}
				// Si los codigos son correctos, se actualiza.
				if (comprobarCodigo(null, null)) {
					JOptionPane.showMessageDialog(contentPane, "Usted ha actualizado el producto deseado",
							"Tabla Actualizada Correctamente", JOptionPane.INFORMATION_MESSAGE);
					// Se guarda los datos del modelo de la tabla (tableModel) al Array.
					guardarDatos();
				}
			}

		});

		// Botón para Borrar datos dentro de la tabla del Gestor de Productos
		// (Actualizar)
		JButton buttonBorrar = new JButton("Borrar");
		buttonBorrar.setMargin(new Insets(2, 4, 2, 4));
		buttonBorrar.setBorderPainted(false);
		buttonBorrar.setForeground(Color.WHITE);
		buttonBorrar.setBackground(new Color(138, 43, 226));
		buttonBorrar.setBounds(305, 35, 63, 23);
		panelbotones.add(SpringLayout.EAST, buttonBorrar);
		buttonBorrar.addActionListener(new ActionListener() {

			// Si el usuario quiere borrar un producto, capturamos la fila seleccionada para
			// saber que producto borrar
			public void actionPerformed(ActionEvent e) {
				// Si el usuario tiene una fila seleccionada.
				if (table.getSelectedRow() != -1) {
					listaproductos.remove(table.getSelectedRow());
					actualizarDatos(true);
					// Se avisa al tableModel que los datos de la tabla han sido modificados.
					tableModel.fireTableDataChanged();
					table.repaint();
					JOptionPane.showMessageDialog(contentPane, "El producto ha sido eliminado correctamente",
							"Exito al borrar", JOptionPane.INFORMATION_MESSAGE);
				} else {
					// En caso de no seleccionar ninguna fila, saltara este mensaje.
					JOptionPane.showMessageDialog(contentPane, "No se ha seleccionado el producto deseado",
							"Error al borrar", JOptionPane.ERROR_MESSAGE);
				}

			}
		});

	}

	/*
	 * Metodo de Actualizar Datos; Se inserta los datos en el tableModel a partir
	 * del Array de Productos.
	 */
	public void actualizarDatos(boolean actualizar) {
		// Se crea un tableModel de forma temporal.
		DefaultTableModel modelauxiliar = new DefaultTableModel(cabecera, 0);
		insertarproductos = new String[4];
		for (int i = 0; i < listaproductos.size(); i++) {
			insertarproductos[0] = (listaproductos.get(i).getCodigo());
			insertarproductos[1] = (listaproductos.get(i).getNombre());
			insertarproductos[2] = (listaproductos.get(i).getPrecio());
			insertarproductos[3] = (listaproductos.get(i).getDescripcion());
			modelauxiliar.addRow(insertarproductos);
		}
		// Se asigna ese tableModel al actual.
		tableModel = modelauxiliar;
		table.setModel(modelauxiliar);
		// Se ordena la tabla segun la columna de codigo.
		table.getRowSorter().toggleSortOrder(0);
	}

	/*
	 * Metodo de Comprobar Codigo; Se comprueba el codigo para saber si es igual aun
	 * producto ya creado o si esta vacio.
	 */
	public boolean comprobarCodigo(String codigoRegistro, JPanel panel) {
		for (int i = 0; i < listaproductos.size(); i++) {
			// La variable codigoRegistro sera distiinto de nulo solamente en el caso de
			// crear un nuevo producto.
			if (codigoRegistro == null) {
				// SOLO CASO DE EDITAR.
				// Se comprueba que el codigo de un producto ya existente no este vacio (caso de
				// Actualizar).
				if (tableModel.getValueAt(i, 0).toString().equals("")) {
					JOptionPane.showMessageDialog(contentPane, "El codigo no puede estar vacio",
							"Error al editar producto", JOptionPane.ERROR_MESSAGE);
					actualizarDatos(true);
					return false;
				} else {
					for (int j = (i + 1); j < listaproductos.size(); j++) {
						// Se comprueba que el codigo de un producto ya existente no sea igual que al
						// codigo de otro producto (caso de Actualizar).
						if ((tableModel.getValueAt(i, 0).toString()).equals(tableModel.getValueAt(j, 0).toString())) {
							JOptionPane.showMessageDialog(contentPane,
									"El codigo de " + (tableModel.getValueAt(i, 1).toString())
											+ " es igual al codigo de " + (tableModel.getValueAt(j, 1).toString()),
									"Error al editar producto", JOptionPane.ERROR_MESSAGE);
							actualizarDatos(true);
							return false;
						}
					}

				}
			} else {
				// SOLO CASO DE CREACION DE NUEVO PRODUCTO.
				// Se comprueba que el nuevo codigo no coincida con uno existente (caso de
				// Insertar).
				if ((tableModel.getValueAt(i, 0).toString()).equals(codigoRegistro)) {
					JOptionPane.showMessageDialog(panel,
							"El codigo es igual al codigo del producto:  " + (tableModel.getValueAt(i, 1).toString()),
							"Error al añadir producto", JOptionPane.ERROR_MESSAGE);
					return false;
				}
			}

		}

		return true;
	}

	/*
	 * Metodo de Guardar Datos; Se añade un nuevo producto a la tabla de Gestion.
	 */
	public void guardarDatos() {
		int i = 0;
		for (Productos listaproducto : listaproductos) {
			listaproducto.setCodigo(tableModel.getValueAt(i, 0).toString());
			listaproducto.setNombre(tableModel.getValueAt(i, 1).toString());
			listaproducto.setPrecio(tableModel.getValueAt(i, 2).toString());
			listaproducto.setDescripcion(tableModel.getValueAt(i, 3).toString());
			i++;
		}
	}

}
