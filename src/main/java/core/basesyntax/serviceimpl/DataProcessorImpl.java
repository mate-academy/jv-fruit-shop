package core.basesyntax.serviceimpl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.model.Operation;
import core.basesyntax.service.DataProcessor;
import core.basesyntax.strategy.OperationStrategy;
import java.util.HashMap;
import java.util.List;

public class DataProcessorImpl implements DataProcessor {
    private final HashMap<Operation, OperationStrategy> handlerMap;

    public DataProcessorImpl(HashMap<Operation, OperationStrategy> handlerMap) {
        this.handlerMap = handlerMap;
    }

    @Override
    public void processData(List<FruitTransaction> fruitTransactions) {
        fruitTransactions.forEach(t -> handlerMap.get(t.getOperation())
                .processTransaction(t));
    }
}
