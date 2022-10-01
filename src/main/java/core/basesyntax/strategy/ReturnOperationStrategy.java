package core.basesyntax.strategy;

public class ReturnOperationStrategy implements OperationStrategy {

    @Override
    public int calculate(final int number) {
        return number;
    }
}
