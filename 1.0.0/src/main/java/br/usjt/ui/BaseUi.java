package br.usjt.ui;

import javax.swing.JFrame;
import javax.swing.JPanel;

public abstract class BaseUi extends JFrame {
    protected JPanel backgroundPanel;
    
    abstract protected void startMainFrame(Boolean visible);

    protected void close() {
        this.dispose();
    }

    protected void centralize() {
        this.setLocationRelativeTo(null);
    }
}
