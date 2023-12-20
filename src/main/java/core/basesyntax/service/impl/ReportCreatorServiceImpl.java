package core.basesyntax.service.impl;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.dao.FruitDaoImpl;
import core.basesyntax.service.ReportCreatorService;
import java.util.Map;

public class ReportCreatorServiceImpl implements ReportCreatorService {
    private static final String FRUIT_HEADER = "fruit";
    private static final String QUANTITY_HEADER = "quantity";
    private final FruitDao fruitDao = new FruitDaoImpl();

    @Override
    public String createReport() {
        Map<String, Integer> data = fruitDao.getBalance();
        StringBuilder builder = new StringBuilder();
        builder.append(FRUIT_HEADER)
                        .append(",")
                        .append(QUANTITY_HEADER)
                        .append(System.lineSeparator());
        for (Map.Entry<String, Integer> entry : data.entrySet()) {
            builder.append(entry.getKey()).append(",").append(entry.getValue())
                    .append(System.lineSeparator());
        }
        return builder.toString();
    }
}
