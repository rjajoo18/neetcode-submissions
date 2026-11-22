class TimeMap {
    private Map<String, List<String>> values;
    private Map<String, List<Integer>> times;

    public TimeMap() {
        values = new HashMap<>();
        times = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        if(values.containsKey(key)) {
            values.get(key).add(value);
            times.get(key).add(timestamp);
        } else {
            List<String> vals = new ArrayList<>();
            List<Integer> time = new ArrayList<>();
            vals.add(value);
            time.add(timestamp);
            values.put(key, vals);
            times.put(key, time);
        }
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
