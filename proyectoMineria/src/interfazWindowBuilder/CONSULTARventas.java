package interfazWindowBuilder;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

public class CONSULTARventas {

	private JFrame frmConsultarStock;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void consultarVentas() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CONSULTARventas window = new CONSULTARventas();
					window.frmConsultarStock.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public CONSULTARventas() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmConsultarStock = new JFrame();
		frmConsultarStock.setIconImage(Toolkit.getDefaultToolkit().getImage(CONSULTARventas.class.getResource("/img/icon.png")));
		frmConsultarStock.setBackground(Color.WHITE);
		frmConsultarStock.setTitle("CONSULTAR VENTA");
		frmConsultarStock.setResizable(false);
		frmConsultarStock.getContentPane().setBackground(Color.WHITE);
		frmConsultarStock.getContentPane().setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBackground(Color.WHITE);
		scrollPane.setBounds(0, 59, 897, 372);
		frmConsultarStock.getContentPane().add(scrollPane);
		
		table = new JTable();
		table.setRowSelectionAllowed(false);
		table.setFont(new Font("JetBrains Mono NL", Font.PLAIN, 14));
		table.setBackground(Color.WHITE);
		scrollPane.setViewportView(table);
		
		JLabel lblNewLabel_1_1_2 = new JLabel("CONSULTAR VENTA");
		lblNewLabel_1_1_2.setForeground(Color.WHITE);
		lblNewLabel_1_1_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1_2.setFont(new Font("JetBrains Mono NL SemiBold", Font.PLAIN, 15));
		lblNewLabel_1_1_2.setBounds(0, 18, 897, 23);
		frmConsultarStock.getContentPane().add(lblNewLabel_1_1_2);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.DARK_GRAY);
		panel.setBounds(0, 0, 897, 61);
		frmConsultarStock.getContentPane().add(panel);
		
		JButton btnNewButton = new JButton("CERRAR");
		btnNewButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmConsultarStock.dispose();
			
			}
		});
		btnNewButton.setBounds(454, 453, 102, 41);
		frmConsultarStock.getContentPane().add(btnNewButton);
		
		JButton btnConsultar = new JButton("CONSULTAR");
		btnConsultar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnConsultar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Class.forName("com.mysql.jdbc.Driver");
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mineria","root","");
					
					java.sql.Statement st = con.createStatement();
					
					String sql= "SELECT cliente_con_direccion.idcliente, \r\n"
							+ "	cliente_con_direccion.nombre,\r\n"
							+ "	cliente_con_direccion.apellido,\r\n"
							+ "    cliente_con_direccion.calle,\r\n"
							+ "    cliente_con_direccion.numero,\r\n"
							+ "    cliente_con_direccion.ciudad,\r\n"
							+ "    material_pedido.tipo,\r\n"
							+ "    material_pedido.cantidad,\r\n"
							+ "    material_pedido.pureza,\r\n"
							+ "    pedido.admin_ventas_nombre_usuario AS vendedor,\r\n"
							+ "    pedido.fecha,\r\n"
							+ "    pedido.total\r\n"
							+ "FROM (\r\n"
							+ "	SELECT * FROM cliente\r\n"
							+ "    INNER JOIN direccion\r\n"
							+ "    	ON cliente.idcliente = direccion.cliente_idcliente\r\n"
							+ ")AS cliente_con_direccion\r\n"
							+ "JOIN pedido\r\n"
							+ "	on pedido.cliente_idcliente = cliente_con_direccion.idcliente\r\n"
							+ "JOIN material_pedido\r\n"
							+ "	ON pedido.material_pedido_idmaterial = material_pedido.idmaterial\r\n";
						
					ResultSet rs = st.executeQuery(sql);
					java.sql.ResultSetMetaData rsmd = rs.getMetaData();
					DefaultTableModel model = (DefaultTableModel) table.getModel();
					
					int cols=rsmd.getColumnCount();
					String[] colName=new String[cols];
					for(int i=0;i<cols;i++)
						colName[i]=rsmd.getColumnName(i+1);
					model.setColumnIdentifiers(colName);
					
					String id,nombre, apellido, calle, numero, pureza,cantidad, vendedor, fecha, total, ciudad, tipo;
					
					while(rs.next()) {
						id=rs.getString(1);
						nombre=rs.getString(2);
						apellido=rs.getString(3);
						calle=rs.getString(4);
						numero=rs.getString(5);
						ciudad=rs.getString(6);
						tipo=rs.getString(7);
						cantidad=rs.getString(8);
						pureza=rs.getString(9);
						vendedor=rs.getString(10);
						fecha=rs.getString(11);
						total=rs.getString(12);
						String[] row= {id,nombre, apellido, calle, numero, pureza,cantidad, vendedor, fecha, total, ciudad, tipo};
						model.addRow(row);
						
					}
						
					
					
						st.close();
					con.close();				
			} catch(Exception e1) {
				System.out.println(e1.getMessage());
			}
		}
		
			
		});
		btnConsultar.setBounds(316, 453, 114, 41);
		frmConsultarStock.getContentPane().add(btnConsultar);
		frmConsultarStock.setBounds(100, 100, 913, 555);
		frmConsultarStock.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
