import java.io.*;
import java.util.*;


public class Main {
    // static int arr[][];
    static ArrayList<ArrayList<Integer>> arr=new ArrayList<ArrayList<Integer>>();
    static boolean visit[];
    
    // static int dir[][]={{-1, 0}, {0, 1}, {0, -1}, {1, 0}};

    static int v, e;
    static int count=0;


    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        v=Integer.parseInt(st.nextToken());
        e=Integer.parseInt(st.nextToken());


        for (int i=0; i<=v; i++) {
            arr.add(new ArrayList<Integer>());
        }
        visit=new boolean[v+1];

        for (int i=0; i<e; i++) {
            st=new StringTokenizer(br.readLine());
            int a=Integer.parseInt(st.nextToken());
            int b=Integer.parseInt(st.nextToken());
            
            arr.get(a).add(b);
            arr.get(b).add(a);
        }

        for (int i=1; i<=v; i++) {
            if (arr.get(i).size()==0) {
                count++;
            }
            for (int j=0; j<arr.get(i).size(); j++) {
                // System.out.println("cur is : "+i+" and size is : "+arr.get(i).size());

                if (!visit[arr.get(i).get(j)]) {
                    count++;
                    dfs(arr.get(i).get(j));
                } 
            }
        }

        System.out.println(count);
        

    }

    static void dfs(int x) {
        visit[x]=true;

        for (int i=0; i<arr.get(x).size(); i++) {
            if (!visit[arr.get(x).get(i)]) {
                // count++;
                dfs(arr.get(x).get(i));
            }
        }
    }


}