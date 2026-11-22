class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Map<String, List<String>> graph = new HashMap<>();
        boolean findBeg = false, findEnd = false;
        for (String word : wordList) {
            if (endWord.equals(word)) {
                findEnd = true;
            }
            if (findDiff(graph, word, beginWord)) {
                findBeg = true;
            }
        }
        if (!findBeg || !findEnd) return 0;
        for (int i = 0; i < wordList.size() - 1; i++) {
            for (int j = i + 1; j < wordList.size(); j++) {
                findDiff(graph, wordList.get(i), wordList.get(j));
            }
        }
        Queue<String> q = new ArrayDeque<>();
        Set<String> visited = new HashSet<>();
        int count = 1;
        q.offer(beginWord);
        visited.add(beginWord);
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                String curr = q.poll();
                if (curr.equals(endWord)) return count;
                for (String nbr : graph.getOrDefault(curr, new ArrayList<>())) {
                    if (!visited.contains(nbr)) {
                        q.offer(nbr);
                        visited.add(nbr);
                    }
                }
            }
            count++;
        }
        return 0;
    }

    public boolean findDiff(Map<String, List<String>> graph, String word1, String word2) {
        int n = word1.length();
        boolean foundDiff = false;
        for (int i = 0; i < n; i++) {
            if (word1.charAt(i) != word2.charAt(i)) {
                if (foundDiff) return false;
                foundDiff = true;
            }
        }
        graph.putIfAbsent(word1, new ArrayList<>());
        graph.putIfAbsent(word2, new ArrayList<>());
        graph.get(word1).add(word2);
        graph.get(word2).add(word1);
        return true;
    }
}
