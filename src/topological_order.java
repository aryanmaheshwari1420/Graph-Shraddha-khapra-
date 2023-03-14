import java.util.ArrayList;
import java.util.Stack;

public class topological_order  {
    public static void main(String[] args) {
        int V = 6;
        ArrayList<Edge> graph[]= new ArrayList[V];
        boolean vis[] = new boolean[V];
        Stack<Integer> stack = new Stack<>();

        createGraph(graph);
        for (int i = 0; i < V; i++) {
            if(!vis[i]){
                topoSort(graph,i,vis,stack);
            }
        }
        while (!stack.isEmpty()){
            System.out.print(stack.pop()+ " ");
        }

    }

    static class Edge{
        int src;
        int dest;
        Edge(int src,int dest){
            this.src = src;
            this.dest = dest;
        }
    }

    public static void topoSort(ArrayList<Edge> graph[], int curr, boolean vis[],Stack<Integer> stack){
        vis[curr] = true;
        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);
            if(vis[e.dest]==false){
                topoSort(graph,e.dest,vis,stack);
            }
        }
        stack.push(curr);
    }

    public static void createGraph(ArrayList<Edge> graph[]){
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<Edge>();
        }

        graph[2].add(new Edge(2,3));
        graph[2].add(new Edge(3,1));
        graph[2].add(new Edge(4,0));
        graph[2].add(new Edge(4,1));
        graph[2].add(new Edge(5,0));
        graph[2].add(new Edge(5,2));
    }

}
