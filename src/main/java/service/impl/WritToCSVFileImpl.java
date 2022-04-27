package service.impl;


import service.WritToCSVFile;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class WritToCSVFileImpl implements WritToCSVFile {
    private static final String TO_FILE = "src/main/resources/report.csv";

    @Override
    public void write(String report) {
        try (BufferedWriter csvWriter = new BufferedWriter(new FileWriter(TO_FILE))) {
            csvWriter.write(report);
        } catch (IOException e) {
            throw new RuntimeException("Can't write to file");
        }
    }
}
