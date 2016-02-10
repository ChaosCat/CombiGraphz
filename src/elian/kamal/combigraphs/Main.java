package elian.kamal.combigraphs;

import elian.kamal.combigraphs.core.Graph;
import elian.kamal.combigraphs.gui.MainFrame;

public class Main {

	public static void main(String[] args) {
		Graph g = new Graph();
		new MainFrame(g).setVisible(true);
	}

}
