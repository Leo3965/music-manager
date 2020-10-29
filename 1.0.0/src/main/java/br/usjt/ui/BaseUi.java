package br.usjt.ui;

import javax.swing.JFrame;

public abstract class BaseUi {
    protected JFrame mainFrame;

    abstract protected void startMainFrame(Boolean visible);

    public void hide() {
        this.mainFrame.hide();
    }

    public void show() {
        this.mainFrame.show();
    }

    protected void close() {
        this.mainFrame.dispose();
    }

    protected void centralize() {
        this.mainFrame.setLocationRelativeTo(null);
    }
}
