package core.basesyntax.models.activities;

public class PurchaseActivityHandler implements ActivityHandler {

    @Override
    public Integer apply(Integer currentQuantity, Integer operationQuantity) {
        int result = currentQuantity - operationQuantity;
        validatePositiveResult(result);
        return result;
    }
}
