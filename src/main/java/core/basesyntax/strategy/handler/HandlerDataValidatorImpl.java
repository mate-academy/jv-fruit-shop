package core.basesyntax.strategy.handler;

public class HandlerDataValidatorImpl implements HandlerDataValidator {

    @Override
    public void checkNull(String fruit) {
        if (fruit == null) {
            throw new RuntimeException("Fruit cannot be null");
        }
    }

    @Override
    public void checkNegative(int quantity) {
        if (quantity < 0) {
            throw new RuntimeException("Quantity cannot be less than zero" + quantity);
        }
    }
}
