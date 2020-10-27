package operation;

public interface CSPSolver {

    public <E> CSPResult<E> solve(CSP<E> csp, int i);

}