package algorithms.dynamic_programming.fibonacci;

public class Staircase {
    public int countWays(int n) {
        FibonacciNumbers fn = new FibonacciNumbers();
        return fn.calculateFibonacciSpaceOptimized(n);
    }

    public static void main(String[] args) {
        Staircase sc = new Staircase();
        System.out.println(sc.countWays(3));
        System.out.println(sc.countWays(4));
        System.out.println(sc.countWays(5));
    }
}
