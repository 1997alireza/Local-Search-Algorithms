package problemGraph.problems;
import problemGraph.State;

import java.util.ArrayList;
import java.util.Arrays;

public class EightQueen extends Problem {

    public EightQueen() {
    }

    @Override
    public State getInitialState() {
        return getRandomState();
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
        return -1 * confNum;
    }

    @Override
    public State getRandomState() {
        int [] qp = new int[8];
        for(int i = 0; i < 8; i++)
            qp[i] = (int)(Math.random() * 8);
        return new PState(qp);
    }

    private class PState extends State {
        int queenPlaces[];
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
        public State getRandomNeighbor() {
            int i = (int) (Math.random() * 8);
            int d = (int) (Math.random() * 7) + 1;
            queenPlaces[i] = (queenPlaces[i] + d) % 8;
            PState returnValue = new PState(queenPlaces);
            queenPlaces[i] = (queenPlaces[i] - d + 8) % 8;
            return returnValue;
        }

        @Override
        public String toString() {
            return Arrays.toString(queenPlaces);
        }
    }

}
