package core.basesyntax.model.dto.impl;

import core.basesyntax.model.dto.WriteToFile;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class FileWriterImpl implements WriteToFile {

    @Override
    public void writeToFile(String report, String fileName) {
        try (BufferedWriter bufferedWriter
                     = new BufferedWriter(new FileWriter(fileName))) {
            bufferedWriter.write(report);
        } catch (IOException e) {
            throw new RuntimeException("File not found or can't be created" + fileName, e);
        }
    }
}
