package core.basesyntax.reporter;

import core.basesyntax.dao.FruitStorageDao;
import java.util.Set;

public class CsvReportGenerator implements ReportGenerator {
    @Override
    public String generateReport(FruitStorageDao fruitStorageDao) {
        StringBuilder builder = new StringBuilder();
        Set<String> fruitSet = fruitStorageDao.getFruitSet();
        builder.append("fruit,quantity");
        for (String fruit : fruitSet) {
            builder.append(System.lineSeparator())
                    .append(fruit)
                    .append(",")
                    .append(fruitStorageDao.getQuantity(fruit));
        }
        return builder.toString();
    }
}
