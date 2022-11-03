package core.basesyntax.service.impl;

import core.basesyntax.service.WriterService;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class WriterServiceImpl implements WriterService {
    private static final String CANNOT_WRITE_TO_FILE_BY_PATH = "Can't write to the file by path: ";

    @Override
    public void writeToFile(List<String> list, String filePath) {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(filePath));
            for (String line : list) {
                writer.append(line);
                writer.newLine();
            }
            writer.close();
        } catch (IOException e) {
            throw new RuntimeException(CANNOT_WRITE_TO_FILE_BY_PATH + filePath, e);
        }
    }
}
