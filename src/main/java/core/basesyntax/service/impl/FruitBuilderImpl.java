package core.basesyntax.service.impl;

import core.basesyntax.model.Fruit;
import core.basesyntax.service.FruitBuilder;
import java.util.ArrayList;
import java.util.List;

public class FruitBuilderImpl implements FruitBuilder {
    @Override
    public List<Fruit> fruitBuilder(List<String> listFromFile) {
        List<Fruit> fruitList = new ArrayList<>();
        for (int i = 1; i < listFromFile.size(); i++) {
            String[] fruitParam = listFromFile.get(i).split(",");
            Fruit newFruit = new Fruit(fruitParam[0], fruitParam[1],
                    Integer.parseInt(fruitParam[2]));
            fruitList.add(newFruit);
        }
        return fruitList;
    }
}
