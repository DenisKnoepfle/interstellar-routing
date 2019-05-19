package net.bplaced.codebase.routing;

import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class InterstellarRoutingMain {

    private static final String DEFAULT_JSON_FILE = "generatedGraph.json";
    private static final String START_NODE = "Erde";
    private static final String TARGET_NODE = "b3-r7-r4nd7";

    public static void main(String[] args) throws JsonParseException, JsonMappingException, IOException {

        String filename = args.length == 1 ? args[0] : DEFAULT_JSON_FILE;

        ObjectMapper objMapper = new ObjectMapper();
        Graph graph = objMapper.readValue(new File(filename), Graph.class);
        graph.buildAdjacencyLists();

        Node source = graph.getNode(START_NODE);
        Node target = graph.getNode(TARGET_NODE);

        DijkstraShortestPath.calcPath(graph, source, target);

        System.out.println("Optimale Abfolge der Nodes: " + target.backtrack());
        System.out.println("Gesamtentfernung: " + target.getMinDistance());
    }

}
