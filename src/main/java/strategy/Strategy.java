package strategy;

import java.util.HashMap;
import java.util.Map;

public class Strategy {
    public Map<String, FruitStrategy> strategyMap = new HashMap<>();

    public Strategy(Map<String, FruitStrategy> strategyMap) {
        this.strategyMap = strategyMap;
    }
}
