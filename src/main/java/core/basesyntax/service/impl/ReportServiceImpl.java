package core.basesyntax.service.impl;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.database.Storage;
import core.basesyntax.service.ReportService;

public class ReportServiceImpl implements ReportService {
    private static final String HEADER = "fruit,quantity";

    private FruitDao fruitDao;

    public ReportServiceImpl(FruitDao fruitDao) {
        this.fruitDao = fruitDao;
    }

    @Override
    public String create() {
        if (fruitDao.getAll().isEmpty()) {
            return "Storage is empty";
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(HEADER);
        Storage.fruitsStorage.entrySet().stream()
                .forEach(f -> stringBuilder.append(System.lineSeparator())
                        .append(f.getKey()).append(",").append(f.getValue()));
        return stringBuilder.toString();
    }
}
