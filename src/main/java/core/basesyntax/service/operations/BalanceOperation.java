package core.basesyntax.service.operations;

public class BalanceOperation implements Operation {
    @Override
    public Integer operation(Integer oldValue, Integer input) {
        return input;
    }
}
