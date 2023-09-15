package core.basesyntax.model.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.model.Operation;
import core.basesyntax.model.handler.OperationHandler;
import core.basesyntax.model.handler.impl.BalanceOperationHandler;
import core.basesyntax.model.handler.impl.PurchaseOperationHandler;
import core.basesyntax.model.handler.impl.ReturnOperationHandler;
import core.basesyntax.model.handler.impl.SupplyOperationHandler;
import core.basesyntax.model.service.OperatorService;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OperatorServiceImpl implements OperatorService {
    private static final Map<Operation, OperationHandler> OPERATION_MAP;

    static {
        OPERATION_MAP = new HashMap<>();
        OPERATION_MAP.put(Operation.BALANCE, new BalanceOperationHandler());
        OPERATION_MAP.put(Operation.PURCHASE, new PurchaseOperationHandler());
        OPERATION_MAP.put(Operation.SUPPLY, new SupplyOperationHandler());
        OPERATION_MAP.put(Operation.RETURN, new ReturnOperationHandler());
    }

    @Override
    public void operateTransactions(List<FruitTransaction> transactions) {
        transactions.forEach(transaction
                -> OPERATION_MAP.get(transaction.getOperation())
                .handleOperation(transaction));
    }
}
