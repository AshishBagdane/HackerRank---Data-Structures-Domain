package datastructures.trie.hard;

import java.util.ArrayList;
import java.util.Scanner;

import datastructures.trie.Trie;

public class NoPrefixSet {
    
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		sc.nextLine();
		Trie trie = new Trie();
		ArrayList<String> words = new ArrayList<>();
		while (n-- != 0) {
			String str = sc.next();
			if (trie.hasPrefix(trie, str) == false) {
				trie.addWord(trie, str);
				words.add(str);
			} else {
				System.out.println("BAD SET");
				System.out.println(str);
				return;
			}
		}
		System.out.println("GOOD SET");
		sc.close();
	}
}