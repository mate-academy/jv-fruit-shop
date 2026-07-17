package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.DataConvertor;
import java.util.ArrayList;
import java.util.List;

public class DataConvertorImpl implements DataConvertor {

    @Override
    public List<FruitTransaction> convertToTransaction(List<String> list) {
        if (list == null) {
            throw new RuntimeException("List can not be null");
        }
        List<FruitTransaction> fruitList = new ArrayList<>();
        for (String item : list) {
            String[] items = item.split(",");
            if (items[0].equals("type")) {
                continue;
            }
            fruitList.add(new FruitTransaction(
                    FruitTransaction.Operation.getOperationByCode(items[0]),
                    items[1],
                    Integer.parseInt(items[2])
            ));
        }
        return fruitList;
    }
}
