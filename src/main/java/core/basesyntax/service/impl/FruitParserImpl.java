package core.basesyntax.service.impl;

import core.basesyntax.models.Fruit;
import core.basesyntax.models.FruitTransition;
import core.basesyntax.service.FruitParser;

public class FruitParserImpl implements FruitParser {
    private static final int OPERATION = 0;
    private static final int FRUIT_TYPE = 1;
    private static final int AMOUNT = 2;

    @Override
    public FruitTransition parseString(String string) {
        String input = string.replaceAll("\\s", "");
        String[] subStrings = input.split(",");
        FruitTransition fruitTransition = new FruitTransition();
        try {
            fruitTransition.setOperation(FruitTransition.Operation.setCode(subStrings[OPERATION]));
            fruitTransition.setFruitType(Fruit.Type.setType(subStrings[FRUIT_TYPE]));
            fruitTransition.setFruitAmount(Integer.parseInt(subStrings[AMOUNT]));
        } catch (RuntimeException e) {
            throw new RuntimeException("Can't parse input to Fruit: " + input);
        }
        return fruitTransition;
    }
}
