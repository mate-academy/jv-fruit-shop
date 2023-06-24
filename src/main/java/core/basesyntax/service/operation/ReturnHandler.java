package core.basesyntax.service.operation;

public class ReturnHandler implements OperationHandler {

    @Override
    public int getOperationAction(int quantity) {
        return -quantity;
    }
}
