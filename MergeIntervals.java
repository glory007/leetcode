// SOLVED ! BOTH SMALL AND LARGE CASES.

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/*
 * 
Given a collection of intervals, merge all overlapping intervals.

For example,
Given [1,3],[2,6],[8,10],[15,18],
return [1,6],[8,10],[15,18].
 */

public class MergeIntervals {
	
	 public ArrayList<Interval> merge(ArrayList<Interval> intervals) {
		 if(intervals.size() <= 1){
			 return intervals;
		 }
		 
		 Collections.sort(intervals, new Comparator<Interval>() {
			 @Override
				public int compare(Interval o1, Interval o2) {
					// TODO Auto-generated method stub
				 return (o1.start - o2.start);
			 }
		 });
		 
		 ArrayList<Interval> result = new ArrayList<Interval>();
		 result.add(intervals.get(0));
		 
		 for (int i = 1; i < intervals.size(); i++){
			  Interval p = intervals.get(i);
			  
			  if(p.start > result.get(result.size() - 1).end){
				  // no overlap case
				  result.add(p);
			  }
			  else if(p.end > result.get(result.size()-1).end)
			  {
				  result.get(result.size()-1).end = p.end;
			  }
		 }
		 return result;
	 }
}
