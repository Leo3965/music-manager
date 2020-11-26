package br.usjt.ui.screens;

import br.usjt.domain.entity.Genre;
import br.usjt.domain.entity.User;
import br.usjt.domain.services.GenreService;
import br.usjt.domain.services.UserService;
import br.usjt.ui.BaseUi;
import br.usjt.ui.UiHandler;

import java.awt.event.*;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JInternalFrame.JDesktopIcon;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

public class GenresUi extends BaseUi {

    private UiHandler handler;
    private JButton addButton;
    private JComboBox<Genre> genreOptions;
    private JTable dataTable;
    private JScrollPane scroolPanel;
    private GenreService genreInteractor;
    private UserService userInteractor;

    public GenresUi(GenreService genreInteractor, UserService userInteractor, Boolean visible,
            UiHandler handler) {
        this.handler = handler;
        this.genreInteractor = genreInteractor;
        this.userInteractor = userInteractor;
        this.startAddButton();
        this.startDataTable();
        this.startGenreComboBox();
        this.startScroolPanel();
        this.startMainFrame(visible);
    }

    private void startScroolPanel() {
        this.scroolPanel = new JScrollPane(this.dataTable);
        this.scroolPanel.setBounds(20, 20, 360, 300);
        this.scroolPanel.setVisible(true);
    }

    private void startGenreComboBox() {
        this.genreOptions = new JComboBox<>();
        this.genreOptions.setBounds(20, 340, 360, 30);

        for (Genre genre : this.genreInteractor.getAll()) {
            this.genreOptions.addItem(genre);
        }
    }

    private void startDataTable() {
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Gênero");
        model.addColumn("Data");
        this.dataTable = new JTable(model);
        this.dataTable.setEnabled(false);
    }

    private void load() {
        User user = handler.getUser();
        DefaultTableModel model = (DefaultTableModel) this.dataTable.getModel();
        model.setRowCount(0);
        for (Genre genre : this.genreInteractor.getGenresByUser(user)) {
            model.addRow(new Object[] { genre.getName(), genre.getId() });
        }
    }

    private void startAddButton() {
        this.addButton = new JButton("Adicionar");
        this.addButton.setBounds(20, 390, 360, 30);

        this.addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Genre genre = (Genre) genreOptions.getSelectedItem();

                if (genre != null) {
                    User user = handler.getUser();
                    userInteractor.addFavoriteGenre(user, genre);
                    load();
                }

            }
        });
    }

    @Override
    protected void startMainFrame(Boolean visible) {
        this.setTitle("Meus gêneros preferidos");
        this.setSize(400, 490);
        this.setVisible(visible);
        this.add(this.scroolPanel);
        this.centralize();
        this.add(this.genreOptions);
        this.add(this.addButton);
        this.setLayout(null);

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
