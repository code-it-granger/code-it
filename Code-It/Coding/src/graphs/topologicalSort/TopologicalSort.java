package graphs.topologicalSort;

import java.util.*;
/*
     https://www.educative.io/courses/grokking-the-coding-interview/m25rBmwLV00
*/

public class TopologicalSort {
    public static void main(String[] args) {
        int vertices = 4;
        int[][] edges = {
                {3, 2},
                {3, 0},
                {2, 0},
                {2, 1},
        };

        topologicalSort(vertices, edges);
    }

    public static void topologicalSort(int vertices, int[][] edges) {
        List<Integer> result = new ArrayList<>();

        HashMap<Integer, List<Integer>> graph = new HashMap<>();
        HashMap<Integer, Integer> inDegree = new HashMap<>();

        for (int i = 0; i < vertices; i++) {
            graph.put(i, new ArrayList<>());
            inDegree.put(i, 0);
        }

        for (int i = 0; i < edges.length; i++) {
            int parent = edges[i][0];
            int child = edges[i][1];
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

        if (result.size() != vertices) {
            System.out.println("Cyclic Graph");
            return;
        }

        System.out.println(result);
    }
}
