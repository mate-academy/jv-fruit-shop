package core.basesyntax.strategy.operation;

public class SupplyOperationHandler implements OperationHandler {
    @Override
    public Integer updateBalance(Integer balance, Integer value) {
        if (value < 0) {
            throw new RuntimeException(String.format("Buyers will not be able to buy %s units. "
                    + "%s is incorrect input.", value, value));
        }
        return balance + value;
    }
}
