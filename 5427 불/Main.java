import java.io.*;
import java.util.*;


public class Main {
    static char arr[][];
    static boolean visit[][];
    static int dir[][]={{-1, 0}, {0, 1}, {0, -1}, {1, 0}};
    static boolean avail=false;
    static int row, col;
    static int n;
    static int startrow, startcol;
    static ArrayList<Integer> result=new ArrayList<Integer>();
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n=Integer.parseInt(br.readLine());


        for (int i=0; i<n; i++) {

            st=new StringTokenizer(br.readLine());
            row=Integer.parseInt(st.nextToken());
            col=Integer.parseInt(st.nextToken());
            arr=new char[row+1][col+1];
            visit=new boolean[row+1][col+1];


            for (int j=1; j<=row; j++) {
                String s=br.readLine();
                for (int k=1; k<=col; k++) {
                    arr[j][k]=s.charAt(k-1);
                    if (arr[j][k]=='@') {
                        startrow=j;
                        startcol=k;
                    } else if (arr[j][k]=='#') {
                        visit[j][k]=true;
                    } else if (arr[j][k]=='*') {
                        visit[j][k]=true;
                    }
                }
            }

            bfs();

        }
    }

    static void bfs() {
        visit[startcol][startrow]=true;
        Queue<int[]> q=new LinkedList<>();
        Queue<int[]> fire=new LinkedList<>();

        q.add(new int[]{startcol, startrow});
        boolean check=true;

        while(!q.isEmpty()) {
            int[] temp=q.poll();
            check=true;

            if (!fire.isEmpty()) {
                int[] tfire=fire.poll();
                for (int i=0; i<4; i++) {
                    
                    
                }
            }


        }

    }

}