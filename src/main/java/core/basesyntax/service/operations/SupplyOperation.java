package core.basesyntax.service.operations;

public class SupplyOperation implements Operation {
    @Override
    public Integer operation(Integer oldValue, Integer input) {
        return oldValue + input;
    }
}
