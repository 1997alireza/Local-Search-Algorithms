package algorithms;

import problemGraph.State;
import problemGraph.problems.Problem;

public abstract class LocalSearch {
    private State bestState;
    public void run(Problem p){
        bestState = search(p);
    }
    protected abstract State search(Problem p);
    public State getBestState(){
        return bestState;
    }
}
