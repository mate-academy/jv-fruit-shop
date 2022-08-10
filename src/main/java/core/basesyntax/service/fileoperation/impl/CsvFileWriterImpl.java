package core.basesyntax.service.fileoperation.impl;

import core.basesyntax.service.fileoperation.CsvFileWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class CsvFileWriterImpl implements CsvFileWriter {

    @Override
    public void writeFile(String filePath, String report) {
        File csvOutputFile = new File(filePath);
        try (FileWriter fileWriter = new FileWriter(csvOutputFile)) {
            fileWriter.write(report);
        } catch (IOException e) {
            throw new RuntimeException("Can't write data to file" + filePath, e);
        }
    }
}
