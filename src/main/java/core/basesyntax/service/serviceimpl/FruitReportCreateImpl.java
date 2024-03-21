package core.basesyntax.service.serviceimpl;

import core.basesyntax.dao.StorageDao;
import core.basesyntax.db.Storage;
import core.basesyntax.service.interfaces.FruitReportCreate;
import java.util.Map;

public class FruitReportCreateImpl implements FruitReportCreate {
    private static final String FIRST_CSV_REPORT_LINE = "fruit,quantity" + System.lineSeparator();
    private static final String DIVIDER = ",";

    private final StorageDao storageDao;

    public FruitReportCreateImpl(StorageDao storageDao) {
        this.storageDao = storageDao;
    }

    public String createReport() {
        StringBuilder builder = new StringBuilder(FIRST_CSV_REPORT_LINE);
        for (String fruitName : Storage.fruitsQuantity.keySet()) {
            Map<String, Integer> fruitMap = storageDao.get(fruitName);
            for (Map.Entry<String, Integer> fruits : fruitMap.entrySet()) {
                builder.append(fruits.getKey())
                        .append(DIVIDER)
                        .append(fruits.getValue())
                        .append(System.lineSeparator());
            }
        }
        return builder.toString();
    }
}
