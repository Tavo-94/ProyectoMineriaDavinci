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

public class AdminStockMenu {

    private JFrame frmAdminstockMenu;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
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
        frmAdminstockMenu.setResizable(false);
        frmAdminstockMenu.setTitle("ADMINSTOCK MENU");
        frmAdminstockMenu.getContentPane().setBackground(Color.WHITE);
        frmAdminstockMenu.setBounds(100, 100, 752, 612);
        frmAdminstockMenu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frmAdminstockMenu.getContentPane().setLayout(null);
        
        JMenuBar menuBar = new JMenuBar();
        menuBar.setBackground(new Color(153, 204, 204));
        menuBar.setBounds(0, 0, 891, 23);
        frmAdminstockMenu.getContentPane().add(menuBar);
        
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
        
        JLabel lblNewLabel_1_1_2 = new JLabel("PANEL ADMINSTOCK");
        lblNewLabel_1_1_2.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_1_1_2.setFont(new Font("JetBrains Mono NL SemiBold", Font.PLAIN, 15));
        lblNewLabel_1_1_2.setBounds(0, 36, 726, 23);
        frmAdminstockMenu.getContentPane().add(lblNewLabel_1_1_2);
        
        JPanel panel = new JPanel();
        panel.setBounds(0, 11, 736, 61);
        frmAdminstockMenu.getContentPane().add(panel);
        
        JLabel lblNewLabel_1 = new JLabel("");
        lblNewLabel_1.setIcon(new ImageIcon("D:\\carol\\checklist (3).png"));
        lblNewLabel_1.setBounds(132, 136, 128, 133);
        frmAdminstockMenu.getContentPane().add(lblNewLabel_1);
        
        JLabel lblNewLabel = new JLabel("");
        lblNewLabel.setIcon(new ImageIcon("D:\\carol\\adsdsa.png"));
        lblNewLabel.setBounds(391, 54, 345, 519);
        frmAdminstockMenu.getContentPane().add(lblNewLabel);
        
        JSeparator separator_5_1 = new JSeparator();
        separator_5_1.setBounds(77, 308, 221, 2);
        frmAdminstockMenu.getContentPane().add(separator_5_1);
        
        JLabel lblNewLabel_1_1_1 = new JLabel("STOCK");
        lblNewLabel_1_1_1.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_1_1_1.setFont(new Font("JetBrains Mono NL SemiBold", Font.PLAIN, 15));
        lblNewLabel_1_1_1.setBounds(92, 280, 192, 23);
        frmAdminstockMenu.getContentPane().add(lblNewLabel_1_1_1);
        
        JButton btnNewButton_1 = new JButton("AGREGAR NUEVO STOCK");
        btnNewButton_1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        btnNewButton_1.setFont(new Font("JetBrains Mono NL", Font.PLAIN, 13));
        btnNewButton_1.setBounds(43, 326, 291, 23);
        frmAdminstockMenu.getContentPane().add(btnNewButton_1);
        
        JButton btnModificar_1 = new JButton("MODIFICAR EXISTENTE");
        btnModificar_1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        btnModificar_1.setFont(new Font("JetBrains Mono NL", Font.PLAIN, 13));
        btnModificar_1.setBounds(43, 362, 291, 23);
        frmAdminstockMenu.getContentPane().add(btnModificar_1);
        
        JButton btnEliminar_1 = new JButton("ACTUALIZAR ");
        btnEliminar_1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        btnEliminar_1.setFont(new Font("JetBrains Mono NL", Font.PLAIN, 13));
        btnEliminar_1.setBounds(43, 396, 291, 23);
        frmAdminstockMenu.getContentPane().add(btnEliminar_1);
        
        JButton btnEliminar_1_1 = new JButton("ELIMINAR");
        btnEliminar_1_1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        btnEliminar_1_1.setFont(new Font("JetBrains Mono NL", Font.PLAIN, 13));
        btnEliminar_1_1.setBounds(43, 430, 291, 23);
        frmAdminstockMenu.getContentPane().add(btnEliminar_1_1);
    }

}
