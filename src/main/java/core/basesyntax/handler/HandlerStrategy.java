package core.basesyntax.handler;

import java.util.HashMap;

public interface HandlerStrategy {
    void strategy(String[] info, HashMap<String, Integer> storage);
}
