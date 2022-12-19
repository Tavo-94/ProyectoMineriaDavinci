package interfazWindowBuilder;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;

import negocio.ClienteDAO;
import negocio.DireccionDAO;

public class CONSULTARclienteParaEliminar {

	private JFrame frmConsultarClientes;
	private JTable table2;
	/**
	 * Launch the application.
	 */
	public static void consultarClientes() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CONSULTARclienteParaEliminar window = new CONSULTARclienteParaEliminar();
					window.frmConsultarClientes.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public CONSULTARclienteParaEliminar() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmConsultarClientes = new JFrame();
		frmConsultarClientes.setIconImage(Toolkit.getDefaultToolkit().getImage(CONSULTARclienteParaEliminar.class.getResource("/img/icon.png")));
		frmConsultarClientes.setBackground(Color.WHITE);
		frmConsultarClientes.setTitle("CONSULTAR CLIENTE ELIMINAR");
		frmConsultarClientes.setResizable(false);
		frmConsultarClientes.getContentPane().setBackground(Color.WHITE);
		frmConsultarClientes.getContentPane().setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBackground(Color.WHITE);
		scrollPane.setBounds(0, 59, 623, 279);
		frmConsultarClientes.getContentPane().add(scrollPane);
		
		table2 = new JTable();
		table2.setRowSelectionAllowed(false);
		table2.setFont(new Font("JetBrains Mono NL", Font.PLAIN, 14));
		table2.setBackground(Color.WHITE);
		table2.setFocusable(false);
		table2.setUpdateSelectionOnSort(false);
		scrollPane.setViewportView(table2);

	      table2.addMouseListener(new MouseAdapter() {
	          public void mouseClicked(MouseEvent me) {
	             if (me.getClickCount() == 1) {     // to detect doble click events
	                JTable target = (JTable)me.getSource();
	                Integer row = target.getSelectedRow(); // select a row
	                	                
	                Integer id = (Integer)table2.getValueAt(row, 0);
	                	        		
	                ClienteDAO clienteDAO = new ClienteDAO();
	                DireccionDAO direccionDAO = new DireccionDAO();
	                
	                direccionDAO.eliminarDireccion(id);
	                clienteDAO.eliminarCliente(id);
	                
	                
	             }
	          }
	       });
		
		JLabel lblNewLabel_1_1_2 = new JLabel("CONSULTAR CLIENTE PARA ELIMINAR");
		lblNewLabel_1_1_2.setForeground(Color.WHITE);
		lblNewLabel_1_1_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1_2.setFont(new Font("JetBrains Mono NL SemiBold", Font.PLAIN, 15));
		lblNewLabel_1_1_2.setBounds(0, 18, 623, 23);
		frmConsultarClientes.getContentPane().add(lblNewLabel_1_1_2);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.DARK_GRAY);
		panel.setBounds(0, 0, 623, 61);
		frmConsultarClientes.getContentPane().add(panel);
		
		JButton btnNewButton = new JButton("CERRAR");
		btnNewButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmConsultarClientes.dispose();
			
			}
		});
		btnNewButton.setBounds(318, 349, 102, 41);
		frmConsultarClientes.getContentPane().add(btnNewButton);
		
		JButton btnConsultar = new JButton("CONSULTAR");
		btnConsultar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnConsultar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				ClienteDAO clienteDAO = new ClienteDAO();
				
				table2.setModel(clienteDAO.modeloParaJTable());
				
		}
		
			
		});
		btnConsultar.setBounds(180, 349, 114, 41);
		frmConsultarClientes.getContentPane().add(btnConsultar);
		frmConsultarClientes.setBounds(100, 100, 639, 440);
		frmConsultarClientes.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}


}
