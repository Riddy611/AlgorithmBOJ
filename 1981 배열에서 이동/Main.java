import java.io.*;
import java.util.*;


public class Main {
    static int arr[][];
    static boolean visit[][];
    
    static int dir[][]={{-1, 0}, {0, 1}, {0, -1}, {1, 0}};

    static int n;
    static int min=201, max=0;
    static int realmin=201, realmax=0;
    static boolean up=false;
    static boolean down=false;

    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        n=Integer.parseInt(st.nextToken());
        
        arr=new int[n][n];

        for (int i=0; i<n; i++) {
            // String s=br.readLine();
            st=new StringTokenizer(br.readLine());
            for (int j=0; j<n; j++) {
                arr[i][j]=Integer.parseInt(st.nextToken());
                if (arr[i][j]<realmin) {
                    realmin=arr[i][j];
                }
                if (arr[i][j]>realmax) {
                    realmax=arr[i][j];
                }
            }
        }

        min=realmin;
        max=min;
        boolean avail=false;
        visit=new boolean[n][n];

        // while(!avail ) {
        //     max++;
        //     Arrays.fill(visit, Boolean.FALSE);
        //     avail=bfs();
        // }

        while(min<=max && max<=realmax) {
            // Arrays.fill(visit, Boolean.FALSE);
            visit=new boolean[n][n];
            if (bfs()) {
                min++;
            } else {
                max++;
            }
            // avail=bfs();
        }

        // avail=false;

        // while(min<max && !avail) {
        //     min++;
        //     Arrays.fill(visit, Boolean.FALSE);

        //     // visit=new boolean[n][n];
        //     avail=bfs();
        // }
        

        System.out.println(max-(min));

    }
    static boolean validation(int i, int j) {
        int val=arr[i][j];
        // System.out.println("vali check val is : "+val);
        if (min<=val && val<=max) {
            return true;
        } else {
            if (val<min)
            return false;
        }
    }

    static boolean bfs() {
        System.out.println("------------------------");
        System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
        System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");

        System.out.println("cur min max is  ( "+min+" ~ "+max+" )");
        Queue<int[]> q=new LinkedList<>();
        q.add(new int[]{0,0,arr[0][0]});
        boolean avail=false;
        // visit[0][0]=true;

        while(!q.isEmpty()) {
            avail=false;
            int temp[]=q.poll();
            System.out.println("-----------------------------------");
            System.out.println("NOW CHECKING ( "+temp[0]+", "+temp[1]+" )");
            if (validation(temp[0], temp[1])) {
                visit[temp[0]][temp[1]]=true;

                if (temp[0]==n-1 && temp[1]==n-1) {
                    return true;
                }

                for (int i=0; i<4; i++) {
                    int nx=temp[0]+dir[i][0];
                    int ny=temp[1]+dir[i][1];
                    
                    if (nx>=0 && nx<n && ny>=0 && ny<n && !visit[nx][ny]) {
                        if (validation(nx, ny)) {
                            visit[nx][ny]=true;
                            q.add(new int[]{nx, ny, arr[nx][ny]});
                            avail=true;
                        } 
                    }
                }

                if (!avail) {
                    return false;
                }

            } else {
                continue;
            }
        }
        return false;
    }

}