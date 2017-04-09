package namor.template.main;

import java.util.HashMap;
import java.util.Map;

public class MapBasedStack {

    private int top;
    private Map<Integer, Integer> storage;

    public MapBasedStack() {
        storage = new HashMap<Integer, Integer>();
    }

    public boolean isEmpty() {
        return top == 0;
    }


}
