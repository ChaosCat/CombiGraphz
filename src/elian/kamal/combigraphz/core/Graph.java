package elian.kamal.combigraphz.core;

import javax.swing.JOptionPane;

public class Graph {

	private Vertex vertecies[];
	private Edge edges[];

	/**
	 * Default Graph constructor, reserves space in memory for 50 vertices and 200 edges
	 * with an initial default values of null
	 */
	public Graph() {
		this.vertecies = new Vertex[50];
		for (int i = 0; i < this.vertecies.length; i++) {
			this.vertecies[i] = null;
		}
		this.edges = new Edge[200];

		for (int i = 0; i < this.edges.length; i++) {
			this.edges[i] = null;
		}
	}

	/**
	 * Returns the array of vertices
	 * 
	 * @return the array of vertices
	 */
	public Vertex[] getVertecies() {
		return this.vertecies;
	}

	/**
	 * Returns the vertex at a specific index
	 * 
	 * @param index
	 * @return the vertex at the specified index
	 */
	public Vertex getVertexAt(int index) {
		return this.vertecies[index];
	}

	/**
	 * Returns the array of edges
	 * 
	 * @return the array of edges
	 */
	public Edge[] getEdges() {
		return this.edges;
	}

	/**
	 * Adds an edge at the first null value of the vertices array
	 * 
	 * @param v
	 *            - Vertex to add
	 */
	public void addVertex(Vertex v) {
		boolean added = false;
		for (int i = 0; i < this.vertecies.length; i++) {
			if (!added && this.vertecies[i] == null) {
				System.out.println("Adding vertex at index [" + i + "]");
				this.vertecies[i] = v;
				added = true;
				System.out.println("Added vertex at index [" + i + "]");
			}
		}
	}

	/**
	 * Adds an edge at the first null value of the edges array
	 * 
	 * @param e
	 *            - Edge to add
	 */
	public void addEdge(Edge e) {
		boolean added = false;
		for (int i = 0; i < this.edges.length; i++) {
			if (!added && this.edges[i] == null) {
				System.out.println("Adding edge at index [" + i + "]");
				this.edges[i] = e;
				added = true;
				System.out.println("Added edge at index [" + i + "]");
				this.mergeEdges();
			}
		}
	}

	/**
	 * Deletes a vertex at a specific valid index
	 * 
	 * @param index
	 */
	public void delVertex(int index) {
		if (this.vertecies[index] != null) {
			this.vertecies[index] = null;
			this.reOrderVerticies();
			this.cleanEdges();
			this.reOrderEdges();
		} else
			JOptionPane.showMessageDialog(null, "ERROR: Vertex was already removed", "Error", JOptionPane.ERROR_MESSAGE,
					null);
	}

	/**
	 * Orders the graph's vertices, valid vertices before null values
	 */
	private void reOrderVerticies() {
		Vertex[] modA = new Vertex[this.vertecies.length];
		int counter = 0;
		for (int i = 0; i < modA.length; i++) {
			if (this.vertecies[i] != null) {
				modA[counter] = this.vertecies[i];
				counter++;
			}
		}
		this.vertecies = modA;
	}

	/**
	 * Deletes an edge at a specified valid index
	 * 
	 * @param index
	 */
	public void delEdge(int index) {
		if (this.edges[index] != null) {
			this.edges[index] = null;
			this.reOrderEdges();
		} else
			JOptionPane.showMessageDialog(null, "ERROR: Edge was already removed", "Error", JOptionPane.ERROR_MESSAGE,
					null);
	}

	// BROKEN
	public void cleanEdges() {
		for (int i = 0; i < this.edges.length; i++) {
		}
	}

	/**
	 * Finds and merges any non null edges into a single edge whilst separating
	 * the different edge names with a comma
	 */
	public void mergeEdges() {
		for (int i = 0; i < this.edges.length; i++) {
			if (this.edges[i] != null) {
				Edge currentEdge = this.edges[i];
				if (!currentEdge.isSelfPointed()) {
					for (int j = 0; j < this.edges.length; j++) {
						if (this.edges[j] != null) {
							if (!currentEdge.equals(this.edges[j])
									&& (currentEdge.getStartVertex().equals(this.edges[j].getStartVertex())
											&& currentEdge.getEndingVertex().equals(this.edges[j].getEndingVertex()))) {
								currentEdge.setName(currentEdge.getName() + ", " + this.edges[j].getName());
								this.delEdge(j);
							}
						}
					}
				} else {
					for (int j = 0; j < this.edges.length; j++) {
						if (this.edges[j] != null) {
							if (!currentEdge.equals(this.edges[j])
									&& currentEdge.getVertex().equals(this.edges[j].getVertex())) {
								currentEdge.setName(currentEdge.getName() + ", " + this.edges[j].getName());
								this.delEdge(j);
							}
						}
					}
				}
			}
		}
	}

	/**
	 * Orders the graph's edges, valid edges before null values
	 */
	private void reOrderEdges() {
		Edge[] modA = new Edge[this.edges.length];
		int counter = 0;
		for (int i = 0; i < modA.length; i++) {
			if (this.edges[i] != null) {
				modA[counter] = this.edges[i];
				counter++;
			}
		}
		this.edges = modA;
	}

	/**
	 * Prints the vertex array which has been specified (prints null if vertex
	 * is unassigned)
	 * 
	 * @param va
	 */
	public void printVertexArray(Vertex[] va) {
		String array = "[";
		for (int i = 0; i < va.length; i++) {
			array = va[i] == null ? array + "null, " : array + va[i].getName() + ", ";
		}
		array = array + "]";
		System.out.println(array);
	}
}
