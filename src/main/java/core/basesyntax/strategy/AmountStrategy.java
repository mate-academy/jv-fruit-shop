package core.basesyntax.strategy;

public interface AmountStrategy {
    AmountHandler get(String operationCode);
}
