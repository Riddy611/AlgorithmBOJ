import java.io.*;

public class Main {
    static int c0, c1;
    static int fibo(int n) {
        if (n == 0) {
            c0++;
            return 0;
        } else if (n == 1) {
            c1++;
            return 1;
        } else {
            return fibo(n-1) + fibo(n-2);
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine());

        for (int i=0; i<n; i++) {
            c0=0;
            c1=0;
            fibo(Integer.parseInt(br.readLine()));
            System.out.println(c0+" "+c1);
        }
    }
}