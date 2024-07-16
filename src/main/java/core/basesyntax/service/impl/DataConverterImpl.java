package core.basesyntax.service.impl;

import core.basesyntax.db.FruitTransaction;
import core.basesyntax.service.DataConverter;
import java.util.ArrayList;
import java.util.List;

public class DataConverterImpl implements DataConverter {

    @Override
    public List<FruitTransaction> convertListToObjects(List<String> list) {
        List<FruitTransaction> listOfTransactions = new ArrayList<>();
        for (int i = 1; i < list.size(); i++) {
            String type = list.get(i).substring(0, list.get(i).indexOf(","));
            String fruit = list.get(i)
                    .substring(list.get(i).indexOf(",") + 1,
                            list.get(i).lastIndexOf(","));
            int quantity = Integer.parseInt(list.get(i)
                    .substring(list.get(i)
                            .lastIndexOf(",") + 1));
            listOfTransactions.add(new FruitTransaction(type, fruit, quantity));
        }
        return listOfTransactions;
    }
}
