package core.basesyntax.service.impl;

import core.basesyntax.model.Fruit;
import core.basesyntax.service.FruitBuilder;
import java.util.ArrayList;
import java.util.List;

public class FruitBuilderImpl implements FruitBuilder {
    @Override
    public List<Fruit> buildFruit(List<String> sourceData) {
        List<Fruit> fruitList = new ArrayList<>();
        for (int i = 1; i < sourceData.size(); i++) {
            String[] fruitParams = sourceData.get(i).split(",");
            Fruit newFruit = new Fruit(fruitParams[0], fruitParams[1],
                    Integer.parseInt(fruitParams[2]));
            fruitList.add(newFruit);
        }
        return fruitList;
    }
}
