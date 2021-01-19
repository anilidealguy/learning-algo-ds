package datastructures.graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class CreateAdjacencyList {
    
    public static void main(String[] args) {
        CreateAdjacencyList create = new CreateAdjacencyList();
        int[][] edgeList = new int[][]{{1,0}, {2,0}, {3,1}, {3,2}};
        Map<Integer, List<Integer>> createAdjacencyList = create.createAdjacencyList(edgeList);

        for (Entry<Integer,List<Integer>> entry : createAdjacencyList.entrySet()) {
            System.out.print(entry.getKey() + "\t->\t");
            for (Integer i : entry.getValue())
                System.out.print(i + "\t");
            System.out.println();
        }
    }

    public Map<Integer, List<Integer>> createAdjacencyList(int[][] edgeList) {
        Map<Integer, List<Integer>> adjacencyList = new HashMap<>();
        final int SRC = 0;
        final int DEST = 1;

        for (int[] edge : edgeList) {
            adjacencyList.putIfAbsent(edge[SRC], new ArrayList<Integer>());
            adjacencyList.get(edge[SRC]).add(edge[DEST]);
        }

        return adjacencyList;
    }
}