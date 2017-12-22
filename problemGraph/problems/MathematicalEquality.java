package problemGraph.problems;

import problemGraph.Chromosome;
import problemGraph.Gen;

public class MathematicalEquality extends GeneticProblem {
    private int[] factors;
    private int result;
    public MathematicalEquality(int[] factors, int result){
        this.factors = factors;
        this.result = result;
    }
    public MathematicalEquality(){
        this.factors = new int[]{1, 2, 3, 4};
        this.result = 40;
    }

    @Override
    public Chromosome[] getInitialChromosomes(int number) {
        Chromosome[] initialChromosomes = new Chromosome[number];
        Gen[] initialGens = new Gen[factors.length];
        for(int i = 0; i < factors.length; i++){
            initialGens[i] = new MathGen(0);
        }
        for(int i = 0; i < number; i++){
            Gen[] randomGens = new Gen[initialGens.length];
            for(int j = 0; j < randomGens.length; j++){
                randomGens[j] = initialGens[j].clone().mutation();
            }
            initialChromosomes[i] = new Chromosome(randomGens);
        }

        return initialChromosomes;
    }

    @Override
    public double objectiveFunction(Chromosome c) {
        int v = 0;
        for(int i = 0; i < factors.length; i++){
            v += factors[i] * ((MathGen)c.gens[i]).value;
        }
        v -= result;
        return Math.abs(v);
    }

    @Override
    public double fitness(double objective) {
        return 1.0 / (1 + objective);
    }

    private class MathGen extends Gen {
        int value;
        public MathGen(int value){
            this.value = value;
        }

        @Override
        public String toString() {
            return Integer.toString(value);
        }

        @Override
        public Gen clone() {
            return new MathGen(value);
        }

        @Override
        public Gen mutation() {
            this.value = (int)(Math.random() * result);
            return this;
        }
    }
}
