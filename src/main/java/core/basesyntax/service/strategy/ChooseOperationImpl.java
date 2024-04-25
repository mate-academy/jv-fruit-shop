package core.basesyntax.service.strategy;

public class ChooseOperationImpl implements ChooseOperation {
    private static final int ZERO = 0;
    private OperationService operationB;
    private OperationService operationS;
    private OperationService operationP;
    private OperationService operationR;

    @Override
    public OperationService chooseOperation(String line) {
        String[] lineSplit = line.split(",");
        return switch (lineSplit[ZERO]) {
            case ("b") -> operationB = new BOperationServiceImpl();
            case ("s") -> operationS = new SOperationServiceImpl();
            case ("p") -> operationP = new POperationServiceImpl();
            case ("r") -> operationR = new ROperationServiceImpl();
            default -> null;
        };
    }
}
