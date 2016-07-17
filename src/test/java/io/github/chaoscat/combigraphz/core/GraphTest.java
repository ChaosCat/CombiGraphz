//                 Copyright 2016 Elian Kamal
//
//   Licensed under the Apache License, Version 2.0 (the "License");
//   you may not use this file except in compliance with the License.
//   You may obtain a copy of the License at
//
//          http://www.apache.org/licenses/LICENSE-2.0
package io.github.chaoscat.combigraphz.core;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import java.util.Random;

/**
 * Created by Elian on 7/17/2016.
 */
public class GraphTest {

    protected Graph testGraph;

    @Before
    public void setUp() {
        int selfEdgeRoll = new Random().nextInt(19) + 1;
        int selfEdgeNum = new Random().nextInt(19) + 1;
        int selfEdgeCounter = 0;
        int edgeCounter = 0;


        testGraph = new Graph();
        for (int i = 0; i < testGraph.getVertecies().length; i++)
            testGraph.getVertecies()[i] = (new Vertex("v" + String.valueOf(i), new Random().nextInt(2000), new Random().nextInt(1000)));
        for (int i = 0; i < testGraph.getEdges().length; i++) {
            if (selfEdgeRoll == selfEdgeNum) {
                selfEdgeCounter++;
                testGraph.getEdges()[i] = (new Edge("se" + String.valueOf(selfEdgeCounter),
                        testGraph.getVertecies()[new Random().nextInt(testGraph.getVertecies().length)]));
            } else {
                edgeCounter++;
                testGraph.getEdges()[i] = (new Edge("e" + String.valueOf(edgeCounter),
                        testGraph.getVertecies()[new Random().nextInt(testGraph.getVertecies().length)],
                        testGraph.getVertecies()[new Random().nextInt(testGraph.getVertecies().length)]));
            }
        }

        for (Vertex v : testGraph.getVertecies()) {
            Assert.assertNotNull(v);
        }
        for (Edge e : testGraph.getEdges()) {
            Assert.assertNotNull(e);
        }
    }

    @Ignore
    public void addVertex() {

    }

    @Ignore
    public void addEdge() {

    }

    @Ignore
    public void delVertex() {

    }

    @Ignore
    public void delEdge() {

    }

    @Test
    public void reOrderVertecies() {
        //iterate over each vertex
        for (int i = 0; i < testGraph.getVertecies().length; i++) {
            //Create an exact instance of the Graph to be tested each iteration
            Graph testGraphInstance = new Graph();
            for (int j = 0; j < testGraph.getVertecies().length; j++)
                testGraphInstance.getVertecies()[j] = testGraph.getVertecies()[j];
            for (int j = 0; j < testGraph.getEdges().length; j++)
                testGraphInstance.getEdges()[j] = testGraph.getEdges()[j];
            testGraphInstance.getVertecies()[i] = null; //nullify (delete) a vertex

            //Created an emulated result of an ordered array after removal of one vertex
            Vertex[] desiredResultArray = new Vertex[testGraph.getVertecies().length];
            int indexToWrite = 0;
            for (int j = 0; j < testGraph.getVertecies().length; j++) {
                //Emulate the result by overwriting the the vertex that should be deleted with the next one
                if (i != j) {
                    desiredResultArray[indexToWrite] = testGraph.getVertecies()[j];
                    indexToWrite++;
                }
            }

            //initiate function and validate result (by names which are persistent regardless of other factors (see Setup))
            testGraphInstance.reOrderVertecies();
            for (int j = 0; j < testGraphInstance.getVertecies().length; j++) {
                if (testGraphInstance.getVertecies()[j] != null)
                    Assert.assertEquals(testGraphInstance.getVertecies()[j].getName(), desiredResultArray[j].getName());
            }
        }
    }

    @Test
    public void reOrderEdges() {
        //iterate over each edge
        for (int i = 0; i < testGraph.getEdges().length; i++) {
            //Create an exact instance of the Graph to be tested each iteration
            Graph testGraphInstance = new Graph();
            for (int j = 0; j < testGraph.getEdges().length; j++)
                testGraphInstance.getEdges()[j] = testGraph.getEdges()[j];
            for (int j = 0; j < testGraph.getEdges().length; j++)
                testGraphInstance.getEdges()[j] = testGraph.getEdges()[j];
            testGraphInstance.getEdges()[i] = null; //nullify (delete) an edge

            //Created an emulated result of an ordered array after removal of one edge
            Edge[] desiredResultArray = new Edge[testGraph.getEdges().length];
            int indexToWrite = 0;
            for (int j = 0; j < testGraph.getEdges().length; j++) {
                //Emulate the result by overwriting the the edge that should be deleted with the next one
                if (i != j) {
                    desiredResultArray[indexToWrite] = testGraph.getEdges()[j];
                    indexToWrite++;
                }
            }

            //initiate function and validate result (by names which are persistent regardless of other factors (see Setup))
            testGraphInstance.reOrderEdges();
            for (int j = 0; j < testGraphInstance.getEdges().length; j++) {
                if (testGraphInstance.getEdges()[j] != null)
                    Assert.assertEquals(testGraphInstance.getEdges()[j].getName(), desiredResultArray[j].getName());
            }
        }
    }

    @Ignore
    public void cleanEdges() {

    }

    @Ignore
    public void mergeEdges() {

    }

    @Ignore
    public void printVertexArray() {

    }


    @Ignore
    public void printEdgeArray() {

    }

    @Test
    public void getNumOfAttachedEdges() {
        //Create a testing graph
        Graph tempGraph = new Graph();
        tempGraph.addVertex(new Vertex("receiver", 100, 100));
        tempGraph.addVertex(new Vertex("sender", 200, 200));

        //decide upon a random number of edges and add them
        int numOfEdges = new Random().nextInt(tempGraph.getEdges().length);
        for (int i = 0; i < numOfEdges; i++) {
            //random edge types
            int rmdType = new Random().nextInt(2) + 1;
            switch (rmdType) {
                case 1:
                    tempGraph.getEdges()[i] = new Edge("e" + String.valueOf(i + 1), tempGraph.getVertecies()[0]);
                    break;
                case 2:
                    tempGraph.getEdges()[i] = new Edge("e" + String.valueOf(i + 1), tempGraph.getVertecies()[1], tempGraph.getVertecies()[0]);
                    break;
                default:
                    Assert.fail("Lol, seems like the java random function just broke");
            }
        }

        tempGraph.printVertexArray(tempGraph.getVertecies());
        tempGraph.printEdgeArray(tempGraph.getEdges());

        Assert.assertEquals(numOfEdges, tempGraph.getNumOfAttachedEdges(tempGraph.getVertecies()[0]));
    }

}