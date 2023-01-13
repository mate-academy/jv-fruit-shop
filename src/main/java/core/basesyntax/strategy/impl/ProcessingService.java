package core.basesyntax.strategy.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.services.OperationHandler;
import core.basesyntax.services.OperationStrategy;
import core.basesyntax.services.impl.FruitTransactionParserImpl;
import core.basesyntax.services.impl.OperationStrategyImpl;
import java.util.List;
import java.util.Map;

public class ProcessingService {
    public void process(List<String> dateFromFile, Map<FruitTransaction.Operation,
            OperationHandler> operationHandlersMap) {
        FruitTransactionParserImpl parser = new FruitTransactionParserImpl();
        List<FruitTransaction> fruitTransactionsList =
                parser.getFruitTransactionsList(dateFromFile);

        OperationStrategy operationStrategy = new OperationStrategyImpl(operationHandlersMap);

        for (FruitTransaction fruitTransaction : fruitTransactionsList) {
            OperationHandler handler = operationStrategy
                    .get(fruitTransaction.getOperation());
            handler.operate(fruitTransaction);
        }
    }
}
