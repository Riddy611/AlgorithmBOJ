import java.io.*;
import java.util.*;

public class Main {
    static ArrayList<ArrayList<Integer>> coord=new ArrayList<ArrayList<Integer>>();
    // static int[][] coord;
    // static int[][] coord2;
    static ArrayList<Boolean> visit=new ArrayList<Boolean>();

    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb=new StringBuilder();
        StringTokenizer st=new StringTokenizer(br.readLine());
        int num, row, col, cab, count;
        
        //int[][] farm;

        num=Integer.parseInt(st.nextToken());
        for (int i=0; i<num; i++) {
            count=0;
            st=new StringTokenizer(br.readLine());
            row=Integer.parseInt(st.nextToken());
            col=Integer.parseInt(st.nextToken());
            cab=Integer.parseInt(st.nextToken());

            // coord=new int[cab][2];
            for (int j=0; j<cab; j++) {
                coord.add(new ArrayList<Integer>());
                visit.add(false);
            }
        
            for (int j=0; j<cab; j++) {
                st=new StringTokenizer(br.readLine());
                int b=Integer.parseInt(st.nextToken());
                int a=Integer.parseInt(st.nextToken());
                coord.get(j).add(a);
                coord.get(j).add(b);
                //j는 순서고, 실제로는 (a,b)가 좌표

                // coord[j][0]=a;
                // coord[j][1]=b;
            }

            // for (int j=0; j<cab; j++) {
            //     System.out.println("("+coord.get(j).get(0)+", "+coord.get(j).get(1)+")");
            // }
            
            bfs(count,cab, sb);
            coord.clear();
            visit.clear();

        }
        System.out.println(sb.toString().trim());
        

        // num=Integer.parseInt(st.nextToken());
        // for (int i=0; i<num; i++) {
        //     st=new StringTokenizer(br.readLine());
        //     row=Integer.parseInt(st.nextToken());
        //     col=Integer.parseInt(st.nextToken());
        //     cab=Integer.parseInt(st.nextToken());
    
        //     farm=new int[row][col];
    
        //     for (int j=0; j<cab; j++) {
        //         st=new StringTokenizer(br.readLine());
        //         int a=Integer.parseInt(st.nextToken());
        //         int b=Integer.parseInt(st.nextToken());
        //         farm[b][a]=1;
        //     }

    }

    public static void bfs(int count, int cab, StringBuilder sb) {
        Queue<Integer> q=new LinkedList<Integer>();
        //큐에는 어레이리스트의 인덱스를 집어넣을 것.
        int curIdx;
        int currow, curcol,temprow, tempcol;
        //boolean conti;
        q.add(0);
        while(!q.isEmpty()) {
            //conti=false;
            curIdx=q.poll();
            visit.set(curIdx, true);
            currow=coord.get(curIdx).get(0);
            curcol=coord.get(curIdx).get(1);
            //System.out.println("now : "+currow+" "+curcol);

            for (int i=0; i<cab; i++) {
                temprow=coord.get(i).get(0);
                tempcol=coord.get(i).get(1);
                if (i==curIdx) continue;
                if (visit.get(i)!=true && ((Math.abs(currow-temprow)==1 && curcol==tempcol) 
                    || (Math.abs(curcol-tempcol)==1 && currow==temprow))) {
                   // System.out.println("checking: "+temprow+" "+tempcol);
                    //System.out.println(Math.abs(currow-temprow)); 
                    q.add(i);
                    visit.set(i,true);
                    //conti=true;
                } 
            }
            if (q.isEmpty()) {
                //System.out.println("conti false entered");
                count++;
                int newIdx=visit.indexOf(false);
               // System.out.println("moving to new Idx");
                if (newIdx!=-1) {
                    q.add(newIdx);
                    visit.set(newIdx,true);
                    //q.poll();
                }
            }
        }

        sb.append(count+"\n");
    }


}