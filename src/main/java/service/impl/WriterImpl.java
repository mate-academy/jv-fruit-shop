package service.impl;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import service.Writer;

public class WriterImpl implements Writer {
    @Override
    public void writeToFile(String report, String pathFile) {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(pathFile))) {
            bufferedWriter.write(report);
        } catch (IOException e) {
            throw new RuntimeException("Report cannot be write to file " + pathFile, e);
        }
    }
}
