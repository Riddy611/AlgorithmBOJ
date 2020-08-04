import java.io.*;
import java.util.StringTokenizer;

public class Main{
    static int weight[];
    static int val[];
    static int arr[][];

    public static void main(String[] args) throws IOException{
        int n, w;
        BufferedReader br=new BufferedReader(new InputStreamReader((System.in)));
        StringTokenizer st=new StringTokenizer(br.readLine());
        n=Integer.parseInt(st.nextToken());
        w=Integer.parseInt(st.nextToken());

        weight=new int[n];
        val=new int[n];
        arr=new int[n+1][w+1];
       

        for (int i=0; i<n; i++) {
            st=new StringTokenizer(br.readLine());
            weight[i]=Integer.parseInt(st.nextToken());
            val[i]=Integer.parseInt(st.nextToken());
        }

        for (int i=0; i<n; i++) {

        }

        for (int i=1; i<n+1; i++) {
            for (int j=1; j<w+1; j++) {
                //arr[i][j]=arr[i-1][j];
                if (j>=weight[i-1]) {
                    arr[i][j]=Math.max(arr[i-1][j], val[i-1]+arr[i-1][j-weight[i-1]]);
                } else {
                    arr[i][j]=arr[i-1][j];
                }
            }
        }

        System.out.println(arr[n][w]);


        
    }
}