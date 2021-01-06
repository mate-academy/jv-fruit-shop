package core.basesyntax.service.impl;

import core.basesyntax.service.CsvFileWriter;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class CsvFileWriterImpl implements CsvFileWriter {
    private String filePath;

    public CsvFileWriterImpl(String filePath) {
        this.filePath = filePath;
    }

    @Override
    public void writeToFile(String report) {
        BufferedWriter bufferedWriter = null;
        try {
            bufferedWriter = new BufferedWriter(new FileWriter(filePath));
            bufferedWriter.write(report);
        } catch (IOException e) {
            throw new RuntimeException("Can't write to the file", e);
        } finally {
            if (bufferedWriter != null) {
                try {
                    bufferedWriter.close();
                } catch (IOException e) {
                    throw new RuntimeException("Can't close the file", e);
                }
            }
        }
    }
}
