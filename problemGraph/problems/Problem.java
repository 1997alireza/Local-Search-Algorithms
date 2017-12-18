package problemGraph.problems;

import problemGraph.State;

import java.util.ArrayList;

public abstract class Problem{
    public Problem(){
    }
    public abstract State getInitialState();
    public abstract double objectiveFunction(State s);
    public abstract State getRandomState();
}
