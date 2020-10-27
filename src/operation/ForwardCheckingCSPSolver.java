package operation;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


public class ForwardCheckingCSPSolver extends CSPAlgorithms {


    public static <E> Inference<E> inference(CSP<E> csp, Assignment<E> assignment, String var, E value) {
        Inference<E> inference = new Inference<E>();
        List<String> neighbores = new ArrayList<String>();
        for (Constraint i:csp.constraints){
            List<String> constraint = i.getScope();
            for(String j:constraint){
                if(j.equals(var)){
                    neighbores.addAll(constraint);
                }
            }
        }
        for(String i:neighbores){
            if(!assignment.containsKey(i)){
                List<E> domain=csp.domains.get(i);
                int size=domain.size();
                Set<E> inconsistent = new HashSet<>();
                for(E j:domain){
                    if(size==1 && j.equals(value)){
                        return null;
                    }
                    if(j.equals(value)){
                        inconsistent.add(j);
                    }
                }
                inference.put(i,inconsistent);
            }
        }
        return inference;
    }
}