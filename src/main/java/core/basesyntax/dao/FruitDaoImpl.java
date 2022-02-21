package core.basesyntax.dao;

import core.basesyntax.db.Storage;
import core.basesyntax.model.Fruit;
import core.basesyntax.service.impl.StringTransformatorImpl;
import core.basesyntax.service.StringTransformator;
import core.basesyntax.strategy.FruitStrategy;
import core.basesyntax.strategy.FruitStrategyImpl;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class FruitDaoImpl implements FruitDao {
    private static final int OPERATION_ABBREVIATION = 0;

    @Override
    public void putDataIntoStorage(List<String> data) {
        FruitStrategy strategy = new FruitStrategyImpl();
        StringTransformator transformator = new StringTransformatorImpl();
        List<String[]> listOfArrays = transformator.transformString(data);
        for (String[] dataArray : listOfArrays) {
            strategy.makeOperation(dataArray[OPERATION_ABBREVIATION]).operation(dataArray);
        }
    }

    @Override
    public Set<Map.Entry<Fruit, Integer>> getDataFromStorage() {
        return Storage.FRUIT_STORAGE.entrySet();
    }
}
