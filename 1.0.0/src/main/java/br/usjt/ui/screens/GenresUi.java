package br.usjt.ui.screens;

import br.usjt.domain.entity.Genre;
import br.usjt.domain.interactor.GenreInteractors;
import br.usjt.ui.BaseUi;
import br.usjt.ui.UiHandler;

import java.awt.event.*;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JTable;

public class GenresUi extends BaseUi {

    private UiHandler handler;
    private JButton addButton;
    private JComboBox<Genre> genreOptions;
    // private JTable dataTable;
    private GenreInteractors interactor;

    public GenresUi(GenreInteractors interactor, Boolean visible, UiHandler handler) {
        this.handler = handler;
        this.interactor = interactor;
        this.startAddButton();
        this.startDataTable();
        this.startGenreComboBox();
        this.startMainFrame(visible);
    }

    private void startGenreComboBox() {
        this.genreOptions = new JComboBox<>();
        this.genreOptions.setBounds(20, 10, 360, 30);

        for (Genre genre : this.interactor.getAll()) {
            this.genreOptions.addItem(genre);
        }
    }

    private void startDataTable() {
        // this.dataTable = new JTable();
        // this.dataTable.setModel(arg0);
    }

    private void startAddButton() {
        this.addButton = new JButton("Adicionar");
        this.addButton.setBounds(20, 55, 360, 30);
    }

    @Override
    protected void startMainFrame(Boolean visible) {
        this.mainFrame = new JFrame("Meus gêneros preferidos");
        this.mainFrame.add(this.genreOptions);
        this.mainFrame.add(this.addButton);
        this.mainFrame.setSize(400, 200);
        this.mainFrame.setLayout(null);
        this.mainFrame.setVisible(visible);
        this.centralize();

        this.mainFrame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent windowEvent) {
                handler.showWindow("dashboard");
            }
        });
    }

}
