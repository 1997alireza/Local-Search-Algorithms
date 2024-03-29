package algorithms.HillClimbing;

import algorithms.LocalSearch;
import problemGraph.State;
import problemGraph.problems.Problem;

public abstract class HillClimbing extends LocalSearch {
    @Override
    protected State search(Problem p) {
        State s = p.getInitialState();
        while(true){
            expandedStatesNumber++;
            State nextState = getNextState(s, p);
            if(nextState != null){
                s = nextState;
            }
            else {
                break;
            }
        }
        return s;
    }

    protected abstract State getNextState(State s, Problem p);
}
