package core.basesyntax.service.service.impl;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.dao.FruitDaoImpl;
import core.basesyntax.service.CreateReportService;

public class CreateReportServiceImpl implements CreateReportService {
    private static final String HEADER_LINE = "fruit,quantity";
    private static final String SEPARATOR = ",";
    private final FruitDao storageDao;

    public CreateReportServiceImpl() {
        this.storageDao = new FruitDaoImpl();
    }

    @Override
    public String createReport() {
        if (storageDao.getAll().isEmpty()) {
            throw new RuntimeException("Can`t create report from empty fruits storage.");
        }
        StringBuilder report = new StringBuilder();
        report.append(HEADER_LINE);
        storageDao.getAll()
                .stream()
                .map(frt -> frt.getFruitName() + SEPARATOR + frt.getQuantity())
                .forEach(str -> report.append(System.lineSeparator()).append(str));
        return report.toString();
    }
}
