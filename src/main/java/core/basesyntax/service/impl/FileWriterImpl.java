package core.basesyntax.service.impl;

import core.basesyntax.service.CustomFileWriter;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class FileWriterImpl implements CustomFileWriter {
    private String outputFile;

    public FileWriterImpl(String outputFile) {
        this.outputFile = outputFile;
    }

    public void write(String resultingReport) {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(outputFile))) {
            bufferedWriter.write(resultingReport);
            System.out.println(resultingReport);
        } catch (IOException e) {
            throw new RuntimeException("Не можна записати файл", e);
        }
    }
}
