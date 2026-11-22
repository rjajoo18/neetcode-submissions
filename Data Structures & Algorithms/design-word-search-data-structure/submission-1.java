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
        return sHelper(word, root, 0);
    }

    public boolean sHelper(String word, TrieNode curr, int idx) {
        for (int i = idx; i < word.length(); i++) {
            char c = word.charAt(i);
            if (c == '.') {
                for (TrieNode node : curr.children) {
                    if (node != null && sHelper(word, node, i + 1)) {
                        return true;
                    }
                }
                return false;
            } else {
                int index = c - 'a';
                if (curr.children[index] == null) return false;
                curr = curr.children[index];
            }
        }
        return curr.endOfWord;
    }
}
