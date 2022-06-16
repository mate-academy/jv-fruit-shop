package core.basesyntax.service.impl;

import core.basesyntax.dao.FruitsDao;
import core.basesyntax.service.CsvFileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.Map;

public class CsvFileWriterImpl implements CsvFileWriter {
    private static final String PATH_NAME = "src/main/resources/report.csv";
    private FruitsDao fruitsDao;

    public CsvFileWriterImpl(FruitsDao fruitsDao) {
        this.fruitsDao = fruitsDao;
    }

    @Override
    public void write() {
        Map<String, Integer> stringIntegerMap = fruitsDao.getFruitsAndQuantityAsMap();
        for (Map.Entry<String, Integer> entry : stringIntegerMap.entrySet()) {
            try {
                Path pathToFile = Path.of(PATH_NAME);
                Files.write(pathToFile,
                        ("fruits,quantity" + System.lineSeparator()).getBytes(),
                        StandardOpenOption.CREATE);
                Files.write(pathToFile, (
                        entry.getKey()
                                + "," + entry.getValue()
                                + System.lineSeparator()).getBytes(), StandardOpenOption.APPEND);
            } catch (IOException e) {
                throw new RuntimeException("Can't write to file " + PATH_NAME);
            }
        }
    }
}
