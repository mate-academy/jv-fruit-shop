package core.basesyntax.service.impl;

import core.basesyntax.model.Fruit;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.ParserService;
import java.util.ArrayList;
import java.util.List;

public class ParserServiceImpl implements ParserService {
    private static final int OPERATION_TYPE_INDEX = 0;
    private static final int FRUIT_INDEX = 1;
    private static final int FRUIT_COUNT_INDEX = 2;
    private static final int INDEX_HEADER = 0;

    @Override
    public List<FruitTransaction> parse(List<String> info) {
        List<FruitTransaction> fruitTransactionList = new ArrayList<>();
        info.remove(INDEX_HEADER);
        for (String infoFromFile : info) {
            String[] fields = infoFromFile.split(",");
            fruitTransactionList.add(new FruitTransaction(fields[OPERATION_TYPE_INDEX],
                    new Fruit(fields[FRUIT_INDEX]),
                    Integer.parseInt(fields[FRUIT_COUNT_INDEX])));
        }
        return fruitTransactionList;
    }
}
