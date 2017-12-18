package problemGraph.problems;

import problemGraph.State;

import java.util.ArrayList;

public class MathematicalEquality extends Problem {
    public MathematicalEquality(){

    }

    @Override
    public State getInitialState() {
        return null;
    }

    @Override
    public double objectiveFunction(State s) {
        return 0;
    }


    private class PState extends State {

        @Override
        public ArrayList<State> getNeighbors() {
            return null;
        }

        @Override
        public String toString() {
            return null;
        }
    }

}
