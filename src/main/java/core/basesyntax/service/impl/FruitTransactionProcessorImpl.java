package core.basesyntax.service.impl;

import core.basesyntax.service.FruitTransactionProcessor;
import core.basesyntax.strategy.FruitHandler;
import java.util.List;
import java.util.Map;

public class FruitTransactionProcessorImpl implements FruitTransactionProcessor {
    private static final int INDEX_OF_OPERATION = 0;
    private static final int INDEX_OF_FRUIT = 1;
    private static final int INDEX_OF_AMOUNT = 2;
    private final Map<String, FruitHandler> handlersMap;

    public FruitTransactionProcessorImpl(Map<String, FruitHandler> handlersMap) {
        this.handlersMap = handlersMap;
    }

    public void process(List<String> lines) {
        lines.remove(0);
        for (String unhandledFruit : lines) {
            String[] currentLine = unhandledFruit.split(",");
            if (!handlersMap.containsKey(currentLine[INDEX_OF_OPERATION])) {
                throw new RuntimeException("Inappropriate operation");
            }
            FruitHandler fruitHandler = handlersMap.get(currentLine[INDEX_OF_OPERATION]);
            fruitHandler.handle(currentLine[INDEX_OF_FRUIT],
                    Integer.parseInt(currentLine[INDEX_OF_AMOUNT]));
        }
    }
}
