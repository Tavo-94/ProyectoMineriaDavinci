package interfazWindowBuilder;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.UIManager;

public class AdminVentasMenu {

    private JFrame frmAdminventasMenu;

    /**
     * Launch the application.
     */
    public static void AdminVentasMenu() {
    	try {
    		UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
    	} catch (Throwable e) {
    		e.printStackTrace();
    	}
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    AdminVentasMenu window = new AdminVentasMenu();
                    window.frmAdminventasMenu.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the application.
     */
    public AdminVentasMenu() {
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frmAdminventasMenu = new JFrame();
        frmAdminventasMenu.setResizable(false);
        frmAdminventasMenu.setTitle("ADMINVENTAS MENU");
        frmAdminventasMenu.getContentPane().setBackground(Color.WHITE);
        frmAdminventasMenu.setBounds(100, 100, 752, 612);
        frmAdminventasMenu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frmAdminventasMenu.getContentPane().setLayout(null);
        
        JLabel lblNewLabel_1_1_2_1 = new JLabel("MENU PRINCIPAL");
        lblNewLabel_1_1_2_1.setForeground(Color.DARK_GRAY);
        lblNewLabel_1_1_2_1.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_1_1_2_1.setFont(new Font("JetBrains Mono NL SemiBold", Font.PLAIN, 12));
        lblNewLabel_1_1_2_1.setBounds(610, 21, 116, 51);
        frmAdminventasMenu.getContentPane().add(lblNewLabel_1_1_2_1);
        
        JLabel lblNewLabel = new JLabel("New label");
        lblNewLabel.setIcon(new ImageIcon("D:\\carol\\AAAAAAA.png"));
        lblNewLabel.setBounds(0, 358, 736, 215);
        frmAdminventasMenu.getContentPane().add(lblNewLabel);
        
        JMenuBar menuBar = new JMenuBar();
        menuBar.setBackground(new Color(153, 204, 204));
        menuBar.setBounds(0, 0, 891, 23);
        frmAdminventasMenu.getContentPane().add(menuBar);
        
        JMenu mnNewMenu = new JMenu("HOME");
        mnNewMenu.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        mnNewMenu.setFont(new Font("JetBrains Mono NL", Font.PLAIN, 12));
        menuBar.add(mnNewMenu);
        
        JMenuItem mntmNewMenuItem_8 = new JMenuItem("Menu Principal");
        mnNewMenu.add(mntmNewMenuItem_8);
        
        JSeparator separator_4 = new JSeparator();
        mnNewMenu.add(separator_4);
        
        JMenuItem mntmNewMenuItem_2 = new JMenuItem("AdminSistema");
        mnNewMenu.add(mntmNewMenuItem_2);
        
        JMenuItem mntmNewMenuItem_3 = new JMenuItem("AdminVentas");
        mnNewMenu.add(mntmNewMenuItem_3);
        
        JMenuItem mntmNewMenuItem_4 = new JMenuItem("AdminStock");
        mnNewMenu.add(mntmNewMenuItem_4);
        
        JSeparator separator_1 = new JSeparator();
        mnNewMenu.add(separator_1);
        
        JMenuItem mntmNewMenuItem = new JMenuItem("Login");
        mnNewMenu.add(mntmNewMenuItem);
        
        JMenuItem mntmNewMenuItem_5 = new JMenuItem("Log Out");
        mnNewMenu.add(mntmNewMenuItem_5);
        
        JSeparator separator_2 = new JSeparator();
        mnNewMenu.add(separator_2);
        
        JMenuItem mntmNewMenuItem_1 = new JMenuItem("Close");
        mnNewMenu.add(mntmNewMenuItem_1);
        
        JMenu mnNewMenu_1 = new JMenu("ADMINVENTAS");
        mnNewMenu_1.setFont(new Font("JetBrains Mono NL", Font.PLAIN, 12));
        mnNewMenu_1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        menuBar.add(mnNewMenu_1);
        
        JMenu mnNewMenu_2 = new JMenu("CLIENTES");
        mnNewMenu_1.add(mnNewMenu_2);
        
        JMenuItem mntmNewMenuItem_6 = new JMenuItem("Agregar Cliente");
        mnNewMenu_2.add(mntmNewMenuItem_6);
        
        JMenuItem mntmNewMenuItem_7 = new JMenuItem("Modificar Cliente");
        mnNewMenu_2.add(mntmNewMenuItem_7);
        
        JMenuItem mntmNewMenuItem_9 = new JMenuItem("Eliminar Cliente");
        mnNewMenu_2.add(mntmNewMenuItem_9);
        
        JSeparator separator = new JSeparator();
        mnNewMenu_1.add(separator);
        
        JMenu mnNewMenu_3 = new JMenu("VENTA");
        mnNewMenu_1.add(mnNewMenu_3);
        
        JMenuItem mntmNewMenuItem_10 = new JMenuItem("Realizar Venta");
        mnNewMenu_3.add(mntmNewMenuItem_10);
        
        JMenuItem mntmNewMenuItem_11 = new JMenuItem("Comprobante Venta");
        mnNewMenu_3.add(mntmNewMenuItem_11);
        
        JSeparator separator_3 = new JSeparator();
        mnNewMenu_1.add(separator_3);
        
        JMenu mnNewMenu_4 = new JMenu("STOCK");
        mnNewMenu_1.add(mnNewMenu_4);
        
        JMenuItem mntmNewMenuItem_12 = new JMenuItem("Consultar Stock");
        mnNewMenu_4.add(mntmNewMenuItem_12);
        
        JLabel lblNewLabel_1_1_2 = new JLabel("PANEL ADMINVENTAS");
        lblNewLabel_1_1_2.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_1_1_2.setFont(new Font("JetBrains Mono NL SemiBold", Font.PLAIN, 15));
        lblNewLabel_1_1_2.setBounds(0, 36, 726, 23);
        frmAdminventasMenu.getContentPane().add(lblNewLabel_1_1_2);
        
        JPanel panel = new JPanel();
        panel.setBounds(0, 11, 736, 61);
        frmAdminventasMenu.getContentPane().add(panel);
        
        JLabel lblNewLabel_1 = new JLabel("");
        lblNewLabel_1.setIcon(new ImageIcon("D:\\carol\\add-user.png"));
        lblNewLabel_1.setBounds(91, 101, 71, 77);
        frmAdminventasMenu.getContentPane().add(lblNewLabel_1);
        
        JLabel lblNewLabel_1_1 = new JLabel("CLIENTES");
        lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_1_1.setFont(new Font("JetBrains Mono NL SemiBold", Font.PLAIN, 15));
        lblNewLabel_1_1.setBounds(53, 180, 143, 23);
        frmAdminventasMenu.getContentPane().add(lblNewLabel_1_1);
        
        JSeparator separator_5 = new JSeparator();
        separator_5.setBounds(45, 209, 158, 2);
        frmAdminventasMenu.getContentPane().add(separator_5);
        
        JButton btnNewButton = new JButton("AGREGAR");
        btnNewButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		AGREGARcliente agregarCliente = new AGREGARcliente();
        		agregarCliente.addCliente();
        		
        	}
        });
        btnNewButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        btnNewButton.setFont(new Font("JetBrains Mono NL", Font.PLAIN, 13));
        btnNewButton.setBounds(26, 225, 192, 23);
        frmAdminventasMenu.getContentPane().add(btnNewButton);
        
        JButton btnModificar = new JButton("MODIFICAR");
        btnModificar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        btnModificar.setFont(new Font("JetBrains Mono NL", Font.PLAIN, 13));
        btnModificar.setBounds(26, 261, 192, 23);
        frmAdminventasMenu.getContentPane().add(btnModificar);
        
        JButton btnEliminar = new JButton("ELIMINAR");
        btnEliminar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        btnEliminar.setFont(new Font("JetBrains Mono NL", Font.PLAIN, 13));
        btnEliminar.setBounds(26, 295, 192, 23);
        frmAdminventasMenu.getContentPane().add(btnEliminar);
        
        JSeparator separator_3_2 = new JSeparator();
        separator_3_2.setOrientation(SwingConstants.VERTICAL);
        separator_3_2.setBounds(246, 46, 2, 519);
        frmAdminventasMenu.getContentPane().add(separator_3_2);
        
        JSeparator separator_3_2_1 = new JSeparator();
        separator_3_2_1.setOrientation(SwingConstants.VERTICAL);
        separator_3_2_1.setBounds(491, 26, 2, 519);
        frmAdminventasMenu.getContentPane().add(separator_3_2_1);
        
        JLabel lblNewLabel_1_2 = new JLabel("");
        lblNewLabel_1_2.setIcon(new ImageIcon("D:\\carol\\shopping-bag.png"));
        lblNewLabel_1_2.setBounds(342, 103, 64, 77);
        frmAdminventasMenu.getContentPane().add(lblNewLabel_1_2);
        
        JLabel lblNewLabel_1_1_1 = new JLabel("VENTA");
        lblNewLabel_1_1_1.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_1_1_1.setFont(new Font("JetBrains Mono NL SemiBold", Font.PLAIN, 15));
        lblNewLabel_1_1_1.setBounds(303, 180, 143, 23);
        frmAdminventasMenu.getContentPane().add(lblNewLabel_1_1_1);
        
        JSeparator separator_5_1 = new JSeparator();
        separator_5_1.setBounds(295, 209, 158, 2);
        frmAdminventasMenu.getContentPane().add(separator_5_1);
        
        JButton btnRealizar = new JButton("REALIZAR");
        btnRealizar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        btnRealizar.setFont(new Font("JetBrains Mono NL", Font.PLAIN, 13));
        btnRealizar.setBounds(276, 225, 192, 23);
        frmAdminventasMenu.getContentPane().add(btnRealizar);
        
        JLabel lblNewLabel_1_2_1 = new JLabel("");
        lblNewLabel_1_2_1.setIcon(new ImageIcon("D:\\carol\\conversation.png"));
        lblNewLabel_1_2_1.setBounds(587, 103, 64, 77);
        frmAdminventasMenu.getContentPane().add(lblNewLabel_1_2_1);
        
        JLabel lblNewLabel_1_1_1_1 = new JLabel("STOCK");
        lblNewLabel_1_1_1_1.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_1_1_1_1.setFont(new Font("JetBrains Mono NL SemiBold", Font.PLAIN, 15));
        lblNewLabel_1_1_1_1.setBounds(548, 180, 143, 23);
        frmAdminventasMenu.getContentPane().add(lblNewLabel_1_1_1_1);
        
        JSeparator separator_5_1_1 = new JSeparator();
        separator_5_1_1.setBounds(540, 209, 158, 2);
        frmAdminventasMenu.getContentPane().add(separator_5_1_1);
        
        JButton btnRealizar_1 = new JButton("CONSULTAR");
        btnRealizar_1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        btnRealizar_1.setFont(new Font("JetBrains Mono NL", Font.PLAIN, 13));
        btnRealizar_1.setBounds(521, 225, 192, 23);
        frmAdminventasMenu.getContentPane().add(btnRealizar_1);
        
        JButton btnComprobante = new JButton("COMPROBANTE");
        btnComprobante.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        btnComprobante.setFont(new Font("JetBrains Mono NL", Font.PLAIN, 13));
        btnComprobante.setBounds(276, 262, 192, 23);
        frmAdminventasMenu.getContentPane().add(btnComprobante);
    }
}
