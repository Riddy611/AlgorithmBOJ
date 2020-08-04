import java.io.*;
import java.util.*;


public class Main {
    // static int arr[][];
    static ArrayList<ArrayList<Integer>> arr;
    static boolean visit[];
    // static ArrayList<Integer> black;
    // static ArrayList<Integer> white;
    static int[] black;
    static int[] white;



    static int v, e;
    static boolean avail=true;
    static int n;



    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        n=Integer.parseInt(br.readLine());
        // boolean avail=true;

        for (int k=0; k<n; k++) {

            StringTokenizer st=new StringTokenizer(br.readLine());
            v=Integer.parseInt(st.nextToken());
            e=Integer.parseInt(st.nextToken());
            arr=new ArrayList<ArrayList<Integer>>();
            // black=new ArrayList<Integer>();
            // white=new ArrayList<Integer>();
            black=new int[v+1];
            white=new int[v+1];



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
                for (int j=0; j<arr.get(i).size(); j++) {
    
                    if (!visit[arr.get(i).get(j)]) {
                        avail=true;
                        
                        dfs(arr.get(i).get(j), "black");
                        if (!avail) {
                            break;
                        }
                    } 
                }
                if (!avail) {
                    break;
                }
            }

            if (avail) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
        
    }

    static void dfs(int x, String col) {
        visit[x]=true;
        if (col.equals("black")) {
            black[x]=1;
            // black.add(x);
            if (!validationCheck(x, col)) {
                avail=false;
                return;
            }
            // curCol="white";
        } else {
            // white.add(x);
            white[x]=1;
            if (! validationCheck(x, col) ) {
                avail=false;
                return;
            }
            // col="black";
        }

        for (int i=0; i<arr.get(x).size(); i++) {
            if (!visit[arr.get(x).get(i)] ) {
                // count++;
                if (col.equals("black")) {
                    dfs(arr.get(x).get(i), "white");
                } else {
                    dfs(arr.get(x).get(i), "black");
                }
            }
        }

        return;
    }

    static boolean validationCheck(int x, String col) {
        if (col.equals("black")) {
           
            for (int i=0; i<arr.get(x).size(); i++) {
                if (black[arr.get(x).get(i)]==1) {
                    return false;
                }
            }

        } else {
            for (int i=0; i<arr.get(x).size(); i++) {
                if (white[arr.get(x).get(i)]==1) {
                    return false;
                }
            }
         
        }
        return true;
    }


}

