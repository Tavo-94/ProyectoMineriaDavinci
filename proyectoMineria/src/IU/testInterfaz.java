package IU;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import negocio.AdminVentasDao;

import java.awt.Font;
import java.awt.Dimension;
import javax.swing.JSplitPane;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Rectangle;
import java.awt.FlowLayout;
import javax.swing.BoxLayout;
import java.awt.Color;
import java.awt.ComponentOrientation;
import javax.swing.JButton;
import java.awt.GridLayout;
import javax.swing.UIManager;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class testInterfaz extends JFrame {

    private JPanel contentPane;
    private JTextField tfNombreDeUsuario;
    private JPasswordField passFClave;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    testInterfaz frame = new testInterfaz();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the frame.
     */
    public testInterfaz() {
        setAlwaysOnTop(true);
        setFont(new Font("JetBrains Mono Medium", Font.PLAIN, 14));
        setTitle("Test Ventana Main");
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 877, 657);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(new BorderLayout(0, 0));
        
        JPanel panel = new JPanel();
        panel.setMaximumSize(new Dimension(400, 32767));
        contentPane.add(panel);
        panel.setLayout(null);
        
        JLabel imagenMainFrameIzq = new JLabel("");
        imagenMainFrameIzq.setBounds(10, 10, 400, 600);
        imagenMainFrameIzq.setIcon(new ImageIcon(testInterfaz.class.getResource("/IU/imagenMain2.png")));
        panel.add(imagenMainFrameIzq);
        
        JPanel panelFormulario = new JPanel();
        panelFormulario.setBounds(420, 10, 423, 654);
        panelFormulario.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
        panelFormulario.setBackground(new Color(128, 128, 128));
        panel.add(panelFormulario);
        panelFormulario.setLayout(null);
        
        JLabel lblNombreFormulario = new JLabel("Nombre de Usuario");
        lblNombreFormulario.setHorizontalAlignment(SwingConstants.CENTER);
        lblNombreFormulario.setBounds(0, 137, 423, 50);
        lblNombreFormulario.setForeground(new Color(255, 255, 255));
        lblNombreFormulario.setFont(new Font("JetBrains Mono", Font.PLAIN, 30));
        panelFormulario.add(lblNombreFormulario);
        
        tfNombreDeUsuario = new JTextField();
        lblNombreFormulario.setLabelFor(tfNombreDeUsuario);
        tfNombreDeUsuario.setBounds(10, 197, 400, 30);
        panelFormulario.add(tfNombreDeUsuario);
        tfNombreDeUsuario.setColumns(10);
        
        JLabel lblTituloLogIn = new JLabel("LogIn");
        lblTituloLogIn.setFont(new Font("JetBrains Mono", Font.BOLD, 50));
        lblTituloLogIn.setBounds(10, 10, 400, 80);
        panelFormulario.add(lblTituloLogIn);
        
        JLabel lblClave = new JLabel("Contraseña");
        lblClave.setHorizontalAlignment(SwingConstants.CENTER);
        lblClave.setForeground(Color.WHITE);
        lblClave.setFont(new Font("JetBrains Mono", Font.PLAIN, 30));
        lblClave.setBounds(10, 237, 400, 50);
        panelFormulario.add(lblClave);
        
        passFClave = new JPasswordField();
        lblClave.setLabelFor(passFClave);
        passFClave.setBounds(10, 297, 400, 30);
        panelFormulario.add(passFClave);
        
        JButton btnAceptar = new JButton("Iniciar Sesion");
 
        btnAceptar.setBounds(10, 364, 150, 40);
        panelFormulario.add(btnAceptar);
    }
}
