package core.basesyntax.service.handler;

public class ReturnActionHandler implements ActionHandler {
    @Override
    public int calculateQuantity(int currentQuantity, int inputQuantity) {
        return currentQuantity + inputQuantity;
    }
}
