package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.ParserService;

import java.util.ArrayList;
import java.util.List;

public class ParserServiceImpl implements ParserService {
    private final int OPERATION_INDEX = 0;
    private final int FRUIT_NAME_INDEX = 1;
    private final int FRUIT_QUANTITY_INDEX = 2;
    @Override
    public List<FruitTransaction> parser(List<String> data) {
        List<FruitTransaction> fruits = new ArrayList<>();
        for (String string : data) {
            String[] splittedData = string.split(",");
            FruitTransaction fruit = new FruitTransaction(FruitTransaction.Operation.valueOf(splittedData[OPERATION_INDEX]),
                    splittedData[FRUIT_NAME_INDEX], Integer.parseInt(splittedData[FRUIT_QUANTITY_INDEX]));
            fruits.add(fruit);
        }
        return fruits;
    }
}
