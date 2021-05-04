package core.basesyntax.createproductslist;

import core.basesyntax.operationswithfile.Operation;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ProductsListImpl implements ProductsList {
    @Override
    public HashMap getProductList(ArrayList<Operation> arrayList) {
        Map<String, Integer> balance = new HashMap<>();
        for (int i = 0; i < arrayList.size(); i++) {
            if ("b".equals(arrayList.get(i).getOperationType())) {
                balance.put(arrayList.get(i).getName(), arrayList.get(i).getCount());
                arrayList.remove(i);
                i--;
            }
        }
        return (HashMap) balance;
    }
}
