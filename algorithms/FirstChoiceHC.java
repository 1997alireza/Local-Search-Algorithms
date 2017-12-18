package algorithms;

import problemGraph.State;
import problemGraph.problems.Problem;

public class FirstChoiceHC extends HillClimbing {
    private static final int MAX_RANDOM_TIME = 10;
    @Override
    protected State getNextState(State s, Problem p) {
        double currentObjective = p.objectiveFunction(s);
        for(int i = 0; i < MAX_RANDOM_TIME; i++){
            State randomNeighbor = s.getRandomNeighbor();
            if(p.objectiveFunction(randomNeighbor) > currentObjective)
                return randomNeighbor;
        }
        return null;
    }
}
