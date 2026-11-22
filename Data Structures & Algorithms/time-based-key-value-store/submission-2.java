class TimeMap {

    private class Pair {
        private String value;
        private int timestamp;

        public Pair(String value, int timestamp) {
            this.value = value;
            this.timestamp = timestamp;
        } 
    }

    private Map<String, List<Pair>> map;

    public TimeMap() {
        map = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        map.putIfAbsent(key, new ArrayList<>());
        map.get(key).add(new Pair(value, timestamp));
    }
    
    public String get(String key, int timestamp) {
        String res = "";
        if (!map.containsKey(key)) {
            return res;
        }
        List<Pair> list = map.get(key);
        int l = 0, r = list.size() - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            Pair p = list.get(mid);
            if (p.timestamp <= timestamp) {
                res = p.value;
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return res;
    }
}
