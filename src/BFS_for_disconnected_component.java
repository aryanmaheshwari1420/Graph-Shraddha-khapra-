import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BFS_for_disconnected_component {
    public static void main(String[] args) {
        int V = 7;
        ArrayList<BFS.Edge> graph[] = new ArrayList[V];
        createGraph(graph);
        boolean vis[] = new boolean[V];
        for (int i = 0; i < V; i++) {
                if(vis[i]==false){
                    bfs(graph,V,vis,i);
                }
        }
        System.out.println();
    }

    public static void bfs(ArrayList<BFS.Edge> graph[], int V, boolean vis[], int start){
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        while (!q.isEmpty()){
            int curr = q.remove();
            if(vis[curr]==false){
                System.out.print(curr+" ");
                vis[curr] = true;

                for (int i = 0; i < graph[curr].size(); i++) {
                    BFS.Edge e  = graph[curr].get(i);
                    q.add(e.dest);
                }
            }
        }

    }

    public static void createGraph(ArrayList<BFS.Edge> graph[]){
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<BFS.Edge>();
        }

        graph[0].add(new BFS.Edge(0,1));
        graph[0].add(new BFS.Edge(0,2));

        graph[1].add(new BFS.Edge(1,0));
        graph[1].add(new BFS.Edge(1,3));

        graph[2].add(new BFS.Edge(2,0));
        graph[2].add(new BFS.Edge(2,4));

        graph[3].add(new BFS.Edge(3,1));
        graph[3].add(new BFS.Edge(3,4));
        graph[3].add(new BFS.Edge(3,5));

        graph[4].add(new BFS.Edge(4,2));
        graph[4].add(new BFS.Edge(4,3));
        graph[4].add(new BFS.Edge(4,5));

        graph[5].add(new BFS.Edge(5,3));
        graph[5].add(new BFS.Edge(5,4));
        graph[5].add(new BFS.Edge(5,6));

        graph[5].add(new BFS.Edge(6,5));

    }

    static class Edge{
        int src;
        int dest;
        Edge(int src,int dest){
            this.src = src;
            this.dest = dest;
        }
    }
}
