import java.io.*;
import java.util.*;


public class Main {
    static char arr[][];
    // static ArrayList<ArrayList<Integer>> arr=new ArrayList<ArrayList<Integer>>();
    static boolean visit1[][];
    static boolean visit2[][];
    static int dir[][]={{-1, 0}, {0, 1}, {0, -1}, {1, 0}};


    static int n;
    static int count1=0;
    static int count2=0;



    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
      
        n=Integer.parseInt(br.readLine());
        arr=new char[n+1][n+1];
        visit1=new boolean[n+1][n+1];
        visit2=new boolean[n+1][n+1];



        for (int i=1; i<=n; i++) {
            String s =br.readLine();
            for (int j=1; j<=n; j++) {
                arr[i][j]=s.charAt(j-1);
            }
        }

        for (int i=1; i<=n; i++) {
            for (int j=1; j<=n; j++) {
                if (!visit1[i][j]) {
                    count1++;
                    dfs1(i, j, arr[i][j]);
                }
                if (!visit2[i][j]) {
                    count2++;
                    dfs2(i, j, arr[i][j]);
                }
            }
        }

        System.out.print(count2+" "+count1);
        

    }

    static void dfs1(int i, int j, char cur) {
        visit1[i][j]=true;
        for (int x=0; x<4; x++) {
            if ((i+dir[x][0])>=1 && (i+dir[x][0])<=n && 
                (j+dir[x][1])>=1 && (j+dir[x][1])<=n) {
                if (( cur=='R' || cur=='G') && 
                    ( arr[i+dir[x][0]][j+dir[x][1]]=='R' || 
                        arr[i+dir[x][0]][j+dir[x][1]]=='G' ) && visit1[i+dir[x][0]][j+dir[x][1]]==false){
                    
                    dfs1(i+dir[x][0], j+dir[x][1], cur);

                } else if (cur=='B' && arr[i+dir[x][0]][j+dir[x][1]]=='B' && visit1[i+dir[x][0]][j+dir[x][1]]==false) {
                    dfs1(i+dir[x][0], j+dir[x][1], cur);

                }
            }
        }
    }

    static void dfs2(int i, int j, char cur) {
        visit2[i][j]=true;
        for (int x=0; x<4; x++) {
            if ((i+dir[x][0])>=1 && (i+dir[x][0])<=n && 
                (j+dir[x][1])>=1 && (j+dir[x][1])<=n) {
                if (arr[i+dir[x][0]][j+dir[x][1]]==cur  && visit2[i+dir[x][0]][j+dir[x][1]]==false){
                    
                    dfs2(i+dir[x][0], j+dir[x][1], cur);
                } 
            }
        }
    }



}