package core.basesyntax.service;

import core.basesyntax.Storage;
import core.basesyntax.model.Transaction;
import core.basesyntax.operation.BuyOperation;
import core.basesyntax.operation.Operational;
import core.basesyntax.operation.SupplyAndReturnOperation;
import java.util.List;

public class StorageService {
    private Storage fruitStore;
    private Operational buy;
    private Operational supplyAndReturn;

    public void storageWriter(String filePath) {
        fruitStore = new Storage();
        buy = new BuyOperation(fruitStore);
        supplyAndReturn = new SupplyAndReturnOperation(fruitStore);
        TransactionReader transactionReader = new TransactionReader();
        List<Transaction> list = transactionReader.getTransactionList(filePath);

        for (Transaction x : list) {
            if (x.getType().equals("s") || x.getType().equals("r")) {
                supplyAndReturn.operation(x);
            }
            if (x.getType().equals("b")) {
                buy.operation(x);
            }
            if (!x.getType().matches("[srb]")) {
                throw new RuntimeException("No such operation!");
            }
        }
    }

    public List<String> printReport() {
        return fruitStore.reportPrinter();
    }
}
