package core.basesyntax.service.impl;

import core.basesyntax.dao.FruitShopDao;
import core.basesyntax.dao.FruitShopDaoImpl;
import core.basesyntax.service.ReportService;
import java.util.Map;

public class ReportServiceImpl implements ReportService {
    private static final String HEADER = "fruit,quantity";
    private FruitShopDao fruitShopDao = new FruitShopDaoImpl();

    @Override
    public String createReport() {
        StringBuilder builder = new StringBuilder();
        builder.append(HEADER).append(System.lineSeparator());
        for (Map.Entry<String, Integer> entry : fruitShopDao.getAll().entrySet()) {
            builder.append(entry.getKey())
                    .append(",")
                    .append(entry.getValue())
                    .append(System.lineSeparator());
            return builder.toString();
        }
        return builder.toString();
    }
}
