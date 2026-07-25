class Solution {

    Map<Character,List<Character>> map = new HashMap<>();
    List<String> res = new ArrayList<>();

    public List<String> letterCombinations(String digits) {
        
        map.put('1',new ArrayList<>());
        map.put('2',new ArrayList<>(List.of('a','b','c')));
        map.put('3',new ArrayList<>(List.of('d','e','f')));
        map.put('4',new ArrayList<>(List.of('g','h','i')));
        map.put('5',new ArrayList<>(List.of('j','k','l')));
        map.put('6',new ArrayList<>(List.of('m','n','o')));
        map.put('7',new ArrayList<>(List.of('p','q','r','s')));
        map.put('8',new ArrayList<>(List.of('t','u','v')));
        map.put('9',new ArrayList<>(List.of('w','x','y','z')));
        map.put('0',new ArrayList<>());

        if(digits.length() == 0){
            return res;
        }

        dfs(digits,"",0);

        return res;
    }

    private void dfs(String num,String cur,int i){
        
        if(i >= num.length()){
            res.add(cur);
            return;
        }

        char digit = num.charAt(i);

        for(char x : map.get(digit)){;
            dfs(num,cur+x,i+1);
        }

    }
}
