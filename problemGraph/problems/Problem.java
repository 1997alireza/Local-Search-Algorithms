package problemGraph.problems;

import problemGraph.State;

import java.util.ArrayList;

public abstract class Problem{
    public Problem(){
    }
    public abstract State getInitialState();
    public ArrayList<State> getNeighbors(State s){
        return s.getNeighbors();
    }
    public abstract double objectiveFunction(State s);
}
