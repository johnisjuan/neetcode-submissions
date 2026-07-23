class Solution {
    public boolean checkInclusion(String s1, String s2) {
        
        if(s1.length() > s2.length()){
            return false;
        }

        int[] s1Perm = new int[26];

        for(char c : s1.toCharArray()){
            s1Perm[c - 'a']++;
        }

        int[] s2Perm = new int[26];

        for(int i=0 ;i < s1.length();++i){
            char c = s2.charAt(i);
            s2Perm[c - 'a']++;
        }

        int l = 0;

        if(Arrays.equals(s1Perm,s2Perm)){
            return true;
        }

        for(int r = s1.length();r<s2.length();++r){
            char removed = s2.charAt(l);
            s2Perm[removed - 'a']--;
            l++;

            char c = s2.charAt(r);
            s2Perm[c - 'a']++;

            if(Arrays.equals(s1Perm,s2Perm)){
                return true;
            }
        }
        return false;
    }
}
