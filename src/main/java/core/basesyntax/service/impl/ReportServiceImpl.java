package core.basesyntax.service.impl;

import core.basesyntax.ReportFormatter;
import core.basesyntax.service.ReportService;
import core.basesyntax.service.StorageDao;
import java.util.List;
import java.util.stream.Collectors;

public class ReportServiceImpl implements ReportService {

    private ReportFormatter formatter = (map) -> map.getAll().stream()
            .map(e -> e.getKey() + "," + e.getValue())
            .collect(Collectors.toList());

    @Override
    public List<String> makeReport(StorageDao storageDao) {
        return formatter.format(storageDao);
    }
}
