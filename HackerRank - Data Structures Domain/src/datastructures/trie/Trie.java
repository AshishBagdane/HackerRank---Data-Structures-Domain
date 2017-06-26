package datastructures.trie;

public class Trie {
    
    private int words;
    private int prefixes;
    private Trie[] references;

    public Trie() {
        this.words = 0;
        this.prefixes = 0;
        this.references = new Trie[26];
    }

    public int getWords() {
        return words;
    }

    public void setWords(int words) {
        this.words = words;
    }

    public int getPrefixes() {
        return prefixes;
    }

    public void setPrefixes(int prefixes) {
        this.prefixes = prefixes;
    }

    public Trie[] getReferences() {
        return references;
    }

    public void setReferences(Trie[] references) {
        this.references = references;
    }
    
    public void addWord(Trie trie, String word) {
        if(word.isEmpty()) {
            trie.setWords(trie.getWords() + 1);
        }else{
            trie.setPrefixes(trie.getPrefixes() + 1);
            char ch = word.charAt(0);
            Trie[] tries = trie.getReferences();
            if(tries[ch - 97]==null) {
                tries[ch - 97] = new Trie();
                trie.setReferences(tries);
            }
            addWord(tries[ch-97], word.substring(1, word.length()));
        }
    }
    
    public int countPrefixes(Trie trie, String prefix) {
        if(prefix.isEmpty()) {
            return (trie.words==1) ? trie.getPrefixes() + 1 : trie.getPrefixes();
        }else{
            char ch = prefix.charAt(0);
            Trie[] tries = trie.getReferences();
            if(tries[ch - 97]==null) {
                return 0;
            }else{
                return countPrefixes(tries[ch - 97], prefix.substring(1, prefix.length()));
            }
        }
    }
    
    public int countWords(Trie trie, String words) {
        if(words.isEmpty()) {
            return trie.getWords();
        }else{
            char ch = words.charAt(0);
            Trie[] tries = trie.getReferences();
            if(tries[ch - 97]==null) {
                return 0;
            }else{
                return countWords(tries[ch - 97], words.substring(1, words.length()));
            }
        }
    }
    
    public boolean hasPrefix(Trie trie, String word) {
        if(trie.getWords()!=0) {
            return true;
        }else if(word.isEmpty()) {
            return (trie.getPrefixes()!=0);
        }else{
            char ch = word.charAt(0);
            Trie[] tries = trie.getReferences();
            if(tries[ch - 97]==null) {
                return false;
            }else{
                return hasPrefix(tries[ch - 97], word.substring(1, word.length()));
            }
        }
    }
}
