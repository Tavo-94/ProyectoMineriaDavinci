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
		frmEliminarAdminStock.setIconImage(Toolkit.getDefaultToolkit().getImage(ELIMINARamindStock.class.getResource("/img/icon.png")));
		frmEliminarAdminStock.getContentPane().setBackground(Color.WHITE);
		frmEliminarAdminStock.getContentPane().setForeground(Color.WHITE);
		frmEliminarAdminStock.setTitle("Eliminar Admin Stock");
		frmEliminarAdminStock.setResizable(false);
		frmEliminarAdminStock.setBounds(100, 100, 410, 459);
		frmEliminarAdminStock.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmEliminarAdminStock.getContentPane().setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("");
	    lblNewLabel_1.setIcon(new ImageIcon(ELIMINARamindStock.class.getResource("/img/MODIFICAR.png")));
	    lblNewLabel_1.setBounds(159, 27, 71, 77);
	    frmEliminarAdminStock.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel = new JLabel("Nombre:");
		lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel.setFont(new Font("JetBrains Mono NL", Font.PLAIN, 13));
		lblNewLabel.setBounds(38, 248, 78, 34);
		frmEliminarAdminStock.getContentPane().add(lblNewLabel);
		
		JLabel lblApellido = new JLabel("Apellido:");
		lblApellido.setHorizontalAlignment(SwingConstants.RIGHT);
		lblApellido.setFont(new Font("JetBrains Mono NL", Font.PLAIN, 13));
		lblApellido.setBounds(39, 298, 78, 34);
		frmEliminarAdminStock.getContentPane().add(lblApellido);
		
		JButton btnCancel = new JButton("CANCEL");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmEliminarAdminStock.dispose();
			}
		});
		btnCancel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnCancel.setBounds(223, 355, 87, 34);
		frmEliminarAdminStock.getContentPane().add(btnCancel);
		
		txtIngreseNombre = new JTextField();
		txtIngreseNombre.setEditable(false);
		txtIngreseNombre.setToolTipText("Ingrese Nombre");
		txtIngreseNombre.setSelectedTextColor(Color.WHITE);
		txtIngreseNombre.setName("");
		txtIngreseNombre.setBounds(126, 253, 218, 27);
		frmEliminarAdminStock.getContentPane().add(txtIngreseNombre);
		txtIngreseNombre.setColumns(10);
		
		JButton btnAgregar = new JButton("ACEPTAR");
		btnAgregar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		
		btnAgregar.setBounds(101, 355, 87, 34);
		frmEliminarAdminStock.getContentPane().add(btnAgregar);
		
		textField_1 = new JTextField();
		textField_1.setEditable(false);
		textField_1.setToolTipText("Ingrese Apellido");
		textField_1.setColumns(10);
		textField_1.setBounds(126, 301, 218, 27);
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
		lblUsuario.setBounds(38, 153, 78, 34);
		frmEliminarAdminStock.getContentPane().add(lblUsuario);
		
		JLabel lblContrasea = new JLabel("Contraseña:");
		lblContrasea.setHorizontalAlignment(SwingConstants.RIGHT);
		lblContrasea.setFont(new Font("JetBrains Mono NL", Font.PLAIN, 13));
		lblContrasea.setBounds(10, 203, 107, 34);
		frmEliminarAdminStock.getContentPane().add(lblContrasea);
		
		textField = new JTextField();
		textField.setEditable(false);
		textField.setToolTipText("Ingrese Apellido");
		textField.setColumns(10);
		textField.setBounds(126, 206, 218, 27);
		frmEliminarAdminStock.getContentPane().add(textField);
		
		JComboBox comboBoxOpcionesDeId = new JComboBox();
		comboBoxOpcionesDeId.setBounds(126, 161, 218, 21);
		
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
					
					
					textField.setText(adminPorId.getClave());
					
					txtIngreseNombre.setText(adminPorId.getNombre());
					
					textField_1.setText(adminPorId.getApellido());
					
					
				}
			}
		});
		
		btnAgregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				AdminStockDAO stockDAO = new AdminStockDAO();
				
				String idDelAdminAEliminar = (String) comboBoxOpcionesDeId.getSelectedItem();
				
				stockDAO.eliminarAdminStockPorId(idDelAdminAEliminar);
				
			}
		});
		frmEliminarAdminStock.getContentPane().add(comboBoxOpcionesDeId);
		
		}

	}


