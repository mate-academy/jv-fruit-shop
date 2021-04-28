package core.basesyntax.store;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.model.Fruit;
import core.basesyntax.model.FruitRecord;
import java.util.List;


public class StorageServiceImpl implements StorageService {
    private final TypeStrategy typeStrategy;
    private final FruitDao fruitDao;

    public StorageServiceImpl(TypeStrategy typeStrategy, FruitDao fruitDao) {
        this.typeStrategy = typeStrategy;
        this.fruitDao = fruitDao;
    }

    @Override
    public List<Fruit> getReport (List<FruitRecord> fruitRecordList) {
        int lineNumber = 0;
        for(FruitRecord fruitRecord: fruitRecordList) {
            saveData(fruitRecord, lineNumber);
            lineNumber++;
        }
        return fruitDao.getAll();
    }

    private void saveData(FruitRecord fruitRecord, int lineNumber) {
        typeStrategy.get(fruitRecord.getOperationType())
                .makeOperation(fruitRecord.getFruit().getName(),
                        fruitRecord.getFruit().getBalance(), lineNumber);
    }
}
