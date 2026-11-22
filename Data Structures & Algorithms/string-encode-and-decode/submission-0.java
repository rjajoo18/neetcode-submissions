class Solution {

    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < strs.size(); i++) {
            String str = strs.get(i);
            sb.append(str.length()).append("#").append(str);
        }
        return sb.toString();
    }

    public List<String> decode(String str) {
        List<String> res = new ArrayList<>();
        int idx = 0;
        int stop = 0;
        int len = 0;
        while (stop < str.length()) {
            if (str.charAt(stop) == '#') {
                len = Integer.parseInt(str.substring(idx, stop));
                res.add(str.substring(stop + 1, stop + len + 1));
                idx = stop + len + 1;
                stop += (len + 1);
            } else {
                stop++;
            }
        }
        return res;
    }
}
