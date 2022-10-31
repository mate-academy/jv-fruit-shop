package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.ParserService;
import java.util.ArrayList;
import java.util.List;

public class ParserServiceImpl implements ParserService {
    private static final int FIRST_STRING_INDEX = 0;
    private static final String COMMA = ",";
    private static final int OPERATION_INDEX = 0;
    private static final int FRUIT_INDEX = 1;
    private static final int QUANTITY_INDEX = 2;

    @Override
    public List<FruitTransaction> parseData(List<String> input) {
        input.remove(FIRST_STRING_INDEX);
        List<FruitTransaction> fruitTransactionList = new ArrayList<>();
        input.stream()
                .map(s -> s.split(COMMA))
                .forEach(strings -> fruitTransactionList
                        .add(new FruitTransaction(
                                FruitTransaction.findOperation(strings[OPERATION_INDEX]),
                                strings[FRUIT_INDEX],
                                Integer.parseInt(strings[QUANTITY_INDEX]))));
        return fruitTransactionList;
    }
}
