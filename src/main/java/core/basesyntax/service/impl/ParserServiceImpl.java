package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.ParserService;
import java.util.ArrayList;
import java.util.List;

public class ParserServiceImpl implements ParserService {
    public static final String COMMA_SEPARATOR = ",";
    public static final int INDEX_FOR_SKIPPING_TITLES = 1;
    public static final int INDEX_FOR_OPERATION = 0;
    public static final int INDEX_FOR_FRUIT = 1;
    public static final int INDEX_FOR_QUANTITY = 2;

    @Override
    public List<FruitTransaction> parseData(List<String> input) {
        List<FruitTransaction> parsedData = new ArrayList<>();
        for (int i = INDEX_FOR_SKIPPING_TITLES; i < input.size(); i++) {
            parsedData.add(formObjectFromData(input.get(i)));
        }
        return parsedData;
    }

    private FruitTransaction formObjectFromData(String input) {
        String[] splitedInput = input.split(COMMA_SEPARATOR);
        FruitTransaction fruitTransaction = new FruitTransaction();
        fruitTransaction.setOperation(FruitTransaction.Operation
                .getByCode(splitedInput[INDEX_FOR_OPERATION]));
        fruitTransaction.setFruit(splitedInput[INDEX_FOR_FRUIT]);
        fruitTransaction.setQuantity(Integer.parseInt(splitedInput[INDEX_FOR_QUANTITY]));
        return fruitTransaction;
    }
}
