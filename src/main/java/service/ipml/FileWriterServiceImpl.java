package service.ipml;

import service.CSVWriter;

import java.io.FileWriter;

public class CSVWriterImpl implements CSVWriter {

    @Override
    public void writeToFile(String report, String filePath) {
        try (FileWriter fileWriter = new FileWriter(filePath)) {
            fileWriter.write(report);
        } catch (Exception e) {
            throw new RuntimeException("Can't write to file " + filePath, e);
        }
    }
}