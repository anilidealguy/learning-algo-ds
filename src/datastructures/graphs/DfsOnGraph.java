package datastructures.graphs;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class DfsOnGraph {
    
    public void doDfsOnGraph(Map<Integer, List<Integer>> graph, int startPos, List<Integer> path, List<List<Integer>> allPaths) {
        path.add(startPos);
        if (startPos == graph.size() - 1) {
            allPaths.add(new ArrayList<>(path));  
            return ;
        }
        
        for (int pos : graph.get(startPos)) {
            doDfsOnGraph(graph, pos, path, allPaths);
            path.remove(path.size() - 1);
        }
    }
}