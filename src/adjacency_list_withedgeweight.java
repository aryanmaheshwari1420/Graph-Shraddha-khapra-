import java.util.ArrayList;
import java.util.Scanner;

public class adjacency_list_withedgeweight {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of vertices: ");
        int V = sc.nextInt(); // 4
        ArrayList<Edge> graph[] = new ArrayList[V];
        createGraph2(graph);

        for (int i = 0; i < graph[2].size(); i++) {
            Edge edge = graph[2].get(i);
            System.out.println(edge.dest+" "+ edge.wt);
        }
    }
    public static void createGraph2(ArrayList<Edge> graph[]){
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<Edge>();
        }


        graph[0].add(new Edge(0,2,2));

        graph[1].add(new Edge(1,2,3));
        graph[1].add(new Edge(1,3,5));

        graph[2].add(new Edge(2,0,3));
        graph[2].add(new Edge(2,1,1));
        graph[2].add(new Edge(2,3,8));

        graph[3].add(new Edge(3,1,9));
        graph[3].add(new Edge(3,2,0));

    }

    static class Edge{
        int src;
        int dest;
        int wt;
        Edge(int src,int dest,int wt){
            this.src = src;
            this.dest = dest;
            this.wt = wt;
        }
    }
}
