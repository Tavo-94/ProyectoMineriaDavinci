package interfazWindowBuilder;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import negocio.ClienteDAO;
import negocio.DireccionDAO;
import proyectoMineria.Cliente;
import proyectoMineria.DireccionCliente;

import java.awt.Choice;
import java.awt.Toolkit;

public class MODIFICARcliente {

	private JFrame frmAgregarCliente;
	private JTextField txtIngreseNombre;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField;
	private JTextField textField_3;
	private JTextField textField_5;
	private JTextField textField_7;
	private static DireccionCliente direccionDelCliente;
	private static Integer fila;
	private static Cliente clienteDeLaDB;

	/**
	 * Launch the application.
	 */
	public static void modifyCliente(Integer fila) {

		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MODIFICARcliente window = new MODIFICARcliente(fila);
					window.frmAgregarCliente.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 * 
	 * @param row
	 */
	
	
	public MODIFICARcliente(Integer row) {

		
		System.out.println("llegue al modificarcliente!!!");
		System.out.println(row);
		
		System.out.println(fila);

		ClienteDAO clienteDAO = new ClienteDAO();

		MODIFICARcliente.clienteDeLaDB = clienteDAO.obtenerDatosPorId(row);
		
		System.out.println(clienteDeLaDB);

		
		DireccionDAO direccionDAO = new DireccionDAO();
		
		MODIFICARcliente.direccionDelCliente = direccionDAO.obtenerTodosLosDatosPorId(MODIFICARcliente.clienteDeLaDB.getIdCliente());
		direccionDelCliente.setIdCliente(clienteDeLaDB.getIdCliente());
		
		System.out.println(direccionDelCliente);
		initialize();
		// seteo los datos de la table en el formulario

		
		

	}



	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmAgregarCliente = new JFrame();
		frmAgregarCliente.setIconImage(Toolkit.getDefaultToolkit().getImage(MODIFICARcliente.class.getResource("/img/icon.png")));
		frmAgregarCliente.getContentPane().setBackground(Color.WHITE);
		frmAgregarCliente.getContentPane().setForeground(Color.WHITE);
		frmAgregarCliente.setTitle("Modificar Cliente");
		frmAgregarCliente.setResizable(false);
		frmAgregarCliente.setBounds(100, 100, 406, 623);
		frmAgregarCliente.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmAgregarCliente.getContentPane().setLayout(null);

		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(MODIFICARcliente.class.getResource("/img/MODIFICAR.png")));
		lblNewLabel_1.setBounds(155, 25, 71, 77);
		frmAgregarCliente.getContentPane().add(lblNewLabel_1);

		JLabel lblNewLabel = new JLabel("Nombre:");
		lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel.setFont(new Font("JetBrains Mono NL", Font.PLAIN, 13));
		lblNewLabel.setBounds(33, 193, 78, 34);
		frmAgregarCliente.getContentPane().add(lblNewLabel);

		JLabel lblApellido = new JLabel("Apellido:");
		lblApellido.setHorizontalAlignment(SwingConstants.RIGHT);
		lblApellido.setFont(new Font("JetBrains Mono NL", Font.PLAIN, 13));
		lblApellido.setBounds(34, 243, 78, 34);
		frmAgregarCliente.getContentPane().add(lblApellido);

		JLabel lblTelfono = new JLabel("Teléfono:");
		lblTelfono.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTelfono.setFont(new Font("JetBrains Mono NL", Font.PLAIN, 13));
		lblTelfono.setBounds(34, 288, 78, 34);
		frmAgregarCliente.getContentPane().add(lblTelfono);

