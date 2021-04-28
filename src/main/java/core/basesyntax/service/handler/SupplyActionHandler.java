package core.basesyntax.service.handler;

public class SupplyActionHandler implements ActionHandler {
    @Override
    public int calculateQuantity(int currentQuantity, int quantityFromFile) {
        return currentQuantity + quantityFromFile;
    }
}
