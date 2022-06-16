package core.basesyntax.service.impl;

import core.basesyntax.service.CsvFileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.Map;

public class CsvFileWriterImpl implements CsvFileWriter {
    @Override
    public void write(Map<String, Integer> fruitsAtStorageMap, String pathname) {
        for (Map.Entry<String, Integer> entry : fruitsAtStorageMap.entrySet()) {
            try {
                Path pathToFile = Path.of(pathname);
                Files.write(pathToFile,
                        ("fruits,quantity" + System.lineSeparator()).getBytes(),
                        StandardOpenOption.CREATE);
                Files.write(pathToFile, (
                        entry.getKey()
                                + "," + entry.getValue()
                                + System.lineSeparator()).getBytes(), StandardOpenOption.APPEND);
            } catch (IOException e) {
                throw new RuntimeException("Can't write to file " + pathname);
            }
        }
    }
}
