package net.bplaced.codebase.routing;

import java.util.Arrays;

public class Graph {

    private Node[] nodes;
    private Edge[] edges;

    public Node[] getNodes() {
        return nodes;
    }

    public Edge[] getEdges() {
        return edges;
    }

    public Node getNode(String label) {
        return Arrays.stream(getNodes()).filter(n -> label.equals(n.getLabel())).findFirst().orElse(null);
    }

    public void buildAdjacencyLists() {
        for (Edge edge : edges) {
            // for simplicity store the edges as outgoing edges for each node respectively
            nodes[edge.getSource()].addAdjacency(edge);
            nodes[edge.getTarget()].addAdjacency(edge.inverse());
        }
    }

}
