package elian.kamal.combigraphz.test;

import static org.junit.Assert.*;

import org.junit.Test;

import elian.kamal.combigraphz.core.Graph;
import elian.kamal.combigraphz.gui.MainFrame;

public class MainFrameTest {

	@Test
	public void testMainFrame() {
		MainFrame tester = new MainFrame(new Graph());
		assertNotNull("Failed to create main frame", tester);
	}

}
