package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.ParserService;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ParserServiceImpl implements ParserService {
    private static final int INDEX_OF_OPERATION = 0;
    private static final int INDEX_OF_FRUIT = 1;
    private static final int INDEX_OF_AMOUNT = 2;
    private static final int HEADER_INDEX = 0;
    private static final String SPLITTER = ",";

    @Override
    public List<FruitTransaction> parse(List<String> data) {
        List<FruitTransaction> fruits = new ArrayList<>();
        data.remove(HEADER_INDEX);
        for (String value : data) {
            String[] currentLine = value.split(SPLITTER);
            FruitTransaction fruitTransaction = new FruitTransaction();
            fruitTransaction.setOperation(
                    Arrays.stream(FruitTransaction.Operation.values())
                            .filter(o -> o.getOperation().equals(currentLine[INDEX_OF_OPERATION]))
                            .findFirst().get());
            fruitTransaction.setFruit(currentLine[INDEX_OF_FRUIT]);
            fruitTransaction.setQuantity(Integer.parseInt(currentLine[INDEX_OF_AMOUNT]));
            fruits.add(fruitTransaction);
        }
        return fruits;
    }
}
