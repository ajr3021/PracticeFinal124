package MST;

import graphs.AdjacencyGraph;

import java.util.Collections;
import java.util.List;

public class SpanTree {
    public int minimumSpanningTree(AdjacencyGraph<Integer> graph){
        return 0;
    }
    public static void main(String[] args) {
        AdjacencyGraph<Integer> graph = new AdjacencyGraph<>();

        for(int i = 0; i < 8; i++){
            graph.add(i);
        }

        graph.connectUndirected(0, 1, 4);
        graph.connectUndirected(0, 2, 16);
        graph.connectUndirected(2, 3, 8);
        graph.connectUndirected(0, 3, 6);
        graph.connectUndirected(3, 4, 5);
        graph.connectUndirected(2, 4, 10);
        graph.connectUndirected(2, 5, 21);
        graph.connectUndirected(5, 6, 7);
        graph.connectUndirected(4, 5, 14);
        graph.connectUndirected(4, 6, 11);
        graph.connectUndirected(1, 7, 24);
        graph.connectUndirected(3, 7, 23);
        graph.connectUndirected(4, 7, 18);
        graph.connectUndirected(6, 7, 9);

        // this should output 50
        System.out.println(new SpanTree().minimumSpanningTree(graph));

    }
}
