package core.basesyntax.models.activities;

public class BalanceActivityHandler implements ActivityHandler {

    @Override
    public Integer apply(Integer currentQuantity, Integer operationQuantity) {
        return Integer.sum(currentQuantity, operationQuantity);
    }
}
