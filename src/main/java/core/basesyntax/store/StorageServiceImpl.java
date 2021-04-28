package core.basesyntax.store;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.dao.FruitDaoImpl;
import core.basesyntax.file.writer.FileWriter;
import core.basesyntax.model.Fruit;
import core.basesyntax.model.FruitRecord;

import java.io.BufferedWriter;
import java.io.IOException;
import java.util.List;


public class StorageServiceImpl implements StorageService {
    private static final String CSV_SEPARATOR = ",";
    private final TypeStrategy typeStrategy;
    private final FruitDao fruitDao;

    public StorageServiceImpl(TypeStrategy typeStrategy, FruitDao fruitDao) {
        this.typeStrategy = typeStrategy;
        this.fruitDao = fruitDao;
    }

    @Override
    public List<Fruit> saveData (List<FruitRecord> fruitRecordList) {
        for(FruitRecord fruitRecord: fruitRecordList) {
            typeStrategy.get(fruitRecord.getOperationType())
                    .makeOperation(fruitRecord.getFruit().getName(),
                            fruitRecord.getFruit().getBalance());
        }
        return fruitDao.getAll();
    }

    @Override
    public String getReport(List<Fruit> storage) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("fruit,quantity");
        for (Fruit fruit: storage) {
            stringBuilder.append("\n" + fruit.getName()
                    + CSV_SEPARATOR + fruit.getBalance());
        }
       return stringBuilder.toString();
    }

}
