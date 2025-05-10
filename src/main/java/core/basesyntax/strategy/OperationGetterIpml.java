package core.basesyntax.strategy;

import core.basesyntax.model.Transaction;
import core.basesyntax.transactionsservice.OperationHandler;
import java.util.Map;

public class OperationGetterIpml implements OperationGetter {
    private final Map<Transaction.TransactionType, OperationHandler> proceederGetterMap;

    public OperationGetterIpml(Map<Transaction.TransactionType,
            OperationHandler> proceederGetterMap) {
        this.proceederGetterMap = proceederGetterMap;
    }

    @Override
    public OperationHandler getOperation(Transaction transaction) {
        return proceederGetterMap.get(transaction.getTransactionType());
    }
}
