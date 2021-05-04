package core.basesyntax.createproductslist;

import core.basesyntax.operationswithfile.Transaction;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductsListImpl implements ProductsList {
    @Override
    public Map<String, Integer> getProductList(List<Transaction> transactionList) {
        Map<String, Integer> balance = new HashMap<>();
        for (int i = 0; i < transactionList.size(); i++) {
            if ("b".equals(transactionList.get(i).getOperationType())) {
                balance.put(transactionList.get(i).getName(), transactionList.get(i).getCount());
                transactionList.remove(i);
                i--;
            }
        }
        return balance;
    }
}
