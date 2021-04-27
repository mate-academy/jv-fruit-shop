package core.basesyntax.service.action;

public class ReturnActionHandler implements ActionHandler {
    @Override
    public int calculateQuantity(int currentQuantity, int inputQuantity) {
        return currentQuantity + inputQuantity;
    }
}
