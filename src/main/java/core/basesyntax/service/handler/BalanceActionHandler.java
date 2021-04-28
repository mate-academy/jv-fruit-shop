package core.basesyntax.service.handler;

public class BalanceActionHandler implements ActionHandler {
    @Override
    public int calculateQuantity(int currentQuantity, int inputQuantity) {
        return inputQuantity + currentQuantity;
    }
}
