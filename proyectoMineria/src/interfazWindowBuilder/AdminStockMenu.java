package interfazWindowBuilder;
import java.awt.EventQueue;

import javax.swing.JFrame;

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
        frmAdminstockMenu.setTitle("ADMINSTOCK MENU");
        frmAdminstockMenu.setBounds(100, 100, 450, 300);
        frmAdminstockMenu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

}
