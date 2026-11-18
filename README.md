# Maze Generator and Solver

This Java Swing application generates a maze with DFS and finds the shortest path with BFS.


## Design

The maze uses a 2D Cell[][] grid. Each cell stores its walls and visited state. Coordinates start at (0, 0) in the top-left. DFS uses a stack to generate the maze. BFS uses a queue to solve it.
