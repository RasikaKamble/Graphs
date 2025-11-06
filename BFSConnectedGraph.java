package Graphs;

import java.util.*;

public class BFSConnectedGraph {

    static ArrayList<Integer> bfs (ArrayList<ArrayList<Integer>> adj )
    {
        int V= adj.size();
        boolean[] visited = new boolean[V];
        Queue<Integer> q = new LinkedList<>();
        int src = 0;
        ArrayList<Integer> res = new ArrayList<>();

        visited[src] = true;
        q.add(src);

        while (!q.isEmpty())
        {
            int current = q.poll();
            res.add(current);


            for( int x: adj.get(current))
            {
                if(!visited[x])
                {
                    visited[x] = true;
                    q.add(x);
                }
            }
        }
        return res;
    }


    public static void main(String args[]) {
       ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
       adj.add(new ArrayList<>(Arrays.asList(1,2)));
        adj.add(new ArrayList<>(Arrays.asList(0,2,3)));
        adj.add(new ArrayList<>(Arrays.asList(0,4)));adj.add(new ArrayList<>(Arrays.asList(1,4)));
        adj.add(new ArrayList<>(Arrays.asList(2,3)));


        ArrayList<Integer> res = bfs(adj);
        for(int i : res)
        {
            System.out.println( i  + " ");
        }
    }
}


