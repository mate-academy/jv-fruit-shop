package strategy;

import java.util.Map;
import model.FruitTransaction;
import strategy.handler.Handler;

public class HandlersStore {
    private Map<FruitTransaction.Operation,Handler> strategy;

    public HandlersStore(Map<FruitTransaction.Operation, Handler> strategy) {
        this.strategy = strategy;
    }

    public Map<FruitTransaction.Operation, Handler> getStrategy() {
        return strategy;
    }
}
