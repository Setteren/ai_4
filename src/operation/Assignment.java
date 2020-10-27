package operation;

import java.util.HashMap;


@SuppressWarnings("serial")
public class Assignment<E> extends HashMap<String, E> {


    public boolean isComplete(CSP<E> csp) {
        for(String i:csp.variables){
            if(!containsKey(i)){
                return false;
            }
        }

        return true;
    }
}