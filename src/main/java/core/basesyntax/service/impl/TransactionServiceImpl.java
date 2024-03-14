package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.operationhandlers.AddHandler;
import core.basesyntax.operationhandlers.OperationHandler;
import core.basesyntax.operationhandlers.ReplaceHandler;
import core.basesyntax.operationhandlers.SubtractHandler;
import core.basesyntax.service.TransactionService;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TransactionServiceImpl implements TransactionService {
    public static final Map<FruitTransaction.Operation, OperationHandler> HANDLER_MAP
            = new HashMap<>();

    public TransactionServiceImpl() {
        HANDLER_MAP.put(FruitTransaction.Operation.BALANCE, new AddHandler());
        HANDLER_MAP.put(FruitTransaction.Operation.PURCHASE, new SubtractHandler());
        HANDLER_MAP.put(FruitTransaction.Operation.RETURN, new ReplaceHandler());
        HANDLER_MAP.put(FruitTransaction.Operation.SUPPLY, new ReplaceHandler());
    }

    @Override
    public void distribute(List<FruitTransaction> list) {
        for (FruitTransaction fruitTransaction : list) {
            if (fruitTransaction == null) {
                throw new RuntimeException("Transaction is null");
            }
            OperationHandler handler = HANDLER_MAP.get(fruitTransaction.getOperation());
            handler.handle(fruitTransaction);
        }
    }
}
