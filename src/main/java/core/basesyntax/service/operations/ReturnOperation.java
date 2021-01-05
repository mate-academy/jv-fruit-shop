package core.basesyntax.service.operations;

public class ReturnOperation implements Operation {
    @Override
    public Integer operation(Integer oldValue, Integer input) {
        return oldValue + input;
    }
}
