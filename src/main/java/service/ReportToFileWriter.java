package service;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Map;

public class ReportToFileWriter implements WriteReportToFile {

    @Override
    public void writeReport(Map<String, Integer> report, String fileName) {
        try (PrintWriter writer = new PrintWriter(fileName)) {
            for (Map.Entry<String, Integer> entry : report.entrySet()) {
                String fruit = entry.getKey();
                int stock = entry.getValue();
                writer.println(fruit + "," + stock);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException("Can't find file with such name " + fileName, e);
        }
    }
}
