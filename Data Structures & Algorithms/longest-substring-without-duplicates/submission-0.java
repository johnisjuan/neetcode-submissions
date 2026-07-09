class Solution {
    public int lengthOfLongestSubstring(String s) {
        
        Set<Character> seen = new HashSet<>();
        int res = 0;

        int l = 0;
        int r = 0;

        while(r < s.length()){
            
            char c = s.charAt(r);

            while(seen.contains(c)){

                seen.remove(s.charAt(l ));
                l++;
            }

            seen.add(c);
            int length = r-l+1;
            res = Math.max(res,length);
            r++;
        }

        return res;
    }
}
