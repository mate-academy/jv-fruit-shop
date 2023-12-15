package core.basesyntax.service.impl;

import core.basesyntax.models.FruitTransaction;
import core.basesyntax.service.FruitParser;

public class FruitParserImpl implements FruitParser {
    private static final int OPERATION = 0;
    private static final int FRUIT_TYPE = 1;
    private static final int AMOUNT = 2;

    @Override
    public FruitTransaction parseString(String string) {
        String input = string.replaceAll("\\s", "");
        String[] subStrings = input.split(",");
        FruitTransaction fruitTransition = new FruitTransaction();
        try {
            fruitTransition
                    .setOperation(FruitTransaction.Operation.getOperation(subStrings[OPERATION]));
            fruitTransition.setFruitType(subStrings[FRUIT_TYPE]);
            fruitTransition.setFruitAmount(Integer.parseInt(subStrings[AMOUNT]));
        } catch (RuntimeException e) {
            throw new RuntimeException("Can't parse input to Fruit: " + input);
        }
        return fruitTransition;
    }
}
