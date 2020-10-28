package br.usjt.ui;

import javax.swing.*;
import java.awt.event.*;

public class LoginUi {

    private JFrame mainFrame;
    private JLabel usernameLabel;
    private JTextField usernameField;
    private JLabel passwordLabel;
    private JPasswordField passwordField;
    private JButton loginButton;

    public LoginUi() {
        this.startUserLabel();
        this.startUserField();
        this.startPasswordLabel();
        this.startPasswordField();
        this.startLoginButton();
        this.startMainFrame();
    }

    private void startPasswordLabel() {
        this.passwordLabel = new JLabel("Senha");
        this.passwordLabel.setBounds(10, 60, 200, 30);
    }

    private void startUserLabel() {
        this.usernameLabel = new JLabel("Usuário");
        this.usernameLabel.setBounds(10, 10, 200, 30);
    }

    private void startMainFrame() {
        this.mainFrame = new JFrame("System Login");
        this.mainFrame.add(this.usernameLabel);
        this.mainFrame.add(this.usernameField);
        this.mainFrame.add(this.passwordLabel);
        this.mainFrame.add(this.passwordField);
        this.mainFrame.add(this.loginButton);
        this.mainFrame.setSize(220, 200);
        this.mainFrame.setLayout(null);
        this.mainFrame.setVisible(true);

        this.mainFrame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent windowEvent) {
                System.exit(0);
            }
        });
    }

    private void startLoginButton() {
        this.loginButton = new JButton("Login");
        this.loginButton.setBounds(10, 120, 200, 30);

        this.loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Do Login");
            }
        });
    }

    private void startPasswordField() {
        this.passwordField = new JPasswordField();
        this.passwordField.setBounds(10, 85, 200, 30);
    }

    private void startUserField() {
        this.usernameField = new JTextField();
        this.usernameField.setBounds(10, 35, 200, 30);
    }

    public void close() {
        this.mainFrame.dispose();
    }
}
