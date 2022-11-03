package core.basesyntax.service.impl;

import core.basesyntax.dao.FruitsDao;
import core.basesyntax.service.WriterService;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.Map;

public class WriterToCsvService implements WriterService {
    public static final String TEMPLATE = "\n%s,%d";
    public static final String FIRST_LINE = "fruit,quantity";
    private final FruitsDao fruitsDao;

    public WriterToCsvService(FruitsDao fruitsDao) {
        this.fruitsDao = fruitsDao;
    }

    @Override
    public void createReportAfterDay(String fileName) {
        StringBuilder stringBuilder = new StringBuilder(FIRST_LINE);
        fruitsDao.getEntrySet().stream()
                .forEach(e -> stringBuilder.append(formatString(e)));
        try {
            Files.write(Path.of(fileName), stringBuilder.toString()
                    .getBytes(), StandardOpenOption.APPEND);
        } catch (IOException e) {
            throw new RuntimeException("Can't write data to file " + e);
        }
    }

    private String formatString(Map.Entry<String, Integer> record) {
        return String.format(TEMPLATE, record.getKey(), record.getValue());
    }
}
