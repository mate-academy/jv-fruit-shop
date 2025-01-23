package core.basesyntax.models.activities;

public class PurchaseActivityHandler implements ActivityHandler {

    @Override
    public Integer apply(Integer currentQuantity, Integer operationQuantity) {
        int result = currentQuantity - operationQuantity;
        if (result < 0) {
            return currentQuantity;
        }
        return currentQuantity - operationQuantity;
    }
}
