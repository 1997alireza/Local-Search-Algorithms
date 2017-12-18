package problemGraph.problems;
import problemGraph.State;

import java.util.ArrayList;
import java.util.Arrays;

public class EightQueen extends Problem {

    public EightQueen() {
    }

    @Override
    public State getInitialState() {
        int [] initialS = new int[8];
        for(int i = 0; i < 8; i++)
            initialS[i] = (int)(Math.random() * 8);
        return new PState(initialS);
    }

    @Override
    public double objectiveFunction(State s) {
        PState ps = (PState)s;
        int confNum = 0;
        for(int i = 0; i < 8; i++){
            for(int j = i+1; j < 8; j++){
                int pi = ps.queenPlaces[i];
                int pj = ps.queenPlaces[j];
                if(pi == pj || pi-pj == i-j || pi-pj == j-i)
                    confNum++;
            }
        }
        return confNum;
    }


    private class PState extends State {
        int queenPlaces[];
        public PState(int p0, int p1, int p2, int p3, int p4, int p5, int p6, int p7){
            queenPlaces = new int[]{p0, p1, p2, p3, p4, p5, p6, p7};
        }
        private PState(int [/*8*/] queenPlaces){
            this.queenPlaces = new int[8];
            System.arraycopy(queenPlaces, 0, this.queenPlaces, 0, 8);
        }
        @Override
        public ArrayList<State> getNeighbors() {
            ArrayList<State> neighborStates = new ArrayList<>();
            for(int i = 0; i < 8; i++){
                for(int d = 1; d < 8; d++){
                    this.queenPlaces[i] = (this.queenPlaces[i] + d) % 8;
                    neighborStates.add(new PState(this.queenPlaces));
                    this.queenPlaces[i] = (this.queenPlaces[i] - d + 8) % 8;
                }
            }
            return neighborStates;
        }

        @Override
        public String toString() {
            return Arrays.toString(queenPlaces);
        }
    }

}
