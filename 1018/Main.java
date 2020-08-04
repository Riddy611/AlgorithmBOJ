import java.io.*;
import java.util.*;

public class Main {
    static char[][] white={{'W','B','W','B','W','B','W','B'},{'B','W','B','W','B','W','B','W'},
        {'W','B','W','B','W','B','W','B'},{'B','W','B','W','B','W','B','W'},
        {'W','B','W','B','W','B','W','B'},{'B','W','B','W','B','W','B','W'},
        {'W','B','W','B','W','B','W','B'},{'B','W','B','W','B','W','B','W'}};
    static char[][] black={{'B','W','B','W','B','W','B','W'},{'W','B','W','B','W','B','W','B'},
        {'B','W','B','W','B','W','B','W'}, {'W','B','W','B','W','B','W','B'},
        {'B','W','B','W','B','W','B','W'},{'W','B','W','B','W','B','W','B'},
        {'B','W','B','W','B','W','B','W'},{'W','B','W','B','W','B','W','B'}};
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n, m, mincount, count;
        char[][] input;
        //char[][] res;
        String line;   

        n=sc.nextInt();
        m=sc.nextInt();
        input=new char[n][m];

        for(int i=0; i<n; i++) {
            line=sc.next();
            for (int j=0; j<m; j++) {
                input[i][j]=line.charAt(j);
            }
        }
        sc.close();

        mincount=64;

        for (int i=0; i<n-7; i++) {
            for (int j=0; j<m-7; j++) {
                count=0;
                count=check(i,j, input);
                //System.out.println(count);
                if (count<mincount) {mincount=count;}
            }
        }

        System.out.println(mincount);

    }

    public static int check(int i, int j, char[][] input) {
        //System.out.println("check entered");
        char[][] target;
        int wcount, bcount, min;
        wcount=0;
        bcount=0;

        // if (input[i][j]=='W') {
        //     target=white;
        // } else {target=black;}

        for (int a=0; a<8; a++) {
            for (int b=0; b<8; b++) {
                if (input[i+a][j+b]!=white[a][b]) {
                    wcount++;
                }
            }
        }

        for (int a=0; a<8; a++) {
            for (int b=0; b<8; b++) {
                if (input[i+a][j+b]!=black[a][b]) {
                    bcount++;
                }
            }
        }
        if(wcount<bcount) {min=wcount;}
        else {min=bcount;}

        return min;
    }
}