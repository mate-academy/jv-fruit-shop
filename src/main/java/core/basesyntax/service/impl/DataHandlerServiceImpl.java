package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.DataHandlerService;
import core.basesyntax.strategy.OperationProcessingStrategy;
import java.util.List;
import java.util.function.Consumer;

public class DataHandlerServiceImpl implements DataHandlerService {
    private OperationProcessingStrategy processingStrategy;

    public DataHandlerServiceImpl(OperationProcessingStrategy processingStrategy) {
        this.processingStrategy = processingStrategy;
    }

    @Override
    public void handleData(List<FruitTransaction> fruitTransactions) {
        Consumer<FruitTransaction> consumer = transaction
                -> processingStrategy.get(transaction.getOperation())
                .doAction(transaction.getFruit(), transaction.getAmount());
        fruitTransactions.forEach(consumer);
    }
}
