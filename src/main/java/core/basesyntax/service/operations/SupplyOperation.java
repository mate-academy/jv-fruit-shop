package core.basesyntax.service.operations;

public class SupplyOperation implements Operation {
    @Override
    public Integer operation(Integer oldValue, Integer input) {
        if (input < 0) {
            throw new RuntimeException("Can't supply value < 0");
        }
        return oldValue + input;
    }
}
