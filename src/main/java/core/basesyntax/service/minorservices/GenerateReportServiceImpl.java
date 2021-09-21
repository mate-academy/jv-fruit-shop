package core.basesyntax.service.minorservices;

import core.basesyntax.dao.FruitsDao;
import core.basesyntax.dao.FruitsDaoImpl;
import java.util.Set;

public class GenerateReportServiceImpl implements GenerateReportService {
    private static final String HEAD_ROW = "fruit,quantity";

    @Override
    public String generateReport(Set<String> fruitNames) {
        StringBuilder report = new StringBuilder();
        report.append(HEAD_ROW).append(System.lineSeparator());
        FruitsDao fruitsDao = new FruitsDaoImpl();
        for (String name : fruitNames) {
            report.append(name).append(",").append(fruitsDao.get(name).getAmount())
                    .append(System.lineSeparator());
        }
        return report.toString().trim();
    }
}
