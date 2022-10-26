package core.basesyntax.service.impl;

import core.basesyntax.service.WriterService;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class WriterServiceImpl implements WriterService {
    private static final String EXCEPTION_MESSAGE = "Can't write to a new file ";

    @Override
    public void writeToFile(String report, String failPath) {
        File file = new File(failPath);
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file))) {
            bufferedWriter.write(report);
        } catch (IOException e) {
            throw new RuntimeException(EXCEPTION_MESSAGE + failPath, e);
        }
    }
}
