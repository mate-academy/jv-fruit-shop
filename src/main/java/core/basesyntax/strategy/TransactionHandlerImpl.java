package core.basesyntax.strategy;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.impl.TransactionRecord;
import java.util.Map;

public class TransactionHandlerImpl implements TransactionHandler {
    private Map<FruitTransaction.Operation, TransactionRecord> transactionRecordMap;

    public TransactionHandlerImpl(Map<FruitTransaction.Operation,
            TransactionRecord> transactionRecordMap) {
        this.transactionRecordMap = transactionRecordMap;
    }

    @Override
    public TransactionRecord get(FruitTransaction.Operation operation) {
        return transactionRecordMap.get(operation);
    }
}
