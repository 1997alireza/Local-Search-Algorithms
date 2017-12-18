import algorithms.FirstChoiceHC;
import algorithms.LocalSearch;
import algorithms.RandomRestartHC;
import problemGraph.problems.EightQueen;
import problemGraph.problems.Problem;

public class Tester {
    public static void main(String[] args) {
        Problem p = new EightQueen();
        LocalSearch localSearch = new RandomRestartHC();
        localSearch.run(p);
        System.out.println(localSearch.getBestState());
        System.out.println(p.objectiveFunction(localSearch.getBestState()));
    }
}