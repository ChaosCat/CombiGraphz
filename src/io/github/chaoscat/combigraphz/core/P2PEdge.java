package io.github.chaoscat.combigraphz.core;

//On hold for the moment
public class P2PEdge {

    private String name;
    private Vertex startingVertex, endingVertex;
    private int xStartPos, yStartPos, xEndPos, yEndPos;

    /**
     * The constructor for an edge between two vertices
     *
     * @param name - the name of the edge
     * @param sV   - the vertex which the edge goes out from
     * @param eV   - the vertex which the edge points towards
     */
    public P2PEdge(String name, Vertex sV, Vertex eV) {
        this.name = name;
        this.startingVertex = sV;
        this.endingVertex = eV;
        this.xStartPos = sV.getXPos();
        this.yStartPos = sV.getYPos();
        this.xEndPos = eV.getXPos();
        this.yEndPos = eV.getYPos();
    }

    /**
     * Returns the edge name
     *
     * @return The name of the edge
     */
    public String getName() {
        return this.name;
    }

    /**
     * Sets the edge name
     *
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the startingVertex
     */
    public Vertex getStartingVertex() {
        return startingVertex;
    }

    /**
     * @param startingVertex - the startingVertex to set
     */
    public void setStartingVertex(Vertex startingVertex) {
        this.startingVertex = startingVertex;
    }

    /**
     * @return the endingVertex
     */
    public Vertex getEndingVertex() {
        return endingVertex;
    }

    /**
     * @param endingVertex - the endingVertex to set
     */
    public void setEndingVertex(Vertex endingVertex) {
        this.endingVertex = endingVertex;
    }

    /**
     * @return the xStartPos
     */
    public int getxStartPos() {
        return xStartPos;
    }

    /**
     * @param xStartPos - the xStartPos to set
     */
    public void setxStartPos(int xStartPos) {
        this.xStartPos = xStartPos;
    }

    /**
     * @return the yStartPos
     */
    public int getyStartPos() {
        return yStartPos;
    }

    /**
     * @param yStartPos - the yStartPos to set
     */
    public void setyStartPos(int yStartPos) {
        this.yStartPos = yStartPos;
    }

    /**
     * @return the xEndPos
     */
    public int getxEndPos() {
        return xEndPos;
    }

    /**
     * @param xEndPos - the xEndPos to set
     */
    public void setxEndPos(int xEndPos) {
        this.xEndPos = xEndPos;
    }

    /**
     * @return the yEndPos
     */
    public int getyEndPos() {
        return yEndPos;
    }

    /**
     * @param yEndPos - the yEndPos to set
     */
    public void setyEndPos(int yEndPos) {
        this.yEndPos = yEndPos;
    }
}
