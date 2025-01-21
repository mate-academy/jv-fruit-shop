package core.basesyntax.models.activities;

public class PurchaseActivityHandler implements ActivityHandler {

    @Override
    public Integer apply(Integer integer, Integer integer2) {

        return integer > integer2 ? integer - integer2 : integer2 - integer;
    }
}
