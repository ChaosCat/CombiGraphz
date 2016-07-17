package io.github.chaoscat.combigraphz.core;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.IOException;
import java.net.URL;

/**
 * The vertex class
 *
 * @author Elian Kamal
 */
public class Vertex {

    private String name;
    private Image image;
    private int xPos, yPos;

    /**
     * Vertex constructor, creates a new Vertex object in correspondence to
     * given name, x position and y position values
     *
     * @param name name of vertex
     * @param xPos x position of vertex
     * @param yPos y position of vertex
     */
    public Vertex(String name, int xPos, int yPos) {
        this.name = name;
        this.xPos = xPos;
        this.yPos = yPos;
        this.image = null;
        URL imageURL = getClass().getClassLoader().getResource("Vertex.png");
        try {
            this.image = ImageIO.read(imageURL);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    /**
     * Default constructor, creates a new Vertex object with the following
     * NOTE: default value: Name = "NAME", X position = 0, Y position = 0
     */
    public Vertex() {
        this.name = "NAME";
        this.xPos = 0;
        this.yPos = 0;
        this.image = null;
        URL imageURL = getClass().getClassLoader().getResource("Vertex.png");
        try {
            this.image = ImageIO.read(imageURL);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    /**
     * Return the vertex name
     *
     * @return name
     */
    public String getName() {
        return this.name;
    }

    /**
     * Sets the vertex name
     *
     * @param name the name to be set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Returns the X position of the vertex
     *
     * @return xPos
     */
    public int getXPos() {
        return this.xPos;
    }

    /**
     * Sets the X position of the vertex
     *
     * @param xPos the X position to be set
     */
    public void setXPos(int xPos) {
        this.xPos = xPos;
    }

    /**
     * Returns the Y position of the vertex
     *
     * @return yPos the Y position to be set
     */
    public int getYPos() {
        return this.yPos;
    }

    /**
     * Sets the Y position of the vertex
     *
     * @param yPos the Y position of the vertex
     */
    public void setYPos(int yPos) {
        this.yPos = yPos;
    }

    /**
     * Returns the image of the vertex
     *
     * @return image
     */
    public Image getImage() {
        return this.image;
    }

}
