package core.basesyntax.dao;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;

public class WriteDataToFileImpl implements WriteDataToFile {
    private static final String FILE_PATH = "src/main/resources/NewReport.csv";

    @Override
    public void writeDataToFile(String dataForReport) {
        File file = new File(FILE_PATH);
        try {
            file.createNewFile();
        } catch (IOException e) {
            throw new RuntimeException("Can't create new file " + file, e);
        }
        try {
            Files.write(file.toPath(), dataForReport.getBytes(), StandardOpenOption.APPEND);
        } catch (IOException e) {
            throw new RuntimeException("Can't write data to file " + file, e);
        }
    }
}
