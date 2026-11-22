class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        dfs(n, "", res, 0, 0);
        return res;
    }

    public void dfs(int n, String curr, List<String> res, int open, int close) {
        if (open + close == 2 * n) {
            res.add(curr);
        }
        if (open + 1 <= n) {
            dfs(n, curr + '(', res, open + 1, close);
        }
        if (close < open) {
            dfs(n, curr + ')', res, open, close + 1);
        }
    } 
}
