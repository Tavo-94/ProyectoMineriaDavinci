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

import negocio.AdminStockDAO;
import negocio.ClienteDAO;
import negocio.DireccionDAO;
import proyectoMineria.Cliente;
import proyectoMineria.DireccionCliente;
import proyectoMineria.Material;

import java.awt.Choice;
import java.awt.Toolkit;

public class MoEliMaterial {

	private JFrame frmMoEliMaterial;
	private JTextField txtTipo;
	private JTextField textPureza;
	private JTextField textCantidad;
	private JTextField textFecha;
	private static Integer fila;
	private static Material materialDeLaDB;

	public static void modifyMaterial(Integer fila) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MoEliMaterial window = new MoEliMaterial(fila);
					window.frmMoEliMaterial.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public MoEliMaterial(Integer row) {

		
		System.out.println("llegue al modificarcliente!!!");
		System.out.println(row);
		
		System.out.println(fila);

		AdminStockDAO material = new AdminStockDAO();

		MoEliMaterial.materialDeLaDB = material.obtenerTodosLosDatosPorId(row);
		
		System.out.println(materialDeLaDB);
		initialize();

	}
	
	private void initialize() {
		frmMoEliMaterial = new JFrame();
		frmMoEliMaterial.setIconImage(Toolkit.getDefaultToolkit().getImage(MoEliMaterial.class.getResource("/img/icon.png")));
		frmMoEliMaterial.getContentPane().setBackground(Color.WHITE);
		frmMoEliMaterial.getContentPane().setForeground(Color.WHITE);
		frmMoEliMaterial.setTitle("Modificar Cliente");
		frmMoEliMaterial.setResizable(false);
		frmMoEliMaterial.setBounds(100, 100, 405, 465);
		frmMoEliMaterial.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmMoEliMaterial.getContentPane().setLayout(null);

		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(MoEliMaterial.class.getResource("/img/MODIFICAR.png")));
		lblNewLabel_1.setBounds(155, 25, 71, 77);
		frmMoEliMaterial.getContentPane().add(lblNewLabel_1);

		JLabel lblTipo = new JLabel("Tipo:");
		lblTipo.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTipo.setFont(new Font("JetBrains Mono NL", Font.PLAIN, 13));
		lblTipo.setBounds(34, 162, 78, 34);
		frmMoEliMaterial.getContentPane().add(lblTipo);

		JLabel lblPureza = new JLabel("Pureza:");
		lblPureza.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPureza.setFont(new Font("JetBrains Mono NL", Font.PLAIN, 13));
		lblPureza.setBounds(34, 199, 78, 34);
		frmMoEliMaterial.getContentPane().add(lblPureza);

		JLabel lblCantidad = new JLabel("Cantidad:");
		lblCantidad.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCantidad.setFont(new Font("JetBrains Mono NL", Font.PLAIN, 13));
		lblCantidad.setBounds(34, 243, 78, 34);
		frmMoEliMaterial.getContentPane().add(lblCantidad);

		JButton btnCancel = new JButton("CANCELAR");
		btnCancel.setFont(new Font("Dialog", Font.PLAIN, 13));
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmMoEliMaterial.dispose();
			}
		});
		btnCancel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnCancel.setBounds(121, 374, 143, 34);
		frmMoEliMaterial.getContentPane().add(btnCancel);

		txtTipo = new JTextField();
		txtTipo.setToolTipText("Ingrese Nombre");
		txtTipo.setSelectedTextColor(Color.WHITE);
		txtTipo.setName("");
		txtTipo.setBounds(121, 167, 218, 27);
		frmMoEliMaterial.getContentPane().add(txtTipo);
		txtTipo.setColumns(10);

		JButton btnModificar = new JButton("MODIFICAR");
		btnModificar.setFont(new Font("Dialog", Font.PLAIN, 13));
		btnModificar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnModificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				AdminStockDAO material = new AdminStockDAO();
				
				materialDeLaDB.setTipo(null);
				materialDeLaDB.setPureza(null);
				materialDeLaDB.setCantidad(null);
				materialDeLaDB.setFecha_ingreso(null);
				
				material.modificarMaterial(materialDeLaDB);
			}
		});
		btnModificar.setBounds(55, 317, 105, 47);
		frmMoEliMaterial.getContentPane().add(btnModificar);

		textPureza = new JTextField();
		textPureza.setToolTipText("Ingrese Apellido");
		textPureza.setColumns(10);
		textPureza.setBounds(121, 204, 218, 27);
		frmMoEliMaterial.getContentPane().add(textPureza);

		textCantidad = new JTextField();
		textCantidad.setToolTipText("Ingrese Teléfono");
		textCantidad.setColumns(10);
		textCantidad.setBounds(121, 241, 218, 27);
		frmMoEliMaterial.getContentPane().add(textCantidad);

		JLabel lblAgregarCliente = new JLabel("MODIFICAR/ELIMINAR MATERIAL");
		lblAgregarCliente.setHorizontalAlignment(SwingConstants.CENTER);
		lblAgregarCliente.setFont(new Font("JetBrains Mono SemiBold", Font.PLAIN, 15));
		lblAgregarCliente.setBounds(45, 98, 308, 34);
		frmMoEliMaterial.getContentPane().add(lblAgregarCliente);

		JSeparator separator = new JSeparator();
		separator.setBounds(95, 137, 192, 2);
		frmMoEliMaterial.getContentPane().add(separator);

		JLabel lblFecha = new JLabel("Fecha:");
		lblFecha.setHorizontalAlignment(SwingConstants.RIGHT);
		lblFecha.setFont(new Font("JetBrains Mono NL", Font.PLAIN, 13));
		lblFecha.setBounds(34, 273, 78, 34);
		frmMoEliMaterial.getContentPane().add(lblFecha);

		textFecha = new JTextField();
		textFecha.setToolTipText("Ingrese Nombre");
		textFecha.setSelectedTextColor(Color.WHITE);
		textFecha.setName("");
		textFecha.setColumns(10);
		textFecha.setBounds(121, 278, 218, 27);
		frmMoEliMaterial.getContentPane().add(textFecha);
		
		// seteo los datos de la table en el formulario

		txtTipo.setText(materialDeLaDB.getTipo());
		textPureza.setText(materialDeLaDB.getPureza());
		textCantidad.setText(materialDeLaDB.getCantidad().toString());
		textFecha.setText(materialDeLaDB.getFecha_ingreso().format(null));
		
		JButton btnEliminar = new JButton("ELIMINAR");
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				AdminStockDAO materialD = new AdminStockDAO();
				
				materialD.eliminarMaterial(null);
			}
		});
		btnEliminar.setFont(new Font("Dialog", Font.PLAIN, 13));
		btnEliminar.setBounds(211, 317, 105, 47);
		frmMoEliMaterial.getContentPane().add(btnEliminar);



	}

	public static Integer getFila() {
		return fila;
	}

	public static void setFila(Integer fila) {
		MoEliMaterial.fila = fila;
	}

	public void modifyStock() {
		// TODO Auto-generated method stub
		
	}
}
