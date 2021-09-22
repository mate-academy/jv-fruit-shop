package core.basesyntax.service;

import core.basesyntax.dao.FruitRecordDao;
import core.basesyntax.dao.FruitRecordDaoImpl;
import java.util.Map;

public class ReportGeneratorImpl implements ReportGenerator {
    public static final String CSV_SEPARATOR = ",";
    private static final String FILE_HEADER = "fruit,quantity";

    @Override
    public String generateReport(Map<String, Integer> fruitMap) {
        FruitRecordDao fruitRecordDao = new FruitRecordDaoImpl();
        StringBuilder builder = new StringBuilder();
        builder.append(FILE_HEADER)
                .append(System.lineSeparator());
        for (Map.Entry<String, Integer> e : fruitRecordDao.getFruitMap().entrySet()) {
            builder.append(e.getKey())
                   .append(CSV_SEPARATOR)
                   .append(e.getValue())
                    .append(System.lineSeparator());
        }
        return builder.toString().trim();
    }
}
