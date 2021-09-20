package core.basesyntax.service;

import core.basesyntax.dao.FruitRecordDao;
import core.basesyntax.dao.FruitRecordDaoImpl;
import java.util.Map;

public class FruitMapServiceImpl implements FruitMapService {
    private static final String CSV_SEPARATOR = ",";
    private static final String FRUIT = "fruit";
    private static final String QUANTITY = "quantity";

    @Override
    public String mapFruitMapToString(Map<String, Integer> fruitMap) {
        FruitRecordDao fruitRecordDao = new FruitRecordDaoImpl();
        StringBuilder builder = new StringBuilder();
        builder.append(FRUIT + CSV_SEPARATOR + QUANTITY)
                .append(System.lineSeparator());
        for (Map.Entry<String, Integer> e : fruitRecordDao.getFruitMap().entrySet()) {
            builder.append(e.getKey())
                   .append(CSV_SEPARATOR)
                   .append(e.getValue())
                    .append(System.lineSeparator());
        }
        return builder.toString();
    }
}
