package graphs;

import java.util.*;

public class BfsOnGraph {

    List<List<Integer>> graph;

    BfsOnGraph(List<List<Integer>> adjacencyList) {
        this.graph = adjacencyList;
    }

    public List<Integer> performBfs(int start, int end) {
        List<Integer> prev = bfs(start);

        return reconstructPath(start, end, prev);
    }

    private List<Integer> reconstructPath(int start, int end, List<Integer> prev) {
        List<Integer> path = new LinkedList<>();

        for (int at = end; prev.get(at) != null; at = prev.get(at)) {
            path.add(0, at);
        }

        if (path.get(0) == start)
            return path;
        return new ArrayList<>();
    }

    private List<Integer> bfs(int start) {
        Queue<Integer> queue = new LinkedList<>();
        Integer[] prev = new Integer[graph.size()];
        boolean[] visited = new boolean[graph.size()];
        queue.add(start);
        visited[start] = true;

        while (!queue.isEmpty()) {
            Integer curr = queue.poll();
            List<Integer> neighbours = graph.get(curr);

            for (Integer neighbour : neighbours ) {
                if (!visited[neighbour]) {
                    visited[neighbour] = true;
                    queue.add(neighbour);
                    prev[neighbour] = curr;
                }
            }
        }

        return Arrays.asList(prev);
    }

}
