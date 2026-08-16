class Solution {
    public String longestCommonPrefix(String[] strs) {
        
        StringBuilder res = new StringBuilder();

        Arrays.sort(strs);

        for(int i = 0;i<strs[0].length();++i){
            char c = strs[0].charAt(i);
            for(String s : strs){
                if(s.charAt(i) != c){
                    return res.toString();
                }
            }
            res.append(c);
        }

        return res.toString();
    }
}