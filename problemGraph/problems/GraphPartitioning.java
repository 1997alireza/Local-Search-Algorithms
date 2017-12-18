package problemGraph.problems;

import problemGraph.State;

import java.util.ArrayList;

public class GraphPartitioning extends Problem {
    public GraphPartitioning(){

    }

    @Override
    public State getInitialState() {
        return null;
    }

    @Override
    public double objectiveFunction(State s) {
        return 0;
    }

    @Override
    public State getRandomState() {
        return null;
    }


    private class PState extends State {

        @Override
        public ArrayList<State> getNeighbors() {
            return null;
        }

        @Override
        public State getRandomNeighbor() {
            return null;
        }

        @Override
        public String toString() {
            return null;
        }
    }

}
