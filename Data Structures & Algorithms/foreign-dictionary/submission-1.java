class Solution {
    public String foreignDictionary(String[] words) {
        Map<Character, Set<Character>> graph = new HashMap<>();
        Map<Character, Integer> state = new HashMap<>();
        String word1, word2;

        for (String word : words) {
            for (char c : word.toCharArray()) {
                state.put(c, 0);
            }
        }

        for (int i = 0; i < words.length - 1; i++) {
            word1 = words[i];
            word2 = words[i + 1];

            int len = Math.min(word1.length(), word2.length());
            boolean foundDiff = false;

            for (int j = 0; j < len; j++) {
                char c1 = word1.charAt(j);
                char c2 = word2.charAt(j);
                if (c1 != c2) {
                    graph.putIfAbsent(c1, new HashSet<>());
                    graph.get(c1).add(c2);
                    foundDiff = true;
                    break;
                }
            }

            if (!foundDiff) {
                if (word2.length() < word1.length()) return "";
            }
        }

        // System.out.println(graph.toString());

        List<Character> res = new LinkedList<>();
        for (char c : state.keySet()) {
            if (state.get(c) == 0) {
                if (!topSort(graph, state, c, res)) return "";
            }
        }

        StringBuilder result = new StringBuilder();
        while (!res.isEmpty()) {
            result.append(res.removeFirst());
        }
        return result.toString();
    }

    public boolean topSort(Map<Character, Set<Character>> graph, Map<Character, Integer> state, char curr, List<Character> res) {
        state.put(curr, 1);

        for (char c : graph.getOrDefault(curr, new HashSet<>())) {
            if (state.get(c) == 1) return false;
            else if (state.get(c) == 0) {
                if (!topSort(graph, state, c, res)) return false;
            }
        }

        state.put(curr, 2);
        res.addFirst(curr);
        return true;
    }
}
