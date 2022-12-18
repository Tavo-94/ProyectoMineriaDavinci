package interfazWindowBuilder;

import java.awt.Choice;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
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
import proyectoMineria.AdminSistema;
import proyectoMineria.AdminStock;
import proyectoMineria.AdminVentas;

public class ELIMINARamindStock {

	private JFrame frmEliminarAdminStock;
	
	private JTextField txtIngreseNombre;
	private JTextField textField_1;
	private JTextField textField;
	private JTextField textField_3;
    private static AdminSistema adminSistemaLogeado;


	/**
	 * Launch the application.
	 */
	public static void deleteAdminStock() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ELIMINARamindStock window = new ELIMINARamindStock(adminSistemaLogeado);
					window.frmEliminarAdminStock.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 * @param adminSistemaLogeado2 
	 */
	public ELIMINARamindStock(AdminSistema adminSistemaLogeado) {
		initialize();
		this.adminSistemaLogeado = adminSistemaLogeado;
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		frmEliminarAdminStock = new JFrame();
		frmEliminarAdminStock.setIconImage(Toolkit.getDefaultToolkit().getImage("D:\\carol\\casco-de-seguridad.png"));
		frmEliminarAdminStock.getContentPane().setBackground(Color.WHITE);
		frmEliminarAdminStock.getContentPane().setForeground(Color.WHITE);
		frmEliminarAdminStock.setTitle("Modificar Admin Ventas");
		frmEliminarAdminStock.setResizable(false);
		frmEliminarAdminStock.setBounds(100, 100, 410, 581);
		frmEliminarAdminStock.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmEliminarAdminStock.getContentPane().setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("");
	    lblNewLabel_1.setIcon(new ImageIcon("D:\\carol\\edit (1).png"));
	    lblNewLabel_1.setBounds(159, 27, 71, 77);
	    frmEliminarAdminStock.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel = new JLabel("Nombre:");
		lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel.setFont(new Font("JetBrains Mono NL", Font.PLAIN, 13));
		lblNewLabel.setBounds(38, 356, 78, 34);
		frmEliminarAdminStock.getContentPane().add(lblNewLabel);
		
		JLabel lblApellido = new JLabel("Apellido:");
		lblApellido.setHorizontalAlignment(SwingConstants.RIGHT);
		lblApellido.setFont(new Font("JetBrains Mono NL", Font.PLAIN, 13));
		lblApellido.setBounds(39, 406, 78, 34);
		frmEliminarAdminStock.getContentPane().add(lblApellido);
		
		JButton btnCancel = new JButton("CANCEL");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmEliminarAdminStock.dispose();
			}
		});
		btnCancel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnCancel.setBounds(223, 469, 87, 34);
		frmEliminarAdminStock.getContentPane().add(btnCancel);
		
		txtIngreseNombre = new JTextField();
		txtIngreseNombre.setEditable(false);
		txtIngreseNombre.setToolTipText("Ingrese Nombre");
		txtIngreseNombre.setSelectedTextColor(Color.WHITE);
		txtIngreseNombre.setName("");
		txtIngreseNombre.setBounds(126, 361, 218, 27);
		frmEliminarAdminStock.getContentPane().add(txtIngreseNombre);
		txtIngreseNombre.setColumns(10);
		
		JButton btnAgregar = new JButton("ACEPTAR");
		btnAgregar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnAgregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				AdminStockDAO stockDAO = new AdminStockDAO();
				
				String idDelAdminAEliminar = textField_3.getText();
				
				stockDAO.eliminarAdminStockPorId(idDelAdminAEliminar);
				
			}
		});
		btnAgregar.setBounds(101, 469, 87, 34);
		frmEliminarAdminStock.getContentPane().add(btnAgregar);
		
		textField_1 = new JTextField();
		textField_1.setEditable(false);
		textField_1.setToolTipText("Ingrese Apellido");
		textField_1.setColumns(10);
		textField_1.setBounds(126, 409, 218, 27);
		frmEliminarAdminStock.getContentPane().add(textField_1);
		
		JLabel lblAgregarCliente = new JLabel("ELIMINAR ADMIN STOCK");
		lblAgregarCliente.setHorizontalAlignment(SwingConstants.CENTER);
		lblAgregarCliente.setFont(new Font("JetBrains Mono SemiBold", Font.PLAIN, 15));
		lblAgregarCliente.setBounds(82, 100, 225, 34);
		frmEliminarAdminStock.getContentPane().add(lblAgregarCliente);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(67, 133, 255, 11);
		frmEliminarAdminStock.getContentPane().add(separator);
		
		JLabel lblUsuario = new JLabel("Usuario:");
		lblUsuario.setHorizontalAlignment(SwingConstants.RIGHT);
		lblUsuario.setFont(new Font("JetBrains Mono NL", Font.PLAIN, 13));
		lblUsuario.setBounds(38, 243, 78, 34);
		frmEliminarAdminStock.getContentPane().add(lblUsuario);
		
		JLabel lblContrasea = new JLabel("Contraseña:");
		lblContrasea.setHorizontalAlignment(SwingConstants.RIGHT);
		lblContrasea.setFont(new Font("JetBrains Mono NL", Font.PLAIN, 13));
		lblContrasea.setBounds(10, 293, 107, 34);
		frmEliminarAdminStock.getContentPane().add(lblContrasea);
		
		textField = new JTextField();
		textField.setEditable(false);
		textField.setToolTipText("Ingrese Apellido");
		textField.setColumns(10);
		textField.setBounds(126, 296, 218, 27);
		frmEliminarAdminStock.getContentPane().add(textField);
		
		textField_3 = new JTextField();
		textField_3.setEditable(false);
		textField_3.setToolTipText("Ingrese Nombre");
		textField_3.setSelectedTextColor(Color.WHITE);
		textField_3.setName("");
		textField_3.setColumns(10);
		textField_3.setBounds(126, 248, 218, 27);
		frmEliminarAdminStock.getContentPane().add(textField_3);
		
		JLabel lblId = new JLabel("Seleccionar Usuario:");
		lblId.setHorizontalTextPosition(SwingConstants.RIGHT);
		lblId.setHorizontalAlignment(SwingConstants.CENTER);
		lblId.setFont(new Font("JetBrains Mono NL", Font.PLAIN, 13));
		lblId.setBounds(67, 156, 257, 34);
		frmEliminarAdminStock.getContentPane().add(lblId);
		
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
		frmEliminarAdminStock.getContentPane().add(comboBoxOpcionesDeId);
		
		}

	}


