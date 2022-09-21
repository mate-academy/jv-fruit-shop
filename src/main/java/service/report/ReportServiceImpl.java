package service.report;

import dao.FruitStorageDao;
import java.util.stream.Collectors;

public class ReportServiceImpl implements ReportService {
    private static final String REPORT_TITLE = "fruit,quantity";
    private FruitStorageDao storageDao;

    public ReportServiceImpl(FruitStorageDao storageDao) {
        this.storageDao = storageDao;
    }

    @Override
    public String getReport() {
        return REPORT_TITLE
                + System.lineSeparator()
                + storageDao
                .getAllFruitsNames()
                .stream()
                .map(c -> c + "," + storageDao.get(c))
                .collect(Collectors.joining(System.lineSeparator()));
    }
}
