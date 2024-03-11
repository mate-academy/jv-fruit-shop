package core.basesyntax.strategy.transaction;

public class SupplyTransactionHandler implements TransactionHandler {

    @Override
    public int getTransaction(int oldQuantity, int transactionQuantity) {
        return oldQuantity + transactionQuantity;
    }
}
