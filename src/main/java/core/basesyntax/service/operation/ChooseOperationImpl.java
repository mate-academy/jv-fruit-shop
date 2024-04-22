package core.basesyntax.service.operation;

public class ChooseOperationImpl implements ChooseOperation {
    private OperationService operationB;
    private OperationService operationS;
    private OperationService oprationP;
    private OperationService operationR;

    @Override
    public OperationService chooseOperation(String line) {
        String[] lineSplit = line.split(",");
        return switch (lineSplit[0]) {
            case ("b") -> operationB = new BOperationServiceImpl();
            case ("s") -> operationS = new SOperationServiceImpl();
            case ("p") -> oprationP = new POperationServiceImpl();
            case ("r") -> operationR = new ROperationServiceImpl();
            default -> null;
        };
    }
}
