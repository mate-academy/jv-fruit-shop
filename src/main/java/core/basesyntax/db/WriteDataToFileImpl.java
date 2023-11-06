package core.basesyntax.db;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;

public class WriteDataToFileImpl implements WriteDataToFile {
    private static final String FILE_PATH = "src/main/resources/Report.csv";

    @Override
    public void writeDataToFile(String data, String fileName) {
        File file = new File(FILE_PATH);
        try {
            Files.write(file.toPath(), data.getBytes(), StandardOpenOption.CREATE);
        } catch (IOException e) {
            throw new RuntimeException("Unable to create a file " + file, e);
        }
    }
}
