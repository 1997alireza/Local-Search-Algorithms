package algorithms.HillClimbing;

import problemGraph.State;
import problemGraph.problems.Problem;

public class SimpleHC extends HillClimbing{
    @Override
    protected State getNextState(State s, Problem p){
        double currentObjective = p.objectiveFunction(s);
        State nextState = null;
        double nextMaxObjective = -1.0 / 0.0;
        for(State neiState : s.getNeighbors()){
            double neiStateObjective = p.objectiveFunction(neiState);
            if(neiStateObjective > nextMaxObjective){
                nextMaxObjective = neiStateObjective;
                nextState = neiState;
            }
            visitedStatesNumber++;
        }
        if(nextState != null && nextMaxObjective <= currentObjective)
            return null;
        return nextState;
    }
}
