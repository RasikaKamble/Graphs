package Graphs;

import java.util.ArrayList;

public class CycleIndirectedGraph {

static boolean isCycle(ArrayList<ArrayList<Integer>> adj,int scr , boolean[] visited, int parent)
{
    visited[scr] = true;

    for(int x : adj.get(scr))
    {
        if(!visited[x])
        {
            if(isCycle(adj,x,visited,scr))
            {
                return true;
            }
        }
        else if(x != parent) {
            return true;
        }
    }

    return false;
}
    static void addEdges(ArrayList<ArrayList<Integer>> adj, int x, int y)
    {
        adj.get(x).add(y);
        adj.get(y).add(x);
    }
    static boolean detectCycle(int v , ArrayList<ArrayList<Integer>> adj)
    {
        for(int i = 0; i<v;i++)
        {
            adj.add(new ArrayList<>());
        }

        int[][] edges ={{0,1},{0,2},{0,3},{1,2},{3,4}};

        for(int[] e: edges)
        {
            addEdges(adj,e[0],e[1]);
        }
        boolean[] visited = new boolean[v];

        for(int i = 0;i<v;i++)
        {
            if(!visited[i])
            {
                if(isCycle(adj,i,visited,-1))
                {
                    return true;
                }
            }
        }
        return false;
    }
    public static void main(String[] args)
    {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        int v = 5;
        if(detectCycle(v,adj))
        {
            System.out.println("true");
        }
        else {
            System.out.println("false");
        }

    }
}
