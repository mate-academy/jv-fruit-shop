package core.basesyntax;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DataCalculator {
    Map<String, Integer> fruitStore;
    List<Transaction> list;
    Operational<Transaction, Map<String, Integer>> supplyAndReturn
            = new SupplyAndReturnOperation<>();
    Operational<Transaction, Map<String, Integer>> buy
            = new BuyOperation<>();

    public Map<String, Integer> dataCalculator(String filePath) {
        DataReader dataReader = new DataReader();
        fruitStore = new HashMap<>();
        list = dataReader.transactionList(filePath);

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
