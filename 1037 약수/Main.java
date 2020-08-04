import java.io.*;
import java.util.*;

public class Main {

    static int[] arr;

    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        int n=Integer.parseInt(st.nextToken());
        int result=1;
        st=new StringTokenizer(br.readLine());

        for (int i=0; i<n; i++) {
            int t=Integer.parseInt(st.nextToken());
            // arr[i]=Integer.parseInt(st.nextToken());
            if (result%t!=0) {
                result*=t/result;
            } else {

            }
        }



    }
    
}