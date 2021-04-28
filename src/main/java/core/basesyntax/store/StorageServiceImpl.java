package core.basesyntax.store;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.dao.FruitDaoImpl;
import core.basesyntax.model.Fruit;
import core.basesyntax.model.FruitRecord;
import core.basesyntax.model.OperationType;
import core.basesyntax.store.strategy.TypeHandler;

import java.util.List;
import java.util.Map;

public class StorageServiceImpl implements StorageService {
    TypeStrategy typeStrategy;
    FruitDao fruitDao;

    public StorageServiceImpl(Map<OperationType, TypeHandler> typeHandlerMap) {
        typeStrategy = new TypeStrategyImpl(typeHandlerMap);
        fruitDao = new FruitDaoImpl();
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
