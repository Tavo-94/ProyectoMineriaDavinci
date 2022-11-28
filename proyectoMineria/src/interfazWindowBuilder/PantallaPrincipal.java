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
import javax.swing.JTextArea;
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
import javax.swing.UIManager;

public class PantallaPrincipal {

    private JFrame frame;
    private JFrame frmAdminsistemas;

    /**
     * Launch the application.
     */
    public static void Aplicacion() {
    	try {
    		UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
    	} catch (Throwable e) {
    		e.printStackTrace();
    	}
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    PantallaPrincipal window = new PantallaPrincipal();
                    window.frmAdminsistemas.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the application.
     */
    public PantallaPrincipal() {
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frmAdminsistemas = new JFrame();
        frmAdminsistemas.setResizable(false);
        frmAdminsistemas.setTitle("MINERALPLUS");
        frmAdminsistemas.getContentPane().setBackground(Color.WHITE);
        frmAdminsistemas.setBounds(100, 100, 752, 612);
        frmAdminsistemas.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frmAdminsistemas.getContentPane().setLayout(null);
        
        JLabel lblNewLabel = new JLabel("New label");
        lblNewLabel.setIcon(new ImageIcon("D:\\carol\\AdobeStock_2813541252.jpg"));
        lblNewLabel.setBounds(-87, 371, 920, 246);
        frmAdminsistemas.getContentPane().add(lblNewLabel);
        
        JMenuBar menuBar = new JMenuBar();
        menuBar.setBackground(new Color(153, 204, 204));
        menuBar.setBounds(0, 0, 891, 23);
        frmAdminsistemas.getContentPane().add(menuBar);
        
        JMenu mnNewMenu = new JMenu("HOME");
        mnNewMenu.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        mnNewMenu.setFont(new Font("JetBrains Mono NL", Font.PLAIN, 12));
        menuBar.add(mnNewMenu);
        
        JMenuItem mntmNewMenuItem_8 = new JMenuItem("Menu Principal");
        mnNewMenu.add(mntmNewMenuItem_8);
        
        JSeparator separator_1 = new JSeparator();
        mnNewMenu.add(separator_1);
        
        JMenuItem mntmNewMenuItem = new JMenuItem("Login");
        mntmNewMenuItem.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		frmAdminsistemas.dispose();
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
        mntmNewMenuItem_1.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		System.exit(0);
        	}
        });
        mnNewMenu.add(mntmNewMenuItem_1);
        
        JTextArea txtrLoremIpsumDolor = new JTextArea();
        txtrLoremIpsumDolor.setLineWrap(true);
        txtrLoremIpsumDolor.setEditable(false);
        txtrLoremIpsumDolor.setWrapStyleWord(true);
        txtrLoremIpsumDolor.setText("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Donec varius pellentesque sagittis. Cras faucibus nibh pulvinar mi cursus pretium. Vivamus tincidunt tempus lectus non luctus. Integer cursus enim sed tempor auctor. Maecenas ac consequat velit, sed vulputate nulla. Mauris bibendum, est sed semper bibendum, arcu lacus dignissim orci, convallis sollicitudin neque magna et magna. Phasellus mollis arcu ipsum, in suscipit metus gravida et. Sed luctus vestibulum nibh in congue. Fusce mattis malesuada dui id porttitor. Nulla vel leo at neque porta cursus. Donec nec consectetur lorem. Proin eget turpis porttitor, facilisis mauris vel, dignissim sem.");
        txtrLoremIpsumDolor.setBounds(31, 131, 291, 219);
        frmAdminsistemas.getContentPane().add(txtrLoremIpsumDolor);
        
        JButton btnPanelAdminStock = new JButton("INGRESAR");
        btnPanelAdminStock.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		frmAdminsistemas.dispose();
        		Login login = new Login();
        		login.VentanaLogin();
        	}
        });
        btnPanelAdminStock.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        btnPanelAdminStock.setFont(new Font("JetBrains Mono NL SemiBold", Font.PLAIN, 15));
        btnPanelAdminStock.setBounds(403, 156, 291, 38);
        frmAdminsistemas.getContentPane().add(btnPanelAdminStock);
        
        JSeparator separator_3 = new JSeparator();
        separator_3.setBounds(403, 221, 291, 2);
        frmAdminsistemas.getContentPane().add(separator_3);
        
        JLabel lblNewLabel_1_1_2 = new JLabel("MINERAL PLUS");
        lblNewLabel_1_1_2.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_1_1_2.setFont(new Font("JetBrains Mono NL SemiBold", Font.PLAIN, 15));
        lblNewLabel_1_1_2.setBounds(0, 36, 726, 23);
        frmAdminsistemas.getContentPane().add(lblNewLabel_1_1_2);
        
        JPanel panel = new JPanel();
        panel.setBounds(0, 11, 736, 61);
        frmAdminsistemas.getContentPane().add(panel);
        
        JSeparator separator_3_2 = new JSeparator();
        separator_3_2.setOrientation(SwingConstants.VERTICAL);
        separator_3_2.setBounds(359, 66, 2, 519);
        frmAdminsistemas.getContentPane().add(separator_3_2);
        
        JLabel lblNewLabel_1_1 = new JLabel("SOBRE NOSOTROS");
        lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_1_1.setFont(new Font("JetBrains Mono NL SemiBold", Font.PLAIN, 15));
        lblNewLabel_1_1.setBounds(69, 97, 192, 23);
        frmAdminsistemas.getContentPane().add(lblNewLabel_1_1);
        
        JSeparator separator = new JSeparator();
        separator.setBounds(83, 122, 164, 2);
        frmAdminsistemas.getContentPane().add(separator);
        
        JButton btnPanelAdminStock_1 = new JButton("SALIR");
        btnPanelAdminStock_1.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		System.exit(0);
        	}
        });
        btnPanelAdminStock_1.setFont(new Font("JetBrains Mono NL SemiBold", Font.PLAIN, 15));
        btnPanelAdminStock_1.setBounds(403, 250, 291, 38);
        frmAdminsistemas.getContentPane().add(btnPanelAdminStock_1);
    }
}
