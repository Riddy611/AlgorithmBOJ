import java.io.*;
import java.util.*;

public class Main2 {
    static boolean visited[];
    static int graph[][];
    static ArrayList<ArrayList<Integer>> arr=new ArrayList<ArrayList<Integer>>();
    
    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        
        int v=Integer.parseInt(st.nextToken());
        int e=Integer.parseInt(st.nextToken());
        int start=Integer.parseInt(st.nextToken());

        graph=new int[v+1][v+1];
        visited=new boolean[v+1];

        for (int i=0; i<e; i++) {
            st=new StringTokenizer(br.readLine());
            int a=Integer.parseInt(st.nextToken());
            int b=Integer.parseInt(st.nextToken());
            // graph[a][b]=1;
            // graph[b][a]=1;
            arr[a].
        }

        dfs(v, start);
        bfs(v, start);

    }

    static void dfs(int v, int start) {
        System.out.print(start+" ");
        for (int i=1; i<=v; i++) {
            for (int j=1; j<=v; j++) {
                if (graph[i][j]==1 && visited[i]==false) {

                }
            }
        }
    }

    static void bfs(int v, int start) {

    }
}