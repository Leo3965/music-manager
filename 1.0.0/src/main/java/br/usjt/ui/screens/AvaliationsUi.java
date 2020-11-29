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

public class AvaliationsUi extends BaseUi {
    
    private UiHandler handler;
    private MusicService musicService;
    private JTable dataTable;
    private JScrollPane scroolPanel;
    private JButton saveButton;

    public AvaliationsUi(Boolean visible, UiHandler handler, MusicService musicService) {
        this.handler = handler;
        this.musicService = musicService;
        this.startDataTable();
        this.startScroolPanel();
        this.startSaveButton();
        this.startMainFrame(visible);
    }

    private void startSaveButton() {
        this.saveButton = new JButton("Confirmar Avaliações");
        this.saveButton.setBounds(20, 340, 460, 30);

        this.saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DefaultTableModel model = ((DefaultTableModel) dataTable.getModel());
                
                Enumeration<Vector> data = model.getDataVector().elements();

                while(data.hasMoreElements()) {
                    Vector element = data.nextElement();
                    String musicName = (String) element.get(0);
                    String musicScore = (String) element.get(1);

                    musicService.addAvaliation(musicName, Short.valueOf(musicScore), handler.getUser());
                }

                JOptionPane.showMessageDialog(null, "Avaliações cadastradas com sucesso");

                load();
            }
        });
    }

    private void startScroolPanel() {
        this.scroolPanel = new JScrollPane(this.dataTable);
        this.scroolPanel.setBounds(20, 20, 460, 300);
        this.scroolPanel.setVisible(true);
    }

    private void startDataTable() {
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Música");
        model.addColumn("Minha Nota");
        this.dataTable = new JTable(model);
    }

    private void load() {
        DefaultTableModel model = (DefaultTableModel) this.dataTable.getModel();
        model.setRowCount(0);
        List<Music> musics = musicService.getMusicForAvaliations(handler.getUser());
        for(Music music: musics) {
            model.addRow(new Object[] {music.getName(), "0"});
        } 
    }

    @Override
    protected void startMainFrame(Boolean visible) {
        this.setTitle("Avaliar Músicas");
        this.add(this.scroolPanel);
        this.add(this.saveButton);
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
