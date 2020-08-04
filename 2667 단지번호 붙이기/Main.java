import java.io.*;
import java.util.*;


public class Main {
    static int arr[][];
    static boolean visit[][];
    static int dir[][]={{-1, 0}, {0, 1}, {0, -1}, {1, 0}};
    static int count=0;
    static int temp=0;
    static int n;
    static ArrayList<Integer> result=new ArrayList<Integer>();
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        n=Integer.parseInt(br.readLine());

        arr=new int[n+1][n+1];
        
        // result=new int[n*n];

        for (int i=1; i<=n; i++) {
            String s=br.readLine();
            for (int j=1; j<=n; j++) {
                arr[i][j]=s.charAt(j-1)-'0';
            }
        }

        for (int i=1; i<=n; i++) {
            for (int j=1; j<=n; j++) {
                if (arr[i][j]==1) {
                    count++;
                    temp=0;
                    dfs(i, j);
                    result.add(temp);
                }
            }
        }
        Collections.sort(result);
        System.out.println(count);
        while(!result.isEmpty()) {
            System.out.println(result.get(0));
            result.remove(0);
        }

    }

    static void dfs(int i, int j) {
        arr[i][j]=0;
        temp++;
        // result[count]++;

        for (int x=0; x<4; x++) {
            if ((i+dir[x][0])>=1 && (i+dir[x][0])<=n && 
                (j+dir[x][1])>=1 && (j+dir[x][1])<=n) {
                if (arr[i+dir[x][0]][j+dir[x][1]]==1){
                    dfs(i+dir[x][0], j+dir[x][1]);
                }
            }
        }

    }


}