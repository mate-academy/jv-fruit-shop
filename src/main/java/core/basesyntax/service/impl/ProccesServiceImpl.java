package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.model.Operation;
import core.basesyntax.service.ProccessService;
import core.basesyntax.strategy.OperationService;
import java.util.List;
import java.util.Map;

public class ProccesServiceImpl implements ProccessService {
    private final Map<Operation, OperationService> processedStoreHanler;

    public ProccesServiceImpl(Map<Operation, OperationService> processedStoreHanler) {
        this.processedStoreHanler = processedStoreHanler;
    }

    @Override
    public void proccessing(List<FruitTransaction> fruitTransactionsList) {
        for (FruitTransaction fruitTransaction : fruitTransactionsList) {
            processedStoreHanler.get(fruitTransaction.getOperation()).doOperation(fruitTransaction);
        }
    }
}
