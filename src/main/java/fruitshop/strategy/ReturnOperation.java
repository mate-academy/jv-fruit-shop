package fruitshop.strategy;

import fruitshop.model.FruitTransaction;
import fruitshop.model.Storage;

public class ReturnOperation implements OperationHandler {
    public static final String READ_FILE_PATH = "src/main/resources/reportToRead.csv";
    private final Storage storage;

    public ReturnOperation(Storage storage) {
        this.storage = storage;
    }

    @Override
    public void handleTransaction(FruitTransaction fruitTransaction) {
        int newQuantity = fruitTransaction.getQuantity()
                + storage.getQuantity(fruitTransaction.getFruit());
        if (newQuantity >= 0) {
            storage.put(fruitTransaction.getFruit(), newQuantity);
        } else {
            throw new RuntimeException("negative balance " + newQuantity
                    + " cannot be recorded at "
                    + PurchaseOperation.class + " from fail " + READ_FILE_PATH);
        }
    }
}
