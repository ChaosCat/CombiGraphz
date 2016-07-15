package io.github.chaoscat.combigraphz.core;

import javax.swing.*;
import java.awt.*;

//On hold for the moment
public class SelfEdge {

    private String name;
    private Vertex vertex;
    private Image image;
    private int xPos, yPos;

    /**
     * The constructor for a self pointing edge
     *
     * @param name the name of the edge
     * @param v the vertex which the edge points towards
     */
    public SelfEdge(String name, Vertex v) {
        this.name = name;
        this.vertex = v;
        this.xPos = v.getXPos();
        this.yPos = v.getYPos();
        this.image = new ImageIcon(this.getClass().getResource("../resources/Self-edge.png")).getImage();
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
     * Returns the vertex of the self-edge
     *
     * @return the vertex
     */
    public Vertex getVertex() {
        return vertex;
    }

    /**
     * Sets the vertex of the self-edge
     *
     * @param vertex the vertex to set
     */
    public void setVertex(Vertex vertex) {
        this.vertex = vertex;
    }

    /**
     * Returns the image of the self-edge
     * NOTE: Currently always returns the same image
     *
     * @return the image
     */
    public Image getImage() {
        return image;
    }

    /**
     * Sets a new image to the self-edge
     *
     * @param image the image to set
     */
    public void setImage(Image image) {
        this.image = image;
    }

    /**
     * Returns the self-edge X position
     *
     * @return the xPos
     */
    public int getXPos() {
        return xPos;
    }

    /**
     * Sets the self-edge X position
     *
     * @param xPos the xPos to set
     */
    public void setXPos(int xPos) {
        this.xPos = xPos;
    }

    /**
     * Returns the self-edge Y position
     *
     * @return the yPos
     */
    public int getYPos() {
        return yPos;
    }

    /**
     * Sets the self-edge X position
     *
     * @param yPos the yPos to set
     */
    public void setYPos(int yPos) {
        this.yPos = yPos;
    }

}
