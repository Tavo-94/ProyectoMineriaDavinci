package interfazWindowBuilder;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;

import negocio.ClienteDAO;
import negocio.DireccionDAO;
import negocio.MaterialDAO;
import negocio.TicketOperacionDAO;
import proyectoMineria.AdminVentas;
import proyectoMineria.Cliente;
import proyectoMineria.DireccionCliente;
import proyectoMineria.Material;
import proyectoMineria.TicketOperacion;

import javax.swing.JPanel;
import javax.swing.JSeparator;
import java.awt.Toolkit;
import java.awt.Choice;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class RealizarCompra {

	private JFrame frmRealizarCompra;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_9;
	private JTextField textField_10;
	private JTextField textField_11;
    private static AdminVentas adminVentasLogeado;


	/**
	 * Launch the application.
	 */
	public static void compra() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RealizarCompra window = new RealizarCompra(adminVentasLogeado);
					window.frmRealizarCompra.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public RealizarCompra(AdminVentas adminVentasLogeado) {
		initialize();
		RealizarCompra.adminVentasLogeado = adminVentasLogeado;
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmRealizarCompra = new JFrame();
		frmRealizarCompra.setResizable(false);
		frmRealizarCompra.setIconImage(Toolkit.getDefaultToolkit().getImage("D:\\carol\\casco-de-seguridad.png"));
		frmRealizarCompra.getContentPane().setBackground(Color.WHITE);
		frmRealizarCompra.setTitle("REALIZAR COMPRA");
		frmRealizarCompra.setBounds(100, 100, 1197, 515);
		frmRealizarCompra.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmRealizarCompra.getContentPane().setLayout(null);
		
		JLabel lblNewLabel_1_1_2 = new JLabel("REALIZAR COMPRA");
		lblNewLabel_1_1_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1_2.setFont(new Font("JetBrains Mono NL SemiBold", Font.PLAIN, 15));
		lblNewLabel_1_1_2.setBounds(0, 21, 1181, 23);
		frmRealizarCompra.getContentPane().add(lblNewLabel_1_1_2);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 1181, 61);
		frmRealizarCompra.getContentPane().add(panel);
		
		JSeparator separator_5 = new JSeparator();
		separator_5.setBounds(109, 186, 158, 2);
		frmRealizarCompra.getContentPane().add(separator_5);
		
		JLabel lblNewLabel_1_1 = new JLabel("PRODUCTO");
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1.setFont(new Font("JetBrains Mono NL SemiBold", Font.PLAIN, 15));
		lblNewLabel_1_1.setBounds(117, 157, 143, 23);
		frmRealizarCompra.getContentPane().add(lblNewLabel_1_1);
		
		JSeparator separator_3_2 = new JSeparator();
		separator_3_2.setOrientation(SwingConstants.VERTICAL);
		separator_3_2.setBounds(372, 11, 2, 519);
		frmRealizarCompra.getContentPane().add(separator_3_2);
		
		JLabel lblId = new JLabel("ID:");
		lblId.setHorizontalTextPosition(SwingConstants.RIGHT);
		lblId.setHorizontalAlignment(SwingConstants.RIGHT);
		lblId.setFont(new Font("JetBrains Mono NL", Font.PLAIN, 13));
		lblId.setBounds(21, 207, 78, 34);
		frmRealizarCompra.getContentPane().add(lblId);
		
		Choice choice = new Choice();
		choice.setBounds(109, 216, 95, 20);
		frmRealizarCompra.getContentPane().add(choice);
		
		JLabel lblNewLabel = new JLabel("Tipo:");
		lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel.setFont(new Font("JetBrains Mono NL", Font.PLAIN, 13));
		lblNewLabel.setBounds(21, 250, 78, 34);
		frmRealizarCompra.getContentPane().add(lblNewLabel);
		
		textField = new JTextField();
		textField.setToolTipText("Ingrese Nombre");
		textField.setSelectedTextColor(Color.WHITE);
		textField.setName("");
		textField.setColumns(10);
		textField.setBounds(109, 255, 218, 27);
		frmRealizarCompra.getContentPane().add(textField);
		
		JLabel lblApellido = new JLabel("Pureza:");
		lblApellido.setHorizontalAlignment(SwingConstants.RIGHT);
		lblApellido.setFont(new Font("JetBrains Mono NL", Font.PLAIN, 13));
		lblApellido.setBounds(22, 300, 78, 34);
		frmRealizarCompra.getContentPane().add(lblApellido);
		
		textField_1 = new JTextField();
		textField_1.setToolTipText("Ingrese Apellido");
		textField_1.setColumns(10);
		textField_1.setBounds(109, 303, 218, 27);
		frmRealizarCompra.getContentPane().add(textField_1);
		
		JLabel lblTelfono = new JLabel("Cantidad:");
		lblTelfono.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTelfono.setFont(new Font("JetBrains Mono NL", Font.PLAIN, 13));
		lblTelfono.setBounds(22, 345, 78, 34);
		frmRealizarCompra.getContentPane().add(lblTelfono);
		
		textField_2 = new JTextField();
		textField_2.setToolTipText("Ingrese Teléfono");
		textField_2.setColumns(10);
		textField_2.setBounds(109, 348, 218, 27);
		frmRealizarCompra.getContentPane().add(textField_2);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("D:\\carol\\caja.png"));
		lblNewLabel_1.setBounds(153, 74, 71, 77);
		frmRealizarCompra.getContentPane().add(lblNewLabel_1);
		
		Choice choice_1 = new Choice();
		choice_1.setBounds(491, 215, 95, 20);
		frmRealizarCompra.getContentPane().add(choice_1);
		
		JLabel lblId_1 = new JLabel("ID:");
		lblId_1.setHorizontalTextPosition(SwingConstants.RIGHT);
		lblId_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblId_1.setFont(new Font("JetBrains Mono NL", Font.PLAIN, 13));
		lblId_1.setBounds(403, 206, 78, 34);
		frmRealizarCompra.getContentPane().add(lblId_1);
		
		JLabel lblNewLabel_2 = new JLabel("Nombre:");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_2.setFont(new Font("JetBrains Mono NL", Font.PLAIN, 13));
		lblNewLabel_2.setBounds(403, 248, 78, 34);
		frmRealizarCompra.getContentPane().add(lblNewLabel_2);
		
		textField_3 = new JTextField();
		textField_3.setToolTipText("Ingrese Nombre");
		textField_3.setSelectedTextColor(Color.WHITE);
		textField_3.setName("");
		textField_3.setColumns(10);
		textField_3.setBounds(491, 253, 218, 27);
		frmRealizarCompra.getContentPane().add(textField_3);
		
		JLabel lblApellido_1 = new JLabel("Apellido:");
		lblApellido_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblApellido_1.setFont(new Font("JetBrains Mono NL", Font.PLAIN, 13));
		lblApellido_1.setBounds(404, 298, 78, 34);
		frmRealizarCompra.getContentPane().add(lblApellido_1);
		
		textField_4 = new JTextField();
		textField_4.setToolTipText("Ingrese Apellido");
		textField_4.setColumns(10);
		textField_4.setBounds(491, 301, 218, 27);
		frmRealizarCompra.getContentPane().add(textField_4);
		
		textField_5 = new JTextField();
		textField_5.setToolTipText("Ingrese Teléfono");
		textField_5.setColumns(10);
		textField_5.setBounds(491, 346, 218, 27);
		frmRealizarCompra.getContentPane().add(textField_5);
		
		JLabel lblTelfono_1 = new JLabel("Teléfono:");
		lblTelfono_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTelfono_1.setFont(new Font("JetBrains Mono NL", Font.PLAIN, 13));
		lblTelfono_1.setBounds(404, 343, 78, 34);
		frmRealizarCompra.getContentPane().add(lblTelfono_1);
		
		JLabel lblCalle = new JLabel("Calle:");
		lblCalle.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCalle.setFont(new Font("JetBrains Mono NL", Font.PLAIN, 13));
		lblCalle.setBounds(824, 110, 78, 34);
		frmRealizarCompra.getContentPane().add(lblCalle);
		
		textField_6 = new JTextField();
		textField_6.setToolTipText("Ingrese Nombre");
		textField_6.setSelectedTextColor(Color.WHITE);
		textField_6.setName("");
		textField_6.setColumns(10);
		textField_6.setBounds(912, 115, 218, 27);
		frmRealizarCompra.getContentPane().add(textField_6);
		
		JLabel lblNmero = new JLabel("Número:");
		lblNmero.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNmero.setFont(new Font("JetBrains Mono NL", Font.PLAIN, 13));
		lblNmero.setBounds(825, 160, 78, 34);
		frmRealizarCompra.getContentPane().add(lblNmero);
		
		textField_7 = new JTextField();
		textField_7.setToolTipText("Ingrese Apellido");
		textField_7.setColumns(10);
		textField_7.setBounds(912, 163, 218, 27);
		frmRealizarCompra.getContentPane().add(textField_7);
		
		JLabel lblPisodepto = new JLabel("Piso/Depto:");
		lblPisodepto.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPisodepto.setFont(new Font("JetBrains Mono NL", Font.PLAIN, 13));
		lblPisodepto.setBounds(807, 205, 96, 34);
		frmRealizarCompra.getContentPane().add(lblPisodepto);
		
		textField_8 = new JTextField();
		textField_8.setToolTipText("Ingrese Teléfono");
		textField_8.setColumns(10);
		textField_8.setBounds(912, 208, 218, 27);
		frmRealizarCompra.getContentPane().add(textField_8);
		
		JLabel lblTelfono_1_1 = new JLabel("Código Postal:");
		lblTelfono_1_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTelfono_1_1.setFont(new Font("JetBrains Mono NL", Font.PLAIN, 13));
		lblTelfono_1_1.setBounds(750, 255, 152, 34);
		frmRealizarCompra.getContentPane().add(lblTelfono_1_1);
		
		textField_9 = new JTextField();
		textField_9.setToolTipText("Ingrese Teléfono");
		textField_9.setColumns(10);
		textField_9.setBounds(911, 258, 218, 27);
		frmRealizarCompra.getContentPane().add(textField_9);
		
		JLabel lblTelfono_1_1_1 = new JLabel("ciudad:");
		lblTelfono_1_1_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTelfono_1_1_1.setFont(new Font("JetBrains Mono NL", Font.PLAIN, 13));
		lblTelfono_1_1_1.setBounds(795, 300, 108, 34);
		frmRealizarCompra.getContentPane().add(lblTelfono_1_1_1);
		
		textField_10 = new JTextField();
		textField_10.setToolTipText("Ingrese Teléfono");
		textField_10.setColumns(10);
		textField_10.setBounds(912, 305, 218, 27);
		frmRealizarCompra.getContentPane().add(textField_10);
		
		JLabel lblTelfono_1_1_1_1 = new JLabel("Localidad:");
		lblTelfono_1_1_1_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTelfono_1_1_1_1.setFont(new Font("JetBrains Mono NL", Font.PLAIN, 13));
		lblTelfono_1_1_1_1.setBounds(795, 345, 108, 34);
		frmRealizarCompra.getContentPane().add(lblTelfono_1_1_1_1);
		
		textField_11 = new JTextField();
		textField_11.setToolTipText("Ingrese Teléfono");
		textField_11.setColumns(10);
		textField_11.setBounds(912, 348, 218, 27);
		frmRealizarCompra.getContentPane().add(textField_11);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(485, 186, 192, 2);
		frmRealizarCompra.getContentPane().add(separator);
		
		JLabel lblCliente = new JLabel("CLIENTE");
		lblCliente.setHorizontalAlignment(SwingConstants.CENTER);
		lblCliente.setFont(new Font("JetBrains Mono SemiBold", Font.PLAIN, 15));
		lblCliente.setBounds(468, 147, 225, 34);
		frmRealizarCompra.getContentPane().add(lblCliente);
		
		JLabel lblNewLabel_1_2 = new JLabel("");
		lblNewLabel_1_2.setIcon(new ImageIcon("D:\\carol\\payment-method.png"));
		lblNewLabel_1_2.setBounds(545, 74, 71, 77);
		frmRealizarCompra.getContentPane().add(lblNewLabel_1_2);
		
		JButton btnAceptar = new JButton("ACEPTAR");
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//agrego datos del material a la tabla material_pedido
				String tipoMaterialComprado = textField.getText();
				String purezaMaterialComprado = textField_1.getText();
				
				Double cantidadMaterialComprado = Double.parseDouble(textField_2.getText());
				
				Material nuevoMaterialComprado = new Material(tipoMaterialComprado, purezaMaterialComprado, cantidadMaterialComprado);
				
				MaterialDAO matDAO = new MaterialDAO();
				
				matDAO.agregarNuevoMaterialPedido(nuevoMaterialComprado);
				
				
				
				nuevoMaterialComprado.setIdMaterial(matDAO.obtenerUltimoIDMaterialPedido());
				
				//agrego datos del cliente a la tabla cliente
				
				String nombreDelNuevoCliente = textField_3.getText();
				String apellidoDelNuevoCliente = textField_4.getText();
				String telefonoDelNuevoCliente = textField_5.getText();

				Cliente nuevoCliente = new Cliente(nombreDelNuevoCliente, apellidoDelNuevoCliente, telefonoDelNuevoCliente);
				
				ClienteDAO clienteDAO = new ClienteDAO();
				
				
				clienteDAO.agregarNuevoCliente(nuevoCliente, adminVentasLogeado);
				
				Integer ultimoIdCliente = clienteDAO.obtenerUltimoIDDeCliente();
				
				nuevoCliente.setIdCliente(ultimoIdCliente);
				
				//agrego datos de la direccion a la tabla direccion
				
				String direccionCalle = textField_6.getText();
				String direccionNumero = textField_7.getText();
				String direccionCodigoPostal = textField_9.getText();
				String direccionCiudad = textField_10.getText();
				
				DireccionCliente nuevaDireccion = new DireccionCliente(direccionCalle, direccionNumero, direccionCodigoPostal, direccionCiudad);
				
				nuevaDireccion.setIdCliente(ultimoIdCliente);
				
				DireccionDAO dirDAO = new DireccionDAO();
				
				dirDAO.agregarNuevadireccion(nuevaDireccion);
				
				//agrego un pedido nuevo
				
				TicketOperacion nuevaOperacion = new TicketOperacion(nuevoCliente, adminVentasLogeado, nuevoMaterialComprado);
				
				if (nuevoMaterialComprado.getPureza().equalsIgnoreCase("alta")) {
		            nuevaOperacion.setTotal(nuevoMaterialComprado.getPrecioBase() * nuevoMaterialComprado.getCantidad() * nuevoMaterialComprado.getCoeficientePurezaAlta());
					
		        } else if (nuevoMaterialComprado.getPureza().equalsIgnoreCase("media")) {
		            nuevaOperacion.setTotal(nuevoMaterialComprado.getPrecioBase() * nuevoMaterialComprado.getCantidad() * nuevoMaterialComprado.getCoeficientePurezaMedia());
		        } else {
		        	nuevaOperacion.setTotal(nuevoMaterialComprado.getPrecioBase() * nuevoMaterialComprado.getCantidad() * nuevoMaterialComprado.getCoeficientePurezaBaja());
		        }
				
				TicketOperacionDAO ticketDAO = new TicketOperacionDAO();
				
				ticketDAO.agregarNuevoTicketOperacionDelPedido(nuevaOperacion, adminVentasLogeado, nuevoCliente, nuevoMaterialComprado);
				
				JOptionPane.showMessageDialog(null, "se creo ticket exitosamente");
				
			}
		});
		btnAceptar.setBounds(468, 414, 87, 34);
		frmRealizarCompra.getContentPane().add(btnAceptar);
		
		JButton btnCancel = new JButton("CANCEL");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmRealizarCompra.dispose();
			}
		});
		btnCancel.setBounds(590, 414, 87, 34);
		frmRealizarCompra.getContentPane().add(btnCancel);
	}
}
