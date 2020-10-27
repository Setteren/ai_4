package operation;
import java.util.List;


public interface Constraint {
    public List<String> getScope();


    <E> boolean isConsistent(Assignment<E> assignment);
}