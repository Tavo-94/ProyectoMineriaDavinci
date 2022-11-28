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
import java.awt.Choice;

public class MODIFICARcliente {

	private JFrame frmAgregarCliente;
	private JTextField txtIngreseNombre;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;

	/**
	 * Launch the application.
	 */
	public static void modifyCliente() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MODIFICARcliente window = new MODIFICARcliente();
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
	public MODIFICARcliente() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmAgregarCliente = new JFrame();
		frmAgregarCliente.getContentPane().setBackground(Color.WHITE);
		frmAgregarCliente.getContentPane().setForeground(Color.WHITE);
		frmAgregarCliente.setTitle("Modificar Cliente");
		frmAgregarCliente.setResizable(false);
		frmAgregarCliente.setBounds(100, 100, 811, 439);
		frmAgregarCliente.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmAgregarCliente.getContentPane().setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("");
        lblNewLabel_1.setIcon(new ImageIcon("D:\\carol\\edit (1).png"));
        lblNewLabel_1.setBounds(155, 25, 71, 77);
        frmAgregarCliente.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel = new JLabel("Nombre:");
		lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel.setFont(new Font("JetBrains Mono NL", Font.PLAIN, 13));
		lblNewLabel.setBounds(33, 193, 78, 34);
		frmAgregarCliente.getContentPane().add(lblNewLabel);
		
		JLabel lblApellido = new JLabel("Apellido:");
		lblApellido.setHorizontalAlignment(SwingConstants.RIGHT);
		lblApellido.setFont(new Font("JetBrains Mono NL", Font.PLAIN, 13));
		lblApellido.setBounds(34, 243, 78, 34);
		frmAgregarCliente.getContentPane().add(lblApellido);
		
		JLabel lblTelfono = new JLabel("Teléfono:");
		lblTelfono.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTelfono.setFont(new Font("JetBrains Mono NL", Font.PLAIN, 13));
		lblTelfono.setBounds(34, 288, 78, 34);
		frmAgregarCliente.getContentPane().add(lblTelfono);
		
