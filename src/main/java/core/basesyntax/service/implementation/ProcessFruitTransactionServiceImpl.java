package core.basesyntax.service.implementation;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.FruitTransactionService;
import core.basesyntax.service.OperationStrategyService;
import core.basesyntax.service.ProcessFruitTransactionService;
import java.util.List;

public class ProcessFruitTransactionServiceImpl implements ProcessFruitTransactionService {
    private final FruitTransactionService fruitTransactionService;
    private final OperationStrategyService operationStrategyService;

    public ProcessFruitTransactionServiceImpl(FruitTransactionService fruitTransactionService,
                                              OperationStrategyService operationStrategyService) {
        this.fruitTransactionService = fruitTransactionService;
        this.operationStrategyService = operationStrategyService;
    }

    @Override
    public void processFruitTransaction(List<String> inputLines) {
        for (String inputLine : inputLines) {
            FruitTransaction fruitTransaction = fruitTransactionService
                    .createFruitTransaction(inputLine);
            operationStrategyService.applyOperationStrategy(fruitTransaction);
        }
    }
}
