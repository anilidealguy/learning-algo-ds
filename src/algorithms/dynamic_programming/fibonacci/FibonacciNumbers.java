package algorithms.dynamic_programming.fibonacci;

import java.util.Arrays;

public class FibonacciNumbers {
    public int calculateFibonacciSpaceOptimized(int n) {
        if (n < 2)
            return n;

        int f = 0;
        int s = 1;
        int t = f+s;

        for (int i = 2; i <= n; i++) {
            t = f + s;
            f = s;
            s = t;
        }
        return t;
    }

    public int calculateFibonacciDynamicProgramming(int n) {
        int[] memo = new int[n+1];
        Arrays.fill(memo, -1);
        memo[0] = 0;
        memo[1] = 1;

        for (int i = 2; i <= n; i++) {
            memo[i] = memo[i-1] + memo[i-2];
        }

        return memo[n];
    }

    public int calculateFibonacciMemoization(int n) {
        int[] memo = new int[n+1];
        Arrays.fill(memo, -1);
        memo[0] = 0;
        memo[1] = 1;

        return calculateFibonacciMemoization(n, memo);
    }

    private int calculateFibonacciMemoization(int n, int[] memo) {
        if (n < 2)
            return n;

        if (memo[n] != -1)
            return memo[n];

        memo[n] = calculateFibonacciMemoization(n-1, memo) + calculateFibonacciMemoization(n-2, memo);

        return memo[n];
    }

    public int calculateFibonacciRecursive(int n) {
        if(n < 2)
            return n;
        return calculateFibonacciRecursive(n-1) + calculateFibonacciRecursive(n-2);
    }

    public static void main(String[] args) {
        FibonacciNumbers fib = new FibonacciNumbers();
        System.out.println("5th Fibonacci is ---> " + fib.calculateFibonacciRecursive(5));
        System.out.println("6th Fibonacci is ---> " + fib.calculateFibonacciRecursive(6));
        System.out.println("7th Fibonacci is ---> " + fib.calculateFibonacciRecursive(7));

        System.out.println("5th Fibonacci is ---> " + fib.calculateFibonacciMemoization(5));
        System.out.println("6th Fibonacci is ---> " + fib.calculateFibonacciMemoization(6));
        System.out.println("7th Fibonacci is ---> " + fib.calculateFibonacciMemoization(7));

        System.out.println("5th Fibonacci is ---> " + fib.calculateFibonacciDynamicProgramming(5));
        System.out.println("6th Fibonacci is ---> " + fib.calculateFibonacciDynamicProgramming(6));
        System.out.println("7th Fibonacci is ---> " + fib.calculateFibonacciDynamicProgramming(7));

        System.out.println("5th Fibonacci is ---> " + fib.calculateFibonacciSpaceOptimized(5));
        System.out.println("6th Fibonacci is ---> " + fib.calculateFibonacciSpaceOptimized(6));
        System.out.println("7th Fibonacci is ---> " + fib.calculateFibonacciSpaceOptimized(7));
    }
}
