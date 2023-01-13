package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.ParseService;
import core.basesyntax.service.ProcessDataService;
import core.basesyntax.strategy.OperationStrategy;
import core.basesyntax.strategy.impl.OperationStrategyImpl;
import core.basesyntax.strategy.operationhandler.OperationHandler;
import java.util.List;
import java.util.Map;

public class ProcessDataServiceImpl implements ProcessDataService {
    private static final int DATA_START_INDEX = 1;
    private static final ParseService<FruitTransaction> fruitTransactionParseService
            = new FruitTransactionParseService();

    @Override
    public void processData(List<String> data, Map<FruitTransaction.Operation,
            OperationHandler> operationHandlerMap) {
        OperationStrategy operationStrategy
                = new OperationStrategyImpl(operationHandlerMap);
        for (String line : data.subList(DATA_START_INDEX, data.size())) {
            FruitTransaction fruitTransaction = fruitTransactionParseService.parse(line);
            OperationHandler operationHandler
                    = operationStrategy.getHandler(fruitTransaction.getOperation());
            operationHandler.handle(fruitTransaction);
        }
    }
}
