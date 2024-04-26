package core.basesyntax.service.strategy;

public class ChooseOperationImpl implements ChooseOperation {
    private static final int TYPE_OPERATION_POSITION = 0;
    private static final String SEPARATOR = ",";

    @Override
    public OperationService chooseOperation(String line) {
        String[] lineSplit = line.split(SEPARATOR);
        return switch (lineSplit[TYPE_OPERATION_POSITION]) {
            case ("b") -> new BOperationServiceImpl();
            case ("s") -> new SOperationServiceImpl();
            case ("p") -> new POperationServiceImpl();
            case ("r") -> new ROperationServiceImpl();
            default -> null;
        };
    }
}
