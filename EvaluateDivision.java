package Graphs;

import java.util.Map;

public class EvaluateDivision {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        Map<String, Map<String, Double>> graph = new HashMap<>();

        // Build graph
        for (int i = 0; i < equations.size(); i++) {
            String a = equations.get(i).get(0);
            String b = equations.get(i).get(1);
            graph.putIfAbsent(a, new HashMap<>());
            graph.putIfAbsent(b, new HashMap<>());
            graph.get(a).put(b, values[i]);
            graph.get(b).put(a, 1.0 / values[i]);
        }

        double[] res = new double[queries.size()];
        for (int i = 0; i < queries.size(); i++) {
            res[i] = dfs(graph, queries.get(i).get(0), queries.get(i).get(1), 1.0, new HashSet<>());
        }
        return res;
    }

    private double dfs(Map<String, Map<String, Double>> graph, String start, String end, double val, Set<String> visited) {
        if (!graph.containsKey(start)) return -1.0;
        if (start.equals(end)) return val;

        visited.add(start);

        for (Map.Entry<String, Double> neighbor : graph.get(start).entrySet()) {
            if (!visited.contains(neighbor.getKey())) {
                double product = dfs(graph, neighbor.getKey(), end, val * neighbor.getValue(), visited);
                if (product != -1.0) return product;
            }
        }

        return -1.0;
    }
}
