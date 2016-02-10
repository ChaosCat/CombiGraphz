package elian.kamal.combigraphs.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import elian.kamal.combigraphs.core.Edge;
import elian.kamal.combigraphs.core.Graph;
import elian.kamal.combigraphs.core.Vertex;

public class MainFrame extends JFrame implements ActionListener {

	/**
	 * Generated serial version UID.
	 */
	private static final long serialVersionUID = -3960130962302213052L;
	private JPanel contentPane;
	private Canvas canvas;

	/**
	 * Create the frame.
	 */
	public MainFrame(Graph graph) {
		this.setTitle("CombiGraphz");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setBounds(100, 100, 827, 559);

		JMenuBar menuBar = new JMenuBar();
		this.setJMenuBar(menuBar);

		JMenu addMenu = new JMenu("Add");

		JMenuItem addVertex = new JMenuItem("Vertex");
		addVertex.addActionListener(this);
		addVertex.setActionCommand("ADD_VERTEX");
		addMenu.add(addVertex);

		JMenuItem addEdge = new JMenuItem("Edge");
		addEdge.addActionListener(this);
		addEdge.setActionCommand("ADD_EDGE_P2P");
		addMenu.add(addEdge);

		menuBar.add(addMenu);

		JMenu delMenu = new JMenu("Remove");

		JMenuItem delVertex = new JMenuItem("Vertex");
		delVertex.addActionListener(this);
		delVertex.setActionCommand("DEL_VERTEX");
		delMenu.add(delVertex);

		menuBar.add(delMenu);
		
		JMenu toolMenu = new JMenu("Debug Tools");
		
		JMenuItem bscDbgItem = new JMenuItem("basic debug");
		bscDbgItem.addActionListener(this);
		bscDbgItem.setActionCommand("BASIC_DEBUG");
		toolMenu.add(bscDbgItem);
		
		menuBar.add(toolMenu);

		this.contentPane = new JPanel();
		this.contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		this.setContentPane(this.contentPane);
		this.contentPane.setLayout(new BorderLayout(0, 0));

		this.canvas = new Canvas(graph);
		contentPane.add(canvas, BorderLayout.CENTER);
		canvas.setSize(new Dimension(100, 100));

		Timer timer = new Timer();
		timer.scheduleAtFixedRate(new TimerTask() {
			@Override
			public void run() {
				canvas.repaint();
			}
		}, 100, 10);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String cmd = e.getActionCommand();
		switch (cmd) {
		case "ADD_VERTEX":
			JFrame vertexFrame = new JFrame();
			vertexFrame.setSize(new Dimension(340, 120));
			vertexFrame.setTitle("Add Vertex");
			vertexFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			vertexFrame.setLayout(new GridLayout(4, 2, 0, 5));
			vertexFrame.setResizable(false);

			Border border = new LineBorder(Color.BLACK);

			JLabel nameLabel = new JLabel("Name");
			nameLabel.setFont(new Font("Blackadder ITC", 0, 18));
			vertexFrame.add(nameLabel);

			JTextArea nameTextArea = new JTextArea();
			nameTextArea.setBorder(border);
			vertexFrame.add(nameTextArea);

			JLabel xPosLabel = new JLabel("X position");
			xPosLabel.setFont(new Font("Blackadder ITC", 0, 18));
			vertexFrame.add(xPosLabel);

			JTextArea xPosTextArea = new JTextArea();
			xPosTextArea.addKeyListener(new KeyListener() {
				@Override
				public void keyPressed(KeyEvent ke) {
				}

				@Override
				public void keyReleased(KeyEvent ke) {
				}

				@Override
				public void keyTyped(KeyEvent ke) {
					int keyCode = ke.getKeyChar();
					if (keyCode != 8 && (keyCode < 48 || keyCode > 57 || xPosTextArea.getText().length() > 2))
						ke.consume();
				}
			});
			xPosTextArea.setBorder(border);
			vertexFrame.add(xPosTextArea);

			JLabel yPosLabel = new JLabel("Y position");
			yPosLabel.setFont(new Font("Blackadder ITC", 0, 18));
			vertexFrame.add(yPosLabel);

			JTextArea yPosTextArea = new JTextArea();
			yPosTextArea.setBorder(border);
			yPosTextArea.addKeyListener(new KeyListener() {
				@Override
				public void keyPressed(KeyEvent ke) {
				}

				@Override
				public void keyReleased(KeyEvent ke) {
				}

				@Override
				public void keyTyped(KeyEvent ke) {
					int keyCode = ke.getKeyChar();
					if (keyCode != 8 && (keyCode < 48 || keyCode > 57 || yPosTextArea.getText().length() > 2))
						ke.consume();
				}
			});
			vertexFrame.add(yPosTextArea);

			JButton btnConfirm = new JButton("Confirm");
			btnConfirm.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					if (nameTextArea.getText().isEmpty()) {
						JOptionPane.showMessageDialog(null, "Name field cannot be empty!", "Empty field",
								JOptionPane.WARNING_MESSAGE);
					} else if (xPosTextArea.getText().isEmpty()) {
						JOptionPane.showMessageDialog(null, "X position field cannot be empty!", "Empty field",
								JOptionPane.WARNING_MESSAGE);
					} else if (yPosTextArea.getText().isEmpty()) {
						JOptionPane.showMessageDialog(null, "Y position field cannot be empty!", "Empty field",
								JOptionPane.WARNING_MESSAGE);
					} else {
						canvas.getGraph().addVertex(new Vertex(nameTextArea.getText(),
								Integer.valueOf(xPosTextArea.getText()), Integer.valueOf(yPosTextArea.getText())));
						vertexFrame.dispose();
					}
				}
			});
			vertexFrame.add(btnConfirm);
			vertexFrame.setLocationRelativeTo(this);
			vertexFrame.setVisible(true);
			break;
		case "ADD_EDGE_P2P":
			int numOfValidVertecies = 0;
			for (int i = 0; i < canvas.getGraph().getVertecies().length; i++) {
				if (canvas.getGraph().getVertecies()[i] != null)
					numOfValidVertecies++;
			}
			if (numOfValidVertecies < 1)
				JOptionPane.showMessageDialog(this,
						"You must have atleast 1 vertecies on the scene in order\n"
								+ "to use the \"Add edge\" function",
						"Not enough vertecies", JOptionPane.WARNING_MESSAGE, null);
			else {
				JFrame edgeFrame = new JFrame();
				edgeFrame.setSize(new Dimension(340, 120));
				edgeFrame.setTitle("Add edge");
				edgeFrame.setLayout(new GridLayout(0, 2, 0, 5));
				edgeFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				edgeFrame.setResizable(false);
				Border border2 = new LineBorder(Color.BLACK);

				JLabel nameLabel2 = new JLabel("Name");
				nameLabel2.setFont(new Font("Blackadder ITC", 0, 18));
				edgeFrame.add(nameLabel2);

				JTextArea nameTextArea2 = new JTextArea();
				nameTextArea2.setBorder(border2);
				edgeFrame.add(nameTextArea2);

				JLabel sVLabel = new JLabel("Starting vertex");
				sVLabel.setFont(new Font("Blackadder ITC", 0, 18));
				edgeFrame.add(sVLabel);

				String[] vNames = new String[numOfValidVertecies];
				for (int i = 0; i < vNames.length; i++) {
					if (canvas.getGraph().getVertecies()[i] != null)
						vNames[i] = canvas.getGraph().getVertecies()[i].getName();
				}
				JComboBox<String> sVCB = new JComboBox<String>(vNames);
				edgeFrame.add(sVCB);

				JLabel eVLabel = new JLabel("Ending vertex");
				eVLabel.setFont(new Font("Blackadder ITC", 0, 18));
				edgeFrame.add(eVLabel);

				JComboBox<String> eVCB = new JComboBox<String>(vNames);
				edgeFrame.add(eVCB);

				JButton btnConfirm2 = new JButton("Confirm");
				btnConfirm2.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent ae) {
						if (sVCB.getSelectedIndex() == eVCB.getSelectedIndex()) {
							canvas.getGraph().addEdge(new Edge(nameTextArea2.getText(), canvas.getGraph().getVertexAt(sVCB.getSelectedIndex())));
						} else {
							canvas.getGraph()
							.addEdge(new Edge(nameTextArea2.getText(),
									canvas.getGraph().getVertexAt(sVCB.getSelectedIndex()),
									canvas.getGraph().getVertexAt(eVCB.getSelectedIndex())));
						}
						edgeFrame.dispose();
					}
				});
				edgeFrame.add(btnConfirm2);
				edgeFrame.setLocationRelativeTo(this);
				edgeFrame.setVisible(true);
			}
			break;
		case "DEL_VERTEX":
			int numOfValidVertecies2 = 0;
			for (int i = 0; i < canvas.getGraph().getVertecies().length; i++) {
				if (canvas.getGraph().getVertecies()[i] != null)
					numOfValidVertecies2++;
			}

			if (numOfValidVertecies2 < 1)
				JOptionPane.showMessageDialog(this,
						"You must have at least 1 vertex on the scene \n" + "in order to use this function.",
						"Not enough vertecies", JOptionPane.WARNING_MESSAGE, null);
			else {
				JFrame delVFrame = new JFrame();
				delVFrame.setSize(new Dimension(340, 120));
				delVFrame.setTitle("Remove vertex");
				delVFrame.setLayout(new GridLayout(0, 1, 0, 10));
				delVFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				delVFrame.setResizable(false);

				JLabel chooseVLabel = new JLabel("Choose the vertex which you wish to remove:");
				chooseVLabel.setFont(new Font("Blackadder ITC", 0, 22));
				delVFrame.add(chooseVLabel);

				String[] vNames2 = new String[numOfValidVertecies2];
				for (int i = 0; i < vNames2.length; i++) {
					if (canvas.getGraph().getVertecies()[i] != null)
						vNames2[i] = canvas.getGraph().getVertecies()[i].getName();
				}
				JComboBox<String> DVCB = new JComboBox<String>(vNames2);
				delVFrame.add(DVCB);

				JButton btnConfirm3 = new JButton("Confirm");
				btnConfirm3.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						canvas.getGraph().delVertex(DVCB.getSelectedIndex());
						delVFrame.dispose();
					}
				});
				delVFrame.add(btnConfirm3);
				delVFrame.setLocationRelativeTo(this);
				delVFrame.setVisible(true);
			}
			break;
		case "BASIC_DEBUG":
			Vertex v1 = new Vertex("test1", 100, 100);
			Vertex v2 = new Vertex("test2", 200, 200);
			Vertex v3 = new Vertex("test3", 100, 300);
			canvas.getGraph().addVertex(v1);
			canvas.getGraph().addVertex(v2);
			canvas.getGraph().addVertex(v3);
			canvas.getGraph().addEdge(new Edge("eTest", v1, v2));
			canvas.getGraph().addEdge(new Edge("eTest2", v1, v2));
			canvas.getGraph().addEdge(new Edge("seTest", v1));
			canvas.getGraph().addEdge(new Edge("eTest3", v3, v1));
			canvas.getGraph().addEdge(new Edge("eTest3", v2, v3));
			break;
		default:
			System.err.println("ERROR: An unrecognized command name have been called (command: " + cmd + ")");
			JOptionPane.showMessageDialog(this, "An unrecognized command name have been called (command: " + cmd + ")",
					"Invalid command name", JOptionPane.ERROR_MESSAGE);
			break;
		}
	}

}
