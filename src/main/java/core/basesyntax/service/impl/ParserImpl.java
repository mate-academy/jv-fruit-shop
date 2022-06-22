package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.Parser;
import java.util.ArrayList;
import java.util.List;

public class ParserImpl implements Parser {

    private static final int NAME_INDEX = 1;
    private static final int QUANTITY_INDEX = 2;
    private static final int OPERATION_INDEX = 0;
    private static final String REGEX = ",";

    @Override
    public List<FruitTransaction> parseData(List<String> data) {
        data.remove(0);
        List<FruitTransaction> fruitTransactions = new ArrayList<>();
        data.stream()
                .map(s -> s.split(REGEX))
                .forEach(strings -> fruitTransactions
                        .add(new FruitTransaction(strings[NAME_INDEX],
                                Integer.parseInt(strings[QUANTITY_INDEX]),
                                FruitTransaction.getOperationBySymbol(strings[OPERATION_INDEX]))
                ));
        return fruitTransactions;
    }
}
