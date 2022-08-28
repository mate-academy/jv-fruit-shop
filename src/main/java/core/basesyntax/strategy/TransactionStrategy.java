package core.basesyntax.strategy;

public interface TransactionStrategy {
    AmountHandler get(String operationCode);
}
