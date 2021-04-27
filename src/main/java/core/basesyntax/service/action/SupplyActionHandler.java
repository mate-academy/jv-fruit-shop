package core.basesyntax.service.action;

public class SupplyActionHandler implements ActionHandler {
    @Override
    public int calculateQuantity(int currentQuantity, int quantityFromFile) {
        return currentQuantity + quantityFromFile;
    }
}
