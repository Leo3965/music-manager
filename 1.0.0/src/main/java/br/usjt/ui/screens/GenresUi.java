package br.usjt.ui.screens;

import br.usjt.domain.entity.Genre;
import br.usjt.domain.entity.User;
import br.usjt.domain.interactor.GenreInteractors;
import br.usjt.domain.interactor.UserInteractors;
import br.usjt.ui.BaseUi;
import br.usjt.ui.UiHandler;

import java.awt.event.*;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;

public class GenresUi extends BaseUi {

    private UiHandler handler;
    private JButton addButton;
    private JComboBox<Genre> genreOptions;
    // private JTable dataTable;
    private GenreInteractors genreInteractor;
    private UserInteractors userInteractor;

    public GenresUi(GenreInteractors genreInteractor, UserInteractors userInteractor, Boolean visible,
            UiHandler handler) {
        this.handler = handler;
        this.genreInteractor = genreInteractor;
        this.userInteractor = userInteractor;
        this.startAddButton();
        this.startDataTable();
        this.startGenreComboBox();
        this.startMainFrame(visible);
    }

    private void startGenreComboBox() {
        this.genreOptions = new JComboBox<>();
        this.genreOptions.setBounds(20, 10, 360, 30);

        for (Genre genre : this.genreInteractor.getAll()) {
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

        this.addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Genre genre = (Genre) genreOptions.getSelectedItem();

                if (genre != null) {
                    User user = handler.getUser();
                    userInteractor.addFavoriteGenre(user, genre);
                }

            }
        });
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
