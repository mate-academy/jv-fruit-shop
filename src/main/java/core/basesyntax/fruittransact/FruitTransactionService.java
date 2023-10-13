package core.basesyntax.fruittransact;

import java.util.List;

public class FruitTransactionService {
    private static final int TYPE_INDEX = 0;
    private static final int FRUIT_INDEX = 1;
    private static final int AMOUNT_INDEX = 2;
    private FruitTransaction fruitTransaction;

    public void handle(String type, String name, int amount) {
        switch (type) {
            case "b":
                fruitTransaction = new RemnantTransaction();
                break;
            case "p":
                fruitTransaction = new PurchaseTransaction();
                break;
            case "s":
            case "r":
                fruitTransaction = new SupplyTransaction();
                break;
            default:
                throw new RuntimeException("No such transaction type: " + type);
        }
        fruitTransaction.handle(name, amount);
    }

    public void handleAll(List<String[]> data) {
        for (String[] datum : data) {
            handle(datum[TYPE_INDEX],
                    datum[FRUIT_INDEX],
                    Integer.parseInt(datum[AMOUNT_INDEX]));
        }
    }
}
