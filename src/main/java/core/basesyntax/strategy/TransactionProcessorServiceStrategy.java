package core.basesyntax.strategy;

import core.basesyntax.db.FruitDb;
import core.basesyntax.model.Transaction.Operation;
import core.basesyntax.service.TransactionProcessorService;
import core.basesyntax.service.impl.IncomingTransactionProcessorService;
import core.basesyntax.service.impl.OutgoingTransactionProcessorService;
import java.util.HashMap;
import java.util.Map;

public class TransactionProcessorServiceStrategy {
    private final Map<Operation, TransactionProcessorService> map = new HashMap<>();

    public TransactionProcessorServiceStrategy(FruitDb db) {
        TransactionProcessorService incoming = new IncomingTransactionProcessorService(db);

        map.put(Operation.BALANCE, incoming);
        map.put(Operation.SUPPLY, incoming);
        map.put(Operation.RETURN, incoming);
        map.put(Operation.PURCHASE, new OutgoingTransactionProcessorService(db));
    }

    public TransactionProcessorService get(Operation operation) {
        TransactionProcessorService service = map.get(operation);

        if (service == null) {
            throw new RuntimeException("Undefined transaction processor service for "
                    + "operation '" + operation + "'.");
        }

        return service;
    }
}
