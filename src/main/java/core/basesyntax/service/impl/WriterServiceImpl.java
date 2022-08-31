package core.basesyntax.service.impl;

import core.basesyntax.service.WriterService;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class WriterServiceImpl implements WriterService {
    @Override
    public void writeToFile(String report, String reportFileName) {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(
                reportFileName, true))) {
            bufferedWriter.write(report);
        } catch (IOException e) {
            throw new RuntimeException("Can't writ to this file: " + reportFileName, e);
        }
    }
}
