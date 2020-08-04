import java.util.*;
import java.io.*;
public class Main {
    static ArrayList<Integer> arr=new ArrayList<Integer>();
    static int size=0;
    public static void push(int x) {
        arr.add(x);
        size++;
    }
    public static void top() {
        if (size==0) {System.out.println("-1");}
        else {System.out.println(arr.get(size-1));}
    }
    public static void size() {
        System.out.println(size);
    }
    public static void empty() {
        if (arr.isEmpty()) {System.out.println("1");}
        else {System.out.println("0");}
    }
    public static void pop() {
        if (size==0) {System.out.println("-1");}
        else {
            int t=arr.remove(size-1);
            size--;
            System.out.println(t);
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine());
        for (int i=0; i<n; i++) {
            StringTokenizer st=new StringTokenizer(br.readLine());
            String s=st.nextToken();
            if (s.equals("push")) {
                int x=Integer.parseInt(st.nextToken());
                push(x);
            } else if (s.equals("pop")) {
                pop();
            } else if (s.equals("size")) {
                size();
            } else if (s.equals("empty")) {
                empty();
            } else if (s.equals("top")) {
                top();
            }
        }

    }

}