package br.usjt.ui.screens;

import br.usjt.entity.Music;
import br.usjt.services.MusicService;
import br.usjt.ui.BaseUi;
import br.usjt.ui.UiHandler;

import java.awt.event.*;
import java.util.Enumeration;
import java.util.List;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class RecommedationUI extends BaseUi {

    private UiHandler handler;
    private MusicService musicService;
    private JScrollPane scroolPanel;
    private JTable dataTable;
    private JButton returnButton;

    public RecommedationUI(Boolean visible, UiHandler handler, MusicService musicService) {
        this.handler = handler;
        this.musicService = musicService;
        this.startDataTable();
        this.startScroolPanel();
        this.startReturnButton();
        this.startMainFrame(visible);
    }

    private void startScroolPanel() {
        this.scroolPanel = new JScrollPane(this.dataTable);
        this.returnButton = new JButton("Voltar");
        this.scroolPanel.setBounds(20, 20, 460, 300);
        this.returnButton.setBounds(20, 340, 460, 30);
        this.scroolPanel.setVisible(true);

    }

    private void startReturnButton(){
       this.returnButton.addActionListener(new ActionListener() {
            
            public void actionPerformed(ActionEvent e) {
                handler.showWindow("dashboard");
            }

        });

    }

    private void startDataTable() {
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Músicas");
        model.addColumn("Posto");
        this.dataTable = new JTable(model);
    }

    private void load() {

        DefaultTableModel model = (DefaultTableModel) this.dataTable.getModel();
        model.setRowCount(0);
        List<Music> musics = this.musicService.getMusicsWithScore(handler.getUser());
        for (Music music : musics) {
            model.addRow(new Object[] { music.getName(), music.getScore() });
        }
    }

    @Override
    protected void startMainFrame(Boolean visible) {
        this.setTitle("Recomendações");
        this.add(this.scroolPanel);
        this.add(this.returnButton);
        this.setSize(520, 490);
        this.setLayout(null);
        this.setVisible(visible);
        this.centralize();

        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent windowEvent) {
                handler.showWindow("dashboard");
            }

        });

        this.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentShown(ComponentEvent windowEvent) {
                load();
            }
        });
    }

}
