package core.basesyntax.service.strategy;

public class ReduceOperationTypeHandler implements TypeHandler {
    @Override
    public int apply(int amount) {
        return -amount;
    }
}
