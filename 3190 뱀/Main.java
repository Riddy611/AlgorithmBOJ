import java.util.*;
import java.io.*;
public class Main {
    public static int row=0;
    //public static int lastrow=0;
    public static int col=0;
    //public static int lastcol=0;
    static int cnt=0;
    //¿À¸¥ÂÊ ¿ÞÂÊ À§ ¾Æ·¡
    static int[][] dir={{0,1},{0,-1},{-1,0},{1,0}};
    static int rowdir=dir[0][0];
    static int coldir=dir[0][1];
    //static int lrowdir=dir[0][0];
    //static int lcoldir=dir[0][1];
    static ArrayList<int[]> snake=new ArrayList<int[]>();

    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine());
        int appleNum=Integer.parseInt(br.readLine());
        snake.add(new int[]{0,0});

        int[][] board=new int[n][n];
        board[0][0]=2;

        for (int i=0; i<appleNum; i++) {
            StringTokenizer st=new StringTokenizer(br.readLine());
            int a=Integer.parseInt(st.nextToken());
            int b=Integer.parseInt(st.nextToken());
            board[a-1][b-1]=1;
        }
        int turn=Integer.parseInt(br.readLine());
        boolean stuck=false;
        //boolean finalnum=false;

        for (int i=0; i<turn; i++) {
            StringTokenizer st=new StringTokenizer(br.readLine());
            int a=Integer.parseInt(st.nextToken());
            String b=st.nextToken();
            stuck=move(n,a,b,board,stuck);
            if (stuck==true) {
                break;
            }
        }
        if (!stuck) {
            move2(n, board);
        }
    }
    public static void move2(int n,int[][] board) {
        while(true) {
            int newrow=row+rowdir;
            int newcol=col+coldir;
            if (0<=newrow && newrow<n && 0<=newcol && newcol<n) {
                //»ç°ú ¸ÔÀ» ¶§
                if (board[newrow][newcol]==1) {
                    board[newrow][newcol]=2;
                    snake.add(new int[]{newrow,newcol});
                    //System.out.println("to "+newrow+", "+newcol+" eating apple");
                    row=newrow;
                    col=newcol;
                }
                //±×³É ÀÏ¹ÝÀûÀÎ ¿òÁ÷ÀÓ 
                else if (board[newrow][newcol]==0) {
                    board[newrow][newcol]=2;
                    snake.add(new int[]{newrow,newcol});
                    board[snake.get(0)[0]][snake.get(0)[1]]=0;
                    snake.remove(0);
                    //System.out.println("to "+newrow+", "+newcol+" just moving");
                   // System.out.println("now last snake is "+snake.get(0)[0]+", "+snake.get(0)[1]+" just moving");
                    row=newrow;
                    col=newcol;
                }
                //³» ¸ö¿¡ ºÎµúÈú ¶§
                else if (board[newrow][newcol]==2){
                    //stuck=true;
                    System.out.println(cnt+1);
                  //  System.out.println("to "+newrow+", "+newcol+" ¸ö¿¡ ºÎµúÈû");
                    break;
                    //return true;
                }
                
                cnt++;
                //continue;
            } else {
                //stuck=true;
                System.out.println(cnt+1);
                //System.out.println("to "+newrow+", "+newcol+" º®ÀÌ¾ß");
                break;
                //return true;
            }
        }
    }

    public static boolean move(int n,int num, String stringdir,int[][] board,boolean stuck) {
        int re=num-cnt;
        while(re>0) {
            int newrow=row+rowdir;
            int newcol=col+coldir;
            if (0<=newrow && newrow<n && 0<=newcol && newcol<n) {
                //»ç°ú ¸ÔÀ» ¶§
                if (board[newrow][newcol]==1) {
                    board[newrow][newcol]=2;
                    snake.add(new int[]{newrow,newcol});
                   // System.out.println("to "+newrow+", "+newcol+" eating apple");
                    row=newrow;
                    col=newcol;
                }
                //±×³É ÀÏ¹ÝÀûÀÎ ¿òÁ÷ÀÓ 
                else if (board[newrow][newcol]==0) {
                    board[newrow][newcol]=2;
                    snake.add(new int[]{newrow,newcol});
                    board[snake.get(0)[0]][snake.get(0)[1]]=0;
                    snake.remove(0);
                //    System.out.println("to "+newrow+", "+newcol+" just moving");
                  //  System.out.println("now last snake is "+snake.get(0)[0]+", "+snake.get(0)[1]+" just moving");


                    row=newrow;
                    col=newcol;
                }
                //³» ¸ö¿¡ ºÎµúÈú ¶§
                else if (board[newrow][newcol]==2){
                    stuck=true;
                    System.out.println(cnt+1);
                  //  System.out.println("to "+newrow+", "+newcol+" ¸ö¿¡ ºÎµúÈû");

                    return true;
                }
                re--;
                cnt++;
                //continue;
            } else {
                stuck=true;
                System.out.println(cnt+1);
           //     System.out.println("to "+newrow+", "+newcol+" º®ÀÌ¾ß");

                return true;
            }
        }
         //¿À¸¥ÂÊ ¿ÞÂÊ À§ ¾Æ·¡
    // static int[][] dir={{0,1},{0,-1},{-1,0},{1,0}};
        if (stringdir.equals("D")) {
            if(rowdir==0 && coldir==1) {rowdir=1; coldir=0;}
            else if (rowdir==0 && coldir==-1) {rowdir=-1; coldir=0;}
            else if (rowdir==-1 && coldir==0) {rowdir=0; coldir=1;}
            else {rowdir=0; coldir=-1;}
        } else {
            if(rowdir==0 && coldir==1) {rowdir=-1; coldir=0;}
            else if (rowdir==0 && coldir==-1) {rowdir=1; coldir=0;}
            else if (rowdir==-1 && coldir==0) {rowdir=0; coldir=-1;}
            else {rowdir=0; coldir=1;}
        }
         return false;               
    }

    

}