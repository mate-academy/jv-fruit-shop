package core.basesyntax.service.impl;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.dao.FruitDaoImpl;
import core.basesyntax.service.ReportCreatorService;
import java.util.Map;

public class ReportCreatorServiceImpl implements ReportCreatorService {
    private final FruitDao fruitDao = new FruitDaoImpl();

    @Override
    public String createReport() {
        Map<String, Integer> data = fruitDao.getData();
        StringBuilder builder = new StringBuilder();
        builder.append("fruit,quantity").append(System.lineSeparator());
        for (Map.Entry<String, Integer> entry : data.entrySet()) {
            if (entry.getValue() < 0) {
                throw new RuntimeException("Negative balance");
            }
            builder.append(entry.getKey()).append(",").append(entry.getValue())
                    .append(System.lineSeparator());
        }
        return builder.toString();
    }
}
