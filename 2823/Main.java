import java.io.*;
import java.util.*;

public class Main {
    static char[][] arr;
    static int[] d1={1, -1, 0, 0};
    static int[] d2={0, 0, 1, -1};
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        int row, col, count, output;
        String line;
        row=Integer.parseInt(st.nextToken());
        col=Integer.parseInt(st.nextToken());
        
        arr=new char[row][col];
        
        for (int i=0; i<row; i++) {
            line=br.readLine();
            for (int j=0; j<col; j++) {
                arr[i][j]=line.charAt(j);
            }
        }
        int precol, prerow, curcol, currow;
        precol=-1;
        prerow=-1;
        output=0;
        for (int i=0; i<row; i++) {
            for (int j=0; j<col; j++) {
                if (arr[i][j]=='.') {
                    count=0;
                    for (int k=0; k<4; k++) {
                        int x = i + d1[k];
						int y = j + d2[k];
						if(0 <= x && x < row && 0 <= y && y < col) {
						if(arr[x][y] == 'X')
							count++;
						} else count++;
						if(count >= 3) {
							output = 1;
							break;
						}
                    }
                }
            }
        }
        System.out.println(output);

    }

}