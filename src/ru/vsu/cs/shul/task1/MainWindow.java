package ru.vsu.cs.shul.task1;

import javax.swing.*;
import java.awt.*;

public class MainWindow extends JFrame {

    public MainWindow() throws HeadlessException {
        DrawPanel dp = new DrawPanel();
        this.add(dp);

        dp.requestFocusInWindow();
    }


}
