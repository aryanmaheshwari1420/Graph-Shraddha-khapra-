import java.util.ArrayList;
import java.util.Scanner;


// By default jo hai graph[] array null pada hoga toh directly hum ArrayList<> nahi create kar sakte isliye
// empty ArrayList<> initialize krna padega jo humne kra hai line no 31 and 32 phr jaake add ki hai array list graph ke har index pe

public class adjacency_list {
    static class Edge{
        int src;
        int dest;
        Edge(int src,int dest){
            this.src = src;
            this.dest = dest;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of vertices: ");
        int V = sc.nextInt(); // Input for the vertices
        ArrayList<Edge> graph[] = new ArrayList[V];
        createGraph(graph);

        for (int i = 0; i < graph[2].size(); i++) {
            Edge edge = graph[2].get(i);
            System.out.print(edge.dest + " ");
        }
    }

    public static void createGraph(ArrayList<Edge> graph[]){
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<Edge>();
        }

        graph[0].add(new Edge(0,2));

        graph[1].add(new Edge(1,2));
        graph[1].add(new Edge(1,3));

        graph[2].add(new Edge(2,0));
        graph[2].add(new Edge(2,1));
        graph[2].add(new Edge(2,3));

        graph[3].add(new Edge(3,1));
        graph[3].add(new Edge(3,2));

    }
}
