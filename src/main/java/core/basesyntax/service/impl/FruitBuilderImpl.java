package core.basesyntax.service.impl;

import core.basesyntax.model.Fruit;
import core.basesyntax.service.FruitBuilder;
import java.util.ArrayList;
import java.util.List;

public class FruitBuilderImpl implements FruitBuilder {
    private static final int OPERATION_INDEX = 0;
    private static final int NAME_INDEX = 1;
    private static final int QUALITY_INDEX = 2;
    private static final String SEPARATOR = ",";

    @Override
    public List<Fruit> buildFruit(List<String> dataList) {
        List<Fruit> fruitList = new ArrayList<>();
        for (String fruitData: dataList) {
            String[] fruitParameters = fruitData.split(SEPARATOR);
            Fruit fruit = new Fruit(fruitParameters[OPERATION_INDEX],
                                    fruitParameters[NAME_INDEX],
                                    Integer.parseInt(fruitParameters[QUALITY_INDEX]));
            fruitList.add(fruit);
        }
        return fruitList;
    }
}
