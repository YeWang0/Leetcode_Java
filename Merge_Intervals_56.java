import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by yvan on 12/29/16.
 */
public class Merge_Intervals_56 {
    class Interval {
        int start;
        int end;
        Interval() { start = 0; end = 0; }
        Interval(int s, int e) { start = s; end = e; }
    }
    public List<Interval> merge(List<Interval> intervals) {
        Collections.sort(intervals, new Comparator<Interval>() {
            @Override
            public int compare(Interval i1, Interval i2) {
                return Integer.compare(i1.start, i2.start);
            }
        });
        int n=intervals.size();
        for(int i=0;i<n-1;){
            if(intervals.get(i).end>=intervals.get(i+1).start){
                intervals.get(i).end=Math.max(intervals.get(i).end,intervals.get(i+1).end);
                intervals.remove(i+1);
                n--;
            }else{
                i++;
            }
        }
        return intervals;
    }
}
