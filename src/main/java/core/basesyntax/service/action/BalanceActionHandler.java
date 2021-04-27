package core.basesyntax.service.action;

public class BalanceActionHandler implements ActionHandler {
    @Override
    public int calculateQuantity(int currentQuantity, int inputQuantity) {
        if (inputQuantity < 0) {
            throw new RuntimeException("Fruit's balance can't be negative: " + inputQuantity);
        }
        return inputQuantity;
    }
}
