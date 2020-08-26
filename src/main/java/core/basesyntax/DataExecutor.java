package core.basesyntax;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DataExecutor {
    Map<String, Integer> fruitStore;
    List<Transaction> list;
    Operational<Transaction, Map<String, Integer>> supplyAndReturn
            = new SupplyAndReturnOperation<>();
    Operational<Transaction, Map<String, Integer>> buy
            = new BuyOperation<>();

    public Map<String, Integer> dataExecutor(String filePath) {
        TransactionScanner transactionScanner = new TransactionScanner();
        fruitStore = new HashMap<>();
        list = transactionScanner.transactionList(filePath);

        for (Transaction x : list) {
            if (x.getType().equals("s") || x.getType().equals("r")) {
                supplyAndReturn.operation(x, fruitStore);
            }
            if (x.getType().equals("b")) {
                buy.operation(x, fruitStore);
            }
        }
        return fruitStore;
    }
}
