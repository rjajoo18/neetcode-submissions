class WordDictionary {

    private class TrieNode {

        private TrieNode[] children;
        private boolean endOfWord;

        private TrieNode() {
            children = new TrieNode[26];
        }
    }

    TrieNode root;

    public WordDictionary() {
        root = new TrieNode();
    }

    public void addWord(String word) {
        TrieNode curr = root;
        for (char c : word.toCharArray()) {
            int idx = c - 'a';
            if (curr.children[idx] == null) {
                curr.children[idx] = new TrieNode();
            }
            curr = curr.children[idx];
        }
        curr.endOfWord = true;
    }

    public boolean search(String word) {
        return sHelper(word, root);
    }

    public boolean sHelper(String word, TrieNode curr) {
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (c == '.') {
                for (TrieNode node : curr.children) {
                    if (node != null && sHelper(word.substring(i + 1, word.length()), node)) {
                        return true;
                    }
                }
                return false;
            } else {
                int idx = c - 'a';
                if (curr.children[idx] == null) return false;
                curr = curr.children[idx];
            }
        }
        return curr.endOfWord;
    }
}
