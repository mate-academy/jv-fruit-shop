package core.basesyntax.service;

import core.basesyntax.Storage;
import core.basesyntax.model.Transaction;
import core.basesyntax.operation.BuyOperation;
import core.basesyntax.operation.Operational;
import core.basesyntax.operation.SupplyAndReturnOperation;
import java.util.List;

public class StorageService {
    private Storage fruitStore;
    private List<Transaction> list;
    private Operational supplyAndReturn = new SupplyAndReturnOperation();
    private Operational buy = new BuyOperation();

    public void storageWriter(String filePath) {
        TransactionReader transactionReader = new TransactionReader();
        fruitStore = new Storage();
        list = transactionReader.getTransactionList(filePath);

        for (Transaction x : list) {
            if (x.getType().equals("s") || x.getType().equals("r")) {
                supplyAndReturn.operation(x, fruitStore);
            }
            if (x.getType().equals("b")) {
                buy.operation(x, fruitStore);
            }
        }
    }

    public List<String> printReport() {
        return fruitStore.reportPrinter();
    }
}
