package com.example.p1_1202416_1191360_s1;

import java.util.*;

public class MissionariesAndCannibals {
    private long endBFSTime;
    private long startBFSTime;
    private List<State> solutionBFS;

    private long endDFSTime;
    private long startDFSTime;
    private List<State> solutionDFS;

    public  List<State> getSolutionBFS() {
        return solutionBFS;
    }

    public  List<State> getSolutionDFS() {
        return solutionDFS;
    }

    public String printBFSSolution() {
        String str="";
        for (int i = 0; i < solutionBFS.size(); i++) {
            str+="Step " + (i+1) + ": on the Right Side of the River, there are " + solutionBFS.get(i).missionariesOnRight+ " Missionaries and " + solutionBFS.get(i).cannibalsOnRight +
                    " Cannibals, with the boat on the " + solutionBFS.get(i).boatPosition + ". On the Left Side of the River, there are " + solutionBFS.get(i).missionariesOnLeft + " Missionaries and " + solutionBFS.get(i).cannibalsOnLeft +
                    " Cannibals" + "\n\n";
        }
        return str;
    }

    public String printBFSExecutionTime(){
        long executionTime = endBFSTime - startBFSTime;
        return "Execution Time: " + executionTime + " milliseconds";
    }

    public void bfs() {
        startBFSTime = System.currentTimeMillis();

        Queue<State> frontier = new LinkedList<>();
        Set<State> explored = new HashSet<>();


        State initialState = new State(3, 3, "right", 0, 0);
        frontier.add(initialState);
        explored.add(initialState);

        while (!frontier.isEmpty()) {
            State state = frontier.poll();

            if (state.goalTest()) {
                solutionBFS = changePath(state);
                System.out.println("Solution using Breadth-First Search in: " + (solutionBFS.size()) + " steps");
                printBFSSolution();

                endBFSTime = System.currentTimeMillis();
                printBFSExecutionTime();
                System.out.println();
            }

            List<State> neighbors = transitionModel(state);
            for (int i = 0; i < neighbors.size(); i++) {
                State neighbor = neighbors.get(i);
                if (!explored.contains(neighbor)) {
                    explored.add(neighbor);
                    neighbor.parent = state;
                    frontier.add(neighbor);
                }
            }

        }

    }

    public String printDFSSolution() {
        String str="";
        for (int i = 0; i < solutionDFS.size(); i++) {
            str+="Step " + (i+1) + ": on the Right Side of the River, there are " + solutionDFS.get(i).missionariesOnRight+ " Missionaries and " + solutionDFS.get(i).cannibalsOnRight +
                    " Cannibals, with the boat on the " + solutionDFS.get(i).boatPosition + ". On the Left Side of the River, there are " + solutionDFS.get(i).missionariesOnLeft + " Missionaries and " + solutionDFS.get(i).cannibalsOnLeft +
                    " Cannibals" + "\n\n";
        }
        return str;
    }
    public String printDFSExecutionTime(){
        long executionTime = endDFSTime - startDFSTime;
        return "Execution Time: " + executionTime + " milliseconds";
    }

    public void dfs() {
        startDFSTime = System.currentTimeMillis();

        Stack<State> frontier = new Stack<>();
        Set<State> explored = new HashSet<>();

        State initialState = new State(3, 3, "right", 0, 0);
        frontier.push(initialState);
        explored.add(initialState);

        while (!frontier.isEmpty()) {
            State state = frontier.pop();

            if (state.goalTest()) {
                solutionDFS = changePath(state);
                System.out.println("Solution using Depth-First Search in: " + (solutionDFS.size()) + " steps");
                printDFSSolution();

                endDFSTime = System.currentTimeMillis();
                printDFSExecutionTime();
                System.out.println();
            }

            List<State> neighbors = transitionModel(state);
            for (int i = 0; i < neighbors.size(); i++) {
                State neighbor = neighbors.get(i);
                if (!explored.contains(neighbor)) {
                    neighbor.parent = state;
                    explored.add(neighbor);
                    frontier.push(neighbor);
                }
            }


        }

    }

    private List<State> changePath(State goalState) {
        List<State> path = new ArrayList<>();
        while (goalState != null) {
            path.add(goalState);
            goalState = goalState.parent;
        }
        Collections.reverse(path);
        return path;
    }





    private List<State> transitionModel(State state) {
        List<State> neighbors = new ArrayList<>();

        int[][] allowedPositions = {{1, 0}, {2, 0}, {0, 1}, {0, 2}, {1, 1}};

        for (int i = 0; i < allowedPositions.length; i++) {
            int[] position = allowedPositions[i];
            int missionariesPositions = position[0];
            int cannibalsPositions = position[1];

            if (state.boatPosition.equals("left")) {
                State neighbor = new State(
                        state.missionariesOnRight + missionariesPositions,
                        state.cannibalsOnRight + cannibalsPositions,
                        "right",
                        state.missionariesOnLeft - missionariesPositions,
                        state.cannibalsOnLeft - cannibalsPositions
                );
                if (neighbor.isValidState()) {
                    neighbors.add(neighbor);
                }
            } else {
                State neighbor = new State(
                        state.missionariesOnRight - missionariesPositions,
                        state.cannibalsOnRight - cannibalsPositions,
                        "left",
                        state.missionariesOnLeft + missionariesPositions,
                        state.cannibalsOnLeft + cannibalsPositions
                );
                if (neighbor.isValidState()) {
                    neighbors.add(neighbor);
                }
            }
        }
        return neighbors;
    }
}
