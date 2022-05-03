package core.basesyntax.service.impl;

import core.basesyntax.model.Fruit;
import core.basesyntax.model.FruitTransaction;
import java.util.ArrayList;
import java.util.List;

public class DataParserService implements core.basesyntax.service.DataParserService {
    @Override
    public List<FruitTransaction> parseData(List<String> data) {
        List<FruitTransaction> fruitTransactions = new ArrayList<>();
        for (int i = 1; i < data.size(); i++) {
            String[] fruitTransactionsFields = data.get(i).split(",");
            fruitTransactions.add(new FruitTransaction(fruitTransactionsFields[0],
                    new Fruit(fruitTransactionsFields[1]),
                    Integer.parseInt(fruitTransactionsFields[2])));
        }
        return fruitTransactions;
    }
}
