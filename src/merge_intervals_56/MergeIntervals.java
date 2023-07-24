package merge_intervals_56;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * https://leetcode.com/problems/merge-intervals/description/?envType=study-plan-v2&envId=top-interview-150
 * 56. Merge Intervals
 * Given an array of intervals where intervals[i] = [starti, endi], merge all overlapping intervals,
 * and return an array of the non-overlapping intervals that cover all the intervals in the input.
 */
public class MergeIntervals {
  // intrvals
  // time - O(nlogn)
  // space - O(n)
  public int[][] merge(int[][] intervals) {

    Arrays.sort(intervals, (a, b)->Integer.compare(a[0], b[0]));
    List<int[]> list = new LinkedList<>();
    int []startInterval = intervals[0];

    for(int i = 0; i<intervals.length; i++){

      if(startInterval[1]<intervals[i][0]){
        list.add(startInterval);
        startInterval = intervals[i];
      }else{
        startInterval[1] = Math.max(startInterval[1], intervals[i][1]);

      }

    }
    list.add(startInterval);
    return list.toArray(new int[list.size()][2]);
  }
  public int[][] insert(int[][] intervals, int[] newInterval) {
    List<int[]>result = new ArrayList<>();
    for(int i= 0; i<intervals.length; i++){

      if(intervals[i][1]<newInterval[0]){
        result.add(intervals[i]);
      }else if(intervals[i][0]>newInterval[1]){
        result.add(newInterval);
        newInterval = intervals[i];
      }else if(intervals[i][1]>=newInterval[0] || intervals[i][0]<=newInterval[1]){
        newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
        newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
      }
    }
    result.add(newInterval);
    return result.toArray(new int[result.size()][2]);

  }

  public static void main(String[] args) {
    MergeIntervals mergeIntervals = new MergeIntervals();
    int[][] merge = mergeIntervals.merge(new int[][]{{1, 5}, {2, 6}, {8, 10}, {15, 18}});
    System.out.println(merge);
    int[][] insert = mergeIntervals.insert(new int[][]{{1,5}}, new int[]{0,0});
    System.out.println(insert
    );
  }
}
