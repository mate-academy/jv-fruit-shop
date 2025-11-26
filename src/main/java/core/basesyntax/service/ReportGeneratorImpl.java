package core.basesyntax.service;

import core.basesyntax.dao.FruitsDao;
import java.util.Map;

public class ReportGeneratorImpl implements ReportGenerator {
    private static final String COMMA = ",";
    private static final String HEADER = "fruit,quantity";
    private FruitsDao fruitsDao;

    public ReportGeneratorImpl(FruitsDao fruitsDao) {
        this.fruitsDao = fruitsDao;
    }

    @Override
    public String getReport() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(HEADER).append(System.lineSeparator());

        for (Map.Entry<String, Integer> storageMap : fruitsDao.getAll().entrySet()) {
            stringBuilder.append(storageMap.getKey())
                    .append(COMMA)
                    .append(storageMap.getValue())
                    .append(System.lineSeparator());
        }

        return stringBuilder.toString();
    }
}
