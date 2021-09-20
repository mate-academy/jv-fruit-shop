package core.basesyntax.service;

import core.basesyntax.dao.FruitsDao;
import core.basesyntax.dao.FruitsDaoImpl;
import core.basesyntax.model.FruitRecord;
import java.util.List;

public class DataProcessorImpl implements DataProcessor {
    @Override
    public boolean processData(List<FruitRecord> records) {
        FruitsDao fruitsDao = new FruitsDaoImpl();
        for (FruitRecord record : records) {
            fruitsDao.addRecord(record);
        }
        return true;
    }
}
