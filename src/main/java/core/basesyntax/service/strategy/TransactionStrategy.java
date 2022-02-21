package core.basesyntax.service.strategy;

public interface TransactionStrategy {
    TransactionHandler get(String operation);
}
