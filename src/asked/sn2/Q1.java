package asked.sn2;

import java.util.*;

public class Q1 {

//    Please write logic for currency conversion rate. IND-USD-0.2 USD-EURO-0.3 EURO-RUS-0.4 IND-RUS-0.5 RUS-GER-0.6 EURO-GER-0.7
//            2.	Test scenarios:
//            3.	Immediate conversion
//	4.	Find the best. Conversion rate for a particular source and target
//	5.
//            6.
//            7.

    // pre processing - to store the given conversion rates - {"IND-USD":0.2, "USD-EURO":0.3}
    // queries - src to dest

    public double getConversionRate(List<Node> edges, String srcCurrency, String destCurrency) {
        // Construct an adj list from the edge list given
        Map<String, List<Node>> adjList = new HashMap<>();

        for(Node edge : edges) {
            adjList.putIfAbsent(edge.src, new ArrayList<>());
            adjList.get(edge.src).add(edge);
        }

        return getConversionRate(adjList, srcCurrency, destCurrency);
    }

    private double getConversionRate(Map<String, List<Node>> adjList, String srcCurrency, String destCurrency) {
        // applying BFS
        Queue<Pair> queue = new LinkedList<>();

        queue.add(new Pair(srcCurrency, 0.0));
        int levels = 0;

        while(!queue.isEmpty()) {
            Pair n = queue.poll();
            List<Node> tempDests = adjList.get(n.currency);
            for (Node dest: tempDests) {
                if (dest.dest.equalsIgnoreCase(destCurrency))
                    return n.conversionRate + dest.conversionRate;

                queue.add(new Pair(dest.dest, n.conversionRate + dest.conversionRate));
            }
            levels++;
        }

        System.out.println(levels);
        return 1.0d;
    }
}

class Pair {
    String currency;
    Double conversionRate;

    public Pair(String currency, Double conversionRate) {
        this.currency = currency;
        this.conversionRate = conversionRate;
    }
}

class Node {
    String src;
    String dest;
    Double conversionRate;

    public Node(String src, String dest, Double conversionRate) {
        this.src = src;
        this.dest = dest;
        this.conversionRate = conversionRate;
    }
}