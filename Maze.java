package Graphs;

import java.util.LinkedList;
import java.util.Queue;

public class Maze {

    public int nearestExit(char[][] maze, int[] entrance) {
        int m = maze.length, n = maze[0].length;
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{entrance[0], entrance[1], 0}); // row, col, steps
        maze[entrance[0]][entrance[1]] = '+'; // mark entrance as visited

        int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};

        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int r = curr[0], c = curr[1], steps = curr[2];

            // Check if on border (and not entrance)
            if ((r == 0 || r == m-1 || c == 0 || c == n-1) && !(r == entrance[0] && c == entrance[1])) {
                return steps;
            }

            for (int[] d : dirs) {
                int nr = r + d[0], nc = c + d[1];
                if (nr >=0 && nr < m && nc >=0 && nc < n && maze[nr][nc] == '.') {
                    queue.offer(new int[]{nr, nc, steps + 1});
                    maze[nr][nc] = '+'; // mark visited
                }
            }
        }

        return -1; // no exit found
    }
}
