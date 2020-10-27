package operation;

public class CSPResult<E> {
    public Assignment<E> assignment;
    public int iterations;

    public CSPResult(Assignment<E> assignment, int iterations) {
        this.assignment = assignment;
        this.iterations = iterations;
    }

    public String toString() {
        String result = new String();
        result = "Iterations: " + iterations + "\n";
        result += assignment.toString();
        return result;
    }
}