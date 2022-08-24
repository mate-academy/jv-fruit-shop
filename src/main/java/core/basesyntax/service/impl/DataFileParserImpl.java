package core.basesyntax.service.impl;

import core.basesyntax.model.Fruit;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.DataFileParser;

import java.util.ArrayList;
import java.util.List;

public class DataFileParserImpl implements DataFileParser<FruitTransaction> {
    private static final String FILE_TITLE = "type,fruit,quantity";
    private static final String SEPARATOR = ",";
    private static final int OPERATION_INDEX = 0;
    private static final int NAME_INDEX = 1;
    private static final int AMOUNT_INDEX = 2;


    @Override
    public List<FruitTransaction> parseDataFile(List<String> data) {
        List<FruitTransaction> fruitTransactions = new ArrayList<>();
        data.stream()
                .filter(t -> !t.equals(FILE_TITLE))
                .map(t -> t.split(SEPARATOR))
                .forEach(t -> fruitTransactions
                        .add(new FruitTransaction((t[OPERATION_INDEX]), new Fruit(t[NAME_INDEX]),
                                Integer.parseInt(t[AMOUNT_INDEX]))));
        return fruitTransactions;
    }
}
