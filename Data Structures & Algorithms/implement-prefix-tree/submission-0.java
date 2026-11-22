class PrefixTree {

    private class TrieNode {
        private Map<Character, TrieNode> map;
        private boolean endOfWord;
        
        public TrieNode(boolean endOfWord) {
            this.map = new HashMap<>();
            this.endOfWord = endOfWord;
        }
    }

    TrieNode root;

    public PrefixTree() {
        root = new TrieNode(false);
    }

    public void insert(String word) {
        TrieNode curr = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            curr.map.putIfAbsent(c, new TrieNode(false));
            if (i == word.length() - 1) {
                curr.map.get(c).endOfWord = true;
            }
            curr = curr.map.get(c);
        }
    }

    public boolean search(String word) {
        TrieNode curr = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (!curr.map.containsKey(c)) return false;
            if (i == word.length() - 1 && curr.map.get(c).endOfWord) return true;
            curr = curr.map.get(c);
        }
        return false;
    }

    public boolean startsWith(String prefix) {
        TrieNode curr = root;
        for (int i = 0; i < prefix.length(); i++) {
            char c = prefix.charAt(i);
            if (!curr.map.containsKey(c)) return false;
            curr = curr.map.get(c);
        }
        return true;
    }
}
