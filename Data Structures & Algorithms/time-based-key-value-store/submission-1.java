class TimeMap {
    private Map<String, List<String>> values;
    private Map<String, List<Integer>> times;

    public TimeMap() {
        values = new HashMap<>();
        times = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        values.computeIfAbsent(key, k -> new ArrayList<>()).add(value);
        times.computeIfAbsent(key, k -> new ArrayList<>()).add(timestamp);
    }
    
    public String get(String key, int timestamp) {
        if(!times.containsKey(key)) return "";

        List<Integer> t = times.get(key);
        List<String> v = values.get(key);

        int l = 0, r = t.size() - 1;
        String res = "";
        while(l <= r) {
            int mid = l + (r - l) / 2;
            if(t.get(mid) == timestamp) {
                return v.get(mid);
            } else if (t.get(mid) < timestamp) {
                res = v.get(mid);
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return res;
    }
}
