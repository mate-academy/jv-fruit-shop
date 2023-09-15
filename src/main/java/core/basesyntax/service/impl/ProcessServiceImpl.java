package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.model.Operation;
import core.basesyntax.service.ProcessService;
import core.basesyntax.strategy.OperationHandler;
import core.basesyntax.strategy.impl.BalanceOperationHandler;
import core.basesyntax.strategy.impl.PurchaseOperationHandler;
import core.basesyntax.strategy.impl.ReturnOperationHandler;
import core.basesyntax.strategy.impl.SupplyOperationHandler;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProcessServiceImpl implements ProcessService {

    private Map<Operation, OperationHandler> operations;

    public ProcessServiceImpl() {
        operations = new HashMap<>();
        operations.put(Operation.BALANCE, new BalanceOperationHandler());
        operations.put(Operation.PURCHASE,new PurchaseOperationHandler());
        operations.put(Operation.RETURN, new ReturnOperationHandler());
        operations.put(Operation.SUPPLY, new SupplyOperationHandler());
    }

    public ProcessServiceImpl(Map<Operation, OperationHandler> operations) {
        this.operations = operations;
    }

    public void manageTransactions(List<FruitTransaction> transactions) {
        transactions.forEach(t -> operations.get(t.getOperation()).handleTransaction(t));
    }
}
