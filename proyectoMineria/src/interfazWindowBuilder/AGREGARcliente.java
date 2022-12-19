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
		frmAgregarCliente.setIconImage(Toolkit.getDefaultToolkit().getImage(AGREGARcliente.class.getResource("/img/icon.png")));
		frmAgregarCliente.getContentPane().setBackground(Color.WHITE);
		frmAgregarCliente.getContentPane().setForeground(Color.WHITE);
		frmAgregarCliente.setTitle("Agregar Cliente");
		frmAgregarCliente.setResizable(false);
		frmAgregarCliente.setBounds(100, 100, 422, 583);
		frmAgregarCliente.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmAgregarCliente.getContentPane().setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("");
        lblNewLabel_1.setIcon(new ImageIcon(AGREGARcliente.class.getResource("/img/AGREGARuser.png")));
        lblNewLabel_1.setBounds(187, 29, 71, 77);
        frmAgregarCliente.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel = new JLabel("Nombre:");
		lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel.setFont(new Font("JetBrains Mono NL", Font.PLAIN, 13));
		lblNewLabel.setBounds(55, 157, 78, 34);
		frmAgregarCliente.getContentPane().add(lblNewLabel);
		
		JLabel lblApellido = new JLabel("Apellido:");
		lblApellido.setHorizontalAlignment(SwingConstants.RIGHT);
		lblApellido.setFont(new Font("JetBrains Mono NL", Font.PLAIN, 13));
		lblApellido.setBounds(56, 207, 78, 34);
		frmAgregarCliente.getContentPane().add(lblApellido);
		
		JLabel lblTelfono = new JLabel("Teléfono:");
		lblTelfono.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTelfono.setFont(new Font("JetBrains Mono NL", Font.PLAIN, 13));
		lblTelfono.setBounds(56, 252, 78, 34);
		frmAgregarCliente.getContentPane().add(lblTelfono);
		
		JButton btnCancel = new JButton("CANCEL");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmAgregarCliente.dispose();
			}
		});
		btnCancel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnCancel.setBounds(240, 495, 87, 34);
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
		btnAgregar.setBounds(118, 495, 87, 34);
		frmAgregarCliente.getContentPane().add(btnAgregar);
		
		txtIngreseNombre = new JTextField();
		txtIngreseNombre.setToolTipText("Ingrese Nombre");
		txtIngreseNombre.setSelectedTextColor(Color.WHITE);
		txtIngreseNombre.setName("");
		txtIngreseNombre.setBounds(143, 162, 218, 27);
		frmAgregarCliente.getContentPane().add(txtIngreseNombre);
		txtIngreseNombre.setColumns(10);
		
		
		
		textIngreseApellido = new JTextField();
		textIngreseApellido.setToolTipText("Ingrese Apellido");
		textIngreseApellido.setColumns(10);
		textIngreseApellido.setBounds(143, 210, 218, 27);
		frmAgregarCliente.getContentPane().add(textIngreseApellido);
		
		textIngreseTelefono = new JTextField();
		textIngreseTelefono.setToolTipText("Ingrese Teléfono");
		textIngreseTelefono.setColumns(10);
		textIngreseTelefono.setBounds(143, 255, 218, 27);
		frmAgregarCliente.getContentPane().add(textIngreseTelefono);
		
		JLabel lblAgregarCliente = new JLabel("AGREGAR CLIENTE");
		lblAgregarCliente.setHorizontalAlignment(SwingConstants.CENTER);
		lblAgregarCliente.setFont(new Font("JetBrains Mono SemiBold", Font.PLAIN, 15));
		lblAgregarCliente.setBounds(110, 102, 225, 34);
		frmAgregarCliente.getContentPane().add(lblAgregarCliente);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(127, 141, 192, 2);
		frmAgregarCliente.getContentPane().add(separator);
		
		JLabel lblCalle = new JLabel("Calle:");
		lblCalle.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCalle.setFont(new Font("JetBrains Mono NL", Font.PLAIN, 13));
		lblCalle.setBounds(55, 297, 78, 34);
		frmAgregarCliente.getContentPane().add(lblCalle);
		
		textIngreseCalle = new JTextField();
		textIngreseCalle.setToolTipText("Ingrese Calle");
		textIngreseCalle.setSelectedTextColor(Color.WHITE);
		textIngreseCalle.setName("");
		textIngreseCalle.setColumns(10);
		textIngreseCalle.setBounds(143, 302, 218, 27);
		frmAgregarCliente.getContentPane().add(textIngreseCalle);
		
		JLabel lblNmero = new JLabel("Altura:");
		lblNmero.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNmero.setFont(new Font("JetBrains Mono NL", Font.PLAIN, 13));
		lblNmero.setBounds(56, 347, 78, 34);
		frmAgregarCliente.getContentPane().add(lblNmero);
		
		textIngreseNumero = new JTextField();
		textIngreseNumero.setToolTipText("Ingrese Numero");
		textIngreseNumero.setColumns(10);
		textIngreseNumero.setBounds(143, 350, 218, 27);
		frmAgregarCliente.getContentPane().add(textIngreseNumero);
		
		JLabel lblTelfono_1_1 = new JLabel("Código Postal:");
		lblTelfono_1_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTelfono_1_1.setFont(new Font("JetBrains Mono NL", Font.PLAIN, 13));
		lblTelfono_1_1.setBounds(-19, 392, 152, 34);
		frmAgregarCliente.getContentPane().add(lblTelfono_1_1);
		
		textIngreseCP = new JTextField();
		textIngreseCP.setToolTipText("Ingrese CP");
		textIngreseCP.setColumns(10);
		textIngreseCP.setBounds(142, 395, 218, 27);
		frmAgregarCliente.getContentPane().add(textIngreseCP);
		
		textIngreseLocalidad = new JTextField();
		textIngreseLocalidad.setToolTipText("Ingrese Localidad");
		textIngreseLocalidad.setColumns(10);
		textIngreseLocalidad.setBounds(143, 440, 218, 27);
		frmAgregarCliente.getContentPane().add(textIngreseLocalidad);
		
		JLabel lblTelfono_1_1_1_1 = new JLabel("Localidad:");
		lblTelfono_1_1_1_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTelfono_1_1_1_1.setFont(new Font("JetBrains Mono NL", Font.PLAIN, 13));
		lblTelfono_1_1_1_1.setBounds(26, 437, 108, 34);
		frmAgregarCliente.getContentPane().add(lblTelfono_1_1_1_1);
	}
}
