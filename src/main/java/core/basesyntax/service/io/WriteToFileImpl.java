package core.basesyntax.service.io;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class WriteToFileImpl implements WriteToFile {
    @Override
    public void writeToFile(String pathToFile, String report) {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(pathToFile))) {
            bufferedWriter.write(report);
        } catch (IOException e) {
            throw new RuntimeException("Can not write to file: " + pathToFile, e);
        }
    }
}
