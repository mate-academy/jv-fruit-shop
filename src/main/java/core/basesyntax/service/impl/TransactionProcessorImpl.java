package core.basesyntax.service.impl;

import core.basesyntax.Main;
import core.basesyntax.service.TransactionProcessor;
import core.basesyntax.strategy.OperationHandler;
import java.util.List;
import java.util.Map;

public class TransactionProcessorImpl implements TransactionProcessor {
    private static final int FRUIT_OPERATION_INDEX = 0;
    private static final int FRUIT_INDEX = 1;
    private static final int FRUIT_QUANTITY_INDEX = 2;

    @Override
    public void process(List<String> transaction) {
        for (int i = 1; i < transaction.size(); i++) {
            String[] splittedLine = transaction.get(i).split(",");
            for (Map.Entry<String, OperationHandler> entry : Main
                    .getOperationHandlerMap().entrySet()) {
                if (entry.getKey().equals(splittedLine[FRUIT_OPERATION_INDEX])) {
                    entry.getValue().handle(splittedLine[FRUIT_INDEX],
                            Integer.parseInt(splittedLine[FRUIT_QUANTITY_INDEX]));
                }
            }
        }
    }
}
