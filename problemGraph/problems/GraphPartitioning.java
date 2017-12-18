package problemGraph.problems;

import problemGraph.State;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class GraphPartitioning extends Problem {
    private ArrayList<ArrayList<Integer>> graph;
    public GraphPartitioning(ArrayList<ArrayList<Integer>> graph){
        this.graph = graph;
    }
    public GraphPartitioning() {
        graph = new ArrayList<>(
                Arrays.asList(
                            /*node  0*/new ArrayList<>(Arrays.asList(1, 2)),
                            /*node  1*/new ArrayList<>(Arrays.asList(0, 2, 3, 5)),
                            /*node  2*/new ArrayList<>(Arrays.asList(0, 1, 4)),
                            /*node  3*/new ArrayList<>(Arrays.asList(1, 4, 7)),
                            /*node  4*/new ArrayList<>(Arrays.asList(2, 3, 6)),
                            /*node  5*/new ArrayList<>(Arrays.asList(1, 8)),
                            /*node  6*/new ArrayList<>(Arrays.asList(4, 7)),
                            /*node  7*/new ArrayList<>(Arrays.asList(3, 6, 8, 11)),
                            /*node  8*/new ArrayList<>(Arrays.asList(5, 7, 9, 10)),
                            /*node  9*/new ArrayList<>(Arrays.asList(8, 10)),
                            /*node 10*/new ArrayList<>(Arrays.asList(8, 9, 11)),
                            /*node 11*/new ArrayList<>(Arrays.asList(7, 10))
                )
        );
    }

    @Override
    public State getInitialState() {
        PState s =  new PState( new ArrayList<>(Collections.nCopies(graph.size(), false)));
        s.subGraph.set(0, true);
        return s;
    }

    @Override
    public double objectiveFunction(State s) {
        return -1 * (edgeNumBetweenSubGraphs((PState)s) + deltaNodeBetweenSubGraphs((PState)s));
    }

    private int deltaNodeBetweenSubGraphs(PState s){
        int trueNum = 0;
        for(Boolean b : s.subGraph){
            if(b) trueNum++;
        }
        int delta = (s.subGraph.size() - trueNum)/*falseNum*/ - trueNum;
        return delta >= 0 ? delta : -delta;
    }

    private int edgeNumBetweenSubGraphs(PState s){
        int edgeNum = 0;
        for(int i = 0; i < s.subGraph.size(); i++){
            if(s.subGraph.get(i)) {
                for (int j = 0; j < s.subGraph.size(); j++) {
                    if(!s.subGraph.get(j)){
                        for(Integer connectedNode : graph.get(i)){
                            if(connectedNode == j){
                                edgeNum++;
                                break;
                            }
                        }
                    }
                }
            }
        }
        return edgeNum;
    }

    private boolean isValidSubGraph(ArrayList<Boolean> subGraph){
        boolean seenTrue = false, seenFalse = false;
        for(Boolean b : subGraph){
            if(b) seenTrue = true;
            else seenFalse = true;
            if(seenTrue && seenFalse) return true;
        }
        return false;
    }

    @Override
    public State getRandomState() {
        ArrayList<Boolean> subGraph = new ArrayList<>();
        for(int i = 0; i < graph.size(); i++){
            subGraph.add(Math.random() < 0.5);
        }
        if(!isValidSubGraph(subGraph)){
            int index = (int) (Math.random() * subGraph.size());
            subGraph.set(index, !subGraph.get(index));
        }
        return new PState(subGraph);
    }

    private class PState extends State {
        ArrayList<Boolean> subGraph; // false: is in subGraph 0, true: is in subGraph 1

        public PState(ArrayList<Boolean> subGraph){
            this.subGraph = new ArrayList<>();
            for(Boolean b : subGraph){
                this.subGraph.add(b);
            }
        }

        @Override
        public ArrayList<State> getNeighbors() {
            ArrayList<State> neighborStates = new ArrayList<>();
            for(int i = 0; i < subGraph.size(); i++) {
                subGraph.set(i, !subGraph.get(i));
                if(isValidSubGraph(subGraph)) {
                    neighborStates.add(new PState(subGraph));
                }
                subGraph.set(i, !subGraph.get(i));
            }
            return neighborStates;
        }

        @Override
        public State getRandomNeighbor() {
            int i = (int) (Math.random() * subGraph.size());
            subGraph.set(i, !subGraph.get(i));
            PState returnValue;
            if(isValidSubGraph(subGraph)) {
                returnValue = new PState(subGraph);
            }
            else{
                int index = (int) (Math.random() * subGraph.size());
                subGraph.set(index, !subGraph.get(index));
                returnValue = new PState(subGraph);
                subGraph.set(index, !subGraph.get(index));

            }
            subGraph.set(i, !subGraph.get(i));
            return returnValue;
        }

        @Override
        public String toString() {
            return Arrays.toString(subGraph.toArray());
        }
    }
}
