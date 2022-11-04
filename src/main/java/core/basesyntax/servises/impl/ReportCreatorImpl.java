package core.basesyntax.servises.impl;

import core.basesyntax.dao.StorageDao;
import core.basesyntax.dao.StorageDaoImpl;
import core.basesyntax.servises.ReportCreator;
import java.util.HashMap;
import java.util.Map;

public class ReportCreatorImpl implements ReportCreator {
    private static final String SEPARATOR = ",";
    private static final String SYSTEM_SEPARATOR = System.lineSeparator();
    private static final String START = "fruit,quantity";
    private StorageDao dao = new StorageDaoImpl();
    private HashMap<String,Integer> storage = dao.getAll();

    @Override
    public String createReport() {
        StringBuilder builder = new StringBuilder();
        builder.append(START).append(SYSTEM_SEPARATOR);

        for (Map.Entry<String, Integer> entry : storage.entrySet()) {
            builder.append(entry.getValue())
                    .append(SEPARATOR)
                    .append(String.valueOf(entry.getKey()))
                    .append(SYSTEM_SEPARATOR);
        }
        return builder.toString();
    }
}
