package interfazWindowBuilder;

import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.stream.Collectors;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import com.mysql.jdbc.ResultSetMetaData;
import com.mysql.jdbc.Statement;

import negocio.MaterialDAO;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.awt.event.ActionEvent;
import java.awt.Cursor;
import java.awt.Toolkit;

public class CONSULTARstock {

	private JFrame frmConsultarStock;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void consultarStock() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CONSULTARstock window = new CONSULTARstock();
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
	public CONSULTARstock() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmConsultarStock = new JFrame();
		frmConsultarStock.setIconImage(Toolkit.getDefaultToolkit().getImage("D:\\carol\\casco-de-seguridad.png"));
		frmConsultarStock.setBackground(Color.WHITE);
		frmConsultarStock.setTitle("CONSULTAR STOCK");
		frmConsultarStock.setResizable(false);
		frmConsultarStock.getContentPane().setBackground(Color.WHITE);
		frmConsultarStock.getContentPane().setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBackground(Color.WHITE);
		scrollPane.setBounds(0, 59, 623, 279);
		frmConsultarStock.getContentPane().add(scrollPane);
		
		table = new JTable();
		table.setRowSelectionAllowed(false);
		table.setFont(new Font("JetBrains Mono NL", Font.PLAIN, 14));
		table.setBackground(Color.WHITE);
		table.setFocusable(false);
		table.setUpdateSelectionOnSort(false);
		scrollPane.setViewportView(table);
		
		JLabel lblNewLabel_1_1_2 = new JLabel("CONSULTAR STOCK");
		lblNewLabel_1_1_2.setForeground(Color.WHITE);
		lblNewLabel_1_1_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1_2.setFont(new Font("JetBrains Mono NL SemiBold", Font.PLAIN, 15));
		lblNewLabel_1_1_2.setBounds(0, 18, 623, 23);
		frmConsultarStock.getContentPane().add(lblNewLabel_1_1_2);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.DARK_GRAY);
		panel.setBounds(0, 0, 623, 61);
		frmConsultarStock.getContentPane().add(panel);
		
		JButton btnNewButton = new JButton("CERRAR");
		btnNewButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmConsultarStock.dispose();
			
			}
		});
		btnNewButton.setBounds(318, 349, 102, 41);
		frmConsultarStock.getContentPane().add(btnNewButton);
		
		JButton btnConsultar = new JButton("CONSULTAR");
		btnConsultar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnConsultar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				MaterialDAO materialDAO = new MaterialDAO();
				
				table.setModel(materialDAO.modeloParaJTable());
				
		}
		
			
		});
		btnConsultar.setBounds(180, 349, 114, 41);
		frmConsultarStock.getContentPane().add(btnConsultar);
		frmConsultarStock.setBounds(100, 100, 639, 440);
		frmConsultarStock.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
