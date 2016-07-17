//                 Copyright 2016 Elian Kamal
//
//   Licensed under the Apache License, Version 2.0 (the "License");
//   you may not use this file except in compliance with the License.
//   You may obtain a copy of the License at
//
//       http://www.apache.org/licenses/LICENSE-2.0
package io.github.chaoscat.combigraphz.gui;

import io.github.chaoscat.combigraphz.core.Graph;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * The canvas class
 * Implements the graph class/methods graphically
 * by extending a JPanel which is utilized by the
 * MainFrame class and overriding it's paint methods.
 *
 * @author Elian Kamal
 * @version 1.0
 */
public class Canvas extends JPanel implements MouseListener, MouseMotionListener, KeyListener {

    /**
     * Generated serial version UID
     */
    private static final long serialVersionUID = 6458084485018920083L;
    private Graph graph;

    /**
     * The constructor for the graph canvas, takes a graph object as a parameter
     *
     * @param graph The graph which the canvas should implement graphically
     */
    public Canvas(Graph graph) {
        this.setBackground(Color.WHITE);
        this.graph = graph;
    }

    @Override
    public void keyPressed(KeyEvent arg0) {

    }

    @Override
    public void keyReleased(KeyEvent arg0) {

    }

    @Override
    public void keyTyped(KeyEvent arg0) {

    }

    @Override
    public void mouseDragged(MouseEvent arg0) {

    }

    @Override
    public void mouseMoved(MouseEvent arg0) {

    }

    @Override
    public void mouseClicked(MouseEvent arg0) {

    }

    @Override
    public void mouseEntered(MouseEvent arg0) {

    }

    @Override
    public void mouseExited(MouseEvent arg0) {

    }

    @Override
    public void mousePressed(MouseEvent arg0) {

    }

    @Override
    public void mouseReleased(MouseEvent arg0) {

    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        for (int i = 0; i < this.graph.getVertecies().length; i++) {
            if (this.graph.getVertecies()[i] != null) {
                g.drawImage(this.graph.getVertecies()[i].getImage(), this.graph.getVertecies()[i].getXPos(),
                        this.graph.getVertecies()[i].getYPos(), 20, 20, null);
                g.drawString(this.graph.getVertecies()[i].getName(), this.graph.getVertecies()[i].getXPos(),
                        this.graph.getVertecies()[i].getYPos() - 5);
            }
        }
        for (int i = 0; i < this.graph.getEdges().length; i++) {
            if (this.graph.getEdges()[i] != null) {
                if (this.graph.getEdges()[i].isSelfPointed()) {
                    g.drawImage(this.graph.getEdges()[i].getImage(), this.graph.getEdges()[i].getXPos() + 20,
                            this.graph.getEdges()[i].getYPos(), 20, 20, null);
                    g.drawString(this.graph.getEdges()[i].getName(), this.graph.getEdges()[i].getXPos() + 25,
                            this.graph.getEdges()[i].getYPos() - 2);
                } else {
                    int sX = this.graph.getEdges()[i].getXPos();
                    int sY = this.graph.getEdges()[i].getYPos();
                    int eX = this.graph.getEdges()[i].getEndXPos();
                    int eY = this.graph.getEdges()[i].getEndYPos();
                    g.drawLine(sX + 10, sY + 10, eX, eY);
                    g.drawLine(eX, eY,
                            getArrowHeadXpos1(sX, sY, eX, eY, 20, 45),
                            getArrowHeadYpos1(sX, sY, eX, eY, 20, 45));

                    g.drawLine(eX, eY,
                            getArrowHeadXpos2(sX, sY, eX, eY, 20, 45),
                            getArrowHeadYpos2(sX, sY, eX, eY, 20, 45));

                    g.drawString(this.graph.getEdges()[i].getName(),
                            (this.graph.getEdges()[i].getXPos() + this.graph.getEdges()[i].getEndXPos()) / 2 + 5,
                            (this.graph.getEdges()[i].getYPos() + this.graph.getEdges()[i].getEndYPos()) / 2);
                }
            }
        }
    }

    private int getArrowHeadXpos1(int x1, int y1, int x2, int y2, int length, double degree) {
        double alpha = Math.toDegrees(Math.atan2(y2 - y1, x2 - x1));
        double beta = alpha + degree;

        int xf = (int) (x2 - length * Math.cos(Math.toRadians(beta)));
        return xf;
    }

    private int getArrowHeadYpos1(int x1, int y1, int x2, int y2, int length, double degree) {
        double alpha = Math.toDegrees(Math.atan2(y2 - y1, x2 - x1));
        double beta = alpha + degree;

        int yf = (int) (y2 - length * Math.sin(Math.toRadians(beta)));
        return yf;
    }

    private int getArrowHeadXpos2(int x1, int y1, int x2, int y2, int length, double degree) {
        double alpha = Math.toDegrees(Math.atan2(y2 - y1, x2 - x1));
        double beta = alpha - degree;

        int xf = (int) (x2 - length * Math.cos(Math.toRadians(beta)));
        return xf;
    }

    private int getArrowHeadYpos2(int x1, int y1, int x2, int y2, int length, double degree) {
        double alpha = Math.toDegrees(Math.atan2(y2 - y1, x2 - x1));
        double beta = alpha - degree;

        int yf = (int) (y2 - length * Math.sin(Math.toRadians(beta)));
        return yf;
    }

    /**
     * Returns the graph of the canvas
     *
     * @return The graph
     */
    public Graph getGraph() {
        return this.graph;
    }

    /**
     * Sets the graph of the canvas to a specified graph object
     *
     * @param graph The graph to use
     */
    public void setGraph(Graph graph) {
        this.graph = graph;
    }

}
