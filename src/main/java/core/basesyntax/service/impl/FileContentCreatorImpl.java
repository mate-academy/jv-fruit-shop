package core.basesyntax.service.impl;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.service.FileContentCreator;
import java.util.Map;

public record FileContentCreatorImpl(FruitDao fruitDao) implements
        FileContentCreator {

    private static final String HEADER = "fruit,quantity";
    private static final String SEPARATOR = ",";

    @Override
    public String createFileContent() {
        Map<String, Integer> storage = fruitDao.getStorage();
        StringBuilder report = new StringBuilder();
        report.append(HEADER).append(System.lineSeparator());
        for (Map.Entry<String, Integer> entry : storage.entrySet()) {
            report.append(entry.getKey()).append(SEPARATOR)
                .append(entry.getValue())
                .append(System.lineSeparator());
        }
        return report.toString();
    }
}
