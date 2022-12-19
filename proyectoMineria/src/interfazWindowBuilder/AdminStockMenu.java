package interfazWindowBuilder;

import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import javax.swing.JPanel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.UIManager;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;

public class AdminStockMenu {

    private JFrame frmAdminstockMenu;

    /**
     * Launch the application.
     */
    public static void AdminStockMenu() {
    	try {
    		UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
    	} catch (Throwable e) {
    		e.printStackTrace();
    	}
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    AdminStockMenu window = new AdminStockMenu();
                    window.frmAdminstockMenu.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the application.
     */
    public AdminStockMenu() {
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frmAdminstockMenu = new JFrame();
        frmAdminstockMenu.setIconImage(Toolkit.getDefaultToolkit().getImage(AdminStockMenu.class.getResource("/img/icon.png")));
        frmAdminstockMenu.setResizable(false);
        frmAdminstockMenu.setTitle("ADMINSTOCK MENU");
        frmAdminstockMenu.getContentPane().setBackground(Color.WHITE);
        frmAdminstockMenu.setBounds(100, 100, 752, 612);
        frmAdminstockMenu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frmAdminstockMenu.getContentPane().setLayout(null);
        
        JLabel lblNewLabel_1_1_2_1 = new JLabel("MENU PRINCIPAL");
        lblNewLabel_1_1_2_1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        lblNewLabel_1_1_2_1.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent e) {
        		frmAdminstockMenu.dispose();
        		PantallaPrincipal main = new PantallaPrincipal();
        		main.Aplicacion();
        	}
        	
        });
        lblNewLabel_1_1_2_1.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_1_1_2_1.setForeground(Color.DARK_GRAY);
        lblNewLabel_1_1_2_1.setFont(new Font("JetBrains Mono NL SemiBold", Font.PLAIN, 12));
        lblNewLabel_1_1_2_1.setBounds(610, 21, 116, 50);
        frmAdminstockMenu.getContentPane().add(lblNewLabel_1_1_2_1);
        
        JMenuBar menuBar = new JMenuBar();
        menuBar.setBackground(new Color(153, 204, 204));
        menuBar.setBounds(0, 0, 891, 23);
        frmAdminstockMenu.getContentPane().add(menuBar);
        
        JMenu mnNewMenu = new JMenu("HOME");
        mnNewMenu.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        mnNewMenu.setFont(new Font("JetBrains Mono NL", Font.PLAIN, 12));
        menuBar.add(mnNewMenu);
        
        JMenuItem mntmNewMenuItem_8 = new JMenuItem("Menu Principal");
        mntmNewMenuItem_8.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		frmAdminstockMenu.dispose();
        		PantallaPrincipal main = new PantallaPrincipal();
        		main.Aplicacion();
        	}
        });
        mnNewMenu.add(mntmNewMenuItem_8);
        
        JSeparator separator_4 = new JSeparator();
        mnNewMenu.add(separator_4);
        
        JMenuItem mntmNewMenuItem = new JMenuItem("Login");
        mntmNewMenuItem.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		frmAdminstockMenu.dispose();
            	Login login = new Login();
        		login.VentanaLogin();
        	}
        });
        mnNewMenu.add(mntmNewMenuItem);
        
        JMenuItem mntmNewMenuItem_5 = new JMenuItem("Log Out");
        mnNewMenu.add(mntmNewMenuItem_5);
        
        JSeparator separator_2 = new JSeparator();
        mnNewMenu.add(separator_2);
        
        JMenuItem mntmNewMenuItem_1 = new JMenuItem("Close");
        mnNewMenu.add(mntmNewMenuItem_1);
        
        JMenu mnNewMenu_1 = new JMenu("ADMINSTOCK");
        mnNewMenu_1.setFont(new Font("JetBrains Mono NL", Font.PLAIN, 12));
        mnNewMenu_1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        menuBar.add(mnNewMenu_1);
        
        JMenuItem mntmAgregarStock = new JMenuItem("Agregar Stock");
        mntmAgregarStock.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		AGREGARstock agregarStock = new AGREGARstock();
        		agregarStock.addStock();
        	}
        });
        mnNewMenu_1.add(mntmAgregarStock);
        
        JMenuItem mntmConsultarStock = new JMenuItem("Consultar Stock");
        mntmConsultarStock.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		MoEliMaterial modifyStock = new MoEliMaterial(null);
        		modifyStock.modifyStock();
        		frmAdminstockMenu.dispose();
        	}
        });
        mnNewMenu_1.add(mntmConsultarStock);
        
        JMenuItem mntmBuscar = new JMenuItem("Buscar Material");
        mnNewMenu_1.add(mntmBuscar);
        
        
        JLabel lblNewLabel_1_1_2 = new JLabel("PANEL ADMINSTOCK");
        lblNewLabel_1_1_2.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_1_1_2.setFont(new Font("JetBrains Mono NL SemiBold", Font.PLAIN, 15));
        lblNewLabel_1_1_2.setBounds(0, 36, 726, 23);
        frmAdminstockMenu.getContentPane().add(lblNewLabel_1_1_2);
        
        JPanel panel = new JPanel();
        panel.setBounds(0, 11, 736, 61);
        frmAdminstockMenu.getContentPane().add(panel);
        
        JLabel lblNewLabel_1 = new JLabel("");
        lblNewLabel_1.setIcon(new ImageIcon(AdminStockMenu.class.getResource("/img/BIGadminstockicon.png")));
        lblNewLabel_1.setBounds(132, 150, 128, 133);
        frmAdminstockMenu.getContentPane().add(lblNewLabel_1);
        
        JLabel lblNewLabel = new JLabel("");
        lblNewLabel.setIcon(new ImageIcon(AdminStockMenu.class.getResource("/img/adminstock.png")));
        lblNewLabel.setBounds(391, 54, 345, 519);
        frmAdminstockMenu.getContentPane().add(lblNewLabel);
        
        JSeparator separator_5_1 = new JSeparator();
        separator_5_1.setBounds(80, 322, 221, 2);
        frmAdminstockMenu.getContentPane().add(separator_5_1);
        
        JLabel lblNewLabel_1_1_1 = new JLabel("STOCK");
        lblNewLabel_1_1_1.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_1_1_1.setFont(new Font("JetBrains Mono NL SemiBold", Font.PLAIN, 15));
        lblNewLabel_1_1_1.setBounds(80, 294, 207, 23);
        frmAdminstockMenu.getContentPane().add(lblNewLabel_1_1_1);
        
        JButton btnAgregarStock = new JButton("AGREGAR NUEVO STOCK");
        btnAgregarStock.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		AGREGARstock agregarStock = new AGREGARstock();
        		agregarStock.addStock();
        		
        		frmAdminstockMenu.dispose();
       
        	}
        });
        btnAgregarStock.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        btnAgregarStock.setFont(new Font("JetBrains Mono NL", Font.PLAIN, 13));
        btnAgregarStock.setBounds(46, 340, 291, 23);
        frmAdminstockMenu.getContentPane().add(btnAgregarStock);
        
        JButton btnConsultar = new JButton("CONSULTAR STOCK");
        btnConsultar.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		MoEliMaterial.modifyMaterial(null);
        		
        	}
        });
        btnConsultar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        btnConsultar.setFont(new Font("JetBrains Mono NL", Font.PLAIN, 13));
        btnConsultar.setBounds(46, 376, 291, 23);
        frmAdminstockMenu.getContentPane().add(btnConsultar);
        
        JButton btnBuscarMaterial = new JButton("BUSCAR MATERIAL");
        btnBuscarMaterial.setFont(new Font("Dialog", Font.PLAIN, 13));
        btnBuscarMaterial.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		CONSULTARstock2.consultarStock();
        	}
        });
        btnBuscarMaterial.setBounds(46, 409, 291, 27);
        frmAdminstockMenu.getContentPane().add(btnBuscarMaterial);
    }
}