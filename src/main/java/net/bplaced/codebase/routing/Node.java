package net.bplaced.codebase.routing;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class Node implements Comparable<Node> {

    private String label;

    private double minDistance = Double.MAX_VALUE;
    private final List<Edge> adjacencies = new ArrayList<>();
    private Node previous;

    public String getLabel() {
        return label;
    }

    @Override
    public int hashCode() {
        return label.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Node)) {
            return false;
        }
        Node other = (Node) obj;
        return label.equals(other.label);
    }

    @Override
    public int compareTo(Node o) {
        if (getMinDistance() == o.getMinDistance()) {
            return 0;
        }
        return getMinDistance() < o.getMinDistance() ? -1 : 1;
    }

    @Override
    public String toString() {
        return label;
    }

    public void addAdjacency(Edge edge) {
        getAdjacencies().add(edge);
    }

    /**
     * @return list of outgoing edges from this node
     */
    public List<Edge> getAdjacencies() {
        return adjacencies;
    }

    public Node getPrevious() {
        return previous;
    }

    public void setPrevious(Node previous) {
        this.previous = previous;
    }

    public double getMinDistance() {
        return minDistance;
    }

    public void setMinDistance(double minDistance) {
        this.minDistance = minDistance;
    }

    /**
     * @return path consisting of the nodes that led from the source to this node
     */
    public Collection<Node> backtrack() {
        Deque<Node> path = new LinkedList<>();
        backtrack(path);
        return path;
    }

    private void backtrack(Deque<Node> path) {
        path.addFirst(this);
        if (previous != null) {
            previous.backtrack(path);
        }
    }

}
