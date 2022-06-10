package core.basesyntax.service.impl;

import core.basesyntax.service.MyFileWriter;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class MyFileWriterImpl implements MyFileWriter {
    public void writeToFile(String pathToFile, List<String> reportList) {
        File report = new File(pathToFile);
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(report))) {
            for (String line : reportList) {
                bufferedWriter.write(line);
            }
        } catch (IOException e) {
            throw new RuntimeException("Could not assess the file", e);
        }
    }
}
