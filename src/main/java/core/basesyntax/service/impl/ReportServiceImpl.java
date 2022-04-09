package core.basesyntax.service.impl;

import core.basesyntax.dao.StorageDao;
import core.basesyntax.service.ReportService;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class ReportServiceImpl implements ReportService {

    private Function<StorageDao, List<String>> formatter = (map) -> map.getAll().stream()
            .map(e -> e.getKey() + "," + e.getValue())
            .collect(Collectors.toList());

    @Override
    public List<String> makeReport(StorageDao storageDao) {
        return formatter.apply(storageDao);
    }
}
