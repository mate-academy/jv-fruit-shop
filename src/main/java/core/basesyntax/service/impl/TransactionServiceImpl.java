package core.basesyntax.service.impl;

import core.basesyntax.database.Storage;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.OperationHandler;
import core.basesyntax.service.TransactionService;
import java.util.List;
import java.util.Map;

public class TransactionServiceImpl implements TransactionService {
    private final Map<FruitTransaction.Operation, OperationHandler> operationHandlerMap;

    public TransactionServiceImpl(Map<FruitTransaction.Operation,
            OperationHandler> operationHandlerMap) {
        this.operationHandlerMap = operationHandlerMap;
    }

    @Override
    public void handleTransaction(List<FruitTransaction> transactions) {
        for (FruitTransaction fruitTransaction : transactions) {
            if (!Storage.storage.containsKey(fruitTransaction.getFruit())) {
                Storage.storage.put(fruitTransaction.getFruit(), fruitTransaction.getQuantity());
            } else {
                int balance = Storage.storage.get(fruitTransaction.getFruit());
                Storage.storage.put(fruitTransaction.getFruit(),
                        operationHandlerMap.get(fruitTransaction.getOperation())
                                .operate(balance, fruitTransaction.getQuantity()));
            }
        }
    }
}
