class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            int[] curr = arrString(str);
            String key = Arrays.toString(curr);
            map.putIfAbsent(key, new ArrayList<>());
            map.get(key).add(str);
        }
        for (List<String> list : map.values()) {
            res.add(list);
        }
        return res;
    }

    public int[] arrString(String str) {
        int[] res = new int[26];
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            res[c - 'a']++;
        }
        return res;
    }
}
