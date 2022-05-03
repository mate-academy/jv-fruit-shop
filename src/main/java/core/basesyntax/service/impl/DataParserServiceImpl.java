package core.basesyntax.service.impl;

import core.basesyntax.model.Fruit;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.DataParserService;
import java.util.LinkedList;
import java.util.List;

public class DataParserServiceImpl implements DataParserService {
    @Override
    public List<FruitTransaction> parseData(List<String> readedFromFile) {
        List<FruitTransaction> fruitTransactionList = new LinkedList<>();
        for (int i = 1; i < readedFromFile.size(); i++) {
            String[] fruitTransactionsFields = readedFromFile.get(i).split(",");
            fruitTransactionList.add(new FruitTransaction(fruitTransactionsFields[0],
                    new Fruit(fruitTransactionsFields[1]),
                    Integer.parseInt(fruitTransactionsFields[2])));
        }
        return fruitTransactionList;
    }
}
