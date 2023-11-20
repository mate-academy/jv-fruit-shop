package service.impl;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;
import java.util.List;
import service.CsvFileWriterService;

public class CsvFileWriterServiceImpl implements CsvFileWriterService {
    @Override
    public void writeToNewCsvFile(String fileName, List<String> dataToWrite) {
        if (fileName == null
                || dataToWrite == null
                || !fileName.endsWith(".csv")) {
            throw new RuntimeException("Incorrect file name, extension or data!");
        }
        File file = new File(fileName);

        try {
            Files.write(file.toPath(), dataToWrite, StandardOpenOption.CREATE);
        } catch (IOException e) {
            throw new RuntimeException("Can't write to a file " + fileName, e);
        }
    }
}
