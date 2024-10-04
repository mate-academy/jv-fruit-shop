package fruitshop.strategy;

import fruitshop.model.FruitTransaction;
import fruitshop.model.Storage;

public class PurchaseOperation implements OperationHandler {
    public static final String READ_FILE_PATH = "src/main/resources/reportToRead.csv";
    private final Storage storage;

    public PurchaseOperation(Storage storage) {
        this.storage = storage;
    }

    @Override
    public void handleTransaction(FruitTransaction fruitTransaction) {
        int newQuantity = storage.getQuantity(fruitTransaction.getFruit())
                - fruitTransaction.getQuantity();
        if (newQuantity >= 0) {
            storage.put(fruitTransaction.getFruit(), newQuantity);
        } else {
            throw new RuntimeException("negative balance " + newQuantity
                    + " cannot be recorded at "
                    + PurchaseOperation.class + " from fail " + READ_FILE_PATH);
        }
    }
}
