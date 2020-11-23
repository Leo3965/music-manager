package br.usjt.ui.screens;

import javax.swing.*;

import br.usjt.domain.interactor.UserInteractors;
import br.usjt.ui.BaseUi;
import br.usjt.ui.UiHandler;

import java.awt.event.*;

public class RegisterUi extends BaseUi {

    private JLabel nameLabel;
    private JTextField nameField;
    private JLabel emailLabel;
    private JTextField emailField;
    private JLabel passwordLabel;
    private JPasswordField passwordField;
    private JButton loginButton;
    private UserInteractors interactor;
    private UiHandler handler;

    public RegisterUi(UserInteractors interactor, Boolean visible, UiHandler handler) {
        this.interactor = interactor;
        this.handler = handler;
        this.startEmailLabel();
        this.startEmailField();
        this.startPasswordLabel();
        this.startPasswordField();
        this.startNameLabel();
        this.startNameField();
        this.startLoginButton();
        this.startMainFrame(visible);
    }

    private void startNameLabel() {
        this.nameLabel = new JLabel("Nome");
        this.nameLabel.setBounds(10, 10, 200, 30);
    }

    private void startNameField() {
        this.nameField = new JTextField();
        this.nameField.setBounds(10, 35, 200, 30);
    }

    private void startEmailLabel() {
        this.emailLabel = new JLabel("E-mail");
        this.emailLabel.setBounds(10, 60, 200, 30);
    }

    private void startEmailField() {
        this.emailField = new JTextField();
        this.emailField.setBounds(10, 85, 200, 30);
    }

    private void startPasswordLabel() {
        this.passwordLabel = new JLabel("Senha");
        this.passwordLabel.setBounds(10, 110, 200, 30);
    }

    private void startPasswordField() {
        this.passwordField = new JPasswordField();
        this.passwordField.setBounds(10, 135, 200, 30);
    }

    protected void startMainFrame(Boolean visible) {
        this.setTitle("Cadastro");
        this.add(this.emailLabel);
        this.add(this.emailField);
        this.add(this.passwordLabel);
        this.add(this.passwordField);
        this.add(this.loginButton);
        this.add(this.nameField);
        this.add(this.nameLabel);
        this.setSize(220, 250);
        this.setLayout(null);
        this.setVisible(visible);
        this.centralize();

        this.addWindowListener(new WindowAdapter() {
            @Override

            public void windowClosing(WindowEvent windowEvent) {
                handler.showWindow("login");
            }
        });
    }

    private void startLoginButton() {
        this.loginButton = new JButton("Cadastrar");
        this.loginButton.setBounds(10, 170, 200, 30);

        this.loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String email = emailField.getText();
                String password = passwordField.getText();
                String name = nameField.getText();

                if (email.equals("") || password.equals("") || name.equals("")) {
                    JOptionPane.showMessageDialog(null, "Por favor, preencha os campos");
                } else {
                    try {
                        interactor.create(name, email, password);
                        JOptionPane.showMessageDialog(null, "Cadastrado com sucesso!");
                        emailField.setText("");
                        passwordField.setText("");
                        nameField.setText("");
                        handler.showWindow("login");
                    } catch (Exception ex) {
                        ex.printStackTrace();
                        JOptionPane.showMessageDialog(null, "Falha no cadastro");
                    }
                }
            }
        });
    }
}
