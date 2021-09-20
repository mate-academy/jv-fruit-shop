package core.basesyntax.service;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.dao.FruitDaoImpl;
import core.basesyntax.model.FruitRecord;
import java.util.List;

public class DataProcessorImpl implements DataProcessor {
    @Override
    public boolean processData(List<FruitRecord> records) {
        FruitDao fruitDao = new FruitDaoImpl();
        for (FruitRecord record : records) {
            fruitDao.addRecord(record);
        }
        return true;
    }
}
