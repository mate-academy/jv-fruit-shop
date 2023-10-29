package core.basesyntax.servise.impl;

import core.basesyntax.servise.FileWriterUtility;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class FileReportWriterImp implements FileWriterUtility {
    @Override
    public String writeReportToFile(String content, String fileName) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            writer.write(content);
        } catch (IOException e) {
            throw new RuntimeException("Failed to write file: " + fileName, e);
        }
        return fileName;
    }
}
