package datastructures.trie.medium;

import java.util.Scanner;

import datastructures.trie.Trie;

public class Contacts {
    
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		sc.nextLine();
		Trie trie = new Trie();
		while (n-- != 0) {
			String operation = sc.next();
			String data = sc.next();
			if (operation.equals("add")) {
				trie.addWord(trie, data);
			} else {
				System.out.println(trie.countPrefixes(trie, data));
			}
		}
		sc.close();
	}
}