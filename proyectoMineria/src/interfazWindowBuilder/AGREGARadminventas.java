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
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class AGREGARadminventas {

	private JFrame frame;
	private JFrame frmAgregarCliente;
	private JTextField txtIngreseNombre;
	private JTextField textField_1;
	private JTextField textField_2;

	/**
	 * Launch the application.
	 */
	public static void addAdminVentas() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AGREGARadminventas window = new AGREGARadminventas();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public AGREGARadminventas() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmAgregarCliente = new JFrame();
		frmAgregarCliente.getContentPane().setBackground(Color.WHITE);
		frmAgregarCliente.getContentPane().setForeground(Color.WHITE);
		frmAgregarCliente.setTitle("Agregar Cliente");
		frmAgregarCliente.setResizable(false);
		frmAgregarCliente.setBounds(100, 100, 410, 417);
		frmAgregarCliente.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmAgregarCliente.getContentPane().setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("");
        lblNewLabel_1.setIcon(new ImageIcon("D:\\carol\\add-user.png"));
        lblNewLabel_1.setBounds(159, 27, 71, 77);
        frmAgregarCliente.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel = new JLabel("Nombre:");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("JetBrains Mono NL", Font.PLAIN, 13));
		lblNewLabel.setBounds(35, 158, 78, 34);
		frmAgregarCliente.getContentPane().add(lblNewLabel);
		
		JLabel lblApellido = new JLabel("Apellido:");
		lblApellido.setHorizontalAlignment(SwingConstants.CENTER);
		lblApellido.setFont(new Font("JetBrains Mono NL", Font.PLAIN, 13));
		lblApellido.setBounds(36, 208, 78, 34);
		frmAgregarCliente.getContentPane().add(lblApellido);
		
		JLabel lblTelfono = new JLabel("Teléfono:");
		lblTelfono.setHorizontalAlignment(SwingConstants.CENTER);
		lblTelfono.setFont(new Font("JetBrains Mono NL", Font.PLAIN, 13));
		lblTelfono.setBounds(36, 253, 78, 34);
		frmAgregarCliente.getContentPane().add(lblTelfono);
		
		JButton btnCancel = new JButton("CANCEL");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnCancel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnCancel.setBounds(220, 312, 87, 34);
		frmAgregarCliente.getContentPane().add(btnCancel);
		
		txtIngreseNombre = new JTextField();
		txtIngreseNombre.setToolTipText("Ingrese Nombre");
		txtIngreseNombre.setSelectedTextColor(Color.WHITE);
		txtIngreseNombre.setName("");
		txtIngreseNombre.setBounds(123, 163, 218, 27);
		frmAgregarCliente.getContentPane().add(txtIngreseNombre);
		txtIngreseNombre.setColumns(10);
		
		JButton btnAgregar = new JButton("AGREGAR");
		btnAgregar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnAgregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnAgregar.setBounds(98, 312, 87, 34);
		frmAgregarCliente.getContentPane().add(btnAgregar);
		
		textField_1 = new JTextField();
		textField_1.setToolTipText("Ingrese Apellido");
		textField_1.setColumns(10);
		textField_1.setBounds(123, 211, 218, 27);
		frmAgregarCliente.getContentPane().add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setToolTipText("Ingrese Teléfono");
		textField_2.setColumns(10);
		textField_2.setBounds(123, 256, 218, 27);
		frmAgregarCliente.getContentPane().add(textField_2);
		
		JLabel lblAgregarCliente = new JLabel("AGREGAR ADMIN VENTAS");
		lblAgregarCliente.setHorizontalAlignment(SwingConstants.CENTER);
		lblAgregarCliente.setFont(new Font("JetBrains Mono SemiBold", Font.PLAIN, 15));
		lblAgregarCliente.setBounds(82, 100, 225, 34);
		frmAgregarCliente.getContentPane().add(lblAgregarCliente);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(99, 139, 192, 2);
		frmAgregarCliente.getContentPane().add(separator);
	}

}
