import java.util.ArrayList;

public class All_path_src_dest extends DFS{
    public static void main(String[] args) {
        int V = 7;
        ArrayList<Edge> graph[] = new ArrayList[V];
        createGraph(graph);
        int src = 0;
        int tar = 5;
        System.out.println("All path are : ");
        printAllPath(graph,new boolean[V],src,"0",tar);

    }
    // O(V^V) // this function is good for only small graph
    public static void printAllPath(ArrayList<Edge> graph[],boolean vis[],int curr,String path ,int tar){
        if(curr==tar){
            System.out.println("path will be "+path);
            return;
        }

        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);
            if(!vis[e.dest]){
                vis[curr] = true;
                printAllPath(graph,vis,e.dest,path+e.dest,tar);
                vis[curr] = false;
            }
        }
    }
}
