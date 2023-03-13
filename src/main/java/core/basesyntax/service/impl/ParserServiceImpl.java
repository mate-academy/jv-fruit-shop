package core.basesyntax.service.impl;

import core.basesyntax.model.Fruit;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.ParserService;
import java.util.ArrayList;
import java.util.List;

public class ParserServiceImpl implements ParserService {
    private static final String COMA = ",";
    private static final int OPERATION_INDEX = 0;
    private static final int FRUIT_INDEX = 1;
    private static final int TITLE_INDEX = 1;
    private static final int QUANTITY_INDEX = 2;

    @Override
    public List<FruitTransaction> parse(List<String> dataFromFile) {
        List<FruitTransaction> fruitTransactions = new ArrayList<>();
        dataFromFile.stream()
                .skip(TITLE_INDEX)
                .map(t -> t.split(COMA))
                .forEach(t -> fruitTransactions
                        .add(new FruitTransaction((t[OPERATION_INDEX]), new Fruit(t[FRUIT_INDEX]),
                                Integer.parseInt(t[QUANTITY_INDEX]))));
        return fruitTransactions;
    }
}
