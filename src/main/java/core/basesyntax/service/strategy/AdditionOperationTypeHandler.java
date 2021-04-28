package core.basesyntax.service.strategy;

public class AdditionOperationTypeHandler implements TypeHandler {
    @Override
    public int apply(int amount) {
        return amount;
    }
}
