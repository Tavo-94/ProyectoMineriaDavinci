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

import negocio.AdminStockDAO;
import negocio.AdminVentasDao;
import proyectoMineria.AdminSistema;
import proyectoMineria.AdminStock;
import proyectoMineria.AdminVentas;

public class ELIMINARmaterial {

	private JFrame frmEliminarMaterial;
	
	private JTextField txtIngreseNombre;
	private JTextField textField_1;
	private JTextField textField;
    private static AdminStock adminStockLogeado;


	/**
	 * Launch the application.
	 */
	public static void deleteMaterial() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ELIMINARmaterial window = new ELIMINARmaterial(adminStockLogeado);
					window.frmEliminarMaterial.setVisible(true);
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
	public ELIMINARmaterial(AdminStock adminStockLogeado) {
		initialize();
		this.adminStockLogeado = adminStockLogeado;
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		frmEliminarMaterial = new JFrame();
		frmEliminarMaterial.setIconImage(Toolkit.getDefaultToolkit().getImage(ELIMINARmaterial.class.getResource("/img/icon.png")));
		frmEliminarMaterial.getContentPane().setBackground(Color.WHITE);
		frmEliminarMaterial.getContentPane().setForeground(Color.WHITE);
		frmEliminarMaterial.setTitle("Eliminar Admin Stock");
		frmEliminarMaterial.setResizable(false);
		frmEliminarMaterial.setBounds(100, 100, 410, 459);
		frmEliminarMaterial.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmEliminarMaterial.getContentPane().setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("");
	    lblNewLabel_1.setIcon(new ImageIcon(ELIMINARmaterial.class.getResource("/img/MODIFICAR.png")));
	    lblNewLabel_1.setBounds(159, 27, 71, 77);
	    frmEliminarMaterial.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel = new JLabel("Nombre:");
		lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel.setFont(new Font("JetBrains Mono NL", Font.PLAIN, 13));
		lblNewLabel.setBounds(38, 248, 78, 34);
		frmEliminarMaterial.getContentPane().add(lblNewLabel);
		
		JLabel lblApellido = new JLabel("Apellido:");
		lblApellido.setHorizontalAlignment(SwingConstants.RIGHT);
		lblApellido.setFont(new Font("JetBrains Mono NL", Font.PLAIN, 13));
		lblApellido.setBounds(39, 298, 78, 34);
		frmEliminarMaterial.getContentPane().add(lblApellido);
		
		JButton btnCancel = new JButton("CANCEL");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmEliminarMaterial.dispose();
			}
		});
		btnCancel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnCancel.setBounds(223, 355, 87, 34);
		frmEliminarMaterial.getContentPane().add(btnCancel);
		
		txtIngreseNombre = new JTextField();
		txtIngreseNombre.setEditable(false);
		txtIngreseNombre.setToolTipText("Ingrese Nombre");
		txtIngreseNombre.setSelectedTextColor(Color.WHITE);
		txtIngreseNombre.setName("");
		txtIngreseNombre.setBounds(126, 253, 218, 27);
		frmEliminarMaterial.getContentPane().add(txtIngreseNombre);
		txtIngreseNombre.setColumns(10);
		
		JButton btnAgregar = new JButton("ACEPTAR");
		btnAgregar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnAgregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				AdminStockDAO eliminarStock = new AdminStockDAO();
				
				
			}
		});
		btnAgregar.setBounds(101, 355, 87, 34);
		frmEliminarMaterial.getContentPane().add(btnAgregar);
		
		textField_1 = new JTextField();
		textField_1.setEditable(false);
		textField_1.setToolTipText("Ingrese Apellido");
		textField_1.setColumns(10);
		textField_1.setBounds(126, 301, 218, 27);
		frmEliminarMaterial.getContentPane().add(textField_1);
		
		JLabel lblAgregarCliente = new JLabel("ELIMINAR ADMIN STOCK");
		lblAgregarCliente.setHorizontalAlignment(SwingConstants.CENTER);
		lblAgregarCliente.setFont(new Font("JetBrains Mono SemiBold", Font.PLAIN, 15));
		lblAgregarCliente.setBounds(82, 100, 225, 34);
		frmEliminarMaterial.getContentPane().add(lblAgregarCliente);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(67, 133, 255, 11);
		frmEliminarMaterial.getContentPane().add(separator);
		
		JLabel lblUsuario = new JLabel("Usuario:");
		lblUsuario.setHorizontalAlignment(SwingConstants.RIGHT);
		lblUsuario.setFont(new Font("JetBrains Mono NL", Font.PLAIN, 13));
		lblUsuario.setBounds(38, 153, 78, 34);
		frmEliminarMaterial.getContentPane().add(lblUsuario);
		
		JLabel lblContrasea = new JLabel("Contraseña:");
		lblContrasea.setHorizontalAlignment(SwingConstants.RIGHT);
		lblContrasea.setFont(new Font("JetBrains Mono NL", Font.PLAIN, 13));
		lblContrasea.setBounds(10, 203, 107, 34);
		frmEliminarMaterial.getContentPane().add(lblContrasea);
		
		textField = new JTextField();
		textField.setEditable(false);
		textField.setToolTipText("Ingrese Apellido");
		textField.setColumns(10);
		textField.setBounds(126, 206, 218, 27);
		frmEliminarMaterial.getContentPane().add(textField);
		
		JComboBox comboBoxOpcionesDeId = new JComboBox();
		comboBoxOpcionesDeId.setBounds(126, 161, 218, 21);
		
		AdminStockDAO stock = new AdminStockDAO();
		
		Object[] listaDeStock = stock.listaDeMateriales();
		
		DefaultComboBoxModel modelocombo = new DefaultComboBoxModel(listaDeStock);
		
		comboBoxOpcionesDeId.setModel(modelocombo);
		
		comboBoxOpcionesDeId.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if (e.getStateChange() == ItemEvent.SELECTED) {
					
					Integer seleccionado = (Integer) comboBoxOpcionesDeId.getSelectedItem();
					
					AdminStockDAO stockDAO = new AdminStockDAO();
					
					AdminStock adminPorId = stockDAO.eliminarMaterial(seleccionado);
					
					textField_1.setText(adminPorId.getNombreUsuario());
					
					textField.setText(adminPorId.getClave());
					
					txtIngreseNombre.setText(adminPorId.getNombre());
					
					textField_1.setText(adminPorId.getApellido());
					
					
				}
			}
		};
		frmEliminarMaterial.getContentPane().add(comboBoxOpcionesDeId);
		
		}

	}


