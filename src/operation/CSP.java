package operation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class CSP<E> {
    public List<String> variables; // The set of variables
    public Map<String, List<E>> domains; // A mapping of variables to their domains
    public List<Constraint> constraints; // The constraints that define the csp


    public CSP() {
        variables = new ArrayList<String>();
        domains = new HashMap<String, List<E>>();
        constraints = new ArrayList<Constraint>();
    }


    public boolean isConsistent(Assignment<E> assignment) {
        for(Constraint i:constraints){
            if(!i.isConsistent(assignment)){
                return false;
            }
        }
        return true;
    }
}