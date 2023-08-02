package core.basesyntax.service.impl;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.service.ReportCreatorService;
import java.util.Map;

public class ReportCreatorServiceImpl implements ReportCreatorService {
    private static final String SEPARATOR = ",";
    private final FruitDao fruitDao;

    public ReportCreatorServiceImpl(FruitDao fruitDao) {
        this.fruitDao = fruitDao;
    }

    @Override
    public String createReport() {
        StringBuilder builder = new StringBuilder("fruit,quantity");
        for (Map.Entry<String, Integer> entry : fruitDao.getAll().entrySet()) {
            builder.append(System.lineSeparator())
                    .append(entry.getKey())
                    .append(SEPARATOR)
                    .append(entry.getValue());

        }
        return builder.toString();
    }
}
