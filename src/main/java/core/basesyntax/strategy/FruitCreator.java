package core.basesyntax.strategy;

import java.util.List;

public class FruitCreator implements FruitHandler {

    @Override
    public void handle(List<String> fruitTypes, List<Integer> fruitAmount, String[] line) {
        fruitTypes.add(line[INDEX_FRUIT]);
        fruitAmount.add(Integer.parseInt(line[INDEX_AMOUNT]));
    }
}
