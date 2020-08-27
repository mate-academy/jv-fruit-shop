package core.basesyntax;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DataExecutor {
    Map<String, Integer> fruitStore;
    Map<String, LocalDate> expiration;
    List<Transaction> list;
    Operational<Transaction, Map<String, Integer>, Map<String, LocalDate>> supplyAndReturn
            = new SupplyAndReturnOperation<>();
    Operational<Transaction, Map<String, Integer>, Map<String, LocalDate>> buy
            = new BuyOperation<>();

    public Map<String, Integer> dataExecutor(String filePath) {
        TransactionScanner transactionScanner = new TransactionScanner();
        fruitStore = new HashMap<>();
        expiration = new HashMap<>();
        list = transactionScanner.transactionList(filePath);

        for (Transaction x : list) {
            if (x.getType().equals("s") || x.getType().equals("r")) {
                supplyAndReturn.operation(x, fruitStore, expiration);
            }
            if (x.getType().equals("b")) {
                buy.operation(x, fruitStore, expiration);
            }
        }
        return fruitStore;
    }
}
