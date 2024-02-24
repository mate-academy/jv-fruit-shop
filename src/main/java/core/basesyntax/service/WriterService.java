package core.basesyntax.service;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.dao.FruitDaoImpl;

public class WriterService {
    private static final String FILE_NAME = "output.csv";
    private FruitDao fruitDao;

    public WriterService() {
        fruitDao = new FruitDaoImpl();
    }

    public void writeReport() {
        fruitDao.writeReportToFile(FILE_NAME);
    }
}
