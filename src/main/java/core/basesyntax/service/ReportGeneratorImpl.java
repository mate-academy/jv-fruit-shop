package core.basesyntax.service;

import core.basesyntax.dao.FruitTransactionDao;
import java.util.Map;

public class ReportGeneratorImpl implements ReportGenerator {
    private final FruitTransactionDao fruitTransactionDao;

    public ReportGeneratorImpl(FruitTransactionDao fruitTransactionDao) {
        this.fruitTransactionDao = fruitTransactionDao;
    }

    @Override
    public String getReport() {
        StringBuilder report = new StringBuilder();
        report.append("fruit, quantity");
        for (Map.Entry<String, Integer> entry : fruitTransactionDao.getEntries()) {
            report.append("\n");
            report.append(entry.getKey()).append(",").append(entry.getValue());
        }
        return report.toString();
    }
}
