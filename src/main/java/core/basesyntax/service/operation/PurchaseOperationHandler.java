package core.basesyntax.service.operation;

public class PurchaseOperationHandler implements OperationHandler {
    @Override
    public Integer updateBalance(Integer balance, Integer value) {
        if (value > balance) {
            throw new RuntimeException(String.format("Buyers will not be able to buy %s units, "
                    + "because they are only %s units in stock.", value, balance));
        }
        return balance - value;
    }
}
