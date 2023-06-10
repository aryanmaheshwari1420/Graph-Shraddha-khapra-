import java.util.ArrayList;
import java.util.Stack;

public class kosaraju_Algo {

    static class Edge{
        int src;
        int dest;
        public Edge(int src, int dest){
            this.src = src;
            this.dest = dest;
        }
    }

    public static void createGraph(ArrayList<Edge> graph[]){
        for (int i = 0; i < graph.length; i++){
            graph[i] = new ArrayList<Edge>();
        }
        graph[0].add(new Edge(0, 2));
        graph[0].add(new Edge(0, 3));
        graph[1].add(new Edge(1, 0));
        graph[2].add(new Edge(2, 1));
        graph[3].add(new Edge(3, 4));
    }

    public static void dfs(ArrayList<Edge> graph[], int curr, boolean[] vis){
        vis[curr] = true;
        System.out.print(curr + " ");
        for (int i = 0; i < graph[curr].size(); i++){
            Edge edge = graph[curr].get(i);
            if (!vis[edge.dest]){
                dfs(graph, edge.dest, vis);
            }
        }
    }

    public static void kosarjuAlgo(ArrayList<Edge> graph[], int v){
        // Step 1: O(V+E)
        Stack<Integer> st = new Stack<>();
        boolean[] vis = new boolean[v];
        for (int i = 0; i < v; i++){
            if (!vis[i]){
                topSort(graph, i, vis, st);
            }
        }

        // Step 2: O(V+E)
        ArrayList<Edge> transpose[] = new ArrayList[v];
        for (int i = 0; i < graph.length; i++){
            vis[i] = false;
            transpose[i] = new ArrayList<Edge>();
        }
        for (int i = 0; i < v; i++){
            for (int j = 0; j < graph[i].size(); j++){
                Edge e = graph[i].get(j);
                transpose[e.dest].add(new Edge(e.dest, e.src));
            }
        }

        // Step 3: O(V+E)
        while (!st.isEmpty()){
            int curr = st.pop();
            if (!vis[curr]){
                dfs(transpose, curr, vis);
                System.out.println();
            }
        }
    }

    public static void topSort(ArrayList<Edge> graph[], int curr, boolean vis[], Stack<Integer> st){
        vis[curr] = true;
        for (int i = 0; i < graph[curr].size(); i++){
            Edge edge = graph[curr].get(i);
            if (!vis[edge.dest]){
                topSort(graph, edge.dest, vis, st);
            }
        }
        st.push(curr);
    }

    public static void main(String[] args) {
        int v = 5;
        ArrayList<Edge> graph[] = new ArrayList[v];
        createGraph(graph);
        kosarjuAlgo(graph, v);
    }
}
