package core.basesyntax.service.csv.impl;

import core.basesyntax.service.csv.CsvService;
import core.basesyntax.service.csv.WriteService;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class CsvWriteServiceImpl extends CsvService implements WriteService {
    public CsvWriteServiceImpl(String destinationPath) {
        super(destinationPath);
    }

    @Override
    public void save(String contentToWrite) {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(path))) {
            bufferedWriter.write(contentToWrite);
        } catch (IOException e) {
            throw new RuntimeException("Can't write to file by path: " + path, e);
        }
    }
}
