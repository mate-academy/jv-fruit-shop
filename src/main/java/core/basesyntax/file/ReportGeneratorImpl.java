package core.basesyntax.file;

import core.basesyntax.dao.StorageDao;
import core.basesyntax.dao.StorageDaoImpl;

public class ReportGeneratorImpl implements ReportGenerator {
    private static final String SEPARATOR = ",";
    private static final String FIRST_LINE = "fruit,quantity";
    private final StorageDao storageDao = new StorageDaoImpl();

    @Override
    public String getReport() {
        StringBuilder reportBuilder = new StringBuilder()
                .append(FIRST_LINE)
                .append(System.lineSeparator());
        storageDao.get().forEach(
                (key, value) -> reportBuilder.append(key)
                        .append(SEPARATOR)
                        .append(value)
                        .append(System.lineSeparator()));
        return reportBuilder.toString();
    }
}
