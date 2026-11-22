class Solution {
    private Map<Integer, Boolean> memo;

    public boolean wordBreak(String s, List<String> wordDict) {
        memo = new HashMap<>();
        memo.put(s.length(), true);
        return dfs(s, wordDict, 0);
    }

    private boolean dfs (String s, List<String> dict, int i) {
        if (memo.containsKey(i)) {
            return memo.get(i);
        }

        for (String w : dict) {
            if (i + w.length() <= s.length()) {
                if (s.substring(i, i + w.length()).equals(w)) {
                    if (dfs(s, dict, i + w.length())) {
                        memo.put(i, true);
                        return true;
                    }
                }
            }
        }
        memo.put(i, false);
        return false;
    }
}
