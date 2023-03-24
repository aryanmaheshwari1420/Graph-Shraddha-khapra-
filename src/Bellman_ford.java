import java.util.ArrayList;

public class Bellman_ford {
    public static void main(String[] args) {

        int V = 5;
        ArrayList<Edge> graph[] = new ArrayList[V];
        createGraph2(graph);
        bellman_Ford(graph,0,V);

    }

    static class Edge {
        int src;
        int dest;
        int wt;

        public Edge(int s, int d, int w) {
            this.src = s;
            this.dest = d;
            this.wt = w;
        }
    }


    public static void bellman_Ford(ArrayList<Edge> graph[], int src , int V){
            int dist[] = new int[V];
        for (int i = 0; i < V;  i++) {
            if(i!=src){
                dist[i] = Integer.MAX_VALUE;
            }
        }

        for(int k=0;k<V-1;k++){ //O(V)
            // O(E)
            for (int i = 0; i < V; i++) {
                for (int j = 0; j < graph[i].size(); j++) {
                    Edge e = graph[i].get(j);
                    int u = e.src;
                    int v = e.dest;
                    int wt = e.wt;

                    if(dist[u]!=Integer.MAX_VALUE && dist[u]+ wt<dist[v]){
                        dist[v] = dist[u] + wt;
                    }
                }
            }
        }

        //detecting -ve weights cycle

        for(int k=0;k<V-1;k++){ //O(V)
            // O(E)
            for (int i = 0; i < V; i++) {
                for (int j = 0; j < graph[i].size(); j++) {
                    Edge e = graph[i].get(j);
                    int u = e.src;
                    int v = e.dest;
                    int wt = e.wt;

                    if(dist[u]!=Integer.MAX_VALUE && dist[u]+ wt<dist[v]){
                        System.out.println("negative cycle exists");
                    }
                }
            }
        }

        for (int i = 0; i < dist.length; i++) {
            System.out.println(dist+" ");
        }
        System.out.println();
    }

    public static void createGraph2(ArrayList<Edge> graph[]){
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<Edge>();
        }

        graph[0].add(new Edge(0,1,2));
        graph[0].add(new Edge(0,2,4));

        graph[1].add(new Edge(1,2,-4));

        graph[2].add(new Edge(2,3,2));

        graph[3].add(new Edge(3,4,4));

        graph[4].add(new Edge(4,1,-1));

    }
}
