package core.basesyntax.serviceImp;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.ProcessData;
import core.basesyntax.strategy.OperationStrategy;
import java.util.List;

public class ProcessDataImp implements ProcessData {
    private static OperationStrategy operationStrategy;

    public ProcessDataImp(OperationStrategy operationStrategy) {
        this.operationStrategy = operationStrategy;
    }

    @Override
    public void operation(List<FruitTransaction> fruitTransactions) {
        fruitTransactions.forEach(
                fruitTransaction -> operationStrategy.getOperation(fruitTransaction.getOperation()).operation(fruitTransaction)
        );
    }
}
