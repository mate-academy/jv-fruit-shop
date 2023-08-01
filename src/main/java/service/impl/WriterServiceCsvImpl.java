package service.impl;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import service.WriterService;

public class WriterServiceCsvImpl implements WriterService {
    private final String filename = "src/main/resources/report.csv";

    @Override
    public void writeToFile(List<String> list) {

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filename))) {
            for (String line : list) {
                bw.write(line);
                bw.newLine();
            }
        } catch (IOException e) {
            throw new RuntimeException("Can't write to file: " + filename, e);
        }
    }
}
