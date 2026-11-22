class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        List<String> curr = new ArrayList<>();
        dfs(s, res, curr, 0);
        return res;
    }

    public void dfs (String s, List<List<String>> res, List<String> curr, int idx) {
        if(idx >= s.length()) {
            res.add(new ArrayList<>(curr));
            return;
        }

        for(int j = idx; j < s.length(); j++) {
            if(isPali(s, idx, j)) {
                curr.add(s.substring(idx, j + 1));
                dfs(s, res, curr, j + 1);
                curr.remove(curr.size() - 1);
            }
        }
    }

    public boolean isPali(String s, int i, int j) {
        while(i < j) {
            if(s.charAt(i) != s.charAt(j)) return false;
            i++;
            j--;
        }
        return true;
    }
}