		JButton btnCancel = new JButton("CANCEL");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmAgregarCliente.dispose();
			}
		});
		btnCancel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnCancel.setBounds(200, 528, 87, 34);
		frmAgregarCliente.getContentPane().add(btnCancel);

		txtIngreseNombre = new JTextField();
		txtIngreseNombre.setToolTipText("Ingrese Nombre");
		txtIngreseNombre.setSelectedTextColor(Color.WHITE);
		txtIngreseNombre.setName("");
		txtIngreseNombre.setBounds(121, 198, 218, 27);
		frmAgregarCliente.getContentPane().add(txtIngreseNombre);
		txtIngreseNombre.setColumns(10);

		JButton btnAgregar = new JButton("ACEPTAR");
		btnAgregar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnAgregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				
				ClienteDAO clienteDAO = new ClienteDAO();
				DireccionDAO direccionDAO = new DireccionDAO();
				
				clienteDeLaDB.setNombre(txtIngreseNombre.getText());
				clienteDeLaDB.setApellido(textField_1.getText());
				clienteDeLaDB.setTelefono(textField_2.getText());
				
				clienteDAO.hacerUnUpdatePorId(clienteDeLaDB);

				direccionDelCliente.setCalle(textField.getText());
				direccionDelCliente.setAltura(textField_3.getText());
				direccionDelCliente.setCodigoPostal(textField_5.getText());
				direccionDelCliente.setCiudad(textField_7.getText());
				
				direccionDAO.hacerUnUpdatePorId(direccionDelCliente);
				
				JOptionPane.showMessageDialog(null, "Se modifico con exito!!!");
				
				frmAgregarCliente.dispose();

			}
		});
		btnAgregar.setBounds(101, 528, 87, 34);
		frmAgregarCliente.getContentPane().add(btnAgregar);

		textField_1 = new JTextField();
		textField_1.setToolTipText("Ingrese Apellido");
		textField_1.setColumns(10);
		textField_1.setBounds(121, 246, 218, 27);
		frmAgregarCliente.getContentPane().add(textField_1);

		textField_2 = new JTextField();
		textField_2.setToolTipText("Ingrese Teléfono");
		textField_2.setColumns(10);
		textField_2.setBounds(121, 291, 218, 27);
		frmAgregarCliente.getContentPane().add(textField_2);

		JLabel lblAgregarCliente = new JLabel("MODIFICAR CLIENTE");
		lblAgregarCliente.setHorizontalAlignment(SwingConstants.CENTER);
		lblAgregarCliente.setFont(new Font("JetBrains Mono SemiBold", Font.PLAIN, 15));
		lblAgregarCliente.setBounds(78, 98, 225, 34);
		frmAgregarCliente.getContentPane().add(lblAgregarCliente);

		JSeparator separator = new JSeparator();
		separator.setBounds(95, 137, 192, 2);
		frmAgregarCliente.getContentPane().add(separator);

		JLabel lblCalle = new JLabel("Calle:");
		lblCalle.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCalle.setFont(new Font("JetBrains Mono NL", Font.PLAIN, 13));
		lblCalle.setBounds(33, 333, 78, 34);
		frmAgregarCliente.getContentPane().add(lblCalle);

		textField = new JTextField();
		textField.setToolTipText("Ingrese Nombre");
		textField.setSelectedTextColor(Color.WHITE);
		textField.setName("");
		textField.setColumns(10);
		textField.setBounds(121, 338, 218, 27);
		frmAgregarCliente.getContentPane().add(textField);

		JLabel lblNmero = new JLabel("Altura: ");
		lblNmero.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNmero.setFont(new Font("JetBrains Mono NL", Font.PLAIN, 13));
		lblNmero.setBounds(34, 383, 78, 34);
		frmAgregarCliente.getContentPane().add(lblNmero);

		textField_3 = new JTextField();
		textField_3.setToolTipText("Ingrese Apellido");
		textField_3.setColumns(10);
		textField_3.setBounds(121, 386, 218, 27);
		frmAgregarCliente.getContentPane().add(textField_3);

		JLabel lblTelfono_1_1 = new JLabel("CP:");
		lblTelfono_1_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTelfono_1_1.setFont(new Font("JetBrains Mono NL", Font.PLAIN, 13));
		lblTelfono_1_1.setBounds(-40, 428, 152, 34);
		frmAgregarCliente.getContentPane().add(lblTelfono_1_1);

		textField_5 = new JTextField();
		textField_5.setToolTipText("Ingrese Teléfono");
		textField_5.setColumns(10);
		textField_5.setBounds(121, 431, 218, 27);
		frmAgregarCliente.getContentPane().add(textField_5);

		textField_7 = new JTextField();
		textField_7.setToolTipText("Ingrese Teléfono");
		textField_7.setColumns(10);
		textField_7.setBounds(121, 476, 218, 27);
		frmAgregarCliente.getContentPane().add(textField_7);

		JLabel lblTelfono_1_1_1_1 = new JLabel("Localidad:");
		lblTelfono_1_1_1_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTelfono_1_1_1_1.setFont(new Font("JetBrains Mono NL", Font.PLAIN, 13));
		lblTelfono_1_1_1_1.setBounds(4, 473, 108, 34);
		frmAgregarCliente.getContentPane().add(lblTelfono_1_1_1_1);
		
		// seteo los datos de la table en el formulario

		txtIngreseNombre.setText(clienteDeLaDB.getNombre());
		textField_1.setText(clienteDeLaDB.getApellido());
		textField_2.setText(clienteDeLaDB.getTelefono());
		textField.setText(direccionDelCliente.getCalle());
		textField_3.setText(direccionDelCliente.getAltura());
		textField_5.setText(direccionDelCliente.getCodigoPostal());
		textField_7.setText(direccionDelCliente.getCiudad());



	}

	public static DireccionCliente getDireccionDelCliente() {
		return direccionDelCliente;
	}

	public static void setDireccionDelCliente(DireccionCliente direccionDelCliente) {
		MODIFICARcliente.direccionDelCliente = direccionDelCliente;
	}

	public static Integer getFila() {
		return fila;
	}

	public static void setFila(Integer fila) {
		MODIFICARcliente.fila = fila;
	}

	public static Cliente getClienteDeLaDB() {
		return clienteDeLaDB;
	}

	public static void setClienteDeLaDB(Cliente clienteDeLaDB) {
		MODIFICARcliente.clienteDeLaDB = clienteDeLaDB;
	}
}
