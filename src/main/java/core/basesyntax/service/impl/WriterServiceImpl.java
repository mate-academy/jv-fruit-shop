package core.basesyntax.service.impl;

import core.basesyntax.service.WriterService;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class WriterServiceImpl implements WriterService {

    @Override
    public void write(String data, String reportPath) {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(reportPath))) {
            bufferedWriter.write(data);
        } catch (IOException e) {
            throw new RuntimeException("Can't write data to file " + reportPath);
        }
    }
}
