package io.github.chaoscat.combigraphz;

import io.github.chaoscat.combigraphz.core.Graph;
import io.github.chaoscat.combigraphz.gui.MainFrame;

public class Main {

    public static void main(String[] args) {

        Graph g = new Graph();
        new MainFrame(g).setVisible(true);
    }

}
