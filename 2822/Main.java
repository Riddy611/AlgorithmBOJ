import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int[][] input=new int[8][2];
        int[] sumIdx=new int[5];
        int sum=0;

        for (int i=0; i<8; i++) {
            input[i][1]=Integer.parseInt(br.readLine());
            input[i][0]=i+1;
        }
        //Arrays.sort(input, Comparator.comparingInt(o1->o1[0]));
        Arrays.sort(input, new Comparator<int[]>() {
            // Override된 compare 함수를 어떻게 정의하냐에 따라서 다양한 정렬이 가능해집니다
            @Override
            public int compare(int[] o1, int[] o2) {
                return o2[1] - o1[1];
                // 내림자순 정렬을 하고 싶다면 o2와 o1의 위치를 바꿔줍니다
                // return o2[1] - o1[1];
            }
        });
        //Array.sort(input, Comp)

        // for (int i = 0; i < input.length; i++) {
        //     for (int j = 0; j < input[i].length; j++) {
        //       System.out.print(input[i][j] + " ");
        //     }
        //     System.out.println(" ");
        // }

        for (int i=0; i<5; i++) {
            sum+=input[i][1];
            sumIdx[i]=input[i][0];
        }

        Arrays.sort(sumIdx);
        //String str="";
        System.out.println(sum);
        for (int i=0; i<5; i++) {
            System.out.print(sumIdx[i]+" ");
        }
    
    }
}