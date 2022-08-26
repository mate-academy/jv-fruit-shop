package core.basesyntax.process;

import core.basesyntax.FruitTransaction;
import core.basesyntax.lib.Injector;
import core.basesyntax.strategy.OperationStrategy;
import core.basesyntax.strategy.OperationStrategyImpl;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProcessDataImpl implements ProcessData {
    @Override
    public Map<String, Integer> processingData(List<FruitTransaction> transactions) {
        Injector injector = new Injector().getInjector();
        OperationStrategy operationStrategy =
                (OperationStrategy) injector.getInstance(OperationStrategyImpl.class);

        Map<String, Integer> values = new HashMap<>();
        for (FruitTransaction data : transactions) {
            operationStrategy.get(data.getOperation())
                    .processingOperation(data.getFruit(),data.getQuantity(), values);
        }
        return values;
    }
}
