import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JSeparator;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;

public class PantallaPrincipal {

    private JFrame frame;
    private JFrame frmAdminsistemas;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    PantallaPrincipal window = new PantallaPrincipal();
                    window.frame.setVisible(true);
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
        
        JLabel lblNewLabel_1 = new JLabel("MINERALPLUS");
        lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_1.setFont(new Font("JetBrains Mono ExtraBold", Font.PLAIN, 18));
        lblNewLabel_1.setBounds(32, 34, 233, 38);
        frmAdminsistemas.getContentPane().add(lblNewLabel_1);
        
        JSeparator separator = new JSeparator();
        separator.setBounds(20, 72, 265, 2);
        frmAdminsistemas.getContentPane().add(separator);
        
        JTextArea txtrLoremIpsumDolor = new JTextArea();
        txtrLoremIpsumDolor.setLineWrap(true);
        txtrLoremIpsumDolor.setEditable(false);
        txtrLoremIpsumDolor.setWrapStyleWord(true);
        txtrLoremIpsumDolor.setText("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Donec varius pellentesque sagittis. Cras faucibus nibh pulvinar mi cursus pretium. Vivamus tincidunt tempus lectus non luctus. Integer cursus enim sed tempor auctor. Maecenas ac consequat velit, sed vulputate nulla. Mauris bibendum, est sed semper bibendum, arcu lacus dignissim orci, convallis sollicitudin neque magna et magna. Phasellus mollis arcu ipsum, in suscipit metus gravida et. Sed luctus vestibulum nibh in congue. Fusce mattis malesuada dui id porttitor. Nulla vel leo at neque porta cursus. Donec nec consectetur lorem. Proin eget turpis porttitor, facilisis mauris vel, dignissim sem.");
        txtrLoremIpsumDolor.setBounds(21, 83, 264, 270);
        frmAdminsistemas.getContentPane().add(txtrLoremIpsumDolor);
        
        JButton btnNewButton = new JButton("PANEL ADMIN SISTEMAS");
        btnNewButton.setFont(new Font("JetBrains Mono NL SemiBold", Font.PLAIN, 15));
        btnNewButton.setBounds(379, 89, 291, 38);
        frmAdminsistemas.getContentPane().add(btnNewButton);
        
        JButton btnPanelAdminVentas = new JButton("PANEL ADMIN VENTAS");
        btnPanelAdminVentas.setFont(new Font("JetBrains Mono NL SemiBold", Font.PLAIN, 15));
        btnPanelAdminVentas.setBounds(379, 178, 291, 38);
        frmAdminsistemas.getContentPane().add(btnPanelAdminVentas);
        
        JButton btnPanelAdminStock = new JButton("PANEL ADMIN STOCK");
        btnPanelAdminStock.setFont(new Font("JetBrains Mono NL SemiBold", Font.PLAIN, 15));
        btnPanelAdminStock.setBounds(379, 265, 291, 38);
        frmAdminsistemas.getContentPane().add(btnPanelAdminStock);
        
        JSeparator separator_3 = new JSeparator();
        separator_3.setBounds(379, 240, 291, 2);
        frmAdminsistemas.getContentPane().add(separator_3);
        
        JSeparator separator_3_1 = new JSeparator();
        separator_3_1.setBounds(379, 149, 291, 2);
        frmAdminsistemas.getContentPane().add(separator_3_1);
    }
}
