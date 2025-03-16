package core.basesyntax.service.impl;

import core.basesyntax.service.CustomFileWriter;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class FileWriterImpl implements CustomFileWriter {
    public void write(String resultingReport, String filePathOutputFile) {
        try (BufferedWriter bufferedWriter =
                     new BufferedWriter(new FileWriter(filePathOutputFile))) {
            bufferedWriter.write(resultingReport);
            System.out.println(resultingReport);
        } catch (IOException e) {
            throw new RuntimeException("Не можна записати файл", e);
        }
    }
}
