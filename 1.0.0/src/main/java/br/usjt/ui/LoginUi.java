package br.usjt.ui;

import javax.swing.*;

import br.usjt.domain.interactor.UserInteractors;

import java.awt.event.*;

public class LoginUi {

    private JFrame mainFrame;
    private JLabel emailLabel;
    private JTextField emailField;
    private JLabel passwordLabel;
    private JPasswordField passwordField;
    private JButton loginButton;
    private JButton registerButton;
    private UserInteractors interactor;
    private UiHandler handler;

    public LoginUi(UserInteractors interactor, Boolean visible, UiHandler handler) {
        this.interactor = interactor;
        this.handler = handler;
        this.startUserLabel();
        this.startUserField();
        this.startPasswordLabel();
        this.startPasswordField();
        this.startLoginButton();
        this.startRegisterButton();
        this.startMainFrame(visible);
    }

    private void startRegisterButton() {
        this.registerButton = new JButton("Register");
        this.registerButton.setBounds(10, 155, 200, 30);

        this.registerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                handler.showWindow("register");
            }
        });
    }

    private void startPasswordLabel() {
        this.passwordLabel = new JLabel("Senha");
        this.passwordLabel.setBounds(10, 60, 200, 30);
    }

    private void startUserLabel() {
        this.emailLabel = new JLabel("E-mail");
        this.emailLabel.setBounds(10, 10, 200, 30);
    }

    private void startMainFrame(Boolean visible) {
        this.mainFrame = new JFrame("System Login");
        this.mainFrame.add(this.emailLabel);
        this.mainFrame.add(this.emailField);
        this.mainFrame.add(this.passwordLabel);
        this.mainFrame.add(this.passwordField);
        this.mainFrame.add(this.registerButton);
        this.mainFrame.add(this.loginButton);
        this.mainFrame.setSize(220, 230);
        this.mainFrame.setLayout(null);
        this.mainFrame.setVisible(visible);

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

    public void hide() {
        this.mainFrame.hide();
    }

    public void show() {
        this.mainFrame.show();
    }
}
