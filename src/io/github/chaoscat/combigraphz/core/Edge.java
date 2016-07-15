package io.github.chaoscat.combigraphz.core;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.net.URL;

public class Edge {

    private String name;
    private Vertex startingVertex, endingVertex;
    private Vertex vertex;
    private Image image;
    private int xPos, yPos, xEndPos, yEndPos;
    private boolean selfPointed;

    /**
     * The constructor for an edge between two vertices
     *
     * @param name - the name of the edge
     * @param sV   - the vertex which the edge goes out from
     * @param eV   - the vertex which the edge points towards
     */
    public Edge(String name, Vertex sV, Vertex eV) {
        this.selfPointed = false;
        this.name = name;
        this.startingVertex = sV;
        this.endingVertex = eV;
        this.xPos = sV.getXPos();
        this.yPos = sV.getYPos();
        this.xEndPos = eV.getXPos();
        this.yEndPos = eV.getYPos();
        this.image = null;
    }

    /**
     * The constructor for a self pointing edge
     *
     * @param name - the name of the edge
     * @param v    - the vertex which the edge points towards
     */
    public Edge(String name, Vertex v) {
        this.selfPointed = true;
        this.name = name;
        this.vertex = v;
        this.xPos = v.getXPos();
        this.yPos = v.getYPos();
        URL imageURL = getClass().getClassLoader().getResource("io/github/chaoscat/combigraphz/resources/Self-edge.png");
        try {
            this.image = ImageIO.read(imageURL);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "An error has occurred while loading Self-edge image from the path" + imageURL.toString(), "Error while loading image", JOptionPane.ERROR_MESSAGE, null);
            ex.printStackTrace();
        }

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
     * Returns the X position of the edge (in case which it is self pointed)
     *
     * @return The X position of the self pointed edge
     */
    public int getXPos() {
        return this.xPos;
    }

    /**
     * Sets the X position of the edge to a specified value (in case which it is
     * self pointed), returns the X position of the starting vertex otherwise
     *
     * @param xPos
     */
    public void setXPos(int xPos) {
        this.xPos = xPos;
    }

    /**
     * Sets the Y position of the edge to a specified value (in case which it is
     * self pointed), returns the Y position of the starting vertex otherwise
     *
     * @return The Y position of the self pointed edge
     */
    public int getYPos() {
        return this.yPos;
    }

    /**
     * Sets the Y position of the edge to a specified value (in case which it is
     * self pointed)
     *
     * @param yPos
     */
    public void setYPos(int yPos) {
        this.yPos = yPos;
    }

    /**
     * Returns the ending X position of the edge (in case which the edge is not
     * self-pointed)
     *
     * @return The ending X position of the edge
     */
    public int getEndXPos() {
        return this.xEndPos;
    }

    /**
     * Returns the ending Y position of the edge (in case which the edge is not
     * self-pointed)
     *
     * @return The ending Y position of the edge
     */
    public int getEndYPos() {
        return this.yEndPos;
    }

    /**
     * Returns true when the edge is self pointing, returns false otherwise
     *
     * @return Whether the edge is self pointing or not
     */
    public boolean isSelfPointed() {
        return this.selfPointed;
    }

    /**
     * Returns the image of the edge (null in case which the edge is not
     * self-pointed)
     *
     * @return The image of the edge
     */
    public Image getImage() {
        return this.image;
    }

    /**
     * Returns the vertex of the edge (in case which it is self pointed)
     *
     * @return The vertex of the self pointed edge
     */
    public Vertex getVertex() {
        return this.vertex;
    }

    /**
     * Returns the starting vertex of the edge (in case which it is not self
     * pointed)
     *
     * @return The starting vertex of the edge
     */
    public Vertex getStartVertex() {
        return this.startingVertex;
    }

    /**
     * Returns the ending vertex of the edge (in case which it is not self
     * pointed)
     *
     * @return The ending vertex of the edge
     */
    public Vertex getEndingVertex() {
        return this.endingVertex;
    }
}
