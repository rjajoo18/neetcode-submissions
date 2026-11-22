class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        HashMap<Character, String> map = new HashMap<>();
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");
        if(digits.length() > 0) dfs(res, map, 0, new StringBuilder(), digits);
        return res;
    }

    public void dfs(List<String> res, HashMap<Character, String> map, int i, StringBuilder sb, String digits) {
        if (i == digits.length()) {
            res.add(sb.toString());
            return;
        }

        String curr = map.get(digits.charAt(i));
        for (int j = 0; j < curr.length(); j++) {
            sb.append(curr.charAt(j));
            dfs(res, map, i + 1, sb, digits);
            sb.deleteCharAt(sb.length() - 1);
        } 
    }
}
