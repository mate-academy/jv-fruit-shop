package core.basesyntax.strategy;

import java.util.Map;

public class FruitsTransactionStrategyImpl implements FruitsTransactionStrategy {
    private final Map<String, FruitHandler> fruitHandlerMap;

    public FruitsTransactionStrategyImpl(Map<String, FruitHandler> fruitHandlerMap) {
        this.fruitHandlerMap = fruitHandlerMap;
    }

    @Override
    public FruitHandler fruitHandler(String transactionType) {
        return fruitHandlerMap.get(transactionType);
    }
}
