import java.io.*;
import java.util.StringTokenizer;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());

        int x=Integer.parseInt(st.nextToken());
        int y=Integer.parseInt(st.nextToken());
        int w=Integer.parseInt(st.nextToken());
        int h=Integer.parseInt(st.nextToken());
        int min;
        int[] cal=new int[4];

        cal[0]=x;
        cal[1]=w-x;
        cal[2]=y;
        cal[3]=h-y;

        min=cal[0];
        
        for (int i=0; i<4; i++) {
            if (cal[i]<min) min=cal[i];
        }
        System.out.println(min);
    }

}