package core.basesyntax.service;

public class ReturnQuantityCounter implements QuantityCounter {
    @Override
    public int count(int startQuantity, int operationQuantity) {
        return startQuantity + operationQuantity;
    }
}
