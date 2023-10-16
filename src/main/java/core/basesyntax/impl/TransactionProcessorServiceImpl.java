package core.basesyntax.impl;

import core.basesyntax.handler.TransactionHandler;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.model.Operation;
import core.basesyntax.service.TransactionProcessorService;
import java.util.List;
import java.util.Map;

public class TransactionProcessorServiceImpl implements TransactionProcessorService {
    private final Map<Operation, TransactionHandler> processedStoreHanler;

    public TransactionProcessorServiceImpl(
            Map<Operation, TransactionHandler> processedStoreHanler) {
        this.processedStoreHanler = processedStoreHanler;
    }

    @Override
    public void proccessing(List<FruitTransaction> fruitTransactionsList) {
        for (FruitTransaction fruitTransaction : fruitTransactionsList) {
            processedStoreHanler.get(fruitTransaction.getTransaction()).apply(fruitTransaction);
        }
    }
}
