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
    private TypeStrategy typeStrategy;
    private final FruitDao fruitDao;
    private FileWriter writerService;

    public StorageServiceImpl(TypeStrategy typeStrategy, FruitDao fruitDao,
                              FileWriter writerService) {
        this.typeStrategy = typeStrategy;
        this.fruitDao = fruitDao;
        this.writerService = writerService;
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

    @Override
    public void reportMaker(String path, List<Fruit> storage) {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new java.io.FileWriter(path))) {
            bufferedWriter.write("fruit,quantity");
            writerService.write(bufferedWriter, storage);
        } catch (IOException e) {
            throw new RuntimeException("Cant find file by path: " + path, e);
        }
    }

    @Override
    public void createNewFruit(String name, long quantity) {
        fruitDao.add(new Fruit(name, quantity));
    }

    @Override
    public Fruit makeFruit(String name, long quantity) {
        return new Fruit(name, quantity);
    }


    private void saveData(FruitRecord fruitRecord, int lineNumber) {
        typeStrategy.get(fruitRecord.getOperationType())
                .makeOperation(fruitRecord.getFruit().getName(),
                        fruitRecord.getFruit().getBalance(), lineNumber);
    }
}
