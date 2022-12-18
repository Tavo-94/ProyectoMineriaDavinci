package interfazWindowBuilder;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.SwingConstants;

import negocio.ClienteDAO;
import negocio.DireccionDAO;
import proyectoMineria.AdminVentas;
import proyectoMineria.Cliente;
import proyectoMineria.DireccionCliente;

import javax.swing.JSeparator;
import java.awt.Cursor;
import java.awt.Toolkit;

public class AGREGARcliente {

	private JFrame frmAgregarCliente;
	private JTextField txtIngreseNombre;
	private JTextField textIngreseApellido;
	private JTextField textIngreseTelefono;
	private JTextField textIngreseCalle;
	private JTextField textIngreseNumero;
	private JTextField textIngreseCP;
	private JTextField textIngreseLocalidad;
	private static AdminVentas adminLogueado;


	/**
	 * Launch the application.
	 */
	public static void addCliente() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AGREGARcliente window = new AGREGARcliente(adminLogueado);
					window.frmAgregarCliente.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 * @param adminVentasLogeado 
	 */
	public AGREGARcliente(AdminVentas adminVentasLogeado) {
		initialize();
		this.adminLogueado = adminVentasLogeado;
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmAgregarCliente = new JFrame();
		frmAgregarCliente.setIconImage(Toolkit.getDefaultToolkit().getImage("D:\\carol\\casco-de-seguridad.png"));
		frmAgregarCliente.getContentPane().setBackground(Color.WHITE);
		frmAgregarCliente.getContentPane().setForeground(Color.WHITE);
		frmAgregarCliente.setTitle("Agregar Cliente");
		frmAgregarCliente.setResizable(false);
		frmAgregarCliente.setBounds(100, 100, 811, 439);
		frmAgregarCliente.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmAgregarCliente.getContentPane().setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("");
        lblNewLabel_1.setIcon(new ImageIcon("D:\\carol\\add-user.png"));
        lblNewLabel_1.setBounds(155, 25, 71, 77);
        frmAgregarCliente.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel = new JLabel("Nombre:");
		lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel.setFont(new Font("JetBrains Mono NL", Font.PLAIN, 13));
		lblNewLabel.setBounds(31, 156, 78, 34);
		frmAgregarCliente.getContentPane().add(lblNewLabel);
		
		JLabel lblApellido = new JLabel("Apellido:");
		lblApellido.setHorizontalAlignment(SwingConstants.RIGHT);
		lblApellido.setFont(new Font("JetBrains Mono NL", Font.PLAIN, 13));
		lblApellido.setBounds(32, 206, 78, 34);
		frmAgregarCliente.getContentPane().add(lblApellido);
		
		JLabel lblTelfono = new JLabel("Teléfono:");
		lblTelfono.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTelfono.setFont(new Font("JetBrains Mono NL", Font.PLAIN, 13));
		lblTelfono.setBounds(32, 251, 78, 34);
		frmAgregarCliente.getContentPane().add(lblTelfono);
		
		JButton btnCancel = new JButton("CANCEL");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmAgregarCliente.dispose();
			}
		});
		btnCancel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnCancel.setBounds(398, 343, 87, 34);
		frmAgregarCliente.getContentPane().add(btnCancel);
		
		JButton btnAgregar = new JButton("AGREGAR");
		btnAgregar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnAgregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String nombreDCliente = txtIngreseNombre.getText();
				String apellidoDCliente = textIngreseApellido.getText();
				String telefonoCliente = textIngreseTelefono.getText();
				
				Cliente nuevoCliente = new Cliente(nombreDCliente, apellidoDCliente, telefonoCliente);
				
				ClienteDAO clienteDAO = new ClienteDAO();
				
				clienteDAO.agregarNuevoCliente(nuevoCliente, adminLogueado);
				
				Integer idDelClienteIngresado = clienteDAO.obtenerUltimoIDDeCliente();
				
				String calleCliente = textIngreseCalle.getText();
				String numeroCliente = textIngreseNumero.getText();
				//String deptoCliente = textIngreseDepto.getText();
				String CPCliente = textIngreseCP.getText();
				//String provinciaCliente = textIngreseProvincia.getText();
				String localidadCliente = textIngreseLocalidad.getText();
				
				DireccionCliente nuevaDireccion = new DireccionCliente(calleCliente, numeroCliente, CPCliente, localidadCliente);
				
				nuevaDireccion.setIdCliente(idDelClienteIngresado);
				
				DireccionDAO direccionCliente = new DireccionDAO();
				
				direccionCliente.agregarNuevadireccion(nuevaDireccion);
				
				
				JOptionPane.showMessageDialog(null, "Se agrego exitosamente");
				
				frmAgregarCliente.setVisible(false);
				//String 
				
			}
		});
		btnAgregar.setBounds(276, 343, 87, 34);
		frmAgregarCliente.getContentPane().add(btnAgregar);
		
		txtIngreseNombre = new JTextField();
		txtIngreseNombre.setToolTipText("Ingrese Nombre");
		txtIngreseNombre.setSelectedTextColor(Color.WHITE);
		txtIngreseNombre.setName("");
		txtIngreseNombre.setBounds(119, 161, 218, 27);
		frmAgregarCliente.getContentPane().add(txtIngreseNombre);
		txtIngreseNombre.setColumns(10);
		
		
		
		textIngreseApellido = new JTextField();
		textIngreseApellido.setToolTipText("Ingrese Apellido");
		textIngreseApellido.setColumns(10);
		textIngreseApellido.setBounds(119, 209, 218, 27);
		frmAgregarCliente.getContentPane().add(textIngreseApellido);
		
		textIngreseTelefono = new JTextField();
		textIngreseTelefono.setToolTipText("Ingrese Teléfono");
		textIngreseTelefono.setColumns(10);
		textIngreseTelefono.setBounds(119, 254, 218, 27);
		frmAgregarCliente.getContentPane().add(textIngreseTelefono);
		
		JLabel lblAgregarCliente = new JLabel("AGREGAR CLIENTE");
		lblAgregarCliente.setHorizontalAlignment(SwingConstants.CENTER);
		lblAgregarCliente.setFont(new Font("JetBrains Mono SemiBold", Font.PLAIN, 15));
		lblAgregarCliente.setBounds(78, 98, 225, 34);
		frmAgregarCliente.getContentPane().add(lblAgregarCliente);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(95, 137, 192, 2);
		frmAgregarCliente.getContentPane().add(separator);
		
		JSeparator separator_3_2 = new JSeparator();
		separator_3_2.setOrientation(SwingConstants.VERTICAL);
		separator_3_2.setBounds(380, 25, 2, 298);
		frmAgregarCliente.getContentPane().add(separator_3_2);
		
		JLabel lblCalle = new JLabel("Calle:");
		lblCalle.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCalle.setFont(new Font("JetBrains Mono NL", Font.PLAIN, 13));
		lblCalle.setBounds(454, 43, 78, 34);
		frmAgregarCliente.getContentPane().add(lblCalle);
		
		textIngreseCalle = new JTextField();
		textIngreseCalle.setToolTipText("Ingrese Calle");
		textIngreseCalle.setSelectedTextColor(Color.WHITE);
		textIngreseCalle.setName("");
		textIngreseCalle.setColumns(10);
		textIngreseCalle.setBounds(542, 48, 218, 27);
		frmAgregarCliente.getContentPane().add(textIngreseCalle);
		
		JLabel lblNmero = new JLabel("Altura:");
		lblNmero.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNmero.setFont(new Font("JetBrains Mono NL", Font.PLAIN, 13));
		lblNmero.setBounds(455, 93, 78, 34);
		frmAgregarCliente.getContentPane().add(lblNmero);
		
		textIngreseNumero = new JTextField();
		textIngreseNumero.setToolTipText("Ingrese Numero");
		textIngreseNumero.setColumns(10);
		textIngreseNumero.setBounds(542, 96, 218, 27);
		frmAgregarCliente.getContentPane().add(textIngreseNumero);
		
		JLabel lblTelfono_1_1 = new JLabel("Código Postal:");
		lblTelfono_1_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTelfono_1_1.setFont(new Font("JetBrains Mono NL", Font.PLAIN, 13));
		lblTelfono_1_1.setBounds(380, 188, 152, 34);
		frmAgregarCliente.getContentPane().add(lblTelfono_1_1);
		
		textIngreseCP = new JTextField();
		textIngreseCP.setToolTipText("Ingrese CP");
		textIngreseCP.setColumns(10);
		textIngreseCP.setBounds(541, 191, 218, 27);
		frmAgregarCliente.getContentPane().add(textIngreseCP);
		
		textIngreseLocalidad = new JTextField();
		textIngreseLocalidad.setToolTipText("Ingrese Localidad");
		textIngreseLocalidad.setColumns(10);
		textIngreseLocalidad.setBounds(542, 281, 218, 27);
		frmAgregarCliente.getContentPane().add(textIngreseLocalidad);
		
		JLabel lblTelfono_1_1_1_1 = new JLabel("Localidad:");
		lblTelfono_1_1_1_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTelfono_1_1_1_1.setFont(new Font("JetBrains Mono NL", Font.PLAIN, 13));
		lblTelfono_1_1_1_1.setBounds(425, 278, 108, 34);
		frmAgregarCliente.getContentPane().add(lblTelfono_1_1_1_1);
	}
}
