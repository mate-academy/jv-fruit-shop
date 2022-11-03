package core.basesyntax.handler;

import java.util.HashMap;

public interface Purchase {
    void purchase(String[] info, HashMap<String,Integer> storage);
}
