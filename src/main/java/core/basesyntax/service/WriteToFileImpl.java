package core.basesyntax.service;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class WriteToFileImpl implements WriteToFile {

    @Override
    public void writeToFile(String report, String outputFileName) {
        File file = new File(outputFileName);
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file))) {
            bufferedWriter.write(report);
        } catch (IOException e) {
            throw new RuntimeException("Can't write to file " + outputFileName, e);
        }
    }
}
