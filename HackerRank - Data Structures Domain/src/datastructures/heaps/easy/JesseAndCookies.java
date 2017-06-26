package datastructures.heaps.easy;

import java.util.PriorityQueue;
import java.util.Scanner;

public class JesseAndCookies {

	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();
        PriorityQueue<Integer> cookies = new PriorityQueue<>();
        while(N--!=0) {
            cookies.add(sc.nextInt());
        }
        sc.close();
        int cnt = 0;
        while(cookies.peek()<K) {
            cnt++;
            int first = cookies.poll();
            int second = cookies.poll();
            int sweetness = (first + (2 * second));
            cookies.add(sweetness);
            if(cookies.size()<2 && cookies.peek()<K) {
                System.out.println("-1");
                return;
            }
        }
        System.out.println(cnt);
	}
}
