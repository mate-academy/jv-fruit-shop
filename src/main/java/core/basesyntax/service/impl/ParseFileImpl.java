package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.ParseFile;
import java.util.ArrayList;
import java.util.List;

public class ParseFileImpl implements ParseFile {
    private static final String COMMA = ",";
    private static final int INDEX_FIRST_LINE = 0;
    private static final int OPERATION_INDEX = 0;
    private static final int FRUIT_TYPE_INDEX = 1;
    private static final int QUANTITY_INDEX = 2;

    @Override
    public List<FruitTransaction> parseData(List<String> data) {
        data.remove(INDEX_FIRST_LINE);
        List<FruitTransaction> fruitTransactionList = new ArrayList<>();
        data.stream()
                .map(s -> s.split(COMMA))
                .forEach(strings -> fruitTransactionList
                        .add(new FruitTransaction(
                                FruitTransaction.findOperation(strings[OPERATION_INDEX]),
                                strings[FRUIT_TYPE_INDEX],
                                Integer.parseInt(strings[QUANTITY_INDEX]))));
        return fruitTransactionList;
    }
}
