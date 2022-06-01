package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.Parser;
import java.util.ArrayList;
import java.util.List;

public class ParserImpl implements Parser {
    private static final int OPERATION_INDEX = 0;
    private static final int FRUIT_INDEX = 1;
    private static final int QUANTITY_INDEX = 2;
    private static final String SEPARATOR = ",";

    @Override
    public List<FruitTransaction> parseData(List<String> data) {
        data.remove(OPERATION_INDEX);
        List<FruitTransaction> parsedData = new ArrayList<>();
        data.stream()
                .map(s -> s.split(SEPARATOR))
                .forEach(strings -> parsedData.add(
                        new FruitTransaction(FruitTransaction.getOperationByName(
                                strings[OPERATION_INDEX]),
                                strings[FRUIT_INDEX],
                                Integer.parseInt(strings[QUANTITY_INDEX]))));
        return parsedData;
    }
}
