package core.basesyntax.models.activities;

public class PurchaseActivityHandler implements ActivityHandler {

    @Override
    public Integer apply(Integer integer, Integer integer2) {

        return Math.abs(integer - integer2);
    }
}
