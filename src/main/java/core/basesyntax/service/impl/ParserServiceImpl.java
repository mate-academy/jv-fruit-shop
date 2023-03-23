package core.basesyntax.service.impl;

import core.basesyntax.model.Fruit;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.ParserService;

public class ParserServiceImpl implements ParserService {
    private static final int TYPE_INDEX = 0;
    private static final int FRUIT_INDEX = 1;
    private static final int QUANTITY_INDEX = 2;
    private static final String SPLIT_SYMBOL = ",";
    private String[] arrayParameters;


    @Override
    public FruitTransaction getDataFromLine(String line) {
        arrayParameters = line.split(SPLIT_SYMBOL);
        FruitTransaction fruitTransaction = new FruitTransaction();
//        fruitTransaction.setOperation(new FruitTransaction.Operation(TYPE_INDEX));
        fruitTransaction.setFruit(new Fruit(arrayParameters[FRUIT_INDEX]));
        fruitTransaction.setQuantity(Integer.parseInt(arrayParameters[QUANTITY_INDEX]));
        return null;
    }
}
