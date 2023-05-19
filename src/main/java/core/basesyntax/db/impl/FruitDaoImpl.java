package core.basesyntax.db.impl;

import core.basesyntax.db.FruitDao;
import core.basesyntax.db.Storage;
import java.util.List;

public class FruitDaoImpl implements FruitDao {
    @Override
    public void addDataToStorage(List<String> calculatedData) {
        checkPositiveValues(calculatedData);
        Storage.dataStorage.addAll(calculatedData);
    }

    private void checkPositiveValues(List<String> calculatedData) {
        for (int i = 1; i < calculatedData.size(); i += 2) {
            if (Integer.parseInt(calculatedData.get(i)) < 0) {
                throw new RuntimeException("Quantity less then 0 for " + calculatedData.get(i - 1));
            }
        }
    }
}
