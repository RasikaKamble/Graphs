package Graphs;

import java.util.ArrayList;

public class CycleDirectedGraph {

static boolean isCycle(ArrayList<ArrayList<Integer>> adj, int scr, boolean[] visited, boolean[] recStack)
{
    // check if present in recstack
    if(recStack[scr])
    {
        return true;
    }

    // if present in visited and not part of rec its okay
    if(visited[scr])
    {
        return false;
    }
    visited[scr] = true;
    recStack[scr] = true;

    for(int x : adj.get(scr))
    {
        if(isCycle(adj,x,visited,recStack))
        {
            return true;
        }
    }
    return false;
}
    static public void addEdge(ArrayList<ArrayList<Integer>> adj, int x, int y)
    {
        adj.get(x).add(y);
        adj.get(y).add(x);
    }
    static public boolean detectCycle(int v, ArrayList<ArrayList<Integer>> adj)
    {
        boolean[] visited = new boolean[v];
        boolean[] recStack = new boolean[v];
        for (int i = 0; i<v;i++)
        {
            adj.add(new ArrayList<>());
        }
        int[][] edges = {{0,1},{1,2},{2,0},{2,3}};

        for(int[] e : edges)
        {
            addEdge(adj,e[0],e[1]);
        }

        for(int i = 0; i<v;i++)
        {
            if(!visited[i]  && isCycle(adj,i,visited,recStack))
            {
                return true;
            }
        }
return false;
    }
    public static void main(String[] args)
    {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        int v = 4;
        if(detectCycle(v,adj))
        {
            System.out.println("true"
                    );
        }else {
            System.out.println("false"
            );
        }

    }


}
