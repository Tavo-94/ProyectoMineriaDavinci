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

import negocio.AdminStockDAO;
import negocio.AdminVentasDao;
import proyectoMineria.AdminSistema;
import proyectoMineria.AdminStock;
import proyectoMineria.AdminVentas;

import java.awt.Choice;
import java.awt.Toolkit;

public class AGREGARadminstock {


	private JFrame frmAgregarAdminStock;
	private JTextField txtIngreseNombre;
	private JTextField textField_1;
	private JTextField textField;
	private JTextField textField_3;
    private static AdminSistema adminSistemaLogeado;


	/**
	 * Launch the application.
	 */
	public static void addAdminStock() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AGREGARadminstock window = new AGREGARadminstock(adminSistemaLogeado);
					window.frmAgregarAdminStock.setVisible(true);
					
					System.out.println(adminSistemaLogeado);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public AGREGARadminstock(AdminSistema adminSistemaLogeado) {
		initialize();
		this.adminSistemaLogeado = adminSistemaLogeado;

	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmAgregarAdminStock = new JFrame();
		frmAgregarAdminStock.setIconImage(Toolkit.getDefaultToolkit().getImage(AGREGARadminstock.class.getResource("/img/icon.png")));
		frmAgregarAdminStock.getContentPane().setBackground(Color.WHITE);
		frmAgregarAdminStock.getContentPane().setForeground(Color.WHITE);
		frmAgregarAdminStock.setTitle("Agregar Admin Stock");
		frmAgregarAdminStock.setResizable(false);
		frmAgregarAdminStock.setBounds(100, 100, 410, 528);
		frmAgregarAdminStock.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmAgregarAdminStock.getContentPane().setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("");
        lblNewLabel_1.setIcon(new ImageIcon(AGREGARadminstock.class.getResource("/img/AGREGARuser.png")));
        lblNewLabel_1.setBounds(159, 27, 71, 77);
        frmAgregarAdminStock.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel = new JLabel("Nombre:");
		lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel.setFont(new Font("JetBrains Mono NL", Font.PLAIN, 13));
		lblNewLabel.setBounds(38, 268, 78, 34);
		frmAgregarAdminStock.getContentPane().add(lblNewLabel);
		
		JLabel lblApellido = new JLabel("Apellido:");
		lblApellido.setHorizontalAlignment(SwingConstants.RIGHT);
		lblApellido.setFont(new Font("JetBrains Mono NL", Font.PLAIN, 13));
		lblApellido.setBounds(39, 318, 78, 34);
		frmAgregarAdminStock.getContentPane().add(lblApellido);
		
		JButton btnCancel = new JButton("CANCEL");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmAgregarAdminStock.dispose();
			}
		});
		btnCancel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnCancel.setBounds(220, 419, 87, 34);
		frmAgregarAdminStock.getContentPane().add(btnCancel);
		
		txtIngreseNombre = new JTextField();
		txtIngreseNombre.setToolTipText("Ingrese Nombre");
		txtIngreseNombre.setSelectedTextColor(Color.WHITE);
		txtIngreseNombre.setName("");
		txtIngreseNombre.setBounds(126, 273, 218, 27);
		frmAgregarAdminStock.getContentPane().add(txtIngreseNombre);
		txtIngreseNombre.setColumns(10);
		
		JButton btnAgregar = new JButton("ACEPTAR");
		btnAgregar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnAgregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//obtengo los datos del formulario
				
				/*
				 * ACA agregar validaciones para los input !!!!
				 * 
				 * */
				
				String nombreDeUsuario = textField_3.getText();
				String clave = textField.getText();
				String nombre = txtIngreseNombre.getText();
				String apellido = textField_1.getText();
				
				//creo el admin ventas en base a los datos del formulario
				
				// Hardcodeo 1 como idDeposito
				
				AdminStock nuevoAdminStock = new AdminStock(nombre, apellido, nombreDeUsuario, clave, 1);
				
				AdminStockDAO stockDAO = new AdminStockDAO();
				
				stockDAO.agregarNuevoAdminStock(nuevoAdminStock, adminSistemaLogeado);
				
				JOptionPane.showMessageDialog(null, "Se agrego con EXITO!!!");

			}
		});
		btnAgregar.setBounds(98, 419, 87, 34);
		frmAgregarAdminStock.getContentPane().add(btnAgregar);
		
		textField_1 = new JTextField();
		textField_1.setToolTipText("Ingrese Apellido");
		textField_1.setColumns(10);
		textField_1.setBounds(126, 321, 218, 27);
		frmAgregarAdminStock.getContentPane().add(textField_1);
		
		JLabel lblAgregarCliente = new JLabel("AGREGAR ADMIN STOCK");
		lblAgregarCliente.setHorizontalAlignment(SwingConstants.CENTER);
		lblAgregarCliente.setFont(new Font("JetBrains Mono SemiBold", Font.PLAIN, 15));
		lblAgregarCliente.setBounds(82, 100, 225, 34);
		frmAgregarAdminStock.getContentPane().add(lblAgregarCliente);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(67, 133, 255, 11);
		frmAgregarAdminStock.getContentPane().add(separator);
		
		JLabel lblUsuario = new JLabel("Usuario:");
		lblUsuario.setHorizontalAlignment(SwingConstants.RIGHT);
		lblUsuario.setFont(new Font("JetBrains Mono NL", Font.PLAIN, 13));
		lblUsuario.setBounds(38, 155, 78, 34);
		frmAgregarAdminStock.getContentPane().add(lblUsuario);
		
		JLabel lblContrasea = new JLabel("Contraseña:");
		lblContrasea.setHorizontalAlignment(SwingConstants.RIGHT);
		lblContrasea.setFont(new Font("JetBrains Mono NL", Font.PLAIN, 13));
		lblContrasea.setBounds(10, 205, 107, 34);
		frmAgregarAdminStock.getContentPane().add(lblContrasea);
		
		textField = new JTextField();
		textField.setToolTipText("Ingrese Apellido");
		textField.setColumns(10);
		textField.setBounds(126, 208, 218, 27);
		frmAgregarAdminStock.getContentPane().add(textField);
		
		textField_3 = new JTextField();
		textField_3.setToolTipText("Ingrese Nombre");
		textField_3.setSelectedTextColor(Color.WHITE);
		textField_3.setName("");
		textField_3.setColumns(10);
		textField_3.setBounds(126, 160, 218, 27);
		frmAgregarAdminStock.getContentPane().add(textField_3);
	}
}
