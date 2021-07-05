package core.basesyntax.service;

import core.basesyntax.dto.OperationType;
import core.basesyntax.dto.Transaction;
import core.basesyntax.strategy.OperationHandler;
import java.util.List;
import java.util.Map;

public interface FruitService {
    void addTransaction(Map<OperationType, OperationHandler> handlerMap,
                        List<Transaction> transactionList);
}
