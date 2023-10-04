package core.basesyntax.service.impl;

import core.basesyntax.dao.FruitTransactionDao;
import core.basesyntax.dao.impl.FruitTransactionDaoImpl;
import core.basesyntax.service.ReportService;

public class ReportServiceImpl implements ReportService {
    private static final String DATA_OUTPUT = "fruit,quantity";
    private final FruitTransactionDao fruitTransactionDao = new FruitTransactionDaoImpl();

    @Override
    public String generateReport() {
        String report = DATA_OUTPUT
                + System.lineSeparator()
                + fruitTransactionDao.getAllData();
        return report;
    }
}
