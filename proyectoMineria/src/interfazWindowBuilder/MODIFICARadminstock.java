package interfazWindowBuilder;

import java.awt.Choice;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import negocio.AdminStockDAO;
import negocio.AdminVentasDao;
import proyectoMineria.AdminStock;
import proyectoMineria.AdminVentas;

import java.awt.Toolkit;

public class MODIFICARadminstock {

	private JFrame frmModificarAdminStock;
	private JTextField txtIngreseNombre;
	private JTextField textField_1;
	private JTextField textField;
	private JTextField textField_3;

	/**
	 * Launch the application.
	 */
	public static void modifyAdminStock() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MODIFICARadminstock window = new MODIFICARadminstock();
					window.frmModificarAdminStock.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MODIFICARadminstock() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmModificarAdminStock = new JFrame();
		frmModificarAdminStock.setIconImage(Toolkit.getDefaultToolkit().getImage("D:\\carol\\casco-de-seguridad.png"));
		frmModificarAdminStock.getContentPane().setBackground(Color.WHITE);
		frmModificarAdminStock.getContentPane().setForeground(Color.WHITE);
		frmModificarAdminStock.setTitle("Modificar Admin Stock");
		frmModificarAdminStock.setResizable(false);
		frmModificarAdminStock.setBounds(100, 100, 410, 581);
		frmModificarAdminStock.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmModificarAdminStock.getContentPane().setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("");
        lblNewLabel_1.setIcon(new ImageIcon("D:\\carol\\edit (1).png"));
        lblNewLabel_1.setBounds(159, 27, 71, 77);
        frmModificarAdminStock.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel = new JLabel("Nombre:");
		lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel.setFont(new Font("JetBrains Mono NL", Font.PLAIN, 13));
		lblNewLabel.setBounds(38, 347, 78, 34);
		frmModificarAdminStock.getContentPane().add(lblNewLabel);
		
		JLabel lblApellido = new JLabel("Apellido:");
		lblApellido.setHorizontalAlignment(SwingConstants.RIGHT);
		lblApellido.setFont(new Font("JetBrains Mono NL", Font.PLAIN, 13));
		lblApellido.setBounds(39, 397, 78, 34);
		frmModificarAdminStock.getContentPane().add(lblApellido);
		
		JButton btnCancel = new JButton("CANCEL");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmModificarAdminStock.dispose();
			}
		});
		btnCancel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnCancel.setBounds(223, 469, 87, 34);
		frmModificarAdminStock.getContentPane().add(btnCancel);
		
		txtIngreseNombre = new JTextField();
		txtIngreseNombre.setToolTipText("Ingrese Nombre");
		txtIngreseNombre.setSelectedTextColor(Color.WHITE);
		txtIngreseNombre.setName("");
		txtIngreseNombre.setBounds(126, 352, 218, 27);
		frmModificarAdminStock.getContentPane().add(txtIngreseNombre);
		txtIngreseNombre.setColumns(10);
		
		JButton btnAgregar = new JButton("ACEPTAR");
		btnAgregar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnAgregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				AdminStockDAO stockDAO = new AdminStockDAO();
				
				
				String nombreId = textField_3.getText();
				
				String clave = textField.getText();
				
				String nombre = txtIngreseNombre.getText();
				
				String apellido = textField_1.getText();
				
				AdminStock adminStockAModificar = new AdminStock(nombre, apellido, nombreId, clave, 1);
				
				stockDAO.hacerUnUpdatePorId(adminStockAModificar);
			
			}
		});
		btnAgregar.setBounds(101, 469, 87, 34);
		frmModificarAdminStock.getContentPane().add(btnAgregar);
		
		textField_1 = new JTextField();
		textField_1.setToolTipText("Ingrese Apellido");
		textField_1.setColumns(10);
		textField_1.setBounds(126, 400, 218, 27);
		frmModificarAdminStock.getContentPane().add(textField_1);
		
		JLabel lblAgregarCliente = new JLabel("MODIFICAR ADMIN STOCK");
		lblAgregarCliente.setHorizontalAlignment(SwingConstants.CENTER);
		lblAgregarCliente.setFont(new Font("JetBrains Mono SemiBold", Font.PLAIN, 15));
		lblAgregarCliente.setBounds(82, 100, 225, 34);
		frmModificarAdminStock.getContentPane().add(lblAgregarCliente);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(67, 133, 255, 11);
		frmModificarAdminStock.getContentPane().add(separator);
		
		JLabel lblUsuario = new JLabel("Usuario:");
		lblUsuario.setHorizontalAlignment(SwingConstants.RIGHT);
		lblUsuario.setFont(new Font("JetBrains Mono NL", Font.PLAIN, 13));
		lblUsuario.setBounds(38, 234, 78, 34);
		frmModificarAdminStock.getContentPane().add(lblUsuario);
		
		JLabel lblContrasea = new JLabel("Contraseña:");
		lblContrasea.setHorizontalAlignment(SwingConstants.RIGHT);
		lblContrasea.setFont(new Font("JetBrains Mono NL", Font.PLAIN, 13));
		lblContrasea.setBounds(10, 284, 107, 34);
		frmModificarAdminStock.getContentPane().add(lblContrasea);
		
		textField = new JTextField();
		textField.setToolTipText("Ingrese Apellido");
		textField.setColumns(10);
		textField.setBounds(126, 287, 218, 27);
		frmModificarAdminStock.getContentPane().add(textField);
		
		textField_3 = new JTextField();
		textField_3.setToolTipText("Ingrese Nombre");
		textField_3.setSelectedTextColor(Color.WHITE);
		textField_3.setName("");
		textField_3.setColumns(10);
		textField_3.setBounds(126, 239, 218, 27);
		frmModificarAdminStock.getContentPane().add(textField_3);
		
		JLabel lblId = new JLabel("Seleccionar Usuario:");
		lblId.setHorizontalTextPosition(SwingConstants.RIGHT);
		lblId.setHorizontalAlignment(SwingConstants.CENTER);
		lblId.setFont(new Font("JetBrains Mono NL", Font.PLAIN, 13));
		lblId.setBounds(67, 165, 255, 34);
		frmModificarAdminStock.getContentPane().add(lblId);
		
		JComboBox comboBoxOpcionesDeId = new JComboBox();
		comboBoxOpcionesDeId.setBounds(69, 203, 253, 21);
		
		AdminStockDAO stockDAOparaIds = new AdminStockDAO();
		
		Object[] listaDeAdminVentas = stockDAOparaIds.obtenerListaDeIdsStock();
		
		DefaultComboBoxModel modelocombo = new DefaultComboBoxModel(listaDeAdminVentas);
		
		comboBoxOpcionesDeId.setModel(modelocombo);
		
		comboBoxOpcionesDeId.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if (e.getStateChange() == ItemEvent.SELECTED) {
					
					String seleccionado = (String) comboBoxOpcionesDeId.getSelectedItem();
					
					AdminStockDAO stockDAO = new AdminStockDAO();
					
					AdminStock adminPorId = stockDAO.obtenerTodosLosDatosPorId(seleccionado);
					
					textField_3.setText(adminPorId.getNombreUsuario());
					
					textField.setText(adminPorId.getClave());
					
					txtIngreseNombre.setText(adminPorId.getNombre());
					
					textField_1.setText(adminPorId.getApellido());
					
					
				}
			}
		});
		frmModificarAdminStock.getContentPane().add(comboBoxOpcionesDeId);
		
	}
}
