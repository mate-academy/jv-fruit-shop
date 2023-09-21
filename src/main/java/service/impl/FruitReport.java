package service.impl;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import service.WriterService;

public class FruitReport implements WriterService {

    private final List<String> report;

    public FruitReport(List<String> report) {
        this.report = report;
    }

    @Override
    public void writeToFile(String filePath) {
        File file = new File(filePath);
        try (FileWriter fileWriter = new FileWriter(file)) {
            for (String reportLine : report) {
                fileWriter.write(reportLine);
            }
            fileWriter.flush();
        } catch (IOException e) {
            throw new RuntimeException("Can't write to the file " + file.getAbsolutePath(), e);
        }
    }

}
