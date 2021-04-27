package core.basesyntax.service.strategy;

public class SupplyTypeHandler implements TypeHandler {
    @Override
    public int getTypeHandler(int amount) {
        return amount;
    }
}
