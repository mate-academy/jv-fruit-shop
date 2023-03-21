package core.basesyntax.service;

import core.basesyntax.model.FruitTransaction;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ParserService {
    private static final int OPERATION_INDEX = 0;
    private static final int FRUIT_INDEX = 1;
    private static final int QUANTITY_INDEX = 2;

    public List<FruitTransaction> getFruitTransaction(List<String> list) {
        List<FruitTransaction> fruitTransactions = new ArrayList<>();
        List<String[]> data = list.stream()
                 .map(l -> l.split(","))
                 .collect(Collectors.toList());
        for (int i = 0; i < list.size(); i++) {
            fruitTransactions.add(new FruitTransaction(data.get(i)[OPERATION_INDEX],
                    data.get(i)[FRUIT_INDEX], Integer.parseInt(data.get(i)[QUANTITY_INDEX])));
        }
        return fruitTransactions;
    }
}
