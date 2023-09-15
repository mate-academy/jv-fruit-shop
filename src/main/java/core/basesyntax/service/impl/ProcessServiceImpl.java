package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.model.Operation;
import core.basesyntax.service.ProcessService;
import core.basesyntax.strategy.OperationHandler;
import java.util.List;
import java.util.Map;

public class ProcessServiceImpl implements ProcessService {

    private Map<Operation, OperationHandler> operations;

    public ProcessServiceImpl(Map<Operation, OperationHandler> operations) {
        this.operations = operations;
    }

    public void manageTransactions(List<FruitTransaction> transactions) {
        transactions.forEach(t -> operations.get(t.getOperation()).handleTransaction(t));
    }
}
