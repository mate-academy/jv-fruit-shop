package core.basesyntax.service.impl;

import core.basesyntax.dao.FruitStorageDao;
import core.basesyntax.dao.FruitStorageDaoImpl;
import core.basesyntax.service.ReportGeneratorService;
import java.util.stream.Collectors;

public class ReportGeneratorServiceImpl implements ReportGeneratorService {
    private static final String REPORT_HEADER = "fruit,quantity" + System.lineSeparator();
    private static final String JOINER = ",";

    @Override
    public String generateReport() {
        FruitStorageDao storage = new FruitStorageDaoImpl();
        return REPORT_HEADER + storage.getStorage().entrySet().stream()
                                        .map(i -> i.getKey() + JOINER + i.getValue())
                                        .collect(Collectors.joining(System.lineSeparator()));
    }
}
