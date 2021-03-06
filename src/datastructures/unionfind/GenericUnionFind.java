package datastructures.unionfind;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class GenericUnionFind<T> {
    
    private int[] parent;
    private int[] size;
    private int noOfcomponents;
    private int n;
    private Map<T, Integer> map;

    // Initializing the data structure
    public GenericUnionFind (int n, Set<T> nodes) {
        parent = new int[n];
        size = new int[n];
        this.n = n;
        this.noOfcomponents = n;
        this.map = new HashMap<>(n); // as we know the maximum number of elements then we can initialize with the number of elements to prevent re-hashing

        int count = 0;
        for (T t : nodes) {
            map.put(t, count++);
        }

        // At first all the nodes are parents to itself
        // At first all the node's size is 1
        for (int i=0; i<n; i++) {
            parent[i] = i;
            size[i] = 1;
        }
    }

    public int noOfElements () {
        return this.n;
    }

    public int getNoOfComponents () {
        return this.noOfcomponents;
    }
    
    public int find(int target) {
        int root = parent[target];

        while (root != target) {
            root = parent[root];
        }

        // Path Comparession
        while (target != root) {
            int temp = parent[target];
            parent[target] = root;
            target = temp;
        }

        return root;
    }

    public boolean isConnected (int p, int q) {
        return find(p) == find(q);
    }

    public void union (int p, int q) {
        if (isConnected(p, q))
            return;

        int parent1 = find(p);
        int parent2 = find(q);

        if (size[parent1] < size[parent2]) {
            size[parent2] = size[parent2] + size[parent1];
            parent[parent1] = parent2;
        } else {
            size[parent1] = size[parent2] + size[parent1];
            parent[parent2] = parent1;
        }

        noOfcomponents--;
    }
}