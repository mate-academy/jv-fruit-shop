package core.basesyntax.service.impl;

import core.basesyntax.service.FileWriter;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class FileWriterImpl implements FileWriter {

    @Override
    public void writeToFile(String report) {
        File resultFile = new File("src/main/resources/result.csv");
        try {
            resultFile.createNewFile();
        } catch (IOException e) {
            throw new RuntimeException("Can't create file: " + resultFile, e);
        }
        try {
            Files.write((resultFile.toPath()), report.getBytes());
        } catch (IOException e) {
            throw new RuntimeException("Can't write to file: " + resultFile, e);
        }
    }
}