		JButton btnCancel = new JButton("CANCEL");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmAgregarCliente.dispose();
			}
		});
		btnCancel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnCancel.setBounds(398, 343, 87, 34);
		frmAgregarCliente.getContentPane().add(btnCancel);
		
		txtIngreseNombre = new JTextField();
		txtIngreseNombre.setToolTipText("Ingrese Nombre");
		txtIngreseNombre.setSelectedTextColor(Color.WHITE);
		txtIngreseNombre.setName("");
		txtIngreseNombre.setBounds(121, 198, 218, 27);
		frmAgregarCliente.getContentPane().add(txtIngreseNombre);
		txtIngreseNombre.setColumns(10);
		
		JButton btnAgregar = new JButton("ACEPTAR");
		btnAgregar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnAgregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnAgregar.setBounds(276, 343, 87, 34);
		frmAgregarCliente.getContentPane().add(btnAgregar);
		
		textField_1 = new JTextField();
		textField_1.setToolTipText("Ingrese Apellido");
		textField_1.setColumns(10);
		textField_1.setBounds(121, 246, 218, 27);
		frmAgregarCliente.getContentPane().add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setToolTipText("Ingrese Teléfono");
		textField_2.setColumns(10);
		textField_2.setBounds(121, 291, 218, 27);
		frmAgregarCliente.getContentPane().add(textField_2);
		
		JLabel lblAgregarCliente = new JLabel("MODIFICAR CLIENTE");
		lblAgregarCliente.setHorizontalAlignment(SwingConstants.CENTER);
		lblAgregarCliente.setFont(new Font("JetBrains Mono SemiBold", Font.PLAIN, 15));
		lblAgregarCliente.setBounds(78, 98, 225, 34);
		frmAgregarCliente.getContentPane().add(lblAgregarCliente);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(95, 137, 192, 2);
		frmAgregarCliente.getContentPane().add(separator);
		
		JSeparator separator_3_2 = new JSeparator();
		separator_3_2.setOrientation(SwingConstants.VERTICAL);
		separator_3_2.setBounds(380, 25, 2, 298);
		frmAgregarCliente.getContentPane().add(separator_3_2);
		
		JLabel lblCalle = new JLabel("Calle:");
		lblCalle.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCalle.setFont(new Font("JetBrains Mono NL", Font.PLAIN, 13));
		lblCalle.setBounds(454, 55, 78, 34);
		frmAgregarCliente.getContentPane().add(lblCalle);
		
		textField = new JTextField();
		textField.setToolTipText("Ingrese Nombre");
		textField.setSelectedTextColor(Color.WHITE);
		textField.setName("");
		textField.setColumns(10);
		textField.setBounds(542, 60, 218, 27);
		frmAgregarCliente.getContentPane().add(textField);
		
		JLabel lblNmero = new JLabel("Número:");
		lblNmero.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNmero.setFont(new Font("JetBrains Mono NL", Font.PLAIN, 13));
		lblNmero.setBounds(455, 105, 78, 34);
		frmAgregarCliente.getContentPane().add(lblNmero);
		
		textField_3 = new JTextField();
		textField_3.setToolTipText("Ingrese Apellido");
		textField_3.setColumns(10);
		textField_3.setBounds(542, 108, 218, 27);
		frmAgregarCliente.getContentPane().add(textField_3);
		
		JLabel lblPisodepto = new JLabel("Piso/Depto:");
		lblPisodepto.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPisodepto.setFont(new Font("JetBrains Mono NL", Font.PLAIN, 13));
		lblPisodepto.setBounds(437, 150, 96, 34);
		frmAgregarCliente.getContentPane().add(lblPisodepto);
		
		textField_4 = new JTextField();
		textField_4.setToolTipText("Ingrese Teléfono");
		textField_4.setColumns(10);
		textField_4.setBounds(542, 153, 218, 27);
		frmAgregarCliente.getContentPane().add(textField_4);
		
		JLabel lblTelfono_1_1 = new JLabel("Código Postal:");
		lblTelfono_1_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTelfono_1_1.setFont(new Font("JetBrains Mono NL", Font.PLAIN, 13));
		lblTelfono_1_1.setBounds(380, 200, 152, 34);
		frmAgregarCliente.getContentPane().add(lblTelfono_1_1);
		
		textField_5 = new JTextField();
		textField_5.setToolTipText("Ingrese Teléfono");
		textField_5.setColumns(10);
		textField_5.setBounds(541, 203, 218, 27);
		frmAgregarCliente.getContentPane().add(textField_5);
		
		JLabel lblTelfono_1_1_1 = new JLabel("Provincia:");
		lblTelfono_1_1_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTelfono_1_1_1.setFont(new Font("JetBrains Mono NL", Font.PLAIN, 13));
		lblTelfono_1_1_1.setBounds(425, 245, 108, 34);
		frmAgregarCliente.getContentPane().add(lblTelfono_1_1_1);
		
		textField_6 = new JTextField();
		textField_6.setToolTipText("Ingrese Teléfono");
		textField_6.setColumns(10);
		textField_6.setBounds(542, 248, 218, 27);
		frmAgregarCliente.getContentPane().add(textField_6);
		
		textField_7 = new JTextField();
		textField_7.setToolTipText("Ingrese Teléfono");
		textField_7.setColumns(10);
		textField_7.setBounds(542, 293, 218, 27);
		frmAgregarCliente.getContentPane().add(textField_7);
		
		JLabel lblTelfono_1_1_1_1 = new JLabel("Localidad:");
		lblTelfono_1_1_1_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTelfono_1_1_1_1.setFont(new Font("JetBrains Mono NL", Font.PLAIN, 13));
		lblTelfono_1_1_1_1.setBounds(425, 290, 108, 34);
		frmAgregarCliente.getContentPane().add(lblTelfono_1_1_1_1);
		
		JLabel lblId = new JLabel("ID:");
		lblId.setHorizontalTextPosition(SwingConstants.RIGHT);
		lblId.setHorizontalAlignment(SwingConstants.RIGHT);
		lblId.setFont(new Font("JetBrains Mono NL", Font.PLAIN, 13));
		lblId.setBounds(33, 151, 78, 34);
		frmAgregarCliente.getContentPane().add(lblId);
		
		Choice choice = new Choice();
		choice.setBounds(121, 160, 95, 20);
		frmAgregarCliente.getContentPane().add(choice);
	}
}
