package core.basesyntax.serviceimpl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.model.Operation;
import core.basesyntax.service.DataProcessorService;
import core.basesyntax.strategy.OperationStrategy;
import java.util.HashMap;
import java.util.List;

public class DataProcessorServiceImpl implements DataProcessorService {
    private final HashMap<Operation, OperationStrategy> handlerMap;

    public DataProcessorServiceImpl(HashMap<Operation, OperationStrategy> handlerMap) {
        this.handlerMap = handlerMap;
    }

    @Override
    public void processData(List<FruitTransaction> fruitTransactions) {
        fruitTransactions.forEach(t -> handlerMap.get(t.getOperation())
                .processTransaction(t));
    }
}
