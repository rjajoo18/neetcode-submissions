class Solution {
    public boolean isAnagram(String s, String t) {
        char[] sArr = s.toCharArray();
        char[] tArr = t.toCharArray();

        Arrays.sort(sArr);
        Arrays.sort(tArr);

        String sSort = String.valueOf(sArr);
        String tSort = String.valueOf(tArr);

        return sSort.equals(tSort);
    }
}
