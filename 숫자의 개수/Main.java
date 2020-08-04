import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        try {
            BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
            int a, b, c, num, temp;
            String line;
            int[] arr=new int[10];

            a=Integer.parseInt(br.readLine());
            b=Integer.parseInt(br.readLine());
            c=Integer.parseInt(br.readLine());
            num=a*b*c;

            line=Integer.toString(num);
            for (int i=0; i<line.length(); i++) {
                temp=line.charAt(i)-'0';
                arr[temp]++;
                // switch(temp) {
                //     case 0 : arr[0]+=1; break;
                //     case 1 : arr[1]+=1; break;
                //     case 2 : arr[2]+=1; break;
                //     case 3 : arr[3]+=1; break;
                //     case 4 : arr[4]+=1; break;
                //     case 5 : arr[5]+=1; break;
                //     case 6 : arr[6]+=1; break;
                //     case 7 : arr[7]+=1; break;
                //     case 8 : arr[8]+=1; break;
                //     case 9 : arr[9]+=1; break;
                //     default : break;
                // }
            }

            for (int i=0; i<10; i++) {
                System.out.println(arr[i]);
            }

        }
        catch (Exception e) {System.out.println("error");}
    }
}