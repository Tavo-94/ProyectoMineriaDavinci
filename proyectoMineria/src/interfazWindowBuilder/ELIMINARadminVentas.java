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
import javax.swing.JOptionPane;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import negocio.AdminVentasDao;
import proyectoMineria.AdminSistema;
import proyectoMineria.AdminVentas;

public class ELIMINARadminVentas {


	private JFrame frmEliminarAdminVentas;
	private JTextField txtIngreseNombre;
	private JTextField textField_1;
	private JTextField textField;
    private static AdminSistema adminSistemaLogeado;
	/**
	 * Launch the application.
	 */
	public static void deleteAdminVentas() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ELIMINARadminVentas window = new ELIMINARadminVentas(adminSistemaLogeado);
					window.frmEliminarAdminVentas.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ELIMINARadminVentas(AdminSistema adminSistemaLogeado) {
		initialize();
		this.adminSistemaLogeado = adminSistemaLogeado;

	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
	frmEliminarAdminVentas = new JFrame();
	frmEliminarAdminVentas.setIconImage(Toolkit.getDefaultToolkit().getImage(ELIMINARadminVentas.class.getResource("/img/icon.png")));
	frmEliminarAdminVentas.getContentPane().setBackground(Color.WHITE);
	frmEliminarAdminVentas.getContentPane().setForeground(Color.WHITE);
	frmEliminarAdminVentas.setTitle("Eliminar Admin Ventas");
	frmEliminarAdminVentas.setResizable(false);
	frmEliminarAdminVentas.setBounds(100, 100, 410, 462);
	frmEliminarAdminVentas.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	frmEliminarAdminVentas.getContentPane().setLayout(null);
	
	JLabel lblNewLabel_1 = new JLabel("");
    lblNewLabel_1.setIcon(new ImageIcon(ELIMINARadminVentas.class.getResource("/img/MODIFICAR.png")));
    lblNewLabel_1.setBounds(159, 27, 71, 77);
    frmEliminarAdminVentas.getContentPane().add(lblNewLabel_1);
	
	JLabel lblNewLabel = new JLabel("Nombre:");
	lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
	lblNewLabel.setFont(new Font("JetBrains Mono NL", Font.PLAIN, 13));
	lblNewLabel.setBounds(38, 250, 78, 34);
	frmEliminarAdminVentas.getContentPane().add(lblNewLabel);
	
	JLabel lblApellido = new JLabel("Apellido:");
	lblApellido.setHorizontalAlignment(SwingConstants.RIGHT);
	lblApellido.setFont(new Font("JetBrains Mono NL", Font.PLAIN, 13));
	lblApellido.setBounds(39, 300, 78, 34);
	frmEliminarAdminVentas.getContentPane().add(lblApellido);
	
	JButton btnCancel = new JButton("CANCEL");
	btnCancel.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			frmEliminarAdminVentas.dispose();
		}
	});
	btnCancel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
	btnCancel.setBounds(220, 362, 87, 34);
	frmEliminarAdminVentas.getContentPane().add(btnCancel);
	
	txtIngreseNombre = new JTextField();
	txtIngreseNombre.setEditable(false);
	txtIngreseNombre.setToolTipText("Ingrese Nombre");
	txtIngreseNombre.setSelectedTextColor(Color.WHITE);
	txtIngreseNombre.setName("");
	txtIngreseNombre.setBounds(126, 255, 218, 27);
	frmEliminarAdminVentas.getContentPane().add(txtIngreseNombre);
	txtIngreseNombre.setColumns(10);
	
	JButton btnAgregar = new JButton("ACEPTAR");
	btnAgregar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
	
	btnAgregar.setBounds(98, 362, 87, 34);
	frmEliminarAdminVentas.getContentPane().add(btnAgregar);
	
	textField_1 = new JTextField();
	textField_1.setEditable(false);
	textField_1.setToolTipText("Ingrese Apellido");
	textField_1.setColumns(10);
	textField_1.setBounds(126, 303, 218, 27);
	frmEliminarAdminVentas.getContentPane().add(textField_1);
	
	JLabel lblAgregarCliente = new JLabel("ELIMINAR ADMIN VENTAS");
	lblAgregarCliente.setHorizontalAlignment(SwingConstants.CENTER);
	lblAgregarCliente.setFont(new Font("JetBrains Mono SemiBold", Font.PLAIN, 15));
	lblAgregarCliente.setBounds(82, 100, 225, 34);
	frmEliminarAdminVentas.getContentPane().add(lblAgregarCliente);
	
	JSeparator separator = new JSeparator();
	separator.setBounds(67, 133, 255, 11);
	frmEliminarAdminVentas.getContentPane().add(separator);
	
	JLabel lblUsuario = new JLabel("Usuario:");
	lblUsuario.setHorizontalAlignment(SwingConstants.RIGHT);
	lblUsuario.setFont(new Font("JetBrains Mono NL", Font.PLAIN, 13));
	lblUsuario.setBounds(38, 155, 78, 34);
	frmEliminarAdminVentas.getContentPane().add(lblUsuario);
	
	JLabel lblContrasea = new JLabel("Contraseña:");
	lblContrasea.setHorizontalAlignment(SwingConstants.RIGHT);
	lblContrasea.setFont(new Font("JetBrains Mono NL", Font.PLAIN, 13));
	lblContrasea.setBounds(10, 205, 107, 34);
	frmEliminarAdminVentas.getContentPane().add(lblContrasea);
	
	textField = new JTextField();
	textField.setEditable(false);
	textField.setToolTipText("Ingrese Apellido");
	textField.setColumns(10);
	textField.setBounds(126, 208, 218, 27);
	frmEliminarAdminVentas.getContentPane().add(textField);
	
	JComboBox comboBoxOpcionesDeId = new JComboBox();
	comboBoxOpcionesDeId.addItemListener(new ItemListener() {
		public void itemStateChanged(ItemEvent e) {
			if (e.getStateChange() == ItemEvent.SELECTED) {
				
				String seleccionado = (String) comboBoxOpcionesDeId.getSelectedItem();
				
				AdminVentasDao ventasDAO = new AdminVentasDao();
				
				AdminVentas adminPorId = ventasDAO.obtenerTodosLosDatosPorId(seleccionado);
				
				//textField_3.setText(adminPorId.getNombreUsuario());
				
				textField.setText(adminPorId.getClave());
				
				txtIngreseNombre.setText(adminPorId.getNombre());
				
				textField_1.setText(adminPorId.getApellido());
				
				
			}
		}
	});
	
	btnAgregar.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			
			AdminVentasDao ventasDAO = new AdminVentasDao();
			
			String idDelAdminAEliminar = (String) comboBoxOpcionesDeId.getSelectedItem();
			
			ventasDAO.eliminarAdminVentasPorId(idDelAdminAEliminar);
			
		}
	});
	comboBoxOpcionesDeId.setBounds(126, 163, 218, 21);
	
	AdminVentasDao ventasDAOparaIds = new AdminVentasDao();
	
	Object[] listaDeAdminVentas = ventasDAOparaIds.obtenerListaDeIdsVentas();
	
	DefaultComboBoxModel modelocombo = new DefaultComboBoxModel(listaDeAdminVentas);
	
	comboBoxOpcionesDeId.setModel(modelocombo);
	
	frmEliminarAdminVentas.getContentPane().add(comboBoxOpcionesDeId);
	
	}
	}


