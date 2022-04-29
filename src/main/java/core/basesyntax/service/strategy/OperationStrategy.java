package core.basesyntax.service.strategy;

public interface OperationStrategy {
    OperationHandler get(String operations);
}
