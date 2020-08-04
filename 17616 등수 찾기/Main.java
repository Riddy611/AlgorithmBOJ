import java.io.*;
import java.util.*;


public class Main {
    static int v, e, x;
    static ArrayList<ArrayList<Integer>> high=new ArrayList<ArrayList<Integer>>(v+1);
    static ArrayList<ArrayList<Integer>> low=new ArrayList<ArrayList<Integer>>(v+1);
    static int count=0;
    static boolean visit1[];
    static boolean visit2[];


    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());


        v=Integer.parseInt(st.nextToken());
        e=Integer.parseInt(st.nextToken());
        x=Integer.parseInt(st.nextToken());
        
      
        for (int i=0; i<=v; i++) {
            high.add(new ArrayList<Integer>());
            low.add(new ArrayList<Integer>());
        }

        visit1=new boolean[v+1];
        visit2=new boolean[v+1];

        for (int i=0; i<e; i++) {
            // high.add(new ArrayList<Integer>());
            // low.add(new ArrayList<Integer>());
            st=new StringTokenizer(br.readLine());
            int a=Integer.parseInt(st.nextToken());
            int b=Integer.parseInt(st.nextToken());
            low.get(a).add(b);
            high.get(b).add(a);
        }

        bfs1(x);
        int max=count;
        // count=0;
        bfs2(x);
        int min=count;

        System.out.println((1+min)+" "+(v-max));


    }


    static void bfs1(int x) {
        count=0;
        Queue<Integer> q=new LinkedList<>();
        q.add(x);
        visit1[x]=true;
    
        while (!q.isEmpty()) {
            int temp=q.poll();
            for (int i=0; i<low.get(temp).size(); i++) {
                if ( !visit1[ low.get(temp).get(i)] ) {
                    q.add(low.get(temp).get(i));
                    visit1[ low.get(temp).get(i) ]=true;
                    count++;
                }
            }
        }
    }

    static void bfs2(int x) {
        count=0;
        Queue<Integer> q=new LinkedList<>();
        q.add(x);
        visit2[x]=true;
    
        while (!q.isEmpty()) {
            int temp=q.poll();
            for (int i=0; i<high.get(temp).size(); i++) {
                if ( !visit2[ high.get(temp).get(i)] ) {
                    q.add(high.get(temp).get(i));
                    visit2[ high.get(temp).get(i)]=true;
                    count++;
                }
            }
        }
    }


}