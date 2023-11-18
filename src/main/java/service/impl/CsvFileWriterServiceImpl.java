package service.impl;

import service.CsvFileWriterService;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;
import java.util.List;

public class CsvFileWriterServiceImpl implements CsvFileWriterService {

    @Override
    public void writeToNewCsvFile(String fileName, List<String> dataToWrite) {
        if (fileName == null
                || dataToWrite == null
                || !fileName.endsWith(".csv")) {
            throw new RuntimeException("Incorrect file name, extension or data!");
        }
        File file = new File(fileName);
        StringBuilder builder = new StringBuilder();

        for (String line : dataToWrite) {
            builder.append(line).append(System.lineSeparator());
        }
        try {
            Files.write(file.toPath(), builder.toString().getBytes(), StandardOpenOption.CREATE);
        } catch (IOException e) {
            throw new RuntimeException("Can't write to a file " + fileName, e);
        }
    }
}
