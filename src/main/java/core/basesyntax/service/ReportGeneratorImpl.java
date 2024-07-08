package core.basesyntax.service;

import core.basesyntax.dao.FruitTransactionDao;
import java.util.Map;

public class ReportGeneratorImpl implements ReportGenerator {
    public static final String COMMA = ",";
    public static final String HEADER = "fruit, quantity";
    private final FruitTransactionDao fruitTransactionDao;

    public ReportGeneratorImpl(FruitTransactionDao fruitTransactionDao) {
        this.fruitTransactionDao = fruitTransactionDao;
    }

    @Override
    public String getReport() {
        StringBuilder report = new StringBuilder();
        report.append(HEADER);
        for (Map.Entry<String, Integer> entry : fruitTransactionDao.getStorage().entrySet()) {
            report.append(System.lineSeparator())
                    .append(entry.getKey())
                    .append(COMMA)
                    .append(entry.getValue());
        }
        return report.toString();
    }
}
