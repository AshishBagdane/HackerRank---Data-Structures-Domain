package datastructures.stacks.easy;

import java.util.Scanner;
import java.util.Stack;

public class EqualStacks {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n1 = sc.nextInt();
        int n2 = sc.nextInt();
        int n3 = sc.nextInt();
        int[] buffer;
        Stack<Integer> stack_1 = new Stack<>();
        Stack<Integer> stack_2 = new Stack<>();
        Stack<Integer> stack_3 = new Stack<>();
        int sum_1, sum_2, sum_3;
        sum_1 = sum_2 = sum_3 = 0;
        buffer = new int[n1];
        for(int i=0;i<n1;i++) {
            int data = sc.nextInt();
            sum_1 += data;
            buffer[i] = data;
        }
        for(int i=n1-1;i>=0;i--) {
            stack_1.push(buffer[i]);
        }
        buffer = new int[n2];
        for(int i=0;i<n2;i++) {
            int data = sc.nextInt();
            sum_2 += data;
            buffer[i] = data;
        }
        for(int i=n2-1;i>=0;i--) {
            stack_2.push(buffer[i]);
        }
        buffer = new int[n3];
        for(int i=0;i<n3;i++) {
            int data = sc.nextInt();
            sum_3 += data;
            buffer[i] = data;
        }
        for(int i=n3-1;i>=0;i--) {
            stack_3.push(buffer[i]);
        }
        while(!(sum_1==sum_2 && sum_2==sum_3)) {
            if(sum_1>sum_2 || sum_1>sum_3) {
                sum_1 -= stack_1.pop();
                System.out.println("Stack 1 : " + sum_1);
            }else if(sum_2>sum_1 || sum_2>sum_3) {
                sum_2 -= stack_2.pop();
                System.out.println("Stack 2 : " + sum_2);
            }else if(sum_3>sum_1 || sum_3>sum_2) {
                sum_3 -= stack_3.pop();
                System.out.println("Stack 3 : " + sum_3);
            }
        }
        System.out.println(sum_1);
        sc.close();
    }
}
