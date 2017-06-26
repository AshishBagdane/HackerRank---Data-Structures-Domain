package datastructures.stacks.medium;

import java.util.Scanner;
import java.util.Stack;

public class SimpleTextEditor {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int Q = sc.nextInt();
        String S = new String();
        Stack<Operation> operations = new Stack<>();
        String buffer  = new String();
        int k;
        while(Q--!=0) {
            byte opType = sc.nextByte();
            switch(opType) {
                case 1 :
                        buffer = sc.next();
                        S += buffer;
                        operations.push(new Operation(opType, buffer));
                        break;
                case 2 :
                        k = sc.nextInt();
                        buffer = S.substring(S.length()-k, S.length());
                        S = S.substring(0, S.length()-buffer.length());
                        operations.push(new Operation(opType, buffer));
                        break;
                case 3 :
                        k = sc.nextInt()-1;
                        System.out.println(S.charAt(k));
                        break;
                case 4 :
                        Operation operation = operations.pop();
                        switch(operation.opType) {
                            case 1 :
                                    S = S.substring(0, S.length()-operation.buffer.length());
                                    break;
                            case 2 :
                                    S += operation.buffer;
                                    break;
                        }
                        break;
            }
        }
        sc.close();
    }
    
    static class Operation {

        byte opType;
        String buffer;

        public Operation(byte opType, String buffer) {
            this.opType = opType;
            this.buffer = buffer;
        }
    }
}