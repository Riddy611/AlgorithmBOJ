import java.io.*;
import java.util.*;


public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int a=Integer.parseInt(br.readLine());
        int b=Integer.parseInt(br.readLine());

        boolean found=false;
        int min=0;
        int sum=0;

        for (int i=a; i<=b; i++) {
            // double t=i;
            // System.out.println("now checking : "+t);

            // t=baseLog(t, 2);
            // System.out.println("now checking : "+i);
            for (int j=1; j<=i; j++) {
                // System.out.println("j is "+ j+" "+i%j+"   "+i/j);
                if (i%j==0 && i/j==j) {
                    if (!found) {
                        found=true;
                        min=i;
                        sum+=i;
                    } else {
                        sum+=i;
                    }
                }
            }
        }

        if (!found) {
            System.out.println("-1");
        } else {
            System.out.println(sum);
            System.out.println(min);
        }

    }

    // static double baseLog(double x, double base) {

    //     return Math.log(x) / Math.log(base);

    // }
        
        
}