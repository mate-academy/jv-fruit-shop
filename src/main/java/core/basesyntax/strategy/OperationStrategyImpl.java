package core.basesyntax.strategy;

public class OperationStrategyImpl implements OperationStrategy {
    @Override
    public Operation getOperationFromCode(String code) {
        return switch (code) {
            case "b" -> Operation.BALANCE;
            case "s" -> Operation.SUPPLY;
            case "p" -> Operation.PURCHASE;
            case "r" -> Operation.RETURN;
            default -> throw new IllegalArgumentException("Invalid operation code: " + code);
        };
    }
}
