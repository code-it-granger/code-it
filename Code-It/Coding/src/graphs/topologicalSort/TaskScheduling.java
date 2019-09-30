package graphs.topologicalSort;

import java.util.*;

public class TaskScheduling {
    public static void main(String[] args) {
        int tasks = 3;
        int[][] dependencies = {
                {1,0},{2,1}
        };
        topologicalSort(tasks,dependencies);

    }

    public static void topologicalSort(int tasks, int[][] dependencies) {
        List<Integer> result = new ArrayList<>();

        HashMap<Integer, List<Integer>> graph = new HashMap<>();
        HashMap<Integer, Integer> inDegree = new HashMap<>();

        for (int i = 0; i < tasks; i++) {
            graph.put(i, new ArrayList<>());
            inDegree.put(i, 0);
        }

        for (int i = 0; i < dependencies.length; i++) {
            int parent = dependencies[i][0];
            int child = dependencies[i][1];
            graph.get(parent).add(child);
            inDegree.put(child, inDegree.get(child) + 1);
        }

        Queue<Integer> sources = new LinkedList<>();
        for (Map.Entry<Integer, Integer> entry : inDegree.entrySet()) {
            if (entry.getValue() == 0)
                sources.add(entry.getKey());
        }

        while (!sources.isEmpty()) {
            int currentVertex = sources.poll();
            result.add(currentVertex);
            List<Integer> children = graph.get(currentVertex);
            for (int child : children) {
                inDegree.put(child, inDegree.get(child) - 1);
                if (inDegree.get(child) == 0)
                    sources.add(child);
            }
        }

        if (result.size() != tasks) {
            System.out.println("Cyclic Graph. Cannot schedule tasks");
            return;
        }

        System.out.println(result.size()==tasks);
    }
}