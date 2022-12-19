package interfazWindowBuilder;

import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.stream.Collectors;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import com.mysql.jdbc.ResultSetMetaData;
import com.mysql.jdbc.Statement;

import negocio.AdminStockDAO;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.awt.event.ActionEvent;
import java.awt.Cursor;
import java.awt.Toolkit;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JSeparator;

public class CONSULTARstock2 {

	private JFrame frmConsultarStock;

	/**
	 * Launch the application.
	 */
	public static void consultarStock() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CONSULTARstock2 window = new CONSULTARstock2();
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
	public CONSULTARstock2() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	@SuppressWarnings("unchecked")
	private void initialize() {
		frmConsultarStock = new JFrame();
		frmConsultarStock.setIconImage(Toolkit.getDefaultToolkit().getImage("D:\\carol\\casco-de-seguridad.png"));
		frmConsultarStock.setBackground(Color.WHITE);
		frmConsultarStock.setTitle("CONSULTAR STOCK");
		frmConsultarStock.setResizable(false);
		frmConsultarStock.getContentPane().setBackground(Color.WHITE);
		frmConsultarStock.getContentPane().setLayout(null);
		
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
		btnNewButton.setFont(new Font("Dialog", Font.PLAIN, 13));
		btnNewButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmConsultarStock.dispose();
			
			}
		});
		btnNewButton.setBounds(276, 338, 102, 41);
		frmConsultarStock.getContentPane().add(btnNewButton);
		
		JComboBox comboBoxTipo = new JComboBox();
		comboBoxTipo.setFont(new Font("Dialog", Font.PLAIN, 13));
		comboBoxTipo.setModel(new DefaultComboBoxModel(new String[] {"Oro", "Plata", "Cobre", "*"}));
		comboBoxTipo.setBounds(180, 111, 125, 30);
		frmConsultarStock.getContentPane().add(comboBoxTipo);
		
		JLabel lblTipo = new JLabel("Tipo:");
		lblTipo.setFont(new Font("Dialog", Font.PLAIN, 14));
		lblTipo.setBounds(113, 111, 52, 30);
		frmConsultarStock.getContentPane().add(lblTipo);
		
		JLabel lblPureza = new JLabel("Pureza:");
		lblPureza.setFont(new Font("Dialog", Font.PLAIN, 14));
		lblPureza.setBounds(113, 265, 52, 30);
		frmConsultarStock.getContentPane().add(lblPureza);
		frmConsultarStock.setBounds(100, 100, 639, 440);
		frmConsultarStock.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JButton btnConsultar = new JButton("CONSULTAR");
		btnConsultar.setFont(new Font("Dialog", Font.PLAIN, 13));
		btnConsultar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnConsultar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String Item;
				Item = comboBoxTipo.getSelectedItem().toString();
					
				AdminStockDAO porTipo = new AdminStockDAO();
				porTipo.mostrarStockTipo(Item);
			}
		});
		btnConsultar.setBounds(391, 100, 114, 41);
		frmConsultarStock.getContentPane().add(btnConsultar);
		
		JSeparator separator_5_1 = new JSeparator();
		separator_5_1.setBounds(91, 182, 484, 2);
		frmConsultarStock.getContentPane().add(separator_5_1);
		
		JComboBox comboBoxTipo_1 = new JComboBox();
		comboBoxTipo_1.setModel(new DefaultComboBoxModel(new String[] {"Oro", "Plata", "Cobre"}));
		comboBoxTipo_1.setFont(new Font("Dialog", Font.PLAIN, 13));
		comboBoxTipo_1.setBounds(180, 209, 125, 30);
		frmConsultarStock.getContentPane().add(comboBoxTipo_1);
		
		JLabel lblTipo_1 = new JLabel("Tipo:");
		lblTipo_1.setFont(new Font("Dialog", Font.PLAIN, 14));
		lblTipo_1.setBounds(113, 209, 52, 30);
		frmConsultarStock.getContentPane().add(lblTipo_1);
		
		
		JComboBox comboBoxPureza = new JComboBox();
		comboBoxPureza.setModel(new DefaultComboBoxModel(new String[] {"Alta", "Media", "Baja"}));
		comboBoxPureza.setFont(new Font("Dialog", Font.PLAIN, 13));
		comboBoxPureza.setBounds(180, 265, 125, 30);
		frmConsultarStock.getContentPane().add(comboBoxPureza);
		
		JButton btnConsultarPureza = new JButton("CONSULTAR");
		btnConsultarPureza.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String Item, Item2;
				Item = comboBoxTipo_1.getSelectedItem().toString();
				Item2 = comboBoxPureza.getSelectedItem().toString();
				
				AdminStockDAO porTipo = new AdminStockDAO();
				if (Item2.equals("Alta")) {
					porTipo.mostrarStockTipoPurezaAlta(Item);
				} if (Item2.equals("Media")) {
					porTipo.mostrarStockTipoPurezaMedia(Item);
				} if (Item2.equals("Baja")) {
					porTipo.mostrarStockTipoPurezaBaja(Item);
				}
				
				
			}
		});
		btnConsultarPureza.setFont(new Font("Dialog", Font.PLAIN, 13));
		btnConsultarPureza.setBounds(391, 226, 114, 41);
		frmConsultarStock.getContentPane().add(btnConsultarPureza);
	
	}
}
