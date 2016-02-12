package elian.kamal.combigraphz;

import elian.kamal.combigraphz.core.Graph;
import elian.kamal.combigraphz.gui.MainFrame;

public class Main {

	public static void main(String[] args) {
		Graph g = new Graph();
		new MainFrame(g).setVisible(true);
	}

}
