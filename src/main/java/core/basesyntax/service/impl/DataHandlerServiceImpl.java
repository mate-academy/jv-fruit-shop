package core.basesyntax.service.impl;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.service.DataHandlerService;
import java.util.Map;

public class DataHandlerServiceImpl implements DataHandlerService {
    private static final String COLUMN_FRUIT = "fruit";
    private static final String COLUMN_QUANTITY = "quantity";

    @Override
    public String dataHandler(FruitDao fruitDao) {
        StringBuilder builder = new StringBuilder(COLUMN_FRUIT.concat(",")
                .concat(COLUMN_QUANTITY).concat(System.lineSeparator()));
        for (Map.Entry<String, Integer> pair : fruitDao.getAll().entrySet()) {
            if (pair.getKey() == null || pair.getValue() == null) {
                throw new RuntimeException("Can`t handle null data.");
            }
            if (pair.getKey().isBlank()) {
                throw new RuntimeException("Can`t handle empty data.");
            }
            if (pair.getValue() < 0) {
                throw new RuntimeException("Incorrect data less 0");
            }
            builder.append(pair.getKey()).append(",")
                    .append(pair.getValue()).append(System.lineSeparator());
        }
        return builder.toString().strip();
    }
}
