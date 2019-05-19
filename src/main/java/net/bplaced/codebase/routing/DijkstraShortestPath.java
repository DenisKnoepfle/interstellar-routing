package net.bplaced.codebase.routing;

import java.util.PriorityQueue;

public class DijkstraShortestPath {

    /**
     * Calculates the shortest path from <code>source</code> to <code>target</code>.
     * 
     * The length of the path can be obtained from the target node via
     * {@link Node#getMinDistance()} and the resulting path via
     * {@link Node#backtrack()}.
     * 
     * @param graph  the graph to operate on
     * @param source the source node
     * @param target the target node
     */
    public static void calcPath(Graph graph, Node source, Node target) {
        source.setMinDistance(0.0);
        PriorityQueue<Node> nodeQueue = new PriorityQueue<>();
        nodeQueue.add(source);

        while (!nodeQueue.isEmpty()) {
            Node u = nodeQueue.poll();

            if (u.equals(target)) {
                return;
            }

            for (Edge e : u.getAdjacencies()) {
                Node v = graph.getNodes()[e.getTarget()];
                double tentativeDistance = u.getMinDistance() + e.getCost();
                if (tentativeDistance < v.getMinDistance()) {
                    nodeQueue.remove(v);
                    v.setMinDistance(tentativeDistance);
                    v.setPrevious(u);
                    nodeQueue.add(v);
                }
            }
        }
    }

}
