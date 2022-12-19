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

import negocio.TicketOperacionDAO;

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
				
				TicketOperacionDAO ticketDAO = new TicketOperacionDAO();
				
				table.setModel(ticketDAO.mostrarTodasLasOperaciones());
				
			
		}
		});
		btnConsultar.setBounds(316, 453, 114, 41);
		frmConsultarStock.getContentPane().add(btnConsultar);
		frmConsultarStock.setBounds(100, 100, 913, 555);
		frmConsultarStock.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}
}

