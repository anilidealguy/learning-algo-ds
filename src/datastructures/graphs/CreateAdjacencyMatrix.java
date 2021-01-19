package datastructures.graphs;

public class CreateAdjacencyMatrix {

    public static void main(String[] args) {
        CreateAdjacencyMatrix adjacencyMatrix = new CreateAdjacencyMatrix();
        int[][] createdAdjacencyMatrix = adjacencyMatrix.createAdjacencyMatrix(new int[][] {{1,0}, {2,0}, {3,1}, {3,2}}, 4);
        for (int[] is : createdAdjacencyMatrix) {
            for (int i : is) {
                System.out.print(i + "\t");
            }
            System.out.println();
        }
    }
    
    public int[][] createAdjacencyMatrix (int[][] edgeList, int n) {
        int[][] adjacencyMatrix = new int[n][n];
        final int SRC = 0;
        final int DEST = 1;

        for (int[] edge : edgeList) 
            adjacencyMatrix[edge[SRC]][edge[DEST]] = 1;

        return adjacencyMatrix;
    }
}