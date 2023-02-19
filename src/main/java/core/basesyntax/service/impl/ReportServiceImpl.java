package core.basesyntax.service.impl;

import core.basesyntax.dao.StorageDao;
import core.basesyntax.service.ReportService;
import java.util.stream.Collectors;

public class ReportServiceImpl implements ReportService {
    private StorageDao storageDao;

    public ReportServiceImpl(StorageDao storageDao) {
        this.storageDao = storageDao;
    }

    @Override
    public String getReport() {
        StringBuilder builder = new StringBuilder("fruit,quantity");
        String infoForRepo = getInfoForReport();
        builder.append(System.lineSeparator()).append(infoForRepo);
        return builder.toString();
    }

    private String getInfoForReport() {
        return storageDao.getMapHandler().entrySet().stream()
                .map(e -> {
                    StringBuilder builder = new StringBuilder();
                    builder.append(e.getKey()).append(",").append(e.getValue());
                    return builder.toString();
                }).collect(Collectors.joining(System.lineSeparator()));
    }
}
