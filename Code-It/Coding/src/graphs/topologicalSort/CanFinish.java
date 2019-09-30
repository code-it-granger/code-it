package graphs.topologicalSort;

import java.util.*;

public class CanFinish {
    public static void main(String[] args) {
        int tasks = 3;
        int[][] dependencies = {
                {2,1},{1,0}
        };
        boolean sol = canFinish(tasks, dependencies);
        System.out.println(sol);

    }

    public static boolean canFinish(int numCourses, int[][] prerequisites) {
//        if (numCourses == 0)
//            return false;
//        if (prerequisites.length == 0)
//            return true;
//        List<Integer> result = new ArrayList<>();
//        HashMap<Integer, List<Integer>> graph = new HashMap<>();
//        HashMap<Integer, Integer> inDegree = new HashMap<>();
//
//        Queue<Integer> sources = new LinkedList<>();
//
//        for (int i = 0; i < numCourses; i++) {
//            graph.put(i, new ArrayList<>());
//            inDegree.put(i, 0);
//        }
//
//        for (int i = 0; i < prerequisites.length; i++) {
//            int course = prerequisites[i][0];
//            int prerequisite = prerequisites[i][1];
//            graph.get(course).add(prerequisite);
//            inDegree.put(prerequisite, inDegree.get(prerequisite) + 1);
//        }
//
//        for (Map.Entry<Integer, Integer> entry : inDegree.entrySet()) {
//            if (entry.getValue() == 0)
//                sources.add(entry.getKey());
//        }
//
//        while (!sources.isEmpty()) {
//            int currCourse = sources.poll();
//            result.add(currCourse);
//            List<Integer> p = graph.get(currCourse);
//
//            for (int pc : p) {
//                inDegree.put(pc, inDegree.get(pc) - 1);
//                if (inDegree.get(pc) == 0)
//                    sources.add(pc);
//            }
//
//        }
//        return result.size() == numCourses;
//    }
        if (numCourses == 0)
            return false;
        if (prerequisites.length == 0)
            return true;
        List<Integer> result = new ArrayList<>();
        HashMap<Integer, List<Integer>> graph = new HashMap<>();
        HashMap<Integer, Integer> inDegree = new HashMap<>();

        Queue<Integer> sources = new LinkedList<>();

        for (int i = 0; i < numCourses; i++) {
            graph.put(i, new ArrayList<>());
            inDegree.put(i, 0);
        }

        for (int i = 0; i < prerequisites.length; i++) {
            int course = prerequisites[i][0];
            int preq = prerequisites[i][1];

            graph.get(course).add(preq);
            inDegree.put(preq, inDegree.get(preq) + 1);
        }

        for (Map.Entry<Integer, Integer> entry : inDegree.entrySet()) {
            if (entry.getValue() == 0)
                sources.add(entry.getKey());
        }

        while (!sources.isEmpty()) {
            int currCourse = sources.poll();
            result.add(currCourse);
            List<Integer> p = graph.get(currCourse);
            for (int pc : p) {
                inDegree.put(pc, inDegree.get(pc) - 1);
                if (inDegree.get(pc) == 0)
                    sources.add(pc);
            }
        }
        System.out.println(result);
        return result.size() == numCourses;
    }
}

/*
class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if(numCourses==0)
            return false;
        if(prerequisites.length==0)
            return true;
        List<Integer> result = new ArrayList<>();
        HashMap<Integer, List<Integer>> graph = new HashMap<>();
        HashMap<Integer, Integer> inDegree = new HashMap<>();

        Queue<Integer> sources = new LinkedList<>();

        for(int i=0;i<numCourses;i++){
            graph.put(i,new ArrayList<>());
            inDegree.put(i,0);
        }

        for(int i=0;i<prerequisites.length;i++){
            int course = prerequisites[i][0];
            int preq = prerequisites[i][1];

            graph.get(course).add(preq);
            inDegree.put(preq, preMap.get(course)+1 );
            }

        for(Map.Entry<Integer, Integer> entry : inDegree.entrySet()){
            if(entry.getValue()==0)
                sources.add(entry.getKey());
        }

        while(!sources.isEmpty()){
            int currCourse = sources.poll();
            result.add(currCourse);
            List<Integer> p = graph.get(currCourse);
            for(int pc : p){
                inDegree.put(pc, inDegree.get(pc)-1);
                if(inDegree.get(pc)==0)
                    sources.add(pc);
            }
        }
        return result.size()==numCourses;
    }
}
 */
