package MST;

import graphs.AdjacencyGraph;
import graphs.Vertex;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class UnionFind<E> {
    private final Map<Vertex<E>, Vertex<E>> boss;
    private final Map<Vertex<E>, Integer> size;
    private final Map<Vertex<E>, HashSet<Vertex<E>>> set;

    public UnionFind(AdjacencyGraph<E> graph){
        boss = new HashMap<>();
        size = new HashMap<>();
        set = new HashMap<>();

        for(Vertex<E> vertex : graph.getVertices().values()){
            boss.put(vertex, vertex);
            size.put(vertex, 1);
            HashSet<Vertex<E>> set = new HashSet<>();
            set.add(vertex);
            this.set.put(vertex, set);
        }
    }

    public Vertex<E> find(Vertex<E> vertex){
        return this.boss.get(vertex);
    }

    public void union(Vertex<E> u, Vertex<E> v){
        Vertex<E> uBoss = this.boss.get(u);
        Vertex<E> vBoss = this.boss.get(v);

        if(size.get(uBoss) < size.get(vBoss)){
            Vertex<E> temp = u;
            u = v;
            v = temp;

            uBoss = this.boss.get(u);
            vBoss = this.boss.get(v);
        }

        HashSet<Vertex<E>> uSet = set.get(uBoss);
        HashSet<Vertex<E>> vSet = set.get(vBoss);

        uSet.addAll(vSet);

        size.put(uBoss, size.get(uBoss) + size.get(vBoss));

        for(Vertex<E> vertex : vSet){
            boss.put(vertex, uBoss);
        }
    }
}
