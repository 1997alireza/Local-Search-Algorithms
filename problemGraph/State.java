package problemGraph;
import java.util.ArrayList;

public abstract class State {
    public State(){
    }
    public abstract ArrayList<State> getNeighbors();
    public abstract State getRandomNeighbor();
    public abstract String toString();
}
