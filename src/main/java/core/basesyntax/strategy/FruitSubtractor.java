package core.basesyntax.strategy;

import java.util.List;

public class FruitSubtractor implements FruitHandler {
    @Override
    public void handle(List<String> fruitTypes, List<Integer> fruitAmount, String[] line) {
        int currentFruitIndex = fruitTypes.indexOf(line[INDEX_FRUIT]);
        fruitAmount.set(currentFruitIndex,
                fruitAmount.get(currentFruitIndex)
                        - Integer.parseInt(line[INDEX_AMOUNT]));
        if (fruitAmount.get(currentFruitIndex) < 0) {
            throw new RuntimeException("Do not have enough fruits for purchasing");
        }
    }
}
