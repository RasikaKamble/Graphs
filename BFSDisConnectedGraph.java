package Graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class BFSDisConnectedGraph {

    static ArrayList<Integer> bfsOfGraph(ArrayList<ArrayList<Integer>> adj ,
                                         int src, boolean[] visited,ArrayList<Integer> res)
    {
        Queue<Integer> q = new LinkedList<>();
        visited[src] = true;
        q.add(src);

        while (!q.isEmpty())
        {
            int curr = q.poll();
            res.add(curr);

            for( int x : adj.get(curr))
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

    static ArrayList<Integer> bfs (ArrayList<ArrayList<Integer>> adj )
    {
        ArrayList<Integer> res = new ArrayList<>();
     int v = adj.size();
     boolean[] visited = new boolean[v];

     for(int i = 0; i<v ; i++)
     {
         if(!visited[i])
         {
             bfsOfGraph(adj,i,visited,res);
         }
     }

     return res;
    }


    public static void main(String args[]) {
       ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        adj.add(new ArrayList<>(Arrays.asList(0,4)));
        adj.add(new ArrayList<>(Arrays.asList(1,2)));
        adj.add(new ArrayList<>(Arrays.asList(1,3)));
        adj.add(new ArrayList<>(Arrays.asList(1,4)));
        adj.add(new ArrayList<>(Arrays.asList(2,3)));
        adj.add(new ArrayList<>(Arrays.asList(3,4)));


        ArrayList<Integer> res = bfs(adj);
        for(int i : res)
        {
            System.out.println( i  + " ");
        }
    }
}


