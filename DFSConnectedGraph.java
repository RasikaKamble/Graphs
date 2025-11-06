package Graphs;

import java.util.ArrayList;

public class DFSConnectedGraph {


static ArrayList<Integer> recdfs(ArrayList<ArrayList<Integer>> adj , int scr, boolean[] visited, ArrayList<Integer> res)
{
    visited[scr] = true;
    res.add(scr);

    for(int i : adj.get(scr))
    {
        if(!visited[i])
        {
            recdfs(adj,i,visited,res);
        }
    }
    return res;

}

    static ArrayList<Integer> dfs(ArrayList<ArrayList<Integer>> adj)
    { int v = adj.size();
        ArrayList<Integer> ans = new ArrayList<>();
        boolean[] visited = new boolean[v];
            ans =  recdfs(adj,0,visited,ans);
        return ans;
    }

    static void addEdge(ArrayList<ArrayList<Integer>> adj, int x, int y)
    {
        adj.get(x).add(y);
        adj.get(y).add(x);
    }

    public static void main(String[] args)
    {
        int v = 5;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();


        for( int i=0;i<v;i++)
        {
            adj.add(new ArrayList<>());
        }

        int[][] edges = {{1,2},{1,0},{2,0},{2,3},{2,4}};

        for(int[] e : edges)
        {
            addEdge(adj,e[0],e[1]);
        }

        ArrayList<Integer> ans = dfs(adj);

for( int a : ans)
{
    System.out.println(a + " ");
}

    }
}
