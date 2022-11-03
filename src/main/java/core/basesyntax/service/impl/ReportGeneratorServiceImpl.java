package core.basesyntax.service.impl;

import core.basesyntax.dao.StorageDao;
import core.basesyntax.dao.StorageDaoImpl;
import core.basesyntax.service.ReportGeneratorService;

import java.util.stream.Collectors;

public class ReportGeneratorServiceImpl implements ReportGeneratorService {
    private static final String COMMA = ",";
    private static final String HEAD_LINE = "fruit,quantity";

    @Override
    public String reportGenerate() {
        StorageDao storage = new StorageDaoImpl();
        return HEAD_LINE + storage.getFruitStorage()
                .entrySet()
                .stream()
                .map(i -> i.getKey() + COMMA + i.getValue())
                .collect(Collectors.joining());
    }
}
