//                 Copyright 2016 Elian Kamal
//
//   Licensed under the Apache License, Version 2.0 (the "License");
//   you may not use this file except in compliance with the License.
//   You may obtain a copy of the License at
//
//       http://www.apache.org/licenses/LICENSE-2.0

package io.github.chaoscat.combigraphz;

import io.github.chaoscat.combigraphz.core.Graph;
import io.github.chaoscat.combigraphz.gui.MainFrame;

/**
 * The main class
 * Creates a new empty graph and initializes
 * a new frame which implements the graph
 * graphically and provide UI tools to alter it.
 */
public class Main {

    public static void main(String[] args) {

        Graph g = new Graph();
        new MainFrame(g).setVisible(true);
    }

}
