package graphs;

import java.util.List;

public class ConnectedComponents {
    List<List<Integer>> graph;
    boolean[] visited;
    int[] components;
    int count = 0;

    ConnectedComponents(List<List<Integer>> adjacencyList) {
        this.graph = adjacencyList;
        this.visited = new boolean[adjacencyList.size()];
        this.components = new int[adjacencyList.size()];
    }

    public int findConnectedComponents() {
        for (int i = 0; i < graph.size(); i++) {
            if (!visited[i]) {
                count++;
                dfs(i);
            }
        }

        return count;
    }

    private void dfs(int at) {
        visited[at] = true;
        components[at] = count;
        graph.get(at).stream().filter(i -> visited[i]).forEach(this::dfs);
        for (Integer next : graph.get(at)) {
            if (!visited[next])
                dfs(next);
        }
    }


    public int findConnectedComponentsFunctional() {
        for (int i = 0; i < graph.size(); i++) {
            if (!visited[i]) {
                count++;
                dfsFunctional(i);
            }
        }

        return count;
    }

    private void dfsFunctional(int at) {
        visited[at] = true;
        components[at] = count;
        graph.get(at).stream().filter(i -> visited[i]).forEach(this::dfs);
    }
}
