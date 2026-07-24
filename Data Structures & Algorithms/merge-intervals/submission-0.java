class Solution {
    public int[][] merge(int[][] intervals) {
        
        List<int[]> res = new ArrayList<>();

        Arrays.sort(intervals, (a,b) -> Integer.compare(a[0],b[0]));

        int start = intervals[0][0];
        int end = intervals[0][1];

        for(int i=1;i<intervals.length;++i){
            int nstart = intervals[i][0];
            int nend = intervals[i][1];

            if(nstart <= end){
                end = Math.max(end,nend);
            } else {
                res.add(new int[]{start,end});
                start = nstart;
                end = nend;
            }
        }

        res.add(new int[]{start,end});

        return res.toArray(new int[0][]);
    }
}
