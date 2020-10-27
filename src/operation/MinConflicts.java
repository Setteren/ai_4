package operation;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MinConflicts implements CSPSolver {

    @Override
    public <E> CSPResult<E> solve(CSP<E> csp, int i) {

        int maxSteps=250;
        return minConflicts(csp,maxSteps);
    }


    private static <E> CSPResult<E> minConflicts(CSP<E> csp, int maxSteps) {
        Assignment<E> current = createCompleteAssignment(csp);
        int iterations=1;
        for(int i=1; i<=maxSteps; i++){
            if(current.isComplete(csp) && csp.isConsistent(current)){
                break;
            }
            String var = getRandomConflictedVariable(current, csp);
            E value = null;
            int min=1000;
            for(E k:csp.domains.get(var)){
                int num=conflicts(var, k, current, csp);
                if(num<min && k!=current.get(var)){
                    min=num;
                    value=k;
                }
            }
            current.put(var,value);
            iterations++;
        }
        if(!csp.isConsistent(current)) {
            current=null;
        }
        return new CSPResult(current,iterations);


    }


    private static <E> String getRandomConflictedVariable(Assignment<E> current, CSP<E> csp) {
        Random rand = new Random();
        List<String> conflicted = new ArrayList<String>();
        for(Constraint i:csp.constraints){
            if(!i.isConsistent(current)){
                for(String j:i.getScope()){
                    if(!conflicted.contains(j)){
                        conflicted.add(j);
                    }
                }
            }
        }
        int randpos = rand.nextInt(conflicted.size());
        return conflicted.get(randpos);

    }


    private static <E> Assignment<E> createCompleteAssignment(CSP<E> csp) {
        Random rand = new Random();
        Assignment<E> assignment = new Assignment<E>();
        for(String i:csp.variables){
            int randValue = rand.nextInt(csp.domains.get(i).size());
            assignment.put(i,csp.domains.get(i).get(randValue));
        }

        return assignment;
    }


    private static <E> int conflicts(String var, E value, Assignment<E> current, CSP<E> csp) {
        E originalValue = current.get(var);
        current.put(var,value);
        int conflicts=0;
        for (Constraint k:csp.constraints){
            if(!k.isConsistent(current)) {
                conflicts++;
            }
        }

        current.put(var,originalValue);


        return conflicts;
    }
}