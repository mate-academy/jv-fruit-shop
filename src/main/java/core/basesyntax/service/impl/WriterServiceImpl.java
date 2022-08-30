package core.basesyntax.service.impl;

import core.basesyntax.service.WriterService;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class WriterServiceImpl implements WriterService {
    @Override
    public File writeToFile(String report, String filePath) {
        if (report == null) {
            throw new RuntimeException("Report can't be null");
        }
        File output = new File(filePath);
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(filePath))) {
            bufferedWriter.write("fruit,quantity");
            bufferedWriter.newLine();
            bufferedWriter.write(report);
        } catch (IOException e) {
            throw new RuntimeException("Can't write data to file: " + output.getName(), e);
        }
        return output;
    }
}
