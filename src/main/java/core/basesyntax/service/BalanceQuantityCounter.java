package core.basesyntax.service;

public class BalanceQuantityCounter implements QuantityCounter {
    @Override
    public int count(int startQuantity, int operationQuantity) {
        return startQuantity + operationQuantity;
    }
}
