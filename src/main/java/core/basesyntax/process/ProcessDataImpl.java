package core.basesyntax.process;

import core.basesyntax.FruitTransaction;
import core.basesyntax.strategy.OperationStrategy;
import core.basesyntax.strategy.OperationStrategyImpl;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProcessDataImpl implements ProcessData {
    private OperationStrategy operationStrategy;

    public void setOperationStrategy(OperationStrategy operationStrategy) {
        this.operationStrategy = operationStrategy;
    }

    @Override
    public Map<String, Integer> processingData(List<FruitTransaction> transactions) {
        setOperationStrategy(new OperationStrategyImpl());
        Map<String, Integer> values = new HashMap<>();
        for (FruitTransaction data : transactions) {
            operationStrategy.get(data.getOperation())
                    .processingOperation(data.getFruit(),data.getQuantity(), values);
        }
        return values;
    }
}
