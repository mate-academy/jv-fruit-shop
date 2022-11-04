package core.basesyntax.servises.impl;

import core.basesyntax.models.FruitTransition;
import core.basesyntax.servises.ParselToTransition;
import java.util.ArrayList;
import java.util.List;

public class ParseToTransitionImpl implements ParselToTransition {
    private static final String SPLIT = ",";
    private static final int OPERAION_INDEX = 0;
    private static final int FRUIT_NAME_INDEX = 1;
    private static final int AMOUNT_INDEX = 2;

    @Override
    public List<FruitTransition> parseToFruit(List<String> list) {
        List<FruitTransition> fruits = new ArrayList<>();
        for (String line : list) {
            String[] elements = line.split(SPLIT);
            FruitTransition.Operation operation = FruitTransition
                        .getOperationByString(elements[OPERAION_INDEX]);
            fruits.add(new FruitTransition(operation, elements[FRUIT_NAME_INDEX],
                        Integer.parseInt(elements[AMOUNT_INDEX])));
        }
        return fruits;
    }
}
