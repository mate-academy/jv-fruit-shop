package mate.academy.service.impl;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import mate.academy.service.FileWriterService;

public class CsvFileWriterServiceImpl implements FileWriterService {
    public void write(String report, String toFileName) {
        File toFile = new File(toFileName);
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(toFile))) {
            bufferedWriter.write(report);
        } catch (IOException e) {
            throw new RuntimeException("Can't write data to the file" + toFileName, e);
        }
    }
}
