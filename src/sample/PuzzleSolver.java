package sample;

import java.util.*;

public class PuzzleSolver {
    private Node root;
    int steps=0;
    long startTime = System.nanoTime();
    public PuzzleSolver(int[][] puzzle) {
        this.root = new Node(puzzle);
    }

    public PuzzleSolver() {
    }

    public int bfsSolve() {
        int ExpandedNodes = 0;
        Queue<Node> frontier = new LinkedList<>();
        Set<int[][]> visited = new HashSet<>();
        List<Node> solutionPath = new ArrayList<>();

        frontier.add(root);
        while (!frontier.isEmpty()) {
            // poll node in the front of the queue
            // then, add to visited
            // then check if node is the goal
            // if not, iterate over all possible children, add them to the frontier, if not already visited
            Node currentNode = frontier.poll();
            visited.add(currentNode.getPuzzle());

            ExpandedNodes++;
            if (currentNode.isGoal()) {
                // trace path to goal and return
                System.out.println("Goal is found!");
                while (currentNode.getParent() != null) {
                    solutionPath.add(currentNode);
                    currentNode.print();
                    System.out.println("----------------");
                    currentNode = currentNode.getParent();
                }
                root.print();
                //System.out.println("Expanded Nodes: " + ExpandedNodes);
                System.out.println("Search Depth: " + solutionPath.size());
                steps = solutionPath.size();
                long endTime   = System.nanoTime();
                long totalTime = endTime - startTime;
                System.out.println("Running time is: " + totalTime/Math.pow(10, 9) + " Seconds");
                return solutionPath.size();
            }
            for (Node child : currentNode.getChildren()) {
                if (!Contains(visited, child)) {
                    frontier.add(child);
                }
            }
        }
        System.out.println("Goal wasn't reached and we're returning false");
        return 0;
    }

    public int dfsSolve() {
        Stack<Node> frontier = new Stack<>();
        Set<int[][]> visited = new HashSet<>();
        List<Node> solutionPath = new ArrayList<>();

        frontier.add(root);
        while (!frontier.isEmpty()) {

            // pop node at the top of the stack
            // then, add to visited
            // then check if node is the goal
            // if not, iterate over all possible children, add them to the frontier, if not already visited
            Node currentNode = frontier.pop();
            visited.add(currentNode.getPuzzle());

            if (currentNode.isGoal()) {

                // trace path to goal and return
                System.out.println("Goal is found!");
                while (currentNode.getParent() != null) {
                    solutionPath.add(currentNode);
                    currentNode.print();
                    System.out.println("----------------");
                    currentNode = currentNode.getParent();
                }
                root.print();
                System.out.println("Search Depth: " + solutionPath.size());
                steps = solutionPath.size();
                long endTime   = System.nanoTime();
                long totalTime = endTime - startTime;
                System.out.println("Running time is: " + totalTime/Math.pow(10, 9) + " Seconds");
                return solutionPath.size();
            }

            for (Node child : currentNode.getChildren()) {
                if (!Contains(visited, child)) {
                    frontier.add(child);
                }
            }
        }
        System.out.println("Goal wasn't reached and we're returning false");
        return 0;
    }

    public boolean compareArrays(int[][] a, int[][] b)
    {
        for(int i =0 ; i < a.length; i++) {
            for(int j = 0; j < a[0].length; j++) {
                if(a[i][j] != b[i][j])
                    return false;
            }
        }
        return true;
    }
    public boolean Contains(Set<int[][]> list, Node child)
    {
        for(int[][] node : list)
        {
            if(compareArrays(node ,child.getPuzzle()))
                return true;
        }
        /*if(list.contains(child.getPuzzle()))
            return true;
            */

        return false;
    }

}
