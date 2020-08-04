import java.io.*;
import java.util.*;

public class Main {

    public static long calc(int a , int b) {
        long r1=1;
        long r2=1;
        
        if (b-a<a) {
            for (int i=0; i<b-a; i++) {
                r1*=(b-i);
                r2*=i+1;
            }
        } else {
    
            for (int i=0; i<a; i++) {
                r1*=(b-i);
                r2*=i+1;
            }

        }
        // System.out.println(r1+" "+r2);
        return r1/r2;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());

        int n=Integer.parseInt(st.nextToken());
        for (int i=0; i<n; i++) {
            int a, b;
            st=new StringTokenizer(br.readLine());
            a=Integer.parseInt(st.nextToken());
            b=Integer.parseInt(st.nextToken());
            calc(a,b);
            System.out.println(calc(a,b));
        }
    }
}