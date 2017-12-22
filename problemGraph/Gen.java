package problemGraph;

public abstract class Gen {
    public abstract String toString();
    public abstract Gen clone();
    public abstract Gen mutation();
}
