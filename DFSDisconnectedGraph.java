package Graphs;

import java.util.ArrayList;

public class DFSDisconnectedGraph {
    static ArrayList<Integer> recdfs(ArrayList<ArrayList<Integer>> adj, int scr, boolean[] visited, ArrayList<Integer>  res)
    {
        visited[scr] = true;
        res.add(scr);

        for (int i: adj.get(scr))
        {
            if(!visited[i])
            {
                recdfs(adj,i,visited,res);
            }
        }
        return res;

    }
    static ArrayList<Integer> dfs(ArrayList<ArrayList<Integer>> adj )
    {
        int v= adj.size();
       boolean[] visited = new boolean[v];
        ArrayList<Integer>  res = new ArrayList<>();

        for( int i = 0; i< adj.size(); i++)
        {
            if(!visited[i])
            {
               res =  recdfs(adj, i, visited,res);
            }
        }
        return res;
    }
    static void addEdges(ArrayList<ArrayList<Integer>> adj, int x , int y)
    {
        adj.get(x).add(y);
        adj.get(y).add(x);
    }
    public static void main (String[] args)
    {
        int v = 6 ;

        ArrayList<ArrayList<Integer>> adj  = new ArrayList<>();

        for ( int i = 0; i<v ; i++)
        {
            adj.add(new ArrayList<>());
        }

        int[][] edges = {{1,2},{1,0},{2,0},{2,3},{2,4}};

        for(int[] e: edges)
        {
            addEdges(adj,e[0],e[1]);
        }

        ArrayList<Integer> res = new ArrayList<>();
        res = dfs(adj);

        for(int x : res)
        {
            System.out.println(x + "  ");
        }

    }
}
