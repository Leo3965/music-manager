package br.usjt.ui;

import javax.swing.*;

import br.usjt.domain.interactor.UserInteractors;

import java.awt.event.*;

public class RegisterUi {

    private JFrame mainFrame;
    private JLabel emailLabel;
    private JTextField emailField;
    private JLabel passwordLabel;
    private JPasswordField passwordField;
    private JButton loginButton;
    private UserInteractors interactor;

    public RegisterUi() {
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
        this.emailLabel = new JLabel("E-mail");
        this.emailLabel.setBounds(10, 10, 200, 30);
    }

    private void startMainFrame() {
        this.mainFrame = new JFrame("System Login");
        this.mainFrame.add(this.emailLabel);
        this.mainFrame.add(this.emailField);
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
                String username = emailField.getText();
                String password = passwordField.getText();

                if (username.equals("") || password.equals("")) {
                    JOptionPane.showMessageDialog(null, "Por favor, preencha os campos");
                } else if (interactor.authenticate(username, password)) {
                    JOptionPane.showMessageDialog(null, "Successfully authenticated");
                } else {
                    JOptionPane.showMessageDialog(null, "Authentication failure");
                }
            }
        });
    }

    private void startPasswordField() {
        this.passwordField = new JPasswordField();
        this.passwordField.setBounds(10, 85, 200, 30);
    }

    private void startUserField() {
        this.emailField = new JTextField();
        this.emailField.setBounds(10, 35, 200, 30);
    }

    public void close() {
        this.mainFrame.dispose();
    }
}
