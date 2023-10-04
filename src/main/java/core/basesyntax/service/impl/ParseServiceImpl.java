package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.ParseService;
import java.util.ArrayList;
import java.util.List;

public class ParseServiceImpl implements ParseService {
    private static final int OPERATION_INDEX = 0;
    private static final int FRUIT_INDEX = 1;
    private static final int QUANTITY_INDEX = 2;

    @Override
    public List<FruitTransaction> getFruitTransactions(List<String> list) {
        List<FruitTransaction> fruitTransactions = new ArrayList<>();
        List<String[]> data = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            data.add(list.get(i).split(","));
            fruitTransactions.add(new FruitTransaction(data.get(i)[OPERATION_INDEX],
                    data.get(i)[FRUIT_INDEX], Integer.parseInt(data.get(i)[QUANTITY_INDEX])));
        }
        return fruitTransactions;
    }
}
