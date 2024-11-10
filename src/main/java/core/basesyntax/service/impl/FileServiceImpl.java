package core.basesyntax.service.impl;

import core.basesyntax.service.FileService;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;
import java.util.List;

public class FileServiceImpl implements FileService {

    private static final String PATH_TO_INPUT_FILE = "transactions.csv";
    private static final String PATH_TO_OUTPUT_FILE = "report.csv";

    @Override
    public List<String> read(String filePath) {
        File file = new File(filePath);
        try {
            return Files.readAllLines(file.toPath());
        } catch (IOException e) {
            throw new RuntimeException("Can't read from file " + filePath, e);
        }
    }

    @Override
    public void write(String filePath, String data) {
        File file = new File(filePath);
        file.delete();
        try {
            file.createNewFile();
            Files.write(file.toPath(), data.getBytes(),
                    StandardOpenOption.APPEND);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
