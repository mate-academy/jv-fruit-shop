package core.basesyntax.parser;

import core.basesyntax.model.FruitTransaction;

public class ParserImpl implements Parser {
    private static final String REGEX = ",";
    private static final int OPERATION = 0;
    private static final int FRUIT = 1;
    private static final int QUANTITY = 2;

    @Override
    public FruitTransaction parse(String data) {
        String[] fields = data.split(REGEX);
        FruitTransaction fruitTransaction = new FruitTransaction();
        fruitTransaction.setOperation(FruitTransaction.getByCode(fields[OPERATION]));
        fruitTransaction.setFruit(fields[FRUIT]);
        fruitTransaction.setQuantity(Integer.parseInt(fields[QUANTITY]));
        return fruitTransaction;
    }
}
