package datastructures.balancedtrees;

import java.util.Scanner;

public class SelfBalancingTree {
 
    public static void main(String[] args) {
        AVLTree balancedTree = new AVLTree();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for(int i=0;i<n;i++) {
            int data = sc.nextInt();
            balancedTree.setRoot(balancedTree.insert(balancedTree.getRoot(), data));
        }
        sc.close();
        balancedTree.preOrder(balancedTree.getRoot());
    }
}