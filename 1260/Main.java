import java.util.*;
import java.io.*;

public class Main {
    static ArrayList<ArrayList<Integer>> graph=new ArrayList<ArrayList<Integer>>();
    static boolean[] visited;
    static boolean[] visited2;

    
    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringBuilder dsb=new StringBuilder();
        StringBuilder bsb=new StringBuilder();
        StringTokenizer st=new StringTokenizer(br.readLine());
        int n, v, start;
        //ArrayList<
        // String line;
        // String[] vers;
        // Scanner sc=new Scanner(System.in);
        // n=sc.nextInt();
        // v=sc.nextInt();
        // start=sc.nextInt();

        // sc.nextLine();

        n=Integer.parseInt(st.nextToken());
        v=Integer.parseInt(st.nextToken());
        start=Integer.parseInt(st.nextToken());

        visited=new boolean[n];
        visited2=new boolean[n];

     
        for (int i=0; i<n; i++) {
            graph.add(new ArrayList<Integer>());
        }

        for (int i=0; i<v; i++) {
            st=new StringTokenizer(br.readLine());
            int n1=Integer.parseInt(st.nextToken());
            int n2=Integer.parseInt(st.nextToken());
            graph.get(n1-1).add(n2);
            graph.get(n2-1).add(n1);
            
            //line=sc.nextLine();
            // System.out.println(line);
            // vers=line.split(" ");
            // System.out.println(vers[0]);
            // System.out.println(vers[1]);

            // graph.get(Integer.parseInt(vers[0])-1).add(Integer.parseInt(vers[1]));
            // graph.get(Integer.parseInt(vers[1])-1).add(Integer.parseInt(vers[0]));
            
        }

        for (int i=0; i<n; i++) {
            graph.get(i).sort(null);
        }

        dfs(start, dsb);
        System.out.println(dsb.toString());
        bfs(start, bsb);
        System.out.println(bsb.toString());


        
        // for (int i=0; i<n; i++) {
        //     for (int j=0; j<graph.get(i).size(); j++) {
        //         System.out.println((i+1)+"³ëµå´Â -> "+graph.get(i).get(j));
        //     }
        // }
    }

    public static void dfs(int start, StringBuilder dsb) {
        if (visited[start-1]) return;
        visited[start-1]=true;

        dsb.append(start+" ");

        for (int i=0; i<graph.get(start-1).size(); i++) {
            dfs(graph.get(start-1).get(i), dsb);
        }
    }

    public static void bfs(int start,  StringBuilder bsb) {
        //Queue<ArrayList<Integer>> q = new LinkedList<ArrayList<Integer>>;
        Queue<Integer> q=new LinkedList<Integer>();
        int temp;
        //visited2[start-1]=true;
        //bsb.append(start+" ");
        q.add(start);
        while(!q.isEmpty()) {
            temp=q.poll();
            visited2[temp-1]=true;
            bsb.append(temp+" ");

            for (int i=0; i<graph.get(temp-1).size(); i++) {
                if (!visited2[graph.get(temp-1).get(i)-1]) {
                    q.add(graph.get(temp-1).get(i));
                    visited2[graph.get(temp-1).get(i)-1]=true;
                }
            }
        }
        

    }

}