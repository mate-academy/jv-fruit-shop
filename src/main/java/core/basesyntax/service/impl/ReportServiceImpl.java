package core.basesyntax.service.impl;

import core.basesyntax.dao.ProductStorageDao;
import core.basesyntax.service.ReportService;
import java.util.stream.Collectors;

public class ReportServiceImpl implements ReportService {
    public static final String HEADER_IN_FILE = "fruit,quantity";
    public static final String FIELDS_DELIMITER = ",";
    private final ProductStorageDao productStorageDao;

    public ReportServiceImpl(ProductStorageDao productStorageDao) {
        this.productStorageDao = productStorageDao;
    }

    @Override
    public String create() {
        return productStorageDao.getAll().entrySet().stream()
                .map(e -> e.getKey() + FIELDS_DELIMITER + e.getValue())
                .collect(Collectors.joining(System.lineSeparator(),
                        HEADER_IN_FILE + System.lineSeparator(), ""));
    }
}
