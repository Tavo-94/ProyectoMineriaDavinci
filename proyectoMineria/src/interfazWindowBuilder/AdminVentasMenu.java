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

public class AdminVentasMenu {

    private JFrame frmAdminventasMenu;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
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
        frmAdminventasMenu.setTitle("ADMINSTOCK MENU");
        frmAdminventasMenu.getContentPane().setBackground(Color.WHITE);
        frmAdminventasMenu.setBounds(100, 100, 752, 612);
        frmAdminventasMenu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frmAdminventasMenu.getContentPane().setLayout(null);
        
        JLabel lblNewLabel = new JLabel("New label");
        lblNewLabel.setIcon(new ImageIcon("D:\\carol\\AdobeStock_2813541252.jpg"));
        lblNewLabel.setBounds(-87, 371, 920, 246);
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
    }

}
