package core.basesyntax.impl;

import core.basesyntax.dao.FruitCSVImpl;
import core.basesyntax.dao.FruitDao;
import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.ReaderService;

import java.io.File;
import java.util.List;

public class ReaderServiceImpl implements ReaderService {
    FruitDao fruitDao =  new FruitCSVImpl();
    @Override
    public List<FruitTransaction> readFromFile(String filePath) {
        File file = new File(filePath);
        return fruitDao.getAll(file);
    }
}
