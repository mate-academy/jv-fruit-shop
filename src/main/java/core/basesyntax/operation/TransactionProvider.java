package core.basesyntax.operation;

public interface TransactionProvider {
    Transaction.Operation get(String operation);
}
