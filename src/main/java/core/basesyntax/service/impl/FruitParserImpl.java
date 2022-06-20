package core.basesyntax.service.impl;

import core.basesyntax.model.Fruit;
import core.basesyntax.model.TransactionInfo;
import core.basesyntax.service.FruitParser;
import java.util.ArrayList;
import java.util.List;

public class FruitParserImpl implements FruitParser {
    private static final int OPERATION_INDEX = 0;
    private static final int FRUIT_NAME_INDEX = 1;
    private static final int QUANTITY_INDEX = 2;
    private static final int INDEX_TITLE = 0;
    private static final String SPLIT_SYMBOL = ",";

    @Override
    public List<TransactionInfo> parse(List<String> list) {
        List<TransactionInfo> fruitRecordsList = new ArrayList<>();
        list.remove(INDEX_TITLE);
        for (String fruit : list) {
            if (fruit.isBlank() || fruit.contains(" ")) {
                throw new RuntimeException("Invalid input date: ");
            }
            String[] split = fruit.split(SPLIT_SYMBOL);
            fruitRecordsList.add(new TransactionInfo(split[OPERATION_INDEX],
                    new Fruit(split[FRUIT_NAME_INDEX]),
                    Integer.parseInt(split[QUANTITY_INDEX])));
        }
        return fruitRecordsList;
    }
}
