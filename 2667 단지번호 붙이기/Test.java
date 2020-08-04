
import java.util.*;
import java.io.*;
 
// https://www.acmicpc.net/problem/2667
 
class Test {
    static int stoi(String s) { return Integer.parseInt(s);}
 
    static int n;
    static int[][] arr;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static int count;
 
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
 
        n = stoi(br.readLine());
        arr = new int[n][n];
        
        for(int i=0; i<n; i++) {
            String s = br.readLine();
 
            for(int j=0; j<n; j++)
                arr[i][j] = s.charAt(j) - '0';
        }
 
        int total = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
 
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                if(arr[i][j] == 1) {
                    count = 0;
                    total++;
                    
                    dfs(i, j);
 
                    pq.add(count);
                }
            }
        }
 
        bw.write(total + "\n");
 
        while(!pq.isEmpty())
            bw.write(pq.poll() + "\n");
 
        bw.flush();
    }
 
    static void dfs(int x, int y) {
        arr[x][y] = 0;
        count++;
 
        for(int i=0; i<4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
 
            if(0 <= nx && nx < n && 0 <= ny && ny < n) {
                if(arr[nx][ny] == 1)
                    dfs(nx, ny);
            }
        }
    }
}