package core.basesyntax.service.serviceimpl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.ProcessService;
import core.basesyntax.strategy.OperationStrategy;
import java.util.List;

public class ProcessServiceImpl implements ProcessService {
    public void processTransactions(List<FruitTransaction> fruitTransactionList) {
        OperationStrategy operationStrategy = new OperationStrategy();
        for (FruitTransaction fruitTransaction: fruitTransactionList) {
            operationStrategy.implementOperationStrategy(fruitTransaction);
        }
    }
}
