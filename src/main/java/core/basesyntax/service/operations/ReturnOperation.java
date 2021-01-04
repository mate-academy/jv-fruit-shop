package core.basesyntax.service.operations;

public class ReturnOperation implements Operation {
    @Override
    public Integer operation(Integer oldValue, Integer input) {
        if (input < 0) {
            throw new RuntimeException("Can't return value < 0");
        }
        return oldValue + input;
    }
}
