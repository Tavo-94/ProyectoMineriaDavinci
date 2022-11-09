package interfazWindowBuilder;

import java.awt.Color;
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
import java.awt.Button;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Label;
import javax.swing.JPanel;
import java.awt.Panel;
import java.awt.Component;
import java.awt.Rectangle;
import java.awt.Cursor;
import javax.swing.JRadioButtonMenuItem;

public class AdminSistemasMenu {

    private JFrame frmAdminsistemaMenu;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    AdminSistemasMenu window = new AdminSistemasMenu();
                    window.frmAdminsistemaMenu.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the application.
     */
    public AdminSistemasMenu() {
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frmAdminsistemaMenu = new JFrame();
        frmAdminsistemaMenu.setResizable(false);
        frmAdminsistemaMenu.setTitle("ADMINSISTEMAS MENU");
        frmAdminsistemaMenu.getContentPane().setBackground(Color.WHITE);
        frmAdminsistemaMenu.setBounds(100, 100, 752, 612);
        frmAdminsistemaMenu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frmAdminsistemaMenu.getContentPane().setLayout(null);
        
        JLabel lblNewLabel = new JLabel("New label");
        lblNewLabel.setIcon(new ImageIcon("D:\\carol\\aaaa.png"));
        lblNewLabel.setBounds(0, 358, 736, 215);
        frmAdminsistemaMenu.getContentPane().add(lblNewLabel);
        
        JMenuBar menuBar = new JMenuBar();
        menuBar.setBackground(new Color(153, 204, 204));
        menuBar.setBounds(0, 0, 891, 23);
        frmAdminsistemaMenu.getContentPane().add(menuBar);
        
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
        
        JMenu mnNewMenu_1 = new JMenu("ADMINSISTEMA");
        mnNewMenu_1.setFont(new Font("JetBrains Mono NL", Font.PLAIN, 12));
        menuBar.add(mnNewMenu_1);
        
        JMenu mnNewMenu_2 = new JMenu("ADMINVENTAS");
        mnNewMenu_1.add(mnNewMenu_2);
        
        JMenuItem mntmNewMenuItem_6 = new JMenuItem("Agregar AdminVentas");
        mnNewMenu_2.add(mntmNewMenuItem_6);
        
        JMenuItem mntmNewMenuItem_7 = new JMenuItem("Modificar AdminVentas");
        mnNewMenu_2.add(mntmNewMenuItem_7);
        
        JMenuItem mntmNewMenuItem_9 = new JMenuItem("Eliminar AdminVentas");
        mnNewMenu_2.add(mntmNewMenuItem_9);
        
        JSeparator separator_6 = new JSeparator();
        mnNewMenu_1.add(separator_6);
        
        JMenu mnNewMenu_3 = new JMenu("ADMINSTOCK");
        mnNewMenu_1.add(mnNewMenu_3);
        
        JMenuItem mntmNewMenuItem_10 = new JMenuItem("Agregar AdminStock");
        mnNewMenu_3.add(mntmNewMenuItem_10);
        
        JMenuItem mntmNewMenuItem_11 = new JMenuItem("Modificar AdminStock");
        mnNewMenu_3.add(mntmNewMenuItem_11);
        
        JMenuItem mntmNewMenuItem_12 = new JMenuItem("EliminarAdminStock");
        mnNewMenu_3.add(mntmNewMenuItem_12);
        
        JSeparator separator_3 = new JSeparator();
        separator_3.setOrientation(SwingConstants.VERTICAL);
        separator_3.setBounds(364, 70, 2, 519);
        frmAdminsistemaMenu.getContentPane().add(separator_3);
        
        JButton btnNewButton = new JButton("AGREGAR");
        btnNewButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        btnNewButton.setFont(new Font("JetBrains Mono NL", Font.PLAIN, 13));
        btnNewButton.setBounds(36, 225, 291, 23);
        frmAdminsistemaMenu.getContentPane().add(btnNewButton);
        
        JButton btnModificar = new JButton("MODIFICAR");
        btnModificar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        btnModificar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            }
        });
        btnModificar.setFont(new Font("JetBrains Mono NL", Font.PLAIN, 13));
        btnModificar.setBounds(36, 261, 291, 23);
        frmAdminsistemaMenu.getContentPane().add(btnModificar);
        
        JButton btnEliminar = new JButton("ELIMINAR");
        btnEliminar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        btnEliminar.setFont(new Font("JetBrains Mono NL", Font.PLAIN, 13));
        btnEliminar.setBounds(36, 295, 291, 23);
        frmAdminsistemaMenu.getContentPane().add(btnEliminar);
        
        JLabel lblNewLabel_1_1 = new JLabel("ADMIN VENTAS");
        lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_1_1.setFont(new Font("JetBrains Mono NL SemiBold", Font.PLAIN, 15));
        lblNewLabel_1_1.setBounds(85, 179, 192, 23);
        frmAdminsistemaMenu.getContentPane().add(lblNewLabel_1_1);
        
        JSeparator separator_5 = new JSeparator();
        separator_5.setBounds(70, 207, 221, 2);
        frmAdminsistemaMenu.getContentPane().add(separator_5);
        
        JSeparator separator_5_1 = new JSeparator();
        separator_5_1.setBounds(441, 207, 221, 2);
        frmAdminsistemaMenu.getContentPane().add(separator_5_1);
        
        JLabel lblNewLabel_1_1_1 = new JLabel("ADMIN STOCK");
        lblNewLabel_1_1_1.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_1_1_1.setFont(new Font("JetBrains Mono NL SemiBold", Font.PLAIN, 15));
        lblNewLabel_1_1_1.setBounds(456, 179, 192, 23);
        frmAdminsistemaMenu.getContentPane().add(lblNewLabel_1_1_1);
        
        JButton btnNewButton_1 = new JButton("AGREGAR");
        btnNewButton_1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        btnNewButton_1.setFont(new Font("JetBrains Mono NL", Font.PLAIN, 13));
        btnNewButton_1.setBounds(407, 225, 291, 23);
        frmAdminsistemaMenu.getContentPane().add(btnNewButton_1);
        
        JButton btnModificar_1 = new JButton("MODIFICAR");
        btnModificar_1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        btnModificar_1.setFont(new Font("JetBrains Mono NL", Font.PLAIN, 13));
        btnModificar_1.setBounds(407, 261, 291, 23);
        frmAdminsistemaMenu.getContentPane().add(btnModificar_1);
        
        JButton btnEliminar_1 = new JButton("ELIMINAR");
        btnEliminar_1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        btnEliminar_1.setFont(new Font("JetBrains Mono NL", Font.PLAIN, 13));
        btnEliminar_1.setBounds(407, 295, 291, 23);
        frmAdminsistemaMenu.getContentPane().add(btnEliminar_1);
        
        JLabel lblNewLabel_2 = new JLabel("");
        lblNewLabel_2.setIcon(new ImageIcon("D:\\carol\\checklist (1).png"));
        lblNewLabel_2.setBounds(526, 93, 71, 76);
        frmAdminsistemaMenu.getContentPane().add(lblNewLabel_2);
        
        JLabel lblNewLabel_2_1 = new JLabel("");
        lblNewLabel_2_1.setIcon(new ImageIcon("D:\\carol\\trade (1).png"));
        lblNewLabel_2_1.setBounds(146, 93, 71, 76);
        frmAdminsistemaMenu.getContentPane().add(lblNewLabel_2_1);
        
        JSeparator separator = new JSeparator();
        separator.setBounds(0, 70, 736, 2);
        frmAdminsistemaMenu.getContentPane().add(separator);
        
        JLabel lblNewLabel_1_1_2 = new JLabel("PANEL ADMIN SISTEMA");
        lblNewLabel_1_1_2.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_1_1_2.setFont(new Font("JetBrains Mono NL SemiBold", Font.PLAIN, 15));
        lblNewLabel_1_1_2.setBounds(0, 36, 726, 23);
        frmAdminsistemaMenu.getContentPane().add(lblNewLabel_1_1_2);
        
        JPanel panel = new JPanel();
        panel.setBounds(0, 11, 736, 61);
        frmAdminsistemaMenu.getContentPane().add(panel);
    }
}
