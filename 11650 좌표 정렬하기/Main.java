import java.io.*;
import java.util.*;


public class Main {
    static int arr[][];
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        int n=Integer.parseInt(st.nextToken());
        arr=new int[n][n];

        for (int i=0; i<n; i++) {
            st=new StringTokenizer(br.readLine());
            arr[i][0]=Integer.parseInt(st.nextToken());
            arr[i][1]=Integer.parseInt(st.nextToken());
        }

        for (int i=0; i<n; i++) {
            for (int j=0; j<n; j++) {
                
            }
        }



    }    
}