package core.basesyntax.service.impl;

import core.basesyntax.exception.FruitStoreException;
import core.basesyntax.service.WriterService;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class WriterServiceImpl implements WriterService {
    @Override
    public void writeReportToFile(String outputFile, String reportData) {
        try (BufferedWriter toFile = new BufferedWriter(new FileWriter(outputFile))) {
            toFile.write(reportData);
        } catch (IOException e) {
            throw new FruitStoreException("Can't write to file " + outputFile);
        }
    }
}
