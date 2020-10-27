package operation;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;


@SuppressWarnings("serial")
public class Inference<E> extends HashMap<String, Set<E>> {

    public void reduceDomain(CSP<E> csp) {
        for(Map.Entry<String, Set<E>> i : this.entrySet()) {
            csp.domains.get(i.getKey()).removeAll(i.getValue());
        }
    }

    public void restoreDomain(CSP<E> csp) {
        for(Map.Entry<String, Set<E>> i : this.entrySet()) {
            csp.domains.get(i.getKey()).addAll(i.getValue());
        }
    }
}