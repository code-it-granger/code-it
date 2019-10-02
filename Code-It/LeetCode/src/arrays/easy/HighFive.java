package arrays.easy;

/*
  Given a list of scores of different students, return the average score of each student's top five scores
  in the order of each student's id.
  Each entry items[i] has items[i][0] the student's id, and items[i][1] the student's score.
  The average score is calculated using integer division.

 Problem: https://leetcode.com/problems/high-five/
 Solution:
*/

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class HighFive {

    public static void main(String[] args) {
        int[][] m = {{1, 44},
                {2, 10},
                {1, 56},
                {1, 22},
                {2, 54},
                {1, 34},
                {1, 23},
                {2, 100},
                {1, 100},
                {2, 30},
                {2, 76},
                {1, 10},
                {2, 12},
                {2, 20}};

        int[][] results = averages(m);

        for(int i=0;i<results.length;i++){
            System.out.println();
            for (int j=0;j<results[i].length;j++)
                System.out.print(results[i][j]+" ");
        }
    }

    private static int[][] averages(int[][] m){
        if(m==null || m.length==0)
            return null;

        HashMap<Integer, PriorityQueue<Integer>> map = new HashMap<>();

       for(int i=0;i<m.length;i++){
           PriorityQueue<Integer> scores = new PriorityQueue<>(Collections.reverseOrder());
           if(map.containsKey(m[i][0])){
                scores = map.get(m[i][0]);
                scores.add(m[i][1]);
           }
           else{
                scores.add(m[i][1]);
           }

           map.put(m[i][0],scores);
       }

       int[][] result = new int[map.size()][2];

       int a=0;
        for(Map.Entry<Integer,PriorityQueue<Integer>> entry: map.entrySet()){
            System.out.println(entry.getKey()+": "+entry.getValue());
            int i=0;
            int sum=0;
            while(i<5){
                sum += entry.getValue().poll();
                i++;
            }
            result[a][0]=entry.getKey();
            result[a][1]=sum/5;
            a++;
        }

        return result;
    }

}
