package core.basesyntax.fruittransact;

import java.util.List;

public class FruitTransactionService {
    private static final int INDEX_OF_TYPE = 0;
    private static final int INDEX_OF_FRUIT = 1;
    private static final int INDEX_OF_AMOUNT = 2;
    private FruitTransaction purchaseTransaction = new PurchaseTransaction();
    private FruitTransaction supplyTransaction = new SupplyTransaction();
    private FruitTransaction remnantTransaction = new RemnantTransaction();

    public void transact(String type, String name, int amount) {
        switch (type) {
            case "b":
                remnantTransaction.transact(name, amount);
                break;
            case "p":
                purchaseTransaction.transact(name, amount);
                break;
            case "s":
            case "r":
                supplyTransaction.transact(name, amount);
                break;
            default:
                throw new RuntimeException("No such transaction type: " + type);

        }
    }

    public void transactAll(List<String[]> data) {
        for (String[] datum : data) {
            transact(datum[INDEX_OF_TYPE],
                    datum[INDEX_OF_FRUIT],
                    Integer.parseInt(datum[INDEX_OF_AMOUNT]));
        }
    }
}
