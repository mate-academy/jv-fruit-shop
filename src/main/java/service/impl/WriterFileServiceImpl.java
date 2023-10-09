package service.impl;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.List;
import service.WriterFileService;

public class WriterFileServiceImpl implements WriterFileService {
    private static final String FILE_NAME_OUTPUT = "src/main/resources/output.csv";

    @Override
    public void writeToFile(List<String> reportList) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME_OUTPUT))) {
            for (String report : reportList) {
                writer.write(report);
                writer.newLine();
            }
        } catch (Exception e) {
            throw new RuntimeException("Can`t write to file" + FILE_NAME_OUTPUT, e);
        }
    }
}
