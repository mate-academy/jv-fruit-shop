package core.basesyntax.service.impl;

import core.basesyntax.model.Fruit;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.Parser;
import java.util.ArrayList;
import java.util.List;

public class ParserImpl implements Parser<FruitTransaction> {
    private static final String FILE_TITLE = "type,fruit,quantity";
    private static final String COMA = ",";
    private static final int OPERATION_INDEX = 0;
    private static final int FRUIT_INDEX = 1;
    private static final int QUANTITY_INDEX = 2;

    @Override
    public List<FruitTransaction> parse(List<String> data) {
        List<FruitTransaction> fruitTransactions = new ArrayList<>();
        data.stream()
                .filter(t -> !t.equals(FILE_TITLE))
                .map(t -> t.split(COMA))
                .forEach(t -> fruitTransactions
                        .add(new FruitTransaction((t[OPERATION_INDEX]), new Fruit(t[FRUIT_INDEX]),
                                Integer.parseInt(t[QUANTITY_INDEX]))));
        return fruitTransactions;
    }
}
