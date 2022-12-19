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
import negocio.MaterialDAO;
import proyectoMineria.Material;

import java.awt.Toolkit;

public class AGREGARstock {

	private JFrame frmAgregarStock;
	private JTextField txtIngreseTipo;
	private JTextField textIngresePureza;
	private JTextField textIngreseCantidad;


	/**
	 * Launch the application.
	 */
	public static void addStock() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AGREGARstock window = new AGREGARstock();
					window.frmAgregarStock.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public AGREGARstock() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmAgregarStock = new JFrame();
		frmAgregarStock.setIconImage(Toolkit.getDefaultToolkit().getImage(AGREGARstock.class.getResource("/img/icon.png")));
		frmAgregarStock.getContentPane().setBackground(Color.WHITE);
		frmAgregarStock.getContentPane().setForeground(Color.WHITE);
		frmAgregarStock.setTitle("Agregar Material");
		frmAgregarStock.setResizable(false);
		frmAgregarStock.setBounds(100, 100, 410, 412);
		frmAgregarStock.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmAgregarStock.getContentPane().setLayout(null);
		
		JLabel lblAgregarStock = new JLabel("AGREGAR MATERIAL");
		lblAgregarStock.setHorizontalAlignment(SwingConstants.CENTER);
		lblAgregarStock.setFont(new Font("JetBrains Mono SemiBold", Font.PLAIN, 15));
		lblAgregarStock.setBounds(82, 100, 225, 34);
		frmAgregarStock.getContentPane().add(lblAgregarStock);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(99, 139, 192, 2);
		frmAgregarStock.getContentPane().add(separator);
		
		JLabel lblNewLabel_1 = new JLabel("");
        lblNewLabel_1.setIcon(new ImageIcon(AGREGARstock.class.getResource("/img/add.png")));
        lblNewLabel_1.setBounds(164, 27, 71, 77);
        frmAgregarStock.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewTipo = new JLabel("Tipo:");
		lblNewTipo.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewTipo.setFont(new Font("JetBrains Mono NL", Font.PLAIN, 13));
		lblNewTipo.setBounds(35, 158, 78, 34);
		frmAgregarStock.getContentPane().add(lblNewTipo);
		
		JLabel lblPureza = new JLabel("Pureza:");
		lblPureza.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPureza.setFont(new Font("JetBrains Mono NL", Font.PLAIN, 13));
		lblPureza.setBounds(36, 208, 78, 34);
		frmAgregarStock.getContentPane().add(lblPureza);
		
		JLabel lblCantidad = new JLabel("Cantidad:");
		lblCantidad.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCantidad.setFont(new Font("JetBrains Mono NL", Font.PLAIN, 13));
		lblCantidad.setBounds(36, 253, 78, 34);
		frmAgregarStock.getContentPane().add(lblCantidad);
		
		JButton btnCancel = new JButton("CANCEL");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmAgregarStock.dispose();
			}
		});
		btnCancel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnCancel.setBounds(220, 318, 87, 34);
		frmAgregarStock.getContentPane().add(btnCancel);
		
		JButton btnAgregar = new JButton("AGREGAR");
		btnAgregar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnAgregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String Tipo = txtIngreseTipo.getText();
				String Pureza = textIngresePureza.getText();
				Double Cantidad = Double.parseDouble(textIngreseCantidad.getText());
				Material material = new Material(Tipo, Pureza, Cantidad);
				
				AdminStockDAO nuevoStock = new AdminStockDAO();
				nuevoStock.agregarMaterial(material);
				addStock();
				
				JOptionPane.showMessageDialog(null, "Se agrego exitosamente");
				frmAgregarStock.dispose();
				AdminStockMenu.AdminStockMenu();
				
			}
		});
		
		btnAgregar.setBounds(98, 318, 87, 34);
		frmAgregarStock.getContentPane().add(btnAgregar);
		
		txtIngreseTipo = new JTextField();
		txtIngreseTipo.setToolTipText("Ingrese Nombre");
		txtIngreseTipo.setSelectedTextColor(Color.WHITE);
		txtIngreseTipo.setName("");
		txtIngreseTipo.setBounds(123, 163, 218, 27);
		frmAgregarStock.getContentPane().add(txtIngreseTipo);
		txtIngreseTipo.setColumns(10);
		
		textIngresePureza = new JTextField();
		textIngresePureza.setToolTipText("Ingrese Pureza");
		textIngresePureza.setColumns(10);
		textIngresePureza.setBounds(123, 211, 218, 27);
		frmAgregarStock.getContentPane().add(textIngresePureza);
		
		textIngreseCantidad = new JTextField();
		textIngreseCantidad.setToolTipText("Ingrese Cantidad");
		textIngreseCantidad.setColumns(10);
		textIngreseCantidad.setBounds(123, 256, 218, 27);
		frmAgregarStock.getContentPane().add(textIngreseCantidad);
		
	}
}
