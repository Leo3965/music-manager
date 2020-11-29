package br.usjt.ui.screens;

import javax.swing.JButton;
import javax.swing.JOptionPane;

import br.usjt.ui.BaseUi;
import br.usjt.ui.UiHandler;

import java.awt.event.*;

public class DashboardUi extends BaseUi {
    private JButton myGenresButton;
    private JButton scoreMusicButton;
    private JButton getRecommendationButton;
    private UiHandler handler;

    public DashboardUi(Boolean visible, UiHandler handler) {
        this.handler = handler;
        this.startButtons();
        this.startMainFrame(visible);
    }

    private void startButtons() {
        startGenresButton();
        startMusicButton();
        startRecommendationButton();
    }

    private void startRecommendationButton() {
        this.getRecommendationButton = new JButton("Quero recomendações");
        this.getRecommendationButton.setBounds(20, 110, 360, 30);

        this.getRecommendationButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "recomendation");
            }
        });
    }

    private void startMusicButton() {
        this.scoreMusicButton = new JButton("Avaliar Músicas");
        this.scoreMusicButton.setBounds(20, 65, 360, 30);

        this.scoreMusicButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "musicScore");
            }
        });
    }

    private void startGenresButton() {
        this.myGenresButton = new JButton("Meus gêneros preferidos");
        this.myGenresButton.setBounds(20, 20, 360, 30);

        this.myGenresButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                handler.showWindow("genres");
            }
        });
    }

    protected void startMainFrame(Boolean visible) {
        this.setTitle("Dashboard");
        this.add(this.myGenresButton);
        this.add(this.scoreMusicButton);
        this.add(this.getRecommendationButton);
        this.setSize(420, 200);
        this.setLayout(null);
        this.setVisible(visible);
        this.centralize();

        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent windowEvent) {
                System.exit(0);
            }
        });
    }
}
