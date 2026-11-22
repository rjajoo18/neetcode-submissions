class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList<>();
        HashMap<String, List<String>> map = new HashMap<>();
        for(String str : strs){
            char[] arr = str.toCharArray();
            Arrays.sort(arr);
            String key = String.valueOf(arr);
            if(!map.containsKey(key)) {
                List<String> list = new ArrayList<>();
                list.add(str);
                map.put(key, list);
            } else {
                List<String> list = map.get(key);
                list.add(str);
                map.put(key, list);
            }
        }

        for(Map.Entry<String, List<String>> entry : map.entrySet()){
            res.add(entry.getValue());
        }
        return res;
    }
}
