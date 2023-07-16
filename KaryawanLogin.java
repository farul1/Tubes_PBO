package cafe_kasir;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class KaryawanLogin extends JFrame implements ActionListener {
    private final JTextField txtUsername;
    private final JPasswordField txtPassword;
    private final JButton btnLogin;
    private final JButton btnCancel;
    private final JCheckBox chkShowPassword;

    public KaryawanLogin() {
        setTitle("Employee Login");
        setSize(350, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);

        JLabel lblUsername = new JLabel("Username:");
        lblUsername.setBounds(20, 60, 80, 25);
        add(lblUsername);

        txtUsername = new JTextField();
        txtUsername.setBounds(130, 60, 160, 25);
        add(txtUsername);

        JLabel lblPassword = new JLabel("Password:");
        lblPassword.setBounds(20, 90, 80, 25);
        add(lblPassword);

        txtPassword = new JPasswordField();
        txtPassword.setBounds(130, 90, 160, 25);
        add(txtPassword);

        btnLogin = new JButton("Login");
        btnLogin.setBounds(190, 130, 100, 35);
        btnLogin.addActionListener(this);
        add(btnLogin);

        btnCancel = new JButton("Cancel");
        btnCancel.setBounds(20, 130, 100, 35);
        btnCancel.addActionListener(this);
        add(btnCancel);

        chkShowPassword = new JCheckBox("Show Password");
        chkShowPassword.setBounds(20, 190, 140, 25);
        chkShowPassword.addActionListener(this);
        chkShowPassword.setOpaque(false);
        add(chkShowPassword);
        
       initBackground();
    }
    private void initBackground() {
        JLabel background = new JLabel(new ImageIcon(getClass().getResource("/img/menulogin.png")));
        background.setBounds(0, 0, 350, 300);
        add(background);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnLogin) {
            String username = txtUsername.getText();
            String password = new String(txtPassword.getPassword());

            if (username.equals("admin") && password.equals("admin123")) {
                Cafe_kasir cafeKasir = new Cafe_kasir();
                cafeKasir.setVisible(true);
                dispose(); 
            } else {
                JOptionPane.showMessageDialog(this, "Invalid username or password. Please try again.");
            }
            txtUsername.setText("");
            txtPassword.setText("");
        } else if (e.getSource() == btnCancel) {
            txtUsername.setText("");
            txtPassword.setText("");
        } else if (e.getSource() == chkShowPassword) {
            if (chkShowPassword.isSelected()) {
                txtPassword.setEchoChar((char) 0);
            } else {
                txtPassword.setEchoChar('*');
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            KaryawanLogin login = new KaryawanLogin();
            login.setVisible(true);
        });
    }
}


