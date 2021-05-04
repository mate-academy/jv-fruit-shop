package core.basesyntax.createproductslist;

import core.basesyntax.operationswithfile.Operation;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductsListImpl implements ProductsList {
    @Override
    public Map getProductList(List<Operation> operationList) {
        Map<String, Integer> balance = new HashMap<>();
        for (int i = 0; i < operationList.size(); i++) {
            if ("b".equals(operationList.get(i).getOperationType())) {
                balance.put(operationList.get(i).getName(), operationList.get(i).getCount());
                operationList.remove(i);
                i--;
            }
        }
        return balance;
    }
}
