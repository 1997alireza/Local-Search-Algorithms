import algorithms.*;
import algorithms.HillClimbing.FirstChoiceHC;
import algorithms.HillClimbing.RandomRestartHC;
import algorithms.HillClimbing.SimpleHC;
import algorithms.HillClimbing.StochasticHC;
import algorithms.SimulatedAnnealing.CoolingScheduler;
import algorithms.SimulatedAnnealing.SimulatedAnnealing;
import org.knowm.xchart.QuickChart;
import problemGraph.problems.*;

public class Tester {
    public static void main(String[] args) {
//        Problem p = new GraphPartitioning();
//        LocalSearch localSearch = new SimulatedAnnealing(CoolingScheduler.reversi);
//        localSearch.run(p);
//        System.out.println("best state: " +     localSearch.getBestState());
//        System.out.println("fitness: " + p.objectiveFunction(localSearch.getBestState()));
//        System.out.println("expanded states number: " + localSearch.expandedStatesNumber + ", visited states number: " + localSearch.visitedStatesNumber);

        GeneticProblem gp = new MathematicalEquality();
        GeneticAlgorithm ga = new GeneticAlgorithm(500000, 10, .25, .1);
        ga.run(gp);
        System.out.println(ga.getBest());
        ga.drawDiagram();
    }
}