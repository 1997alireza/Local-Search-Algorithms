import algorithms.*;
import algorithms.HillClimbing.RandomRestartHC;
import algorithms.SimulatedAnnealing.CoolingScheduler;
import algorithms.SimulatedAnnealing.SimulatedAnnealing;
import problemGraph.problems.GraphPartitioning;
import problemGraph.problems.Problem;

public class Tester {
    public static void main(String[] args) {
        Problem p = new GraphPartitioning();
        LocalSearch localSearch = new SimulatedAnnealing(CoolingScheduler.reversi);
        localSearch.run(p);
        System.out.println(localSearch.getBestState());
        System.out.println(p.objectiveFunction(localSearch.getBestState()));
        System.out.println(localSearch.expandedStatesNumber + ", " + localSearch.visitedStatesNumber);
    }
}