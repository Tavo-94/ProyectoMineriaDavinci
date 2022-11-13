package interfazWindowBuilder;

import java.awt.Button;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPasswordField;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import java.awt.Component;
import javax.swing.SwingConstants;

public class Login {

    private JFrame frmMetalplus;
    private JPasswordField passTxt;
    private JTextField userTxt;
    private JFrame frmAdminsistemas;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Login window = new Login();
                    window.frmMetalplus.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the application.
     */
    public Login() {
        initialize();
    }
    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frmMetalplus = new JFrame();
        frmMetalplus.setTitle("Login");
        frmMetalplus.setResizable(false);
        frmMetalplus.getContentPane().setForeground(Color.GRAY);
        frmMetalplus.setBackground(Color.WHITE);
        frmMetalplus.getContentPane().setBackground(Color.WHITE);
        frmMetalplus.getContentPane().setLayout(null);
        
        JMenuBar menuBar = new JMenuBar();
        menuBar.setBorder(null);
        menuBar.setBackground(new Color(153, 204, 204));
        menuBar.setBounds(0, 0, 709, 23);
        frmMetalplus.getContentPane().add(menuBar);
        
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
        
        
        JSeparator separator_1_1 = new JSeparator();
        separator_1_1.setOpaque(true);
        separator_1_1.setIgnoreRepaint(true);
        separator_1_1.setBounds(361, 295, 306, 2);
        frmMetalplus.getContentPane().add(separator_1_1);
        
     
        
        JLabel imagen = new JLabel("");
        imagen.setBounds(-35, 0, 358, 469);
        imagen.setIcon(new ImageIcon("D:\\carol\\two-horizontal-mining-banners-with-extractive-equipment\\18669a.jpg"));
        frmMetalplus.getContentPane().add(imagen);
        
        Button loginButton = new Button("LOGIN");
        loginButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        loginButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            }
        });
        loginButton.setForeground(new Color(255, 255, 255));
        loginButton.setFont(new Font("JetBrains Mono Medium", Font.BOLD, 17));
        loginButton.setBackground(new Color(128, 64, 0));
        loginButton.setBounds(390, 360, 249, 37);
        frmMetalplus.getContentPane().add(loginButton);
        
        JLabel usuarioTitulo = new JLabel("USUARIO");
        usuarioTitulo.setFont(new Font("JetBrains Mono NL SemiBold", Font.PLAIN, 14));
        usuarioTitulo.setForeground(new Color(160, 82, 45));
        usuarioTitulo.setBounds(361, 162, 134, 14);
        frmMetalplus.getContentPane().add(usuarioTitulo);
        
        JLabel passTitulo = new JLabel("PASSWORD");
        passTitulo.setForeground(new Color(160, 82, 45));
        passTitulo.setFont(new Font("JetBrains Mono NL SemiBold", Font.PLAIN, 14));
        passTitulo.setBounds(361, 246, 134, 14);
        frmMetalplus.getContentPane().add(passTitulo);
        
        JLabel mainTitulo = new JLabel("INICIAR SESIÓN");
        mainTitulo.setFont(new Font("JetBrains Mono", Font.BOLD, 17));
        mainTitulo.setBounds(360, 88, 306, 37);
        frmMetalplus.getContentPane().add(mainTitulo);
        
        JSeparator separator = new JSeparator();
        separator.setBounds(360, 123, 164, 2);
        frmMetalplus.getContentPane().add(separator);
        
        passTxt = new JPasswordField();
        passTxt.setBorder(null);
        passTxt.setText("**********");
        passTxt.setForeground(Color.LIGHT_GRAY);
        passTxt.setBounds(361, 266, 305, 27);
        frmMetalplus.getContentPane().add(passTxt);
        passTxt.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                userTxt.setText("");
                passTxt.setText("*******");
            }
        });
        
        userTxt = new JTextField();
        userTxt.setFont(new Font("JetBrains Mono", Font.PLAIN, 14));
        userTxt.setForeground(Color.LIGHT_GRAY);
        userTxt.setDisabledTextColor(Color.LIGHT_GRAY);
        userTxt.setBorder(null);
        userTxt.setText("Ingrese su nombre de usuario.");
        userTxt.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                userTxt.setText("");
                passTxt.setText("*******");
            }
        });
        userTxt.setBounds(361, 181, 302, 27);
        frmMetalplus.getContentPane().add(userTxt);
        userTxt.setColumns(10);
        
        JLabel lblNewLabel = new JLabel("MENU PRINCIPAL");
        lblNewLabel.setForeground(Color.GRAY);
        lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel.setHorizontalTextPosition(SwingConstants.CENTER);
        lblNewLabel.setFont(new Font("JetBrains Mono NL", Font.PLAIN, 13));
        lblNewLabel.setBounds(390, 403, 249, 14);
        frmMetalplus.getContentPane().add(lblNewLabel);
        
        JSeparator separator_1_1_1 = new JSeparator();
        separator_1_1_1.setOpaque(true);
        separator_1_1_1.setIgnoreRepaint(true);
        separator_1_1_1.setBounds(358, 211, 306, 2);
        frmMetalplus.getContentPane().add(separator_1_1_1);
        frmMetalplus.setBounds(100, 100, 725, 508);
        frmMetalplus.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
