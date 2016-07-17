//                 Copyright 2016 Elian Kamal
//
//   Licensed under the Apache License, Version 2.0 (the "License");
//   you may not use this file except in compliance with the License.
//   You may obtain a copy of the License at
//
//       http://www.apache.org/licenses/LICENSE-2.0
package io.github.chaoscat.combigraphz.core;

import javax.swing.*;

/**
 * The graph class
 * provides as a structure and method container
 * for vertecies and edges, which basically
 * construct a graph.
 * It is implemented by the canvas and it
 * contains most of the functions handling
 * the object management on the scene
 *
 * @author Elian Kamal
 * @version 1.0
 */
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
     * @param index the specified index
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
     * @param v vertex to add
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
     * @param e Edge to add
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
     * @param index the index of the vertex to be deleted
     */
    public void delVertex(int index) {
        if (this.vertecies[index] != null) {
            this.vertecies[index] = null;
            this.cleanEdges();
            this.reOrderVertecies();
            this.reOrderEdges();
        } else
            JOptionPane.showMessageDialog(null, "ERROR: Vertex was already removed", "Error", JOptionPane.ERROR_MESSAGE,
                    null);
    }

    /**
     * Orders the graph's vertices, valid vertices before null values
     */
    public void reOrderVertecies() {
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
     * @param index the index of the edge to be deleted
     */
    public void delEdge(int index) {
        if (this.edges[index] != null) {
            this.edges[index] = null;
            this.reOrderEdges();
        } else
            JOptionPane.showMessageDialog(null, "ERROR: Edge was already removed", "Error", JOptionPane.ERROR_MESSAGE,
                    null);
    }

    /**
     * Removes any edges that don't have a starting and/or ending vertex associated with them
     */
    public void cleanEdges() {
        for (int i = 0; i < this.edges.length; i++) {
            if (this.getEdges()[i] != null && (this.getEdges()[i].getStartVertex() == null || this.getEdges()[i].getEndingVertex() == null)) {
                System.out.println("Found edge: " + this.getEdges()[i].getName() + " to be removed");
                System.out.println("Conditions: \n" + "Exists: " + (this.getEdges()[i] != null) +
                        "\nMissing start: " + (this.getEdges()[i].getStartVertex() == null) +
                        "\nMissing ending:" + (this.getEdges()[i].getEndingVertex() == null));
                this.edges[i] = null;
                System.out.println("Clean edge pass: " + i);
                this.printEdgeArray(this.edges);
            }
        }
    }

    /**
     * Finds and merges any non null edges into a single edge while separating
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
    public void reOrderEdges() {
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
     * @param vArr The vertex array to be printed
     */
    public void printVertexArray(Vertex[] vArr) {
        String array = "[";
        for (Vertex v : vArr) {
            array = v == null ? array + "null, " : array + v.getName() + ", ";
        }
        array = array.substring(0, array.length() - 2) + "]";
        System.out.println(array);
    }

    /**
     * Prints the edge array which has been specified (prints null if edge
     * is unassigned)
     *
     * @param eArr The edge array to be printed
     */
    public void printEdgeArray(Edge[] eArr) {
        String array = "[";
        for (Edge e : eArr) {
            array = e == null ? array + "null, " : array + e.getName() + ", ";
        }
        array = array.substring(0, array.length() - 2) + "]";
        System.out.println(array);
    }

    /**
     * Returns the number of edges attached to a specified vertex
     *
     * @param v the vertex which it's edges should be counted
     * @return the number of attached edges
     */
    public int getNumOfAttachedEdges(Vertex v) {
        int result = 0;
        for (Edge e : this.edges)
            if (
                    (e != null && v != null && e.getStartVertex() != null
                            && e.getEndingVertex() != null && e.getVertex() == null
                            && (e.getStartVertex().equals(v) || e.getEndingVertex().equals(v)))
                            ^
                            (e != null && v != null && e.getStartVertex() == null
                                    && e.getEndingVertex() == null && e.getVertex() != null
                                    && e.getVertex().equals(v))
                    )
                result++;
        return result;
    }
}
