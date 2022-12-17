package interfazWindowBuilder;

import java.awt.Choice;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import negocio.AdminVentasDao;
import proyectoMineria.AdminVentas;

import java.awt.Toolkit;
import javax.swing.JComboBox;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;

public class MODIFICARadminventas {

	private JFrame frmAgregarCliente;
	private JTextField txtIngreseNombre;
	private JTextField textField_1;
	private JTextField textField;
	private JTextField textField_3;

	/**
	 * Launch the application.
	 */
	public static void modifyAdminVentas() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MODIFICARadminventas window = new MODIFICARadminventas();
					window.frmAgregarCliente.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MODIFICARadminventas() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmAgregarCliente = new JFrame();
		frmAgregarCliente.setIconImage(Toolkit.getDefaultToolkit().getImage("D:\\carol\\casco-de-seguridad.png"));
		frmAgregarCliente.getContentPane().setBackground(Color.WHITE);
		frmAgregarCliente.getContentPane().setForeground(Color.WHITE);
		frmAgregarCliente.setTitle("Modificar Admin Ventas");
		frmAgregarCliente.setResizable(false);
		frmAgregarCliente.setBounds(100, 100, 410, 581);
		frmAgregarCliente.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmAgregarCliente.getContentPane().setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("");
        lblNewLabel_1.setIcon(new ImageIcon("D:\\carol\\edit (1).png"));
        lblNewLabel_1.setBounds(159, 27, 71, 77);
        frmAgregarCliente.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel = new JLabel("Nombre:");
		lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel.setFont(new Font("JetBrains Mono NL", Font.PLAIN, 13));
		lblNewLabel.setBounds(38, 311, 78, 34);
		frmAgregarCliente.getContentPane().add(lblNewLabel);
		
		JLabel lblApellido = new JLabel("Apellido:");
		lblApellido.setHorizontalAlignment(SwingConstants.RIGHT);
		lblApellido.setFont(new Font("JetBrains Mono NL", Font.PLAIN, 13));
		lblApellido.setBounds(39, 361, 78, 34);
		frmAgregarCliente.getContentPane().add(lblApellido);
		
		JButton btnCancel = new JButton("CANCEL");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmAgregarCliente.dispose();
			}
		});
		btnCancel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnCancel.setBounds(223, 469, 87, 34);
		frmAgregarCliente.getContentPane().add(btnCancel);
		
		txtIngreseNombre = new JTextField();
		txtIngreseNombre.setToolTipText("Ingrese Nombre");
		txtIngreseNombre.setSelectedTextColor(Color.WHITE);
		txtIngreseNombre.setName("");
		txtIngreseNombre.setBounds(126, 316, 218, 27);
		frmAgregarCliente.getContentPane().add(txtIngreseNombre);
		txtIngreseNombre.setColumns(10);
		
		JButton btnAgregar = new JButton("ACEPTAR");
		btnAgregar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnAgregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				AdminVentasDao ventasDAO = new AdminVentasDao();
				
				
				String nombreId = textField_3.getText();
				
				String clave = textField.getText();
				
				String nombre = txtIngreseNombre.getText();
				
				String apellido = textField_1.getText();
				
				AdminVentas adminVentasAModificar = new AdminVentas(nombre, apellido, nombreId, clave, 1);
				
				ventasDAO.hacerUnUpdatePorId(adminVentasAModificar);
			}
		});
		btnAgregar.setBounds(101, 469, 87, 34);
		frmAgregarCliente.getContentPane().add(btnAgregar);
		
		textField_1 = new JTextField();
		textField_1.setToolTipText("Ingrese Apellido");
		textField_1.setColumns(10);
		textField_1.setBounds(126, 364, 218, 27);
		frmAgregarCliente.getContentPane().add(textField_1);
		
		JLabel lblAgregarCliente = new JLabel("MODIFICAR ADMIN VENTAS");
		lblAgregarCliente.setHorizontalAlignment(SwingConstants.CENTER);
		lblAgregarCliente.setFont(new Font("JetBrains Mono SemiBold", Font.PLAIN, 15));
		lblAgregarCliente.setBounds(82, 100, 225, 34);
		frmAgregarCliente.getContentPane().add(lblAgregarCliente);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(67, 133, 255, 11);
		frmAgregarCliente.getContentPane().add(separator);
		
		JLabel lblUsuario = new JLabel("Usuario:");
		lblUsuario.setHorizontalAlignment(SwingConstants.RIGHT);
		lblUsuario.setFont(new Font("JetBrains Mono NL", Font.PLAIN, 13));
		lblUsuario.setBounds(38, 198, 78, 34);
		frmAgregarCliente.getContentPane().add(lblUsuario);
		
		JLabel lblContrasea = new JLabel("Contraseña:");
		lblContrasea.setHorizontalAlignment(SwingConstants.RIGHT);
		lblContrasea.setFont(new Font("JetBrains Mono NL", Font.PLAIN, 13));
		lblContrasea.setBounds(10, 248, 107, 34);
		frmAgregarCliente.getContentPane().add(lblContrasea);
		
		textField = new JTextField();
		textField.setToolTipText("Ingrese Apellido");
		textField.setColumns(10);
		textField.setBounds(126, 251, 218, 27);
		frmAgregarCliente.getContentPane().add(textField);
		
		textField_3 = new JTextField();
		textField_3.setToolTipText("Ingrese Nombre");
		textField_3.setSelectedTextColor(Color.WHITE);
		textField_3.setName("");
		textField_3.setColumns(10);
		textField_3.setBounds(126, 203, 218, 27);
		frmAgregarCliente.getContentPane().add(textField_3);
		
		JLabel lblId = new JLabel("ID:");
		lblId.setHorizontalTextPosition(SwingConstants.RIGHT);
		lblId.setHorizontalAlignment(SwingConstants.RIGHT);
		lblId.setFont(new Font("JetBrains Mono NL", Font.PLAIN, 13));
		lblId.setBounds(38, 156, 78, 34);
		frmAgregarCliente.getContentPane().add(lblId);
		
		Choice choice = new Choice();
		choice.setBounds(126, 165, 95, 20);
		frmAgregarCliente.getContentPane().add(choice);
		
		JComboBox comboBoxOpcionesDeId = new JComboBox();
		comboBoxOpcionesDeId.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if (e.getStateChange() == ItemEvent.SELECTED) {
					
					String seleccionado = (String) comboBoxOpcionesDeId.getSelectedItem();
					
					AdminVentasDao ventasDAO = new AdminVentasDao();
					
					AdminVentas adminPorId = ventasDAO.obtenerTodosLosDatosPorId(seleccionado);
					
					textField_3.setText(adminPorId.getNombreUsuario());
					
					textField.setText(adminPorId.getClave());
					
					txtIngreseNombre.setText(adminPorId.getNombre());
					
					textField_1.setText(adminPorId.getApellido());
					
					
				}
			}
		});
		comboBoxOpcionesDeId.setBounds(239, 164, 133, 21);
		
		AdminVentasDao ventasDAOparaIds = new AdminVentasDao();
		
		Object[] listaDeAdminVentas = ventasDAOparaIds.obtenerListaDeIdsVentas();
		
		DefaultComboBoxModel modelocombo = new DefaultComboBoxModel(listaDeAdminVentas);
		
		comboBoxOpcionesDeId.setModel(modelocombo);
		
		frmAgregarCliente.getContentPane().add(comboBoxOpcionesDeId);
		
	}
}
