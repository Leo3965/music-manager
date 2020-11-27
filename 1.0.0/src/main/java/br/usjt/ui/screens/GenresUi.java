package br.usjt.ui.screens;

import br.usjt.entity.Genre;
import br.usjt.entity.User;
import br.usjt.services.GenreService;
import br.usjt.services.UserService;
import br.usjt.ui.BaseUi;
import br.usjt.ui.UiHandler;
import br.usjt.ui.utils.ButtonColumn;

import java.awt.event.*;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class GenresUi extends BaseUi {

    private UiHandler uiHandler;
    private JButton addButton;
    private JComboBox<Genre> genreOptions;
    private JTable dataTable;
    private JScrollPane scroolPanel;
    private GenreService genreService;
    private UserService userService;

    public GenresUi(GenreService genreService, UserService userService, Boolean visible, UiHandler uiHandler) {
        this.uiHandler = uiHandler;
        this.genreService = genreService;
        this.userService = userService;
        this.startAddButton();
        this.startDataTable();
        this.startGenreComboBox();
        this.startScroolPanel();
        this.startMainFrame(visible);
    }

    private void startScroolPanel() {
        this.scroolPanel = new JScrollPane(this.dataTable);
        this.scroolPanel.setBounds(20, 20, 460, 300);
        this.scroolPanel.setVisible(true);
    }

    private void startGenreComboBox() {
        this.genreOptions = new JComboBox<>();
        this.genreOptions.setBounds(20, 340, 460, 30);

        for (Genre genre : this.genreService.getAll()) {
            this.genreOptions.addItem(genre);
        }
    }

    private void startDataTable() {
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Gênero");
        model.addColumn("Data");
        model.addColumn("Action");
        this.dataTable = new JTable(model);
        //this.dataTable.setEnabled(false);
    }

    private void load() {
        User user = uiHandler.getUser();
        DefaultTableModel model = (DefaultTableModel) this.dataTable.getModel();
        model.setRowCount(0);
        for (Genre genre : this.genreService.getGenresByUser(user)) {
            model.addRow(new Object[] { genre.getName(), genre.getDate(), "Delete" });
        }

        Action delete = new AbstractAction() {
            public void actionPerformed(ActionEvent e) {
                JTable table = (JTable) e.getSource();
                int modelRow = Integer.valueOf(e.getActionCommand());
                DefaultTableModel model = ((DefaultTableModel) table.getModel());//.removeRow(modelRow);
                String genreName = (String) model.getDataVector().get(modelRow).get(0);
                Genre genre = genreService.getByKey("name", genreName).get(0);
                userService.removeFavoriteGenre(uiHandler.getUser(), genre);
                model.removeRow(modelRow);
            }
        };

        ButtonColumn buttonColumn = new ButtonColumn(this.dataTable, delete, 2);
        buttonColumn.setMnemonic(KeyEvent.VK_D);
    }

    private void startAddButton() {
        this.addButton = new JButton("Adicionar");
        this.addButton.setBounds(20, 390, 460, 30);

        this.addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Genre genre = (Genre) genreOptions.getSelectedItem();

                if (genre != null) {
                    User user = uiHandler.getUser();
                    userService.addFavoriteGenre(user, genre);
                    load();
                }

            }
        });
    }

    @Override
    protected void startMainFrame(Boolean visible) {
        this.setTitle("Meus gêneros preferidos");
        this.setSize(500, 490);
        this.setVisible(visible);
        this.add(this.scroolPanel);
        this.centralize();
        this.add(this.genreOptions);
        this.add(this.addButton);
        this.setLayout(null);

        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent windowEvent) {
                uiHandler.showWindow("dashboard");
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
