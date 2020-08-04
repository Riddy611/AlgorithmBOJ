import java.io.*;
import java.util.*;


public class Main {
    static int arr[][];
    static boolean visit[][];
    static int dir[][]={{-1, 0}, {0, 1}, {0, -1}, {1, 0}};

    static int n;
    // static int temp=0;
    static int count=0;
    static int maxSafe=0;

    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        n=Integer.parseInt(br.readLine());
        int max=-1;
        
        arr=new int[n+1][n+1];
        visit=new boolean[n+1][n+1];
        
        
        for (int i=1; i<=n; i++) {
            // String s=br.readLine();
            StringTokenizer st=new StringTokenizer(br.readLine());
            for (int j=1; j<=n; j++) {
                arr[i][j]=Integer.parseInt(st.nextToken());
                if (arr[i][j]>max) {
                    max=arr[i][j];
                }
            }
        }


        for (int i=0; i<max; i++) {
            count=0;
            // int temp=calc(i);
            calc(i);
            if (count>maxSafe) {
                maxSafe=count;
            }
            flush();
        }

        System.out.println(maxSafe);

    }
    
    static void flush() {
        for (int i=1; i<=n; i++) {
            for (int j=1; j<=n; j++) {
                visit[i][j]=false;
            }
        }
    }

    static void calc(int max) {
        for (int i=1; i<=n; i++) {
            for (int j=1; j<=n; j++) {
                if (!visit[i][j] && arr[i][j]>max) {
                    // count=0;
                    count++;
                    safe(i, j, max);
                    
                }
            }
        }
        // System.out.println("cur max is : "+max+" and the count is : "+count);

        // return count;
    }

    static void safe(int i, int j, int max) {
        visit[i][j]=true;
        // count++;

        for (int x=0; x<4; x++) {
            if ((i+dir[x][0])>=1 && (i+dir[x][0])<=n && 
                (j+dir[x][1])>=1 && (j+dir[x][1])<=n) {
                if (arr[i+dir[x][0]][j+dir[x][1]]>max && !visit[i+dir[x][0]][j+dir[x][1]]){
                    safe(i+dir[x][0], j+dir[x][1], max);
                }
            }
        }
    }



}