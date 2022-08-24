package core.basesyntax.process;

import core.basesyntax.DataBase;
import core.basesyntax.FruitTransaction;
import core.basesyntax.strategy.OperationStrategy;
import core.basesyntax.strategy.OperationStrategyImpl;

public class ProcessDataImpl implements ProcessData {
    private OperationStrategy operationStrategy = new OperationStrategyImpl();

    @Override
    public void processingData() {
        for (FruitTransaction data : DataBase.transitions) {
            operationStrategy.get(data.getOperation())
                    .processingOperation(data.getFruit(),data.getQuantity());
        }
    }
}
