package com.basesyntax.services.impl;

import com.basesyntax.model.Fruit;
import com.basesyntax.services.TransactionProcessor;
import com.basesyntax.strategy.impl.StrategyImpl;
import java.util.List;

public class TransactionProcessorImpl implements TransactionProcessor {
    private static final int OPERATION_TYPE = 0;
    private static final int REDUNDANT_LINE = 0;
    private static final int FRUIT_NAME = 1;
    private static final int COUNT = 2;
    private static final String SEPARATOR = ",";

    @Override
    public void processingData(List<String> data, StrategyImpl strategy) {
        data.remove(REDUNDANT_LINE);
        for (String currentLine : data) {
            String[] strings = currentLine.split(SEPARATOR);
            strategy.getStrategyType(strings[OPERATION_TYPE])
                    .apply(new Fruit(strings[FRUIT_NAME]), Integer.parseInt(strings[COUNT]));
        }
    }
}
