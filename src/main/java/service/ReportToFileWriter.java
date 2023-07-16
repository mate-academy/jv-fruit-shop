package service;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.List;

public class ReportToFileWriter implements WriteReportToFile {

    @Override
    public void writeReport(List<String> report, String fileName) {
        try (PrintWriter writer = new PrintWriter(fileName)) {
            for (String entry : report) {
                writer.println(entry);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException("Can't find file with such name " + fileName, e);
        }
    }
}
