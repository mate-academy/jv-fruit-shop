package core.basesyntax.impl;

import core.basesyntax.dao.StorageDao;
import core.basesyntax.service.ReportService;
import java.util.ArrayList;
import java.util.List;

public class ReportServiceImpl implements ReportService {
    private static final String BASE_DELIMITER = "=";
    private static final String FILE_DELIMITER = ",";
    private static final String TITLE_OF_REPORT = "fruit,quantity";
    private final StorageDao storageDao;

    public ReportServiceImpl(StorageDao storageDao) {
        this.storageDao = storageDao;
    }

    @Override
    public List<String> getReport() {
        List<String> report = storageDao.getAllFruits()
                .stream()
                .map(s -> s.replace(BASE_DELIMITER, FILE_DELIMITER))
                .toList();
        List<String> lines = new ArrayList<>();
        lines.add(TITLE_OF_REPORT);
        lines.addAll(report);
        return lines;
    }
}
