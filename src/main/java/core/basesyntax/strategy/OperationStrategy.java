package core.basesyntax.strategy;

public interface OperationStrategy {
    int calculateQuantity(int quantityBefore, int quantityCurrent);

    int putPreviousPeriodQuantity(int quantity);
}
