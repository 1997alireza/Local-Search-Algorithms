import algorithms.*;
import problemGraph.problems.EightQueen;
import problemGraph.problems.GraphPartitioning;
import problemGraph.problems.Problem;

public class Tester {
    public static void main(String[] args) {
        Problem p = new GraphPartitioning();
        LocalSearch localSearch = new RandomRestartHC();
        localSearch.run(p);
        System.out.println(localSearch.getBestState());
        System.out.println(p.objectiveFunction(localSearch.getBestState()));
        System.out.println(localSearch.expandedStatesNumber + ", " + localSearch.visitedStatesNumber);
    }
}