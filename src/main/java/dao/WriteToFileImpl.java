package dao;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class WriteToFileImpl implements WriteToFile {
    @Override
    public void writeToFile(String report) {
        String filePath = "src/main/java/db/dailyReport.csv";
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            writer.write(report);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
