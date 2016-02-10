package elian.kamal.combigraphs.core;

import java.awt.Image;

import javax.swing.ImageIcon;

public class Vertex {

	private String name;
	private Image image;
	private int xPos, yPos;

	/**
	 * Vertex constructor, creates a new Vertex object in correspondence to
	 * given name, x position and y position values
	 * 
	 * @param name
	 * @param xPos
	 * @param yPos
	 */
	public Vertex(String name, int xPos, int yPos) {
		this.name = name;
		this.xPos = xPos;
		this.yPos = yPos;
		this.image = null;
		this.image = new ImageIcon(this.getClass().getResource("../resources/Dot.png")).getImage();
	}

	/**
	 * Default constructor, creates a new Vertex object with the following
	 * default value: Name - "NAME" X position - 0 Y position - 0
	 */
	public Vertex() {
		this.name = "NAME";
		this.xPos = 0;
		this.yPos = 0;
		this.image = null;
		this.image = new ImageIcon(this.getClass().getResource("../resources/Dot.png")).getImage();
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
	 * @param name
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
	 * @param xPos
	 */
	public void setXPos(int xPos) {
		this.xPos = xPos;
	}

	/**
	 * Returns the Y position of the vertex
	 * 
	 * @return yPos
	 */
	public int getYPos() {
		return this.yPos;
	}

	/**
	 * Sets the Y position of the vertex
	 * 
	 * @param yPos
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
