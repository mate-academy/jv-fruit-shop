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
        for (Map.Entry<String, Integer> entry : Storage.fruitsQuantity.entrySet()) {
            String fruitName = entry.getKey();
            Integer quantity = storageDao.get(fruitName);
            if (quantity != null) {
                builder.append(fruitName)
                        .append(DIVIDER)
                        .append(quantity)
                        .append(System.lineSeparator());
            }
        }
        return builder.toString();
    }
}
