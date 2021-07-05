package core.basesyntax.service.strategy;

public interface StrategySupplier {
    OperationStrategy getStrategy(String operation);
}
