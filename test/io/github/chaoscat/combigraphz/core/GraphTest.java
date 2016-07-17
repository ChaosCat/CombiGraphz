package io.github.chaoscat.combigraphz.core;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;

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

    @Ignore
    public void cleanEdges() {

    }

    @Ignore
    public void mergeEdges() {

    }

    @Ignore
    public void printVertexArray() {

    }

}