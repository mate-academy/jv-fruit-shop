package db;

import java.io.BufferedWriter;
import java.io.IOException;

public class FileWriterImpl implements FileWriter {
    @Override
    public void writeToFile(String report) {
        String filePath = "src/main/resources/dailyReport.csv";
        try (BufferedWriter writer = new BufferedWriter(new java.io.FileWriter(filePath))) {
            writer.write(report);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
